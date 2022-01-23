package my_Algorithm;

public class MyStringTest {
    public static void main(String[] args) {
        String s = "whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone";
        int count = 0;
        int len = s.length();
        for(int i = len; i > 0; i--) {
            for(int j = 0; j < len; j++) {
                if(j+i > len) {
                    continue;
                }
                count++;
                String subString = s.substring(j, j+i);
                if(isRight(subString)) {
                    System.out.println(subString);
                    break;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isRight(String s) {
        char[] c = s.toCharArray();
        int l = 0;
        int r = c.length-1;
        while(l<r) {
            if(c[l++]!=c[r--])
                return false;
        }
        return true;
    }
}
