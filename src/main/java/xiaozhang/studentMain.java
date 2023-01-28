package xiaozhang;

public class studentMain {
    public static void main(String[] args) {
        student s1 = new student(1);
        student s2 = new student(2,18);
        student s3 = new student(3,20,"boy");
        student s4 = new student(4,22,"girl","Jessica");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
