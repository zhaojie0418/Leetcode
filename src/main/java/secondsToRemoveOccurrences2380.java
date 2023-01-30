public class secondsToRemoveOccurrences2380 {
    public static void main(String[] args) {
        int i = new secondsToRemoveOccurrences2380().secondsToRemoveOccurrences("0110101");
        System.out.println(i);
    }
    public int secondsToRemoveOccurrences(String s) {
        //实际上移动的时间取决于最后一个元素移动的时长
        //并且最后一个元素移动的时长实际上等于这个元素前面的0的个数
        int f = 0, pre0 = 0;
        for (var i = 0; i < s.length(); i++)
            if (s.charAt(i) == '0') ++pre0;
            //这里的后面的一个f表示的是前一个元素的走的路程加一，加一表示堵车，需要等一秒
            else if (pre0 > 0) f = Math.max(f + 1, pre0); // 前面有 0 的时候才会移动
        return f;
    }
}
