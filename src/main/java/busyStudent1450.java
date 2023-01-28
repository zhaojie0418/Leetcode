public class busyStudent1450 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {3,2,7};
        System.out.println(new busyStudent1450().busyStudent(arr1,arr2,4));

    }
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int resCount = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (endTime[i] >= queryTime && startTime[i] <= queryTime) {
                resCount++;
            }
        }
        return resCount;
    }
}
