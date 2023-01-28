public class calculateTax2303 {
    public static void main(String[] args) {
        System.out.println(new calculateTax2303().calculateTax(new int[][]{{919,95}},858));
    }
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int upperBefore = 0;
        for (int i = 0; i < brackets.length; i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            if (income > upper) {
                int money = (upper - upperBefore) * percent;
                upperBefore = upper;
                res += money;
            } else {
                int money = (income - upperBefore) * percent;
                res += money;
                break;
            }

        }
        return res/100;
    }
}
