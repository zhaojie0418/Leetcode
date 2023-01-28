public class moveZeroes283 {
    public void moveZeroes(int[] nums) {
        int indexNow = 0;
        int indexNum = 0;
        int m = nums.length;

        //这里很巧妙的使用了遍历一次的方式
        //无论怎样都需要对0后面的进行移动，那么只需要记录下0的个数即可
        while(indexNum<m){
            if(nums[indexNum] != 0) {
                nums[indexNow++] = nums[indexNum];
            }
            ++indexNum;
        }
        //最后不用移动0，直接赋0即可
        for(int i = indexNow; i < m; i++){
            nums[i] = 0;
        }
    }
}
