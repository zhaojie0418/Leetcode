public class prefixCount2185 {
    public static void main(String[] args) {
        String s = "0123456";
        System.out.println(s.substring(0, 2));
    }
    public int prefixCount(String[] words, String pref) {
        //注意考虑给定的字符串过小的情况
        int length = pref.length();
        int count = 0;
        for (String s : words) {
            if (s.length() >= length && s.substring(0, length).equals(pref)) {
                count++;
            }
        }
        return count;
    }
}
