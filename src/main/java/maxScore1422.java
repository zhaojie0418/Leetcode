public class maxScore1422 {
    public static void main(String[] args) {
        System.out.println(new maxScore1422().maxScore("00"));
    }
    public int maxScore(String s) {
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneCount++;
            }
        }
        int temp = oneCount;
        int max = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '0') {
                temp++;
            } else {
                temp--;
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
