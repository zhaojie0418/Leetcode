import java.util.HashMap;

public class equationsPossible990 {
    public boolean equationsPossible(String[] equations) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            char left = equations[i].charAt(0);
            char right = equations[i].charAt(3);
            if (equations[i].charAt(1) == '=') {
                
            } else {

            }
        }
        return false;
    }
}
