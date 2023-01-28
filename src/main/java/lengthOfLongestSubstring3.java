import java.util.HashMap;
import java.util.HashSet;

public class lengthOfLongestSubstring3 {
    public static void main(String[] args) {
        System.out.println(new lengthOfLongestSubstring3().lengthOfLongestSubstring("bbbbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        HashMap<Character, Integer> numberMap = new HashMap<>();
        while(right<s.length()){
            char c = s.charAt(right);
            if(numberMap.containsKey(c)){
                int oldLeft = left;
                left = numberMap.get(c)+1;
                for(;oldLeft<left;oldLeft++){
                    numberMap.remove(s.charAt(oldLeft));
                }
                numberMap.put(c,right);
                right++;
            }else{
                numberMap.put(c,right);
                right++;
            }
            maxLength = Math.max(maxLength,right-left);
        }
        return maxLength;
    }
}
