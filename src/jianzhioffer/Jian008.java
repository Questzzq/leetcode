package jianzhioffer;

public class Jian008 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        Jian008 j = new Jian008();
        System.out.println(j.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int l = 0;
        int s = 0;
        int min = len;
        for(int i = 0; i < len; i++) {
            s += nums[i];
            if(s >= target) {
                System.out.println("s = " + s);
                if(i-l+1 < min) {
                    min = i-l+1;
                }
                while(s >= target && l < i) {
                    if(i-l+1 < min) {
                        min = i-l+1;
                    }
                    s -= nums[l];
                    l++;
                }
                System.out.println("l = " + l);
            }
        }
        return min;
    }
}
