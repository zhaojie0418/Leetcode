package miHoYo;

import java.util.Arrays;
import java.util.Scanner;

public class mhyMagic {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int mp = sc.nextInt();
//        int sum = 0;
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = sc.nextInt();
//        }
//        sc.nextLine();//读取换行符
//        String s = sc.nextLine();
        int n = 4;
        int mp = 5;
        int[] arr = new int[]{1, 1, 1, 1};
        String s = "WFFI";
        int res = new mhyMagic().mpCount(n, mp, arr, s);
//        System.out.println(mp);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(s);
        System.out.println(res);

    }

    public int mpCount(int n, int mp, int[] arr, String s) {
        int sum = 0;
        char[] magic = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (i == n - 1) { //最后一个还判断啥，直接开打
                sum += arr[i];
                break;
            }
            if (magic[i] == magic[i + 1]) { //不能用大
                sum += arr[i];
            } else {  //可用大
                if (arr[i] + arr[i + 1] < mp) { //用大不划算
                    sum += arr[i] + arr[i + 1];
                    i++;
                } else { //用大划算
                    if (i + 2 < n && arr[i + 2] > arr[i] && magic[i + 2] != magic[i + 1]) { //后面这玩意更值得用大，留给后面用，这个单打
                        sum += arr[i] + mp;
                        i += 2;
                    } else {
                        sum += mp;
                        i++;
                    }
                }
            }
        }
        return sum;
    }
}
