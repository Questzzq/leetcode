package my_Algorithm;

public class Romans {
    public static void main(String[] args) {
        System.out.println(intToRoman(4));
    }
    public static String intToRoman(int num) {
        //                  1    5    10   50   100  500  1000  4     9    40    90     400  900
        //                  0    1    2    3    4    5    6     7     8    9     10     11   12
        String[] romans = {"I", "V", "X", "L", "C", "D", "M", "IV", "IX", "XL", "XC", "CD", "CM"}; //13  0-12
        int[] counts = new int[13];
        for(int i = 0; i < 13; i++)
            counts[i] = 0;
        for(int i = 0; i < 13; i++) {
            System.out.print(counts[i] + " ");
        }
        System.out.println();
        counts[6] = num/1000;
        counts[5] = (num%1000)/500;
        counts[4] = ((num%1000)%500)/100;
        counts[3] = (((num%1000)%500)%100)/50;
        counts[2] = ((((num%1000)%500)%100)%50)/10;
        counts[1] = (((((num%1000)%500)%100)%50)%10)/5;
        counts[0] = (((((num%1000)%500)%100)%50)%10)%5;
        if(counts[0] == 4) {
            if(counts[1] == 1) {
                counts[0] = 0;
                counts[1] = 0;
                counts[8] = 1;
            } else {
                counts[0] = 0;
                counts[7] = 1;
            }
        }
        if(counts[2] == 4) {
            if(counts[3] == 1) {
                counts[2] = 0;
                counts[3] = 0;
                counts[10] = 1;
            } else {
                counts[2] = 0;
                counts[9] = 1;
            }
        }
        if(counts[4] == 4) {
            if(counts[5] == 1) {
                counts[4] = 0;
                counts[5] = 0;
                counts[12] = 1;
            } else {
                counts[4] = 0;
                counts[11] = 1;
            }
        }
        for(int i = 0; i < 13; i++) {
            System.out.print(counts[i]+" ");
        }
        System.out.println();
        StringBuilder sb = new StringBuilder();
        for(int i = 6; i>=0; i--) {
            int t = counts[i];
            while(t>0) {
                sb.append(romans[i]);
                t--;
            }
        }
        return sb.toString();
    }
}
