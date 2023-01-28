public class search33 {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    public int binarySearch(int[] nums, int target,int left, int right){
        int begin = nums[left];
        int mid = (right + left)/2;
        int midNumber = nums[mid];
        //目标数字在查找位置的右边
        if(target > midNumber){
            if(begin < midNumber){

            }else {

            }
        }
        //目标数字在查找位置的左边
        else if(target < nums[mid]){

        }else{
            return mid;
        }
        return target;
    }
}
