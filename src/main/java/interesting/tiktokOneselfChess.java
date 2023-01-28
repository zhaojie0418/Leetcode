package interesting;

public class tiktokOneselfChess {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
               arr[i][j] = true;
            }
        }
        arr[3][3] = false;
        System.out.println(new tiktokOneselfChess().solve(arr));
    }
    public static final int[] MOVEX = {0, 1, 0, -1};
    public static final int[] MOVEY = {1, 0, -1, 0};

    public String solve(boolean[][] pegs) {
        if(isSolve(pegs)) {
            return "";
        }
        String result = null;
        int delti = 0;
        int deltj = 0;
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                if(!isEffectivity(i, j)) {
                    continue;
                }
                if(pegs[i][j]) {
                    for(int k = 0; k < 4; k++) {
                        delti = MOVEX[k];
                        deltj = MOVEY[k];
                        result = tryMove(pegs, i, j, i + delti, j + deltj, i + 2 * delti, j + 2 * deltj);
                        if(result != null) {
                            String str = solve(pegs);
                            if(str != null) {
                                return result + str;
                            }
                            pegs[i][j] = true;
                            pegs[i + delti][j + deltj] = true;
                            pegs[i + 2 * delti][j + 2 * deltj] = false;
                        }
                    }
                }
            }
        }
        return null;
    }


    private static String tryMove(boolean[][] pegs, int startX, int startY, int jumpX,
                                  int jumpY, int endX, int endY) {
        if(jumpX < 0 || jumpY < 0 || endX < 0 || endY < 0) {
            return null;
        }
        if(jumpX >= 7 || jumpY >= 7 || endX >= 7 || endY >= 7) {
            return null;
        }
        if(!isEffectivity(endX, endY)) {
            return null;
        }
        if(pegs[jumpX][jumpY] != true || pegs[endX][endY] != false) {
            return null;
        }
        pegs[startX][startY] = false;
        pegs[jumpX][jumpY] = false;
        pegs[endX][endY] = true;
        StringBuffer str = new StringBuffer();
        str.append(startX + " " + startY + " "
                + endX + " " + endY + "\n");
        return str.toString();
    }

    private static boolean isEffectivity(int x, int y) {
        if(x < 2 && (y < 2 || y > 4)) {
            return false;
        }else if(x > 4 && (y < 2 || y > 4)) {
            return false;
        }else {
            return true;
        }
    }

    public static boolean isSolve(boolean[][] board) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] && !(i == 3 && j == 3)) {
                    return false;
                }
            }
        }
        return board[3][3];
    }
    
}
