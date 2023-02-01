public class countSpecialSubsequences1955 {
    static int mod = 1000000007;
    public int countSpecialSubsequences(int[] nums) {
        int f0=0,f1=0,f2=0;
        //这里的关键点在于f0=0,f1=0,f2=0初始值均为0，并且f0=0,f1=0,f2=0的计算方式也很巧妙
        for(int num:nums){
            if(num == 0){
                //f0表示只有0能组成的字符串种类，每多一个0就导致0的个数翻倍并加一
                f0 = (f0*2+1)%mod;
            }else if(num == 1){
                //注意这个计算式子很重要
                f1 = (f1*2%mod+f0)%mod;
            }else{
                //最终结果只取决于有多少个2
                f2 = (f2*2%mod+f1)%mod;
            }
        }
        return f2;
    }
}
