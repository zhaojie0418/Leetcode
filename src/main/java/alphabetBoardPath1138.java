public class alphabetBoardPath1138 {
    public static void main(String[] args) {
        System.out.println(new alphabetBoardPath1138().alphabetBoardPath("zdz"));
    }
    public String alphabetBoardPath(String target) {
        //这里实际上优先左上角移动
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int curX = (c - 'a') / 5;
            int curY = (c - 'a') % 5;
            if (curY < y) {
                int gap = y - curY;
                sb.append("L".repeat(gap));
            }
            if (curX > x) {
                int gap = curX - x;
                sb.append("D".repeat(gap));
            }
            if (curX < x) {
                int gap = x - curX;
                sb.append("U".repeat(gap));
            }
            if (curY > y) {
                int gap = curY - y;
                sb.append("R".repeat(gap));
            }
            x = curX;
            y = curY;
            sb.append('!');
        }
        return sb.toString();
    }

}
