public class countAsterisks2315 {
    public int countAsterisks(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                count++;
                continue;
            }
            if (c == '*' && count % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
