package xiaozhang.mystatic;

public class student {
    public static String school;

    static {
        school = "计算机学院";
        //由于是静态代码块在，只会在类加载的时候加载一次
        System.out.println("使用静态代码块初始化静态变量");
    }
    public static void getSchool_static() {
        System.out.println("使用静态方法输出:  "+"我的学校是" + school);
    }

    public void getSchool() {
        System.out.println("使用非静态方法输出:  "+"我的学校是" + school);
    }
}

