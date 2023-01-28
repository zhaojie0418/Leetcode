public class canConstruct383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] numbers = new int[26];
        for(int i = 0;i<magazine.length();i++){
            numbers[magazine.charAt(i)-'a']++;
        }
        for(int i = 0;i<ransomNote.length();i++){
            int number = --numbers[ransomNote.charAt(i) - 'a'];
            if(number <0){
                return false;
            }
        }
        return true;
    }
}
