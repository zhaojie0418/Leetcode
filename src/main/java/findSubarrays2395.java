import java.util.HashSet;

public class findSubarrays2395 {
    public boolean findSubarrays(int[] nums) {
        int length = nums.length;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i =0;i<length-1;i++){
            int tempSum = nums[i] + nums[i+1];
            if(hashSet.contains(tempSum)){
                return true;
            }
            hashSet.add(tempSum);
        }
        return false;
    }
}
