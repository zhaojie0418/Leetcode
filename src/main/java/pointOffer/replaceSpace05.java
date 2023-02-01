package pointOffer;

public class replaceSpace05 {
    public String replaceSpace(String s) {

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' '){
                string.append("%20");
            } else {
                string.append(c);
            }

        }
        return string.toString();
    }
}
