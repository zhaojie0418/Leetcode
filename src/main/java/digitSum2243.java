public class digitSum2243 {
    public static void main(String[] args) {
        System.out.println(new digitSum2243().digitSum("1234",2));
    }
    public String digitSum(String s, int k) {
        StringBuffer stringBuffer = new StringBuffer(s);
        while (stringBuffer.length() > k) {
            StringBuffer temp = new StringBuffer();
            int i;
            for (i = 0; i + k <= stringBuffer.length(); i += k) {
                int sum = 0;
                for (int j = i; j < k+i; j++) {
                    sum = sum + (stringBuffer.charAt(j) - '0');
                }
                temp.append(sum);
            }
            int sum = 0;
            boolean ifAdd = false;
            while (i < stringBuffer.length()) {
                sum += stringBuffer.charAt(i) - '0';
                i++;
                ifAdd = true;
            }
            if(ifAdd){
                temp.append(sum);
            }
            stringBuffer = temp;
        }
        return stringBuffer.toString();
    }
}
