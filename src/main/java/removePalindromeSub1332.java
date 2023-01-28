public class removePalindromeSub1332 {
    //注意该题目中设置，字符串中只有 a 和 b
    //实际上题目说的有些怪，实际上只有两种情况，根据是否是回文串
    //如果是回文串，删除一次即可
    //如果不是回文串，则无论怎样的组合都只需要删除两次（删除所有的a，再删除所有的b）
    public int removePalindromeSub(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; ++i) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }
}
