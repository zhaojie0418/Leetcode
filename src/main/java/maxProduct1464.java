public class maxProduct1464 {
    public int maxProduct(int[] nums) {
        int max = Math.max(nums[0],nums[1]);
        int tempMax = Math.min(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            int num = nums[i];
            if (num > tempMax) {
                if (num > max) {
                    int temp = max;
                    max = num;
                    tempMax = temp;
                }else{
                    tempMax = num;
                }
            }
        }
        return (max - 1) * (tempMax - 1);
    }
}
