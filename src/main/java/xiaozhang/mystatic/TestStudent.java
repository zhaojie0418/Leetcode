package xiaozhang.mystatic;

public class TestStudent {

    static {
        System.out.println("TestStudent is running ");
    }

    public static void main(String[] args) {
        student s = new student();
        student.getSchool_static();
        s.getSchool();
    }

}