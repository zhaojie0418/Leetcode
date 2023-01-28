public class areAlmostEqual1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        char firstChar = 0;
        char secondChar = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count == 0) {
                    firstChar = s1.charAt(i);
                    secondChar = s2.charAt(i);
                    count++;
                }else if(count == 1){
                    if (firstChar == s2.charAt(i) && secondChar == s1.charAt(i)) {
                        count++;
                        continue;
                    }
                    return false;
                }else if (count >= 2) {
                    return false;
                }
            }
        }
        if (count == 1) {
            return false;
        }
        return true;
    }
}
