public class minimumRecolors2379 {
    public static void main(String[] args) {
        System.out.println(new minimumRecolors2379().minimumRecolors("WBBWWBBWBW", 7));
    }
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        char[] chars = blocks.toCharArray();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (chars[i] == 'W') {
                count++;
            }
        }
        int res = count;
        for (int i = k; i < blocks.length(); i++) {
            if (chars[i] == 'W') {
                count++;
            }
            if (chars[i - k] == 'W') {
                count--;
            }
            res = Math.min(res, count);
        }
        return res;
    }
}
