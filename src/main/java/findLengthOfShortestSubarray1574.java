public class findLengthOfShortestSubarray1574 {
    public int findLengthOfShortestSubarray(int[] arr) {

        return 0;
    }
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                ++counter;
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                ++counter;
            }
        }, "t2");
        t1.start();
        t2.start();
        //等待t1线程执行结束
        t1.join();
        //等待t2线程执行结束
        t2.join();
        System.out.println(counter);
    }
}
