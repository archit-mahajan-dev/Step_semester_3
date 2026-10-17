package arrays.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Week 4 assignment A3: 3Sum using sorting and two pointers. */
public class ThreeSum {
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int leftValue = nums[left];
                    int rightValue = nums[right];
                    while (left < right && nums[left] == leftValue) left++;
                    while (left < right && nums[right] == rightValue) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }
}
