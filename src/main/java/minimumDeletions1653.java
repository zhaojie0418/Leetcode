public class minimumDeletions1653 {
    public int minimumDeletions(String s) {
        int countA = 0;
        int countB = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }
        int res = countA;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                countA--;
            } else {
                countB++;
            }
            res = Math.min(res, countB + countA);
        }
        return res;
    }

    //巧妙地使用了普适a和b的表达式来规避了if-else分支语句带来的性能开销
    public int minimumDeletions2(String S) {
        var s = S.toCharArray();
        int del = 0;
        for (var c : s)
            del += 'b' - c; // 统计 'a' 的个数
        int ans = del;
        for (var c : s) {
            // 'a' -> -1    'b' -> 1
            del += (c - 'a') * 2 - 1;
            ans = Math.min(ans, del);
        }
        return ans;
    }
}
