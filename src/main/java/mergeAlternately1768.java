public class mergeAlternately1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int indexA = 0;
        int indexB = 0;
        int lengthA = word1.length();
        int lengthB = word2.length();
        while (indexA < lengthA && indexB < lengthB) {
            res.append(word1.charAt(indexA++));
            res.append(word2.charAt(indexB++));
        }
        if (indexA >= lengthA) {
            res.append(word2.substring(indexB));
        } else {
            res.append(word1.substring(indexA));
        }
        return res.toString();
    }
}
