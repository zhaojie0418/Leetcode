public class characterReplacement424 {
    public static void main(String[] args) {

    }
    //替换后得到的最长相同字符串
    public static int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        //TODO 分析使用滑动窗口来解决的问题
        //使用大小为26的int数组来判断其中字母的数量
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}
