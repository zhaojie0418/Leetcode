public class isAnagram242 {
    public boolean isAnagram(String s, String t) {
        int[] numbers = new int[26];
        for(int i = 0;i<s.length();i++){
            numbers[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<t.length();i++){
            int number = --numbers[t.charAt(i) - 'a'];
            if(number < 0){
                return false;
            }
        }
        for(int i:numbers){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
