public class minDominoRotations1007 {
    public static void main(String[] args) {
        int[] tops = {1,2,1,1,1,2,2,2};
        int[] bottoms = {2,1,2,2,2,2,2,2};
        //4320
        System.out.println(new minDominoRotations1007().minDominoRotations(tops,bottoms));
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int topHead = tops[0];
        int bottomHead = bottoms[0];
        int topCount = 0;
        int bottomsCount = 0;

        int length = tops.length;
        int sameCount = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == bottoms[i]) {
                sameCount++;
            }
        }
        for (int i = 1; i < tops.length; i++) {
            if (tops[i] != topHead) {
                if (bottoms[i] == topHead) {
                    topCount++;
                } else {
                    topCount = -1;
                    break;
                }
            }
        }
        for (int i = 1; i < tops.length; i++) {
            if (bottoms[i] != bottomHead) {
                if (tops[i] == bottomHead) {
                    bottomsCount++;
                } else {
                    bottomsCount = -1;
                    break;
                }
            }

        }
        int res;
        //注意这里易错，需要对sameCount进行统计，因为当使用length减去时，上下相同的数量实际上不需要相减
        if (bottomsCount == -1) {
            res = Math.min(topCount,length-sameCount- topCount);
        } else if (topCount == -1) {
            res = Math.min(bottomsCount,length-sameCount-bottomsCount);
        } else {
            res = Math.min(Math.min(topCount,length-sameCount-topCount), Math.min(bottomsCount,length-sameCount-bottomsCount));
        }
        return res;
    }
}
