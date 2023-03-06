package pointOffer;

public class reverseLeftWords58_2 {
    public String reverseLeftWords(String s, int n) {
        //注意这里如果要求不允许使用StringBuilder，使用string会导致每次字符串拼接都需要创建一个新的字符串
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }
}
