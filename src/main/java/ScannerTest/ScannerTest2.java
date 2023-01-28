package ScannerTest;

import java.util.Scanner;

public class ScannerTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println("int:  "+a);
            System.out.println("int 2:  "+b);
            System.out.println("string:  "+s);
        }
    }
}
