public class balancedStringSplit1221 {
    public int balancedStringSplit(String s) {
        //自己的想法和官方题解类似但是官方题解更为简洁
        //stringCount记录能分成几个平衡字符串  charCount记录有几个连续重复字符
        int stringCount = 0;
        int charCount = 0;
        //为了对迭代变量便于操控这里将迭代变量单独声明
        int i = 0;

        char c = s.charAt(i);
        i++;
        for(;i<s.length();i++){
            if(s.charAt(i)==c){
                charCount++;
            }else{
                int count = 0;
                while(count<charCount){
                    //一旦有一个和之前的字符相同
                    if(s.charAt(i)==c){
                        return 1;
                    }
                    count++;
                    i++;
                }
                stringCount++;
            }
        }
        return stringCount;
    }

    //官方题解
    //求解的主要思路是利用贪心算法，一旦一个平衡字符串分成两个字符串，只要其中一个是平衡字符串，另外一个也一定是平衡字符串
    //尽可能的去分割，只要能分割我就进行处理
    //注意观察题目简洁写法
    public int balancedStringSplit2(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                ++d;
            } else {
                --d;
            }
            if (d == 0) {
                ++ans;
            }
        }
        return ans;
    }

}
