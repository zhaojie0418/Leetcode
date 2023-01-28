public class freqAlphabets1309 {
    public String freqAlphabets(String s) {
        int length = s.length();
        StringBuffer res = new StringBuffer();
        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            //说明倒着算的这个一定是一个“两位数”
            if (c == '#') {
                res.append( (char)((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '1') + 'a'));
                i = i - 2;
            }
            //如果没有就说明只是对应的“一位数”
            else {
                //这里注意将数字转换未对应字母的操作
                res.append((char)(c - '1' + 'a'));
            }
        }
        return res.reverse().toString();
    }
}
