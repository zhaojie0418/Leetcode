public class searchMatrix74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1}};
        System.out.println(new searchMatrix74().searchMatrix(matrix,2));
    }
    //这里注意实际上可以将两个方法的相互递归转化为一个函数的递归，这里懒得重新写了
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        return binarySearch(matrix,target,0,m*n-1);
    }
    public boolean binarySearch(int[][] matrix, int target,int left,int right){
        //二分查找的典型数据 ，注意判断迭代跳出条件，mid的算法，二分判断后对mid的加减
        if(left > right){
            return false;
        }
        int mid = (right + left)/2;
        int m = matrix[0].length;
        int row = mid / m;
        int line = mid - row*m;
        if(matrix[row][line]>target){
            return binarySearch(matrix,target,left,mid-1);
        }else if(matrix[row][line]<target){
            return binarySearch(matrix,target,mid+1,right);
        }else{
            return true;
        }
    }
}
