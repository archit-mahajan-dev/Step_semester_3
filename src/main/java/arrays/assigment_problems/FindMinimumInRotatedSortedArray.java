package arrays.assigment_problems;

/** Week 4 assignment A5: Find minimum using modified binary search. */
public class FindMinimumInRotatedSortedArray {
    static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
    }
}
