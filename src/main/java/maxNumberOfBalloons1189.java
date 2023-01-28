import java.util.Arrays;

public class maxNumberOfBalloons1189 {
    public static void main(String[] args) {


    }
    public int maxNumberOfBalloons(String text) {
        int[] arr = {0,0,0,0,0};
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case 'b':
                    arr[0]++;
                    break;
                case 'a':
                    arr[1]++;
                    break;
                case 'l':
                    arr[2]++;
                    break;
                case 'o':
                    arr[3]++;
                    break;
                case 'n':
                    arr[4]++;
                    break;
            }
        }
        arr[2] = arr[2] / 2;
        arr[3] = arr[3] / 2;
        return Arrays.stream(arr).min().getAsInt();
    }
}
