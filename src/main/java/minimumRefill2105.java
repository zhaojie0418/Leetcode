public class minimumRefill2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0;
        int length = plants.length;
        int ca = capacityA;
        int cb = capacityB;
        int left = 0;
        int right =length-1;
        while(left<right){
            //如果左边的同学 水壶中够浇水
            if(capacityA>=plants[left]){
                capacityA = capacityA - plants[left];
            }else{
                capacityA = ca;
                capacityA = capacityA - plants[left];
                count++;
            }
            left++;
            //如果右边的同学 水壶中够浇水
            if(capacityB>=plants[right]){
                capacityB = capacityB - plants[right];
            }else{
                capacityB = cb;
                capacityB = capacityB - plants[right];
                count++;

            }
            right--;
        }
        if(left==right){
            if(Math.max(capacityA,capacityB) < plants[left]){
                count++;
            }
        }
        return count;
    }
}
