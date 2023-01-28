import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class findAnagrams438 {
    public static void main(String[] args) {
        char c = 'b';
        System.out.println(new findAnagrams438().findAnagrams("cbaebabacd","abc"));
    }
    //未完成  不匹配原因是由于重复还是由于不符合原因  为解决
    public List<Integer> findAnagrams(String s, String p) {
        int length = p.length();
        int[] charMap = new int[26];
        for(int i = 0;i<length;i++){
            char c = p.charAt(i);
            //如果这个字符之前没有遍历过
            if(charMap[c-'a']==0){
                charMap[c-'a']=1;
            }
        }
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int[] copy = charMap.clone();
        while(right<s.length()){
            while(right-left<3&&right<s.length()){
                if(copy[s.charAt(right)-'a']>=1){
//                    copy[s.charAt(right)-'a']=0;
                    copy[s.charAt(right)-'a']++;
                    //等于2 说明第一次检索到，如果大于2 则说明重复
                    if(copy[s.charAt(right)-'a']==2){
                        right++;
                    }else{

                    }
                }else{
                    right++;
                    left=right;
                    copy = charMap.clone();
                }
            }
            list.add(left);
            copy[s.charAt(left)-'a'] = 1;
            left++;
        }

        return list;
    }
    //官方题解，由于不考虑重复的，所以待定子串一定和给定子串的长度相同，所以只要维护对应的sCount pCount
    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        //由于是整体判断，所以不需要考虑不匹配原因是由于重复还是由于不符合原因
        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

}
