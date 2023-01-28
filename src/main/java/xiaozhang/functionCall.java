package xiaozhang;

public class functionCall {
    public static void main(String[] args) {
        //字符 a 对应的ASCII值为97
        char c = 'a';
        int i = 1;
        //char类型和 int 类型相加导致强制类型转换将结果作为int类型输出
        System.out.println(c + i);
        //输出长为10，宽为20 的长方形周长
        System.out.println(getRectanglePerimeter(10,20));
        //输出长为30，宽为40 的长方形周长
        System.out.println(getRectanglePerimeter(30,40));
    }

    private static int getRectanglePerimeter(int length,int width){
        return 2 * (length + width);
    }

}
