import static java.lang.Math.pow;

public class multiply43 {
    //大整数相乘问题常见解决方法：1、转化成加法计算  2、转化成乘法计算
    //注意这里存在溢出的可能性，因为使用字符串表示的数字可能很大，对于int类型会溢出
    public String multiply(String num1, String num2) {
        int sum = stringToInt(num1)*stringToInt(num2);
        return String.valueOf(sum);
    }
    public int stringToInt(String s){
        int length = s.length();
        int sum = 0;
        for(int i = 0;i<length;i++){
            int multiplier = (int) Math.pow(10,length-i-1);
            sum = sum + (s.charAt(i)-'0')*multiplier;
        }
        return sum;
    }

    //官方题解版本
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }

}
