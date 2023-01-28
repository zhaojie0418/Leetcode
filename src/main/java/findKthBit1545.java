public class findKthBit1545 {
    public static void main(String[] args) {
        System.out.println(new findKthBit1545().findKthBit(3,1));
    }
    public char findKthBit(int n, int k) {
        if(n==1){
            return '0';
        }
        StringBuilder stringBefore = new StringBuilder("0");
        StringBuilder stringBuffer = new StringBuilder("0");
        for(int i = 1;i<n;i++){
            for(int j = 0;j<stringBefore.length();j++){
                //注意这里老犯错误，是'1' 不是 1
                if(stringBefore.charAt(j)=='1'){
                    stringBefore.setCharAt(j,'0');
                }else{
                    stringBefore.setCharAt(j,'1');
                }
            }
            stringBefore.reverse();
            stringBuffer.append('1');
            stringBuffer.append(stringBefore);
            stringBefore = new StringBuilder(stringBuffer);
        }
        return stringBuffer.charAt(k-1);
    }

    //官方版本使用递归方式进行求解
    public char findKthBit2(int n, int k) {
        //根据数学关系得到，对应二进制串的长度等于2的n次方减一
        if (k == 1) {
            return '0';
        }
        //实际上就是2的n-1次方（正好位于对应二进制串的中间位置）
        int mid = 1 << (n - 1);
        //这里不是在比较是否相等，而是在比较k对应的和mid的位置
        //如果k正好在中间（根据题目要求中间的是 1）
        if (k == mid) {
            return '1';
        }
        //如果小于mid则说明在上一种字符串的左边
        else if (k < mid) {
            return findKthBit2(n - 1, k);
        }
        //大于mid则说明在字符串的右边，注意对应的字符可以使用左边的字符来表示
        else {
            k = mid * 2 - k;
            return invert(findKthBit2(n - 1, k));
        }
    }

    public char invert(char bit) {
        return (char) ('0' + '1' - bit);
    }

}
