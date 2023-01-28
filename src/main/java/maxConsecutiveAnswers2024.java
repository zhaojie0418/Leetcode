public class maxConsecutiveAnswers2024 {
    public static void main(String[] args) {

    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    //k是能够改变的字符数量，ch如果是T，说明原字符串中只能是F变成T，以下分析ch为T的情况
    public int maxConsecutiveChar(String answerKey, int k, char ch) {
        int n = answerKey.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            //K是窗口中能够承载的量，而sum是窗口中另一种字F的数量
            sum += answerKey.charAt(right) != ch ? 1 : 0;
            //一旦F的数量超过了K的承受范围，就要从左边牺牲对应的T
            while (sum > k) {
                sum -= answerKey.charAt(left++) != ch ? 1 : 0;
            }
            //取每一次滑动过程中的滑动窗口最大值
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
