public class kLengthApart1437 {
    public static void main(String[] args) {
        int[] arr = {1,0,0,0,1,0,0,1};
        System.out.println(new kLengthApart1437().kLengthApart(arr,2));
    }
    public boolean kLengthApart(int[] nums, int k) {
        int index = -k-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                //满足题意条件
                if (i - index - 1 >= k) {
                    index = i;
                } else {
                    return false;
                }
            }
            //由于当等于1的时候就将所有的0都进行处理了，所以无需对0进行处理
        }
        return true;
    }
}
