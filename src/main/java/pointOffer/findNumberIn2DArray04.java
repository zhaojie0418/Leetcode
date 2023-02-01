package pointOffer;

public class findNumberIn2DArray04 {
    public static void main(String[] args) {
        System.out.println(new findNumberIn2DArray04().findNumberIn2DArray(new int[][]{}, 0));
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int x = matrix[0].length;
        int y = matrix.length;
        int i = 0;
        int j = y - 1;
        while (i < x && j >= 0) {
            int num = matrix[j][i];
            if (num > target) {
                j--;
            } else if (num < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }


}
