package my_Algorithm;

public class MyTest {
    public static void main(String[] args) {
        int u = -2147483648;
        int d = -1;
        System.out.println(divide(u, d));
    }

    public static int divide(int dividend, int divisor) {
        long up = dividend < 0? 0L-dividend:dividend;
        long down = divisor < 0? 0L-divisor: divisor;
        if(up == 0 || up < down)
            return 0;
        if(down == 0)
            return dividend > 0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        long res = 1;
        boolean flag = true;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }

        long tmpDown = down;

        while(up >= tmpDown) {
            tmpDown <<= 1;
            res <<= 1;
        }

        if(flag) {
            return (int)res;
        } else {
            if(res >= Integer.MAX_VALUE+1L) {
                return Integer.MIN_VALUE;
            } else {
                return -(int)res;
            }
        }
    }
}
