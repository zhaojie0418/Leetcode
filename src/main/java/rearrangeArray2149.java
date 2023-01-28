public class rearrangeArray2149 {
    public static void main(String[] args) {
        new rearrangeArray2149().rearrangeArray(new int[]{3,1,-2,-5,2,-4});
    }
    public int[] rearrangeArray(int[] nums) {
        int positive = 0;
        int negative = 0;
        int length = nums.length;
        int count = 0;
        int[] res = new int[length];
        while (count != length) {
            while (nums[positive] < 0 && positive < length) {
                positive++;
            }
            res[count++] = nums[positive];
            positive++;
            while (nums[negative] > 0 && negative < length) {
                negative++;
            }
            res[count++] = nums[negative];
            negative++;
        }
        return res;
    }
}
