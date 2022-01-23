package my_Algorithm;

import java.util.HashMap;
import java.util.Map;

public class BinSearch {
    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 6};
//        int target = 8;
//        System.out.println(searchInsert(nums, 2));
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {
        // 21:59
        // 先判断行
        Map<Character, Integer> map = new HashMap<>(9);
        for(int i = 0; i < 9; i++) {
            map.clear();
            for(int j = 0; j < 9; j++) {
                if(map.isEmpty() || !map.containsKey(board[i][j])) {
                    if(board[i][j]!='.') {
                        map.put(board[i][j], 1);
                    }
                } else {
                    return false;
                }
            }
        }
        // 再判断列
        for(int i = 0; i < 9; i++) {
            map.clear();
            for(int j = 0; j < 9; j++) {
                if(map.isEmpty() || !map.containsKey(board[j][i])) {
                    if(board[i][j]!='.') {
                        map.put(board[i][j], 1);
                    }
                } else {
                    return false;
                }
            }
        }
        // 再判断小3x3
        for(int i = 0; i < 9; i+=3) {
            boolean small = isValidSudokuSmall(board, i, i+3);
            if(!small)
                return false;
        }
        return true;
    }

    // r:row;lc:cloumn
    private static boolean isValidSudokuSmall(char[][] board, int r, int c) {
        Map<Character, Integer> map = new HashMap<>(9);
        for(int i = r; i < r+3; i++) {
            for(int j = i; j < c; j++) {
                if(map.isEmpty() || !map.containsKey(board[i][j])) {
                    if(board[i][j]!='.') {
                        map.put(board[i][j], 1);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = l + (r - l)/2;
        while(l <= r) {
            m = l + (r - l)/2;
            if(target == nums[m]) {
                return m;
            } else if(target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        //找不到的话，返回应该插入的位置
        return nums[m] < target ? m+1:m;
    }

    public static int[] searchRange(int[] nums, int target) {
        // 21:12
        int[] res = {-1, -1};
        for(int i = 0; i < nums.length; i++) {
            int result = search(nums, target - nums[i]);
            if(result != -1) {
                res[0] = i;
                res[1] = result;
                break;
            }
        }
        return res;
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
