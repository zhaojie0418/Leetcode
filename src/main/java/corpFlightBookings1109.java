import java.util.Arrays;

public class corpFlightBookings1109 {
    public static void main(String[] args) {
        int[][] arr =  {{1,2,10},{2,3,20},{2,5,25}};
        System.out.println(Arrays.toString(new corpFlightBookings1109().corpFlightBookings(arr, 5)));
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        int numBooking = bookings.length;
        for (int[] booking : bookings) {
            for (int j = booking[0] - 1; j < booking[1]; j++) {
                res[j] = res[j] + booking[2];
            }
        }
        return res;
    }

    //官方解法  效率相对于原版大幅提升
    //差分数组对应的概念是前缀和数组,只需要对第一个元素和最后一个元素进行遍历就好
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
