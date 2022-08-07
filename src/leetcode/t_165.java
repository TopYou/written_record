package leetcode;

import java.util.Scanner;

/*
* FIXME
* 给你两个版本号 version1 和 version2 ，请你比较它们。
版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。
* 每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。
* 例如，2.5.33 和 0.1 都是有效的版本号。
比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。
* 也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
* 例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
* 没有的版本号默认给0
。*/
public class t_165 {
    // 方法一：字符串分割
//    public static int compareVersion(String version1, String version2) {
//        String[] arr1 = version1.split("\\.");
//        String[] arr2 = version2.split("\\.");
//        for (int i = 0; i < arr1.length || i < arr2.length; i++) {
//                int x = 0 ,y = 0;
//                if(i < arr1.length){// 如果arr1[i]存在则给x赋值，若不存在则赋默认值0
//                    x = Integer.parseInt(arr1[i]);
//                }
//                if(i < arr2.length){// 如果arr2[i]存在则给x赋值，若不存在赋默认值0
//                    y = Integer.parseInt(arr2[i]);
//                }
//                if(x > y){
//                    return 1;
//                }
//                if(x < y){
//                    return -1;
//                }
//        }
//        return 0;
//    }

    //方法二：双指针
    public static int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m){
            int x = 0;
            while (i < n && version1.charAt(i) != '.'){
                x = x * 10 + version1.charAt(i) - '0'; //求出每一段的数值大小,到.就停止 version1.charAt(i)- '0'为assic码差值，即真正数值
                i++;
            }
            i++;// 跳过.号
            int y = 0;
            while (j < m && version2.charAt(j) != '.'){
                y = y * 10 + version2.charAt(j) - '0'; //求出每一段的数值大小,到.就停止
                j++;
            }
            j++;// 跳过点号
            if(x > y){
                return 1;
            }
            if(x < y){
                return -1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String v1 = scanner.next();
        String v2 = scanner.next();
        int res = compareVersion(v1,v2);
        System.out.println(res);
    }
}
