public class isPrefixOfWord1455 {
    public static void main(String[] args) {
        System.out.println(new isPrefixOfWord1455().isPrefixOfWord("i love eating burger","burg"));
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strings = sentence.split(" ");
        int length = searchWord.length();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() >= length && strings[i].substring(0, length).equals(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
