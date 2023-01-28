public class rob198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(new rob198().rob(nums));
    }
    //从左往右依次选择偷不偷，每一次选择都使得左边的元素组合已经是最贵的偷法了
    public int rob(int[] nums) {
        int length = nums.length;
        if(length==1) return nums[0];
        if(length==2) return Math.max(nums[0],nums[1]);
        int curMoney = Math.max(nums[0],nums[1]);
        int earlyMoney = nums[0];
        for(int i = 2;i<length;i++){
            //偷了更贵，选择偷
            //这里的自己的解法有问题，并不是拿了更贵才迭代两个值，而是无论拿不拿都得迭代
            if(earlyMoney+nums[i] > curMoney){
                int temp = earlyMoney;
                earlyMoney = curMoney;
                curMoney = temp+nums[i];
            }
        }
        return curMoney;
    }
    //官方题解方法
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            //而是无论拿不拿都得迭代
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}
