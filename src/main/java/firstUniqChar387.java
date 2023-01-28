public class firstUniqChar387 {
    public static void main(String[] args) {
        System.out.println(new firstUniqChar387().firstUniqChar("loveleetcode"));
    }
    public int firstUniqChar(String s) {
        int[] numbers = new int[26];
        for(int i = 0;i<s.length();i++){
           numbers[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<s.length();i++){
            if(numbers[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
