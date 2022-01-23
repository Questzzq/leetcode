package my_Algorithm;

public class Pow {
    public static void main(String[] args) {
//        System.out.println(myPow(2.00000, -2147483648));
//        System.out.println(reverse(1534469));
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 2)
            return len;
        int s = 0;
        int t = nums[0]-1;
        for(int i = 0; i < len; i++) {
            if(nums[i] == t) {
                for(int j = i; j < len-1; j++) {
                    nums[j] = nums[j+1];
                }
                len--;
            } else {
                t = nums[i];
                s++;
            }
        }
        return s;
    }

    public static int reverse(int x) {
        String s = String.valueOf(x);
        int j = s.length() - 1;
        boolean flag = s.charAt(0) == '-';
        int end = flag?1:0;
        StringBuilder sb = new StringBuilder();
        for(int i = j; i >= end; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
        int res = 0;
        try {
           res = Integer.parseInt(sb.toString().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
        return flag?-res:res;
    }


    public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        boolean flag = n > 0;
        long N = n;
        double res = N > 0 ? quickIteratorPow(x, N): quickIteratorPow(x, -N);
        if(!flag)
            res = 1.0/res;
        return res;
    }

    private static double quickIteratorPow(double x, long n) {
        if(n == 0) {
            return 1;
        }
        double res = quickIteratorPow(x, n/2);
        return n%2>0?res*res*x:res*res;
    }
}
