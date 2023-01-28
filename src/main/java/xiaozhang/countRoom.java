package xiaozhang;

public class countRoom {
    public static void main(String[] args) {
        System.out.println("6个人要住 "+getRoomCount(6)+" 间房");
        System.out.println("7个人要住 "+getRoomCount(7)+" 间房");
        System.out.println("12个人要住 "+getRoomCount(12)+" 间房");
        System.out.println("13个人要住 "+getRoomCount(13)+" 间房");
    }
    public static int getRoomCount(int number){
        int count = number/6;
        int ret = number%6;
        return ret>0?count+1:count;
    }
}
