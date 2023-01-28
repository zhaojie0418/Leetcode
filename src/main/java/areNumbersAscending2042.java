public class areNumbersAscending2042 {
    public static void main(String[] args) {
        System.out.println(new areNumbersAscending2042().areNumbersAscending("9 hi 9"));
    }
    public boolean areNumbersAscending(String s) {
        int length = s.length();
        int min = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            //这里易错忘记加等号
            if (c >= '0' && c <= '9') {
                int temp = c - '0';
                //这里易错忘记加等号
                while (i + 1 < length && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    temp = temp * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                if (min >= temp) {
                    return false;
                } else {
                    min = temp;
                }
            }
        }
        return true;
    }
}
