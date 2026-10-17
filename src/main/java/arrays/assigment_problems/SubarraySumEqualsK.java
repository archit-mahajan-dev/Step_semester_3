package arrays.assigment_problems;

import java.util.HashMap;
import java.util.Map;

/** Week 4 assignment A4: Prefix sums and hash-map frequencies. */
public class SubarraySumEqualsK {
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFrequencies = new HashMap<>();
        prefixFrequencies.put(0, 1);

        int prefixSum = 0;
        int count = 0;
        for (int value : nums) {
            prefixSum += value;
            count += prefixFrequencies.getOrDefault(prefixSum - k, 0);
            prefixFrequencies.put(prefixSum,
                    prefixFrequencies.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}
