package my_Sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 4234523, 56, 566565, 5, 9, 9, 7, 7, 6, 6, 6, 5, 4, 4, 3, 2, 12, 1, 2, 2, 2132};
        HeapSort heap = new HeapSort();
        heap.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void heapSort(int[] arr) {
        int n = arr.length;
        for(int i = n/2-1; i >= 0; i--) {
            heapAdjust(arr, i, n);
        }
        int t;
        for(int i = n-1; i > 0; i--) {
            t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            heapAdjust(arr, 0, i);
        }
    }

    /**
     * 功能：完成以 i 对应的非叶子节点的树调整为大顶堆
     * @param arr 待调整的数组
     * @param i 非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整
     */
    private void heapAdjust(int[] arr, int i, int length) {
        int temp = arr[i];
        for(int k = 2*i+1; k < length; k = 2*k+1) {
            if(k+1 < length && arr[k] < arr[k+1]) {
                k++;
            }
            if(arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
