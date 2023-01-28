public class backspaceCompare844 {
    public static void main(String[] args) {
        System.out.println(new backspaceCompare844().backspaceCompare("ab##", "c#d#"));
    }
    //没有处理好连续#和间隔#的处理方式导致出错
    public boolean backspaceCompare(String s, String t) {
        int pointer1 = s.length()-1;
        int pointer2 = t.length()-1;
        while(pointer1>=0||pointer2>=0){
            char sc = s.charAt(pointer1);
            char tc = t.charAt(pointer2);
            int count = 0;
            while(sc == '#'){
                pointer1--;
                count++;
                sc = s.charAt(pointer1);
            }
            pointer1 = pointer1-count;
            count = 0;
            while(tc == '#'){
                if(t.charAt(pointer2-1)=='#'){
                    count++;
                }
                count++;
                tc = t.charAt(pointer2);
            }
            pointer2 = pointer2-count;
            if(pointer1<0&&pointer2<0){
                return true;
            }
            sc = s.charAt(pointer1);
            tc = t.charAt(pointer2);
            if(sc!=tc){
                return false;
            }else {
                pointer1--;
                pointer2--;
            }
        }
        return true;
    }
    //官方题解，注意其控制连续#和间隔#的处理方式
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

}
