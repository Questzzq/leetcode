package my_collections;

public class Solution {
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == i) continue;
            if (nums[num] == num) return num;

            // 循环置位：
            // 将当前i位置上的数放置到它应该去的位置，置换出来的数，换回到i位置，盯住i位置不动，继续循环置位。
            // 期间如果发现应该去的位置上躺着的已经是正确的数字了，则发现重复，return
            while (nums[i] != i) { // 在一次置位循环中，始终盯住i位置不动，以i位置为发货地，不断向外发送数字。
                // i位置上数应该发往nums[i]位置，置换出num这个数：
                num = nums[nums[i]];
                if (num == nums[i]) return num; // 发现重复
                nums[nums[i]] = nums[i];
                nums[i] = num;
            }
        }
        return -1; // never happen!
    }
}
