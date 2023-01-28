public class countHomogenous1759 {
    public static void main(String[] args) {
        System.out.println(new countHomogenous1759().countHomogenous("llllllllllllwaarrrrrrrrrrtttttiiiakkkjnjjjjjjjjjjjjjjjjjjjewwwwwwwwwzzzzzzoooooooooooooollffffttttoookkxxxxxxxxxsggggdddddooooooooooooosssyyiiiiiihhhhhhhhhhhhttttttttoooooorrrrrrrrrrrrrrrrrrvvvvvvvvvvvvvvvvyyyyyynnjkkkkkklllhhkkkkkceeefffffffggggeeeee"));
    }
    public int countHomogenous(String s) {
        long res = 0;
        int count = 1;
        char tempChar = s.charAt(0);
        int mod = (int) 1e9 + 7;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == tempChar) {
                count++;
            } else {
                res = res + ((long) count * (count + 1)) / 2;
                res %= mod;
                tempChar = c;
                count = 1;
            }
        }
        res = res + ((long) count * (count + 1)) / 2;
        return (int) (res %= mod);
    }

}
