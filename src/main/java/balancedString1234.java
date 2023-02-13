import java.util.Arrays;

public class balancedString1234 {
    public int balancedString(String s) {
        //要把多的变成缺少的，题目给定说字符串长度是四的倍数
        //这里很巧妙的不是讨论总的字符串，而是讨论所有能替换的部分
        int quarter = s.length() / 4;
        int[] count = new int['X'];
        Arrays.fill(count, 0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        if (count['Q'] == quarter && count['W'] == quarter && count['E'] == quarter && count['R'] == quarter)
            return 0; // 已经符合要求啦
        int l = 0;
        int r = 0;
        int res = s.length();//注意待比较的最小值，初始值需要赋值可能情况的最大值
        for (; r < s.length(); r++) {
            count[s.charAt(r)]--;
            while (count['Q'] <= quarter && count['W'] <= quarter && count['E'] <= quarter && count['R'] <= quarter) {
                res = Math.min(res, r - l + 1);
                ++count[s.charAt(l++)]; // 缩小子串
            }

        }
        return res;
    }
}
