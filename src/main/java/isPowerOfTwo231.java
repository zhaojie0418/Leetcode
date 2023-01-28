public class isPowerOfTwo231 {
    public static void main(String[] args) {
        int num = -2147483648;
        System.out.println(new isPowerOfTwo231().isPowerOfTwo(num));
    }
    public boolean isPowerOfTwo(int n) {
        //注意这里要对负数进行过滤
        if(n<=0) return false;
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='1') count++;
        }
        if(count==1) return true;
        else return false;
    }
    //官方极简解法
    public boolean isPowerOfTwo2(int n) {
        //(n & (n - 1))这个算法能够将最低位的 1 移除，故剩下的只需要判断是否为0即可
        //注意根据 n & (n - 1) 这个性质还能快速得到一个二进制数中有几个1
        return n > 0 && (n & (n - 1)) == 0;
    }

}
