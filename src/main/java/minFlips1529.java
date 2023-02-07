public class minFlips1529 {
    public int minFlips(String target) {
        //这里考虑将题目转换为求将给定字符串转换成00000所需要的次数
        int count = 0;
        //这里是不是只需要考虑有多少个不同的段即可
        char prev = '0';
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);//这里不好对want赋值，可以等到获取到下一个的时候再赋值
            if (c != prev) {
                count++;
                prev = c;
            }

        }
        return count;
    }
    public int minFlips2(String target) {
        int flips = 0;
        char prev = '0';
        int n = target.length();
        for (int i = 0; i < n; i++) {
            char curr = target.charAt(i);
            if (curr != prev) {
                flips++;
                prev = curr;
            }
        }
        return flips;
    }
}
