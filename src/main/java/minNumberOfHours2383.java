import java.util.Arrays;

public class minNumberOfHours2383 {
    public static void main(String[] args) {
        int energy = 1;
        int exp = 1;
        int[] energyArr = {1, 1, 1, 1};
        int[] experienceArr = {1, 1, 1, 50};
        System.out.println(new minNumberOfHours2383().minNumberOfHours(energy, exp, energyArr, experienceArr));

    }
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int count = 0;
        int exp = initialExperience;
        int sum = 0;
        for (int j : energy) {
            sum += j;
        }
        if (sum >= initialEnergy) {
            count += sum - initialEnergy + 1;
        }
        for (int i : experience) {
            if (exp <= i) {
                count += i - exp + 1;
                exp += i - exp + 1;
            }
            exp += i;
        }
        return count;
    }
}
