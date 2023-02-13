public class trap42 {
    public static void main(String[] args) {
        System.out.println(new trap42().trap(new int[]{5,0,2,1,4,0,1,0,3}));
    }
    public int trap(int[] height) {
        if(height==null||height.length==0){
            return 0;
        }
        int maxHeightIndex = 0;
        int maxHeight = height[0];
        for (int i = 1; i < height.length; i++) {
            if(height[i]>maxHeight){
                maxHeight = height[i];
                maxHeightIndex = i;
            }

        }
        int pillarSum = 0;
        int totalSum = 0;
        int currentMaxHeight = 0;
        for (int i = 0; i <= maxHeightIndex; i++) {
            int currentPillar = height[i];
            if(currentPillar>currentMaxHeight){
                totalSum += currentPillar;
                currentMaxHeight = currentPillar;
            }else {
                totalSum += currentMaxHeight;
            }
            pillarSum += currentPillar;
        }
        currentMaxHeight = 0;
        for (int i = height.length-1; i > maxHeightIndex; i--) {
            int currentPillar = height[i];
            if(currentPillar>currentMaxHeight){
                totalSum += currentPillar;
                currentMaxHeight = currentPillar;
            }else {
                totalSum += currentMaxHeight;
            }
            pillarSum += currentPillar;
        }

        return totalSum-pillarSum;
    }
}
