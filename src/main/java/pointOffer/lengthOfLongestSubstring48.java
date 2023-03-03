package pointOffer;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring48 {
    public static void main(String[] args) {
        System.out.println(new lengthOfLongestSubstring48().lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        //这里不能只使用set作为标记，因为需要使用map来保存其前一个位置
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;//注意这里的ij是左右指针
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果,这里不需要额外加一的原因是此时i和j对应的字符相同，需要剔除一个
        }
        return res;
    }
}
