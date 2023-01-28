package xiaozhang;

public class getSum {
    public static void main(String[] args) {
        System.out.println("1 到 3 的和为" + sum(1, 3));
        System.out.println("2 到 5 的和为" + sum(2, 5));
        System.out.println("3 到 140 的和为" + sum(3, 140));

    }
    public static int sum(int begin,int end){
        return (end*(end+1))/2-(begin*(begin+1))/2;
    }
}
