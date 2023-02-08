package pointOffer;

public class minArray11 {
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (numbers[m] < numbers[r]) {
                r = m;
            } else if (numbers[m] > numbers[r]) {
                l = m + 1;
            } else {
                r -= 1;
            }
        }
        return numbers[l];
    }
    public int minArray2(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            //关键在于考虑下面的左右判断情况
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) { //右半部分
                high = pivot; //要找的点肯定在该点的左边
            } else if (numbers[pivot] > numbers[high]) {  //左半部分
                low = pivot + 1; //要找的点肯定在该点的右边
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
