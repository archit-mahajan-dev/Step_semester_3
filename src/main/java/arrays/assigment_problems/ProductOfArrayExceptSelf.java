package arrays.assigment_problems;

/** Week 4 assignment A1: Product except self without division, O(n). */
public class ProductOfArrayExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int prefix = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] first = productExceptSelf(new int[]{1, 2, 3, 4});
        int[] second = productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        print(first);
        print(second);
    }

    private static void print(int[] values) {
        System.out.print("[");
        for (int i = 0; i < values.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(values[i]);
        }
        System.out.println("]");
    }
}
