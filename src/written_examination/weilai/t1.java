package written_examination.weilai;

import java.util.Scanner;

/*
* 求最大版本号
* 求一组数的最大版本号基于两个版本号之间的比较进行排序
* 测试输入：5
          2.1.4.5 3.1.5 3.1.20.6 2.20 1.9.9
* 预计输出：3.1.20.6
* */
public class t1 {
    public static String maxVersion(String[] arr){
        // 选择排序找到一次最大的
        int maxIndex = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(compareVersion(arr[i],arr[maxIndex]) > 0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
    // 要想比较全部先比较两个版本
    public static int compareVersion(String version1 , String version2){
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        for (int i = 0; i < arr1.length || i < arr2.length; i++) {
            int x = 0, y = 0;
            if(i < arr1.length){
                x = Integer.parseInt(arr1[i]);
            }
            if(i < arr2.length){
                y = Integer.parseInt(arr2[i]);
            }
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
        while (scanner.hasNextInt()){
            int N = scanner.nextInt();
            String[] versionArr = new String[N];
            for (int i = 0; i < N; i++) {
                versionArr[i] = scanner.next();
            }
            System.out.println(maxVersion(versionArr));
        }
    }
}
