import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class isIsomorphic205 {
    public static void main(String[] args) {
        String s = "aaeaa";
        String t = "uuxyy";
        System.out.println(isIsomorphic(s,t));
    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int length = s.length();
        for(int i = 0;i<length;i++){
            char c =t.charAt(i);
//            boolean b = (map.get(s.charAt(i)) != c);
            //判断s字符串是否重复出现，重复出现的情况
            if(map.containsKey(s.charAt(i))){
                if((map.get(s.charAt(i)) != c))
                    return false;
                else {
                    continue;
                }
            }//第一次出现的情况
            else {
                if(set.contains(c)){
                    return false;
                }
                map.put(s.charAt(i),c);
                set.add(c);
            }
        }
        return true;
        }

    //官方解法，使用两个Map进行映射
    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    //聪明简洁解法
    public boolean isIsomorphic3(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}


