public class sortColors75 {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for(int i : nums){
            if(i == 0) arr[0]++;
            else if (i == 1) arr[1]++;
            else if (i == 2) arr[2]++;
        }
        int first  = arr[0];
        int second = arr[1];
        int third  = arr[2];
        for(int i = 0;i < first;i++){
            nums[i] = 0;
        }
        for(int i = first;i < first+second;i++){
            nums[i] = 1;
        }
        for(int i = first+second;i < nums.length;i++){
            nums[i] = 2;
        }
    }
}
