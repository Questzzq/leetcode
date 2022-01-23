package my_Algorithm;

public class MySortTest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        quicksort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }

    static void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
}
