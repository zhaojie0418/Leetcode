public class checkPalindromeFormation1616 {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        //swap(a, b); 注意这样进行交换无法真的交换对应数据
        System.out.println(new checkPalindromeFormation1616().checkPalindromeFormation(a, b));
    }
    public boolean checkPalindromeFormation(String a, String b) {
        //这里注意题目已经给定条件两个字符串长度相同
        //考虑使用双指针
        //如果多次创建string判断则开销过大
        //这里考虑复用这两个字符串然后双指针只能从外部判断
        int length = a.length();
        for (int i = 0; i < length; i++) {
            //1a左b右
            //a右b左
            for (int j = 0; j < 2; j++) {
                String ta;
                String tb;
                if (j == 1) {
                    ta = b;
                    tb = a;
                }else{
                    ta = a;
                    tb = b;
                }
                int count = i;
                int indexA = 0;
                int indexB = length - 1;
                while (indexA <= indexB) {
                    char c = count > 0 ? ta.charAt(indexA) : tb.charAt(indexA);
                    count--;
                    if (c != tb.charAt(indexB)) {
                        break;
                    }
                    indexA++;
                    indexB--;
                    if (indexA >= indexB) {
                        return true;
                    }
                }
            }
            swap(a, b);
        }
        return false;
    }

    public static void swap(String a, String b) {
        String temp = a;
        a = b;
        b = temp;
    }
}
