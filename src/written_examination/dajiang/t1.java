package written_examination.dajiang; /**
 * 通过率（100%）
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *
 *
 * 输入描述
 * timePoints = ["23:59","00:00"]
 *
 * 注意【输入样例】中
 *
 * 2  //第一行为timePoints数组长度
 *
 * 23:59  //第二行至最后一行为数组每个元素
 *
 * 00:00
 *
 * 输出描述
 * 1
 *
 *
 * 样例输入
 * 2
 * 23:59
 * 00:00
 * 样例输出
 * 1
 *
 * 提示
 * 2 <= timePoints.length <= 2 * 104
 *
 * timePoints[i] 格式为 "HH:MM"
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static int transform(String str){
        String[] strArr = str.split(":");
        int sum = 0;
        int hour = Integer.parseInt((strArr[0]));
        int min = Integer.parseInt(strArr[1]);
        if(hour<12){
            hour+=24;
        }
        sum = hour * 60 + min;
        return sum;
    }
    /* Write Code Here */
    public int findMinDifference(String[] timePoints) {
        int[] intArr = new int[timePoints.length];
        for (int i = 0; i < timePoints.length; i++) {
            intArr[i] = transform(timePoints[i]);
        }
        int gap = 1000000;

        Arrays.sort(intArr);
        for (int i = 0; i < intArr.length - 1; i++) {
            int abs = Math.abs(intArr[i] - intArr[i + 1]);
            if(abs < gap){
                gap = abs;
            }
        }
        return gap;
    }
}

public class t1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int timePoints_size = 0;
        timePoints_size = in.nextInt();
        if (in.hasNextLine())
            in.nextLine();
        String[] timePoints = new String[timePoints_size];
        String timePoints_item;
        for(int timePoints_i = 0; timePoints_i < timePoints_size; timePoints_i++) {
            try {
                timePoints_item = in.nextLine();
            } catch (Exception e) {
                timePoints_item = null;
            }
            timePoints[timePoints_i] = timePoints_item;
        }
        res = new Solution().findMinDifference(timePoints);
        System.out.println(String.valueOf(res));

    }
}

