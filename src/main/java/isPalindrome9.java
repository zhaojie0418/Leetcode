public class isPalindrome9 {
    public static void main(String[] args) {
        System.out.println(new isPalindrome9().isPalindrome(123));
    }
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
