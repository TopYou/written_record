package written_examination.weilai;

import java.util.Objects;
import java.util.Scanner;

/*判断一个矩阵是否为另一个矩阵的子矩阵，原题地址https://atcoder.jp/contests/abc054/tasks/abc054_b
样例输入：
3 2
# . #
. # .
# . #
# .
. #
样例输出：YES
*/
public class t2 {
    public static boolean isChild(String[][] arrA, String[][] arrB ){
        int n = arrA.length , m = arrB.length;
        boolean ok;
        for (int i = 0; i < n - m + 1; i++) {
            for (int j = 0; j < n - m + 1 ; j++) {
                ok = true;
                for (int k = 0; k < m; k++) {
                    for (int h = 0; h < m; h++) {
                        if(!Objects.equals(arrB[k][h], arrA[k + i][h + j])){
                            ok = false;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int numA = scanner.nextInt();
            int numB = scanner.nextInt();
            String[][] arrA = new String[numA][numA];
            String[][] arrB = new String[numB][numB];
            for (int i = 0; i < numA; i++) {
                for (int j = 0; j < numA; j++) {
                    arrA[i][j] = scanner.next();
                }
            }
            for (int i = 0; i < numB; i++) {
                for (int j = 0; j < numB; j++) {
                    arrB[i][j] = scanner.next();
                }
            }
            System.out.println(isChild(arrA,arrB));
        }
    }
}
