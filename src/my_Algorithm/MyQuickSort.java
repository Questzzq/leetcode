package my_Algorithm;

public class MyQuickSort {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("2w1");
        int[] n = {2,2,1};
        int len = n.length;
        int k = len/2;
        System.out.println(findKthElement(n, 0, len-1, k, len));
    }

    private static int findKthElement(int[] n, int l, int r, int k, int len) {
        int index = partition(n, l, r);
        int position = len - index + 1;
        if(position == k) {
            return n[index];
        } else if(position > k) {
            return findKthElement(n, index+1, r, k, len);
        } else {
            return findKthElement(n, l, index-1, k, len);
        }
    }

    public static int majorityElement(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        return nums[nums.length/2];
    }

    private static void quickSort(int[] n, int l, int r) {
        if(l >= r) {
            return;
        }
        int index = partition(n, l, r);
        quickSort(n, l, index-1);
        quickSort(n, index+1, r);
    }

    private static int partition(int[] n, int l, int r) {
        int pivot = n[l];
        while(l < r) {
            while(l < r && n[r] >= pivot) {
                r--;
            }
            n[l] = n[r];
            while(l < r && n[l] <= pivot) {
                l++;
            }
            n[r] = n[l];
        }
        n[l] = pivot;
        return l;
    }
}
