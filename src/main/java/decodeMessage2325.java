import java.util.HashMap;
import java.util.Map;

public class decodeMessage2325 {
    public static void main(String[] args) {
        System.out.println(1);

    }
    public String decodeMessage(String key, String message) {
        char cur = 'a'; //这里注意直接使用char类型进行迭代
        Map<Character, Character> rules = new HashMap<>();

        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (c != ' ' && !rules.containsKey(c)) {
                rules.put(c, cur);
                ++cur;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); ++i) {
            char c = message.charAt(i);
            if (c != ' ') {
                c = rules.get(c);
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
