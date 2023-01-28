package Leetcode_race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class first {
    public static void main(String[] args) {
        System.out.println(new first().countSubarrays(new int[]{1,1,1,1},1,1));
    }
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length && nums[i] < 0; i++) {
            set.add(nums[i]);
        }
        for (int i = nums.length - 1; i >= 0 && nums[i] > 0; i--) {
            int temp = nums[i];
            if (set.contains(-temp)) {
                return temp;
            }
        }
         return -1;
    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            StringBuilder temp = new StringBuilder(String.valueOf(num));
            temp.reverse();
            int res = Integer.parseInt(temp.toString());
            set.add(res);
        }
        return set.size();
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        List<Integer> minList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == maxK) {
                maxList.add(i);
            }
            if (num == minK) {
                minList.add(i);
            }
        }
        for (int i = 0; i < minList.size(); i++) {
            int temp = minList.get(i);
            for (int j = 0; j < maxList.size(); j++) {
                if (maxList.get(j) >= temp) {
                    res = res + maxList.size() - j;
                    break;
                }
            }
        }
        return res;
    }
}
