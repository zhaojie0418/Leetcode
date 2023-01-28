public class canJump55 {

    //成功通过！！！
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new canJump55().canJump(arr));
    }
    public boolean canJump(int[] nums) {
        //这里考虑使用动态规划的思想，能够到达最后的前提条件是能够到达前一个
        //但是好像如果使用动态规划的思想需要考虑的情况过多
        //这里还是选择从左往右遍历

        int length = nums.length;
        //boolean默认值是false Boolean默认值是null
        boolean[] isReachable = new boolean[length];
        //第一个元素一定是能够抵达的
        isReachable[0] = true;
        for(int i = 0;i<length;i++){
            if(isReachable[i]){
                if(nums[i]==0&&length==1) return true;
                for(int j = 0;j<nums[i];j++){
                    //如果超过了长度则说明可以抵达
                    if(i+j+1 >= length-1)  return true;
                    //将前面的元素设置为可抵达的
                    isReachable[i+j+1] = true;
                }
            }
        }
        return false;
    }
}
