public class maxValue1881 {
    public static void main(String[] args) {
        System.out.println(new maxValue1881().maxValue("-13",2));
    }
    public String maxValue(String n, int x) {
        char c = n.charAt(0);
        StringBuffer stringBuffer = new StringBuffer(n);
        //如果是正数的情况
        if (c != '-') {
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i)-'0' <= x) {
                    stringBuffer.insert(i,x+"");
                    return stringBuffer.toString();
                }
            }
            stringBuffer.append(x);
        }
        //如果是负数的情况
        else{
            for (int i = 1; i < n.length(); i++) {
                if (n.charAt(i)-'0' >= x) {
                    stringBuffer.insert(i,x+"");
                    return stringBuffer.toString();
                }
            }
            stringBuffer.append(x);
        }
        return stringBuffer.toString();
    }
}
