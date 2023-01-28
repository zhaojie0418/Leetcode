import java.util.HashMap;

public class areSentencesSimilar1813 {
    public static void main(String[] args) {
        String[] strings1 = new String[]{"1", "2", "3"};
        String[] strings2 = new String[]{"4", "5", "6"};
        String[] temp = strings2;
        strings2 = strings1;
        strings1 = temp;
        System.out.println(strings1[0] + "" + strings2[0]);
    }
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0, j = 0;
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        while (j < words1.length - i && j < words2.length - i && words1[words1.length - j - 1].equals(words2[words2.length - j - 1])) {
            j++;
        }
        return i + j == Math.min(words1.length, words2.length);
    }
}
