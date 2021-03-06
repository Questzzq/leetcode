package jianzhioffer;

public class Jian16 {
    public static void main(String[] args) {
        double x =  2;
        int n = -3;
        Jian16 jian16 = new Jian16();
        System.out.println(jian16.myPow1(x, n));
    }
    public double myPow(double x, int n) {
        if(x == 0) return 0.0;
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(n == -1) return 1.0/x;
        double t = myPow(x, n>>1);
        return (n&1)==1?t*t*x:t*t;
    }
    private double myPow1(double x, int n) {
        boolean flag = n > 0;
        double res = 1;
        while(n != 0) {
            if((n&1)==1) {
                res *= x;
            }
            x *= x;
            n/=2;
        }
        return flag?res:1/res;
    }
}
