package xiaozhang;

public class xyFunction {
    public static void main(String[] args) {
        System.out.println("当x = 3,y = 3 时，z = " + getZ(9, 3));
    }
    public static int getZ(int x,int y){
        if (x > 0 && y > 0) {
            return (3*x)/y;
        }
        System.out.println("输入错误");
        return 0;
    }
}
