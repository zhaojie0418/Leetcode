public class checkDistances2399 {
    public static void main(String[] args) {
        System.out.println(new checkDistances2399().checkDistances("zz",new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
    public boolean checkDistances(String s, int[] distance) {
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (arr[index] != -1) {
                if (i - arr[index] - 1 != distance[index]) {
                    return false;
                }
            } else {
                arr[index] = i;
            }
        }
        return true;
    }
}
