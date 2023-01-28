public class interpret1678 {
    public static void main(String[] args) {
        System.out.println(new interpret1678().interpret("G()()()()(al)"));
    }
    public String interpret(String command) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == '(') {
                if (command.charAt(++i) == ')') {
                    res.append('o');
                } else {
                    res.append("al");
                    i = i + 2;
                }
            } else {
                res.append('G');
            }
        }
        return res.toString();
    }
}
