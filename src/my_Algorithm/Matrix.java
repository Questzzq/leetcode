package my_Algorithm;

public class Matrix {
    public static void main(String[] args) {
        int[][] nums = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        print(nums);
        rotate(nums);
//        print(nums);
    }

    private static void print(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        // 22:34
        int r = matrix.length;
        int c = matrix[0].length;
        System.out.println("r = " + r);
        System.out.println("c = " + c);
        for(int i = 0; i < r; i++) {
            for(int j = i; j < c; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        print(matrix);
        int m = c%2==0?c/2-1:c/2;
        System.out.println("m = " + m);
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < m; j++) {
                int t = matrix[i][j];
                System.out.println("t = " + t);
                System.out.println("matrix[i][c-j-1] = " + matrix[i][c-j-1]);
                matrix[i][j] = matrix[i][c-j-1];
                matrix[i][c-j-1] = t;
            }
        }
        print(matrix);
    }
}
