public class maxProduct152 {
    //第一想法是使用滑动数组来进行求解
    public int maxProduct(int[] nums) {
        int left = 0;
        int right = 0;
        boolean if_minus = false;
        int max = 1;
        int temp = 1;
        for(int i = 0;i< nums.length;i++){
            if(nums[i]>0){
                temp = temp*nums[i];
                max = Math.max(max,temp);
            }else if(nums[i]<0){

            }else{

            }
        }
        //分三种情况进行处理： 正数  负数  0
        return 0;
    }
}
