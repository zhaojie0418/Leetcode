import java.util.HashMap;

public class minWindow76 {
    //感觉这个题目就已经暗示了使用滑动窗口
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        return s;
    }
}
