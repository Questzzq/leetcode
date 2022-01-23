package my_Algorithm;

public class StringTest {
    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        System.out.println(addBinary(a, b));
    }
    public static String addBinary(String a, String b) {
        if(a==null) {
            return b;
        }
        if(b==null) {
            return a;
        }
        return getResult(a, b);
    }

    private static String getResult(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int flag = 0;
        int sum = 0;
        int cur = 0;
        int pa = ca.length-1;
        int pb = cb.length-1;
        while(pa >= 0 && pb >= 0) {
            sum = ca[pa--] - '0' + cb[pb--] - '0' + flag;
            cur = sum%2;
            flag = sum/2;
            sb.append(cur);
        }
        while(pa >= 0) {
            sum = ca[pa--] - '0' + flag;
            cur = sum%2;
            flag = sum/2;
            sb.append(cur);
        }
        while(pb >= 0) {
            sum = cb[pb--] - '0' + flag;
            cur = sum%2;
            flag = sum/2;
            sb.append(cur);
        }
        if(flag > 0) {
            sb.append(1);
        }
        StringBuilder res = new StringBuilder();
        for(int i = 1; i <= sb.length(); i++) {
            res.append(sb.charAt(sb.length()-i));
        }
        return res.toString();
    }
}
