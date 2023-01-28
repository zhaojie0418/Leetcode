import java.sql.Array;
import java.util.Arrays;

public class latestTimeCatchTheBus2332 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int index = 0;
        int count = 0;
        //由于一定要做到最后一辆车，所以这里需要将最后一辆车前面的所有车尽可能的装满
        for (int i = 0; i < buses.length; i++) {
            int bus = buses[i];
            count = capacity;
            while (count > 0 && index < passengers.length && passengers[index] <= bus) {
                index++;
                count--;
            }
        }
        index--;
        int res = count > 0 ? buses[buses.length - 1] : passengers[index]; // 在发车时到达公交站 or 上一个上车的乘客
        while (index >= 0 && passengers[index--] == res) --res; // 往前找没人到达的时刻
        return res;
    }
}
