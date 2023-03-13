package test;

import java.util.Scanner;

public class ClassTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(" ");
            int sum = 0;
            for (String s : str) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
            System.out.println(new A().function());

        }


    }
    static class A{
        public int function(){
            return 1;
        }
    }
}
