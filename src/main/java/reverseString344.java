public class reverseString344 {
    public void reverseString(char[] s) {
        char temp;
        int length = s.length;
        for(int i = 0;i<length/2;i++){
            temp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = temp;
        }
    }
}
