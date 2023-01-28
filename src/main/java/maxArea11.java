public class maxArea11 {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(new maxArea11().maxArea(arr));
    }
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        int tempHeight;
        while(left<right){
            int length = right-left;
            tempHeight = Math.min(height[left],height[right]);
            area = Math.max(area,length*tempHeight);
            if(height[left]>height[right]){
                tempHeight = height[right];
                while(left<=right&&height[right]<=tempHeight){
                    right--;
                }
            }else{
                tempHeight = height[left];
                while(left<=right&&height[left]<=tempHeight){
                    left++;
                }
            }
        }
        return area;
    }
}
