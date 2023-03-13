package pdd;

import java.util.*;

public class dinner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countDay = sc.nextInt();
        int[] pjCount = new int[countDay];
        int[] zwCount = new int[countDay];
        double sum = 0;
        PriorityQueue<Integer> firstP = new PriorityQueue<>();
        PriorityQueue<Integer> secondP = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0; i < countDay; i++){
            int people = sc.nextInt();
            //计算平均数
            sum += people;
            pjCount[i] = push(sum / (i + 1));
            //计算中位数
            if (firstP.size() != secondP.size()) {
                firstP.add(people);
                secondP.add(firstP.poll());
            } else {
                secondP.add(people);
                firstP.add(secondP.poll());
            }
            zwCount[i] = firstP.size() != secondP.size() ? firstP.peek() : push((firstP.peek() + secondP.peek()) / 2.0);
        }
        StringBuilder pj = new StringBuilder().append(pjCount[0]);
        StringBuilder zw = new StringBuilder().append(zwCount[0]);
        for (int i = 1; i < countDay; i++) {
            pj.append(" ").append(pjCount[i]);
            zw.append(" ").append(zwCount[i]);
        }
        System.out.println(pj);
        System.out.println(zw);

    }

    public static int push(double d) {
        int i = (int) d;
        if (d - i >= 0.5) {
            return i + 1;
        } else {
            return i;
        }
    }
}
