import java.util.Arrays;

public class reverseWords557 {
//    字符串可变语言：
//
//    C/C++, Ruby, PHP, Swift
//
//    字符串不可变语言：
//
//    Java, Python, C#, Javascript, Go
    //注意有些简单的问题注意原地遍历
    public static void main(String[] args) {
        System.out.println(new reverseWords557().reverseWords("Let's take LeetCode contest"));
    }
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        for(int i = 0 ;i<strings.length;i++){
            strings[i] = reverseString(strings[i].toCharArray());
        }
        String ret = strings[0];
        for(int i = 1 ;i<strings.length;i++){
            ret = ret.concat(" "+strings[i]);
        }
        return ret;
    }
    public String reverseString(char[] s) {
        char temp;
        int length = s.length;
        for(int i = 0;i<length/2;i++){
            temp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = temp;
        }
        //Arrays.toString(s);   结果"[s, ', t, e, L] [e, k, a, t] [e, d, o, C, t, e, e, L] [t, s, e, t, n, o, c]"
//      return Arrays.toString(s);
        //String.valueOf(s)     结果s'teL ekat edoCteeL tsetnoc
        return String.valueOf(s);
    }
}
