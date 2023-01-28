package xiaozhang;

public class personMain {
    public static void main(String[] args) {
        person p2 = new person(20, "女");
        person p3 = new person(22, "男");

        person p1 = p3;

        p2.shout();
        if (p3 == p1) {
            System.out.println("P1和P3相等！");
        }

    }
}
