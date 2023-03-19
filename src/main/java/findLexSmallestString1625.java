public class findLexSmallestString1625 {
    public String findLexSmallestString(String s, int a, int b) {
        char[] chars = s.toCharArray();
        String ans = s;
        for (int i = 0; i < 10; i++) {
            if (a * i % 10 == 0) {  // 判断是否可以完成累加操作
                int[] nums = new int[chars.length];
                for (int j = 0; j < nums.length; j++) {
                    nums[j] = chars[j] - '0';
                    if (j % 2 == 1) {
                        nums[j] = (nums[j] + a * i) % 10;  // 对下标为奇数的元素进行累加操作
                    }
                }
                for (int j = 0; j < nums.length; j++) {
                    chars[(j + b) % chars.length] = (char) (nums[j] + '0');  // 对字符串进行轮转操作
                }
                ans = String.valueOf(chars);
                if (ans.compareTo(s) < 0) {  // 更新字典序最小的字符串
                    s = ans;
                }
            }
        }
        return ans;
    }
}
