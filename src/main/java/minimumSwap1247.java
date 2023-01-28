public class minimumSwap1247 {
    public static void main(String[] args) {
        System.out.println(new minimumSwap1247().minimumSwap("xy","yx"));
    }
    public int minimumSwap(String s1, String s2) {
        //注意s1和s2中只包含两种字符，x和y
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 != length2) {
            return -1;
        }
        int countXY = 0;
        int countYX = 0;
        for (int i = 0; i < length1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == 'x' && c2 == 'y') {
                countXY++;
            }
            if (c1 == 'y' && c2 == 'x') {
                countYX++;
            }
        }
        int res = countXY / 2 + countYX / 2;
        countXY = countXY % 2;
        countYX = countYX % 2;
        if (countXY == 1 && countYX == 1) {
            return res + 2;
        } else if (countXY == 0 && countYX == 0) {
            return res;
        } else {
            return -1;
        }
    }
}
