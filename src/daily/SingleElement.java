package daily;

public class SingleElement {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        SingleElement singleElement = new SingleElement();
        System.out.println(singleElement.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1 || nums.length/2 == 0) {
            return nums[0];
        }
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        int t;
        while(l < r) {
            mid = l + (r-l)/2;
            t = mid-l;
            if(t%2==1) {
                if(nums[mid] == nums[mid+1]) r = mid-1;
                else if(nums[mid] == nums[mid-1]) l = mid+1;
                else return nums[mid];
            } else {
                if(nums[mid] == nums[mid+1]) l = mid+2;
                else if(nums[mid] == nums[mid-1]) r = mid-2;
                else return nums[mid];
            }
        }
        return nums[l];
    }
}
