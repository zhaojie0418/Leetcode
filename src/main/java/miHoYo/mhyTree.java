package miHoYo;

import java.util.Scanner;

public class mhyTree {
//    //一层层遍历
//    static char[] arr;
//    static int number;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String first = "0";
//        String temp = sc.nextLine();
//        String s = first + temp;
//        arr = s.toCharArray();
//        number = (int) Math.pow(2, n - 1);
//        int res = new mhyTree().count(1);
//        if (res == 0) {
//            res++;
//        }
//        long mod = (long) (Math.pow(10, 9) + 7);
//        System.out.println(res%mod);
//    }
////    public static void main(String[] args) {
////        int n = 3;
////        String s = "0ABBAABB";
////        arr = s.toCharArray();
////        number = (int) Math.pow(2, n - 1);
////        int res = new mhyTree().count(1);
////        if (res == 0) {
////            res++;
////        }
////        System.out.println(res);
////    }
//
//    public long count(int begin) {
//        if (begin >= number) {
//            if (begin % 2 == 0 && arr[begin] != arr[begin + 1]) {
//                return 1;
//            }
//            return 0;
//        }
//        int left = begin * 2;
//        int right = left + 1;
//        long leftCount = count(left);
//        long rightCount = count(right);
//        if (arr[left] != arr[right]) {
//            return 2 * (leftCount + rightCount);
//        } else {
//            return leftCount + rightCount;
//        }
//    }

}
