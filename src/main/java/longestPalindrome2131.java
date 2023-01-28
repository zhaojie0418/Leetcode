import java.util.HashMap;
import java.util.List;

public class longestPalindrome2131 {
    public static void main(String[] args) {
        String[] arr = {"bd"};
        String[] arr2 = {"lc","cl","gg"};
        System.out.println(new longestPalindrome2131().longestPalindrome(arr));
    }
    public int longestPalindrome(String[] words) {
        //最长回文串是由能够组成回味串的字符串个数pairCount和单个位于中间的singleCount组成
        int pairCount = 0;
        int singleCount = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:words){
            //无论遍历到的这个字符串是否存在都需要对其对偶的一部分进行处理
            String tempString = String.valueOf(new StringBuilder(s).reverse());
            //如果有对应匹配的另一半
            if(map.containsKey(tempString)){
                pairCount++;
                int num = map.get(tempString);
                if(num>1)
                    map.put(tempString,num-1);
                else
                    map.remove(tempString);
            }else {
                //如果没有对应匹配的另一半

                //如果之前出现了
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else {
                    //如果之前没有出现
                    map.put(s,1);
                }
            }
        }
        //注意要最后判断有没有能够出现在回文串最中间的字符，因为有可能有多个“bb”
        if(!map.isEmpty()){
            for(String s: map.keySet()){
                if(s.charAt(0)==s.charAt(1)){
                    singleCount++;
                    break;
                }
            }
            //注意map.values()可以直接使用在特殊for循环中
//            for(Integer i:map.values()){
//                if(i%2==1){
//                    singleCount++;
//                    break;
//                }
//            }
        }
        return 2*singleCount+4*pairCount;
    }
}
