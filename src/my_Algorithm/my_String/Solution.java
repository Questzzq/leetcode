package my_Algorithm.my_String;

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        char[] n1;
        char[] n2;
        if(num1.length() > num2.length()) {
            n1 = num1.toCharArray();
            n2 = num2.toCharArray();
        } else {
            n1 = num2.toCharArray();
            n2 = num1.toCharArray();
        }
        int len1 = n1.length;
        int len2 = n2.length;
        int t, a, b, c; // c 乘积, t 进位
        for(int i = len2-1; i >= 0; i--) {
            a = n2[i]-'0';
            t = 0;
            StringBuilder tmpRes = new StringBuilder();
            for(int j = len1-1; j >= 0; j--) {
                b = n1[j]-'0';
                c = a*b + t;
                t = c/10; // t 表示乘的时候的进位
                tmpRes.append(c%10);
            }
            if(t > 0) {
                tmpRes.append(t);
            }
            for(int k = 0; k < len2-i-1; k++) {
                tmpRes.insert(0, 0);
            }
            String tmpString = addTwoString(res.toString(), tmpRes.reverse().toString());
            res = new StringBuilder(tmpString);
        }
        return res.toString();
    }

    private String addTwoString(String a, String b) {
        if(a==null || a.length()==0) {
            return b;
        }
        if(b==null || b.length()==0) {
            return a;
        }
        StringBuilder res = new StringBuilder();
        int m, n, s, t;
        t = 0;
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        reverseCharArray(ca);
        reverseCharArray(cb);
        int p1 = 0;
        int p2 = 0;
        int len1 = ca.length;
        int len2 = cb.length;
        while(p1 < len1 && p2 < len2) {
            m = ca[p1]-'0';
            n = cb[p2]-'0';
            s = m+n+t;
            t = s/10;
            res.append(s%10);
            p1++;
            p2++;
        }
        while(p1 < len1) {
            s = t+(ca[p1]-'0');
            t = s/10;
            res.append(s%10);
            p1++;
        }
        while(p2 < len2) {
            s = t+(cb[p2]-'0');
            t = s/10;
            res.append(s%10);
            p2++;
        }
        if(t > 0) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    private void reverseCharArray(char[] c) {
        int l = 0;
        int r = c.length-1;
        char p;
        while(l < r) {
            p = c[l];
            c[l] = c[r];
            c[r] = p;
            l++;
            r--;
        }
    }
}
