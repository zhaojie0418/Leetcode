public class judgeCircle657 {
    public boolean judgeCircle(String moves) {
        int countUD = 0;
        int countLR = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if(c == 'U'){
                countUD++;
            }
            if(c == 'D'){
                countUD--;
            }
            if(c == 'L'){
                countLR--;
            }
            if(c == 'R'){
                countLR++;
            }
        }
        if (countUD == 0 && countLR == 0) {
            return true;
        }
        return false;
    }
}
