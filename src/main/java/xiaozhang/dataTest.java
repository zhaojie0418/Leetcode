package xiaozhang;

public class dataTest {
    //静态常量定义
    static final int i = 1;
    static final short s = 100;
    static final long l = 10000;
    static final float f = (float) 1.1;
    static final double d = 1.1;
    static final char c = 'c';
    static final String string = "String";
    public static void main(String[] args) {
        int i2 = 2;
        short s2 = 200;
        long l2 = 20000;
        float f2 = (float) 2.2;
        double d2 = 2.1;
        char c2 = 'l';
        String string = "String2";
        System.out.println("---对静态常量的输出如下---");
        System.out.println("整型 i = " + i);
        System.out.println("短整型 s = "+s);
        System.out.println("长整型 l = "+l);
        System.out.println("单精度浮点值 f = "+f);
        System.out.println("双精度浮点值 d = "+d);
        System.out.println("字符类型 c = " +c);
        System.out.println("字符串类型 string = "+string);


        System.out.println("---对变量输出如下---");
        System.out.println("整型 i = " + i2);
        System.out.println("短整型 s = "+s2);
        System.out.println("长整型 l = "+l2);
        System.out.println("单精度浮点值 f = "+f2);
        System.out.println("双精度浮点值 d = "+d2);
        System.out.println("字符类型 c = " +c2);
        System.out.println("字符串类型 string = "+string);
    }
    public void addNumber(){
    }
}
