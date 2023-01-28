import java.util.*;

public class longestPalindrome409 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        System.out.println(s.length());
        for(int i=0;i<s.length();i++){
            Character character = s.charAt(i);
            if(charMap.containsKey(character)){
                charMap.put(character,charMap.get(character)+1);
            }else {
                charMap.put(character,1);
            }
        }
        Collection<Integer> list = charMap.values();
        int sum = 0;
        boolean b_add=true;
        for(Integer i:list){
            if(i%2==0)
                sum+=i;
            else{
                if(b_add){
                    sum++;
                    b_add = false;
                }
            }
        }
        return sum;
    }
    //可以避免使用哈希表来对字符串存储，使用字符对应的哈希值作为下标
    public int longestPalindrome2(String s) {
        // 找出可以构成最长回文串的长度
        int[] arr = new int[128];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }
}
