public class maxChunksToSorted769 {
    public static void main(String[] args) {
        System.out.println(new maxChunksToSorted769().maxChunksToSorted(new int[]{1,2,0,3}));
    }
    public int maxChunksToSorted(int[] arr) {
        int count = 1;
        int left = 0;
        int right = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //注意这里i < arr.length 条件必须写在前面，因为写在后面的话，前面已经超出范围了
//            while (i < arr.length && arr[i] < arr[i - 1]) {
//                right = i;
//                i++;
//            }
            if (arr[i] > max) {
                count++;
                left = i;
                right = i;
                max = arr[i];
            } else {
                right = i;
            }
        }
        //如果后面一个元素比这个元素小，那么将这个元素划分到前面这个集合中
        //如果后面一个元素比前面这个元素大，那就直接分
        return count;
    }
}

