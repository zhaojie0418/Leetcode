package pointOffer;

public class findRepeatNumber03 {
    public static void main(String[] args) {
        System.out.println(new findRepeatNumber03().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
    //使用hashmap简单，这里使用原地hash的方法
//    public int findRepeatNumber(int[] nums) {
//        int i = 0;
//        while(i < nums.length) {
//            if(nums[i] == i) {
//                i++;
//                continue;
//            }
//            if(nums[nums[i]] == nums[i]) return nums[i];
//            int tmp = nums[i];
//            nums[i] = nums[tmp];
//            nums[tmp] = tmp;
//        }
//        return -1;
//    }

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[nums[i]];
            nums[temp] = temp;
        }
        return -1;
    }

}
