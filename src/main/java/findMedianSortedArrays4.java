public class findMedianSortedArrays4 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        int[] b = new int[]{4,5,6,7};
        System.out.println(findMedianSortedArrays(a,b));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int sum = length1+length2;
        if(sum%2==1){
            int index = sum/2+1;
            int guard1 = 0;
            int guard2 = 0;
            for(int i = 1;i!=index;i++){
                if(nums1[guard1]>nums2[guard2]){
                    guard2++;
                }else{
                    guard1++;
                }
            }
            if(nums1[guard1]>nums2[guard2]){
                return nums2[guard2];
            }else{
                return nums1[guard2];
            }
        }else{
            int index = sum/2;
            int guard1 = 0;
            int guard2 = 0;
            int temp;
            for(int i = 1;i!=index;i++){
                if(nums1[guard1]>nums2[guard2]){
                    guard2++;
                }else{
                    guard1++;
                }
            }
            if(nums1[guard1]>nums2[guard2]){
                temp = nums2[guard2];
                guard2++;
            }else{
                temp = nums1[guard1];
                guard1++;
            }
            if(nums1[guard1]>nums2[guard2]){
                return (float)(nums2[guard2]+temp)/2;
            }else{
                return (float)(nums1[guard1]+temp)/2;
            }
        }
    }
}
