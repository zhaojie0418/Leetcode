public class divisorSubstrings2269 {
    public static void main(String[] args) {
        System.out.println(new divisorSubstrings2269().divisorSubstrings(10,1));
    }
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        String s = Integer.toString(num).trim();
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < k; j++) {
            sb.append(s.charAt(j));
        }
        for (int i = k; i < s.length(); i++) {
            int tempNumber = Integer.parseInt(sb.toString());
            if (tempNumber != 0 && num % tempNumber == 0) {
                count++;
            }
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
        }
        if (Integer.parseInt(sb.toString()) != 0 && num % Integer.parseInt(sb.toString()) == 0) {
            count++;
        }
        return count;
    }

    //评论区超级简洁写法
    public int divisorSubstrings2(int num, int k) {
        String s = String.valueOf(num);
        int ans = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            //没有用到stringBuffer，而是每一次都重新进行截取
            int a = Integer.parseInt(s.substring(i, i + k));
            if (a > 0 && num % a == 0) {
                ans++;
            }
        }
        return ans;
    }
}
