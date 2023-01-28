public class slowestKey1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        int point = 0;
        for (int i = 1; i < releaseTimes.length; i++) {
            int temp = releaseTimes[i] - releaseTimes[i - 1];
            if (temp > max || (temp == max && keysPressed.charAt(point) < keysPressed.charAt(i))) {
                max = temp;
                point = i;
            }
        }
        return keysPressed.charAt(point);
    }
}
