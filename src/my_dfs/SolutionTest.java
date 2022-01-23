package my_dfs;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    public static void main(String[] args) {
        int a = 16;
        int b = 8;
        int c = 4;
        SolutionTest solutionTest = new SolutionTest();
        System.out.println(solutionTest.movingCount(a, b, c));
    }

    private int m;
    private int n;
    private int k;
    private final int[][] d = {{0,1},{1,0}};
    private boolean[][] v;

    public int movingCount(int m, int n, int k) {
        System.out.println("k = " + k);
        this.k = k;
        this.m = m;
        this.n = n;
        this.v = new boolean[m][n];
        return dfs(0, 0);
    }

    private int dfs(int x, int y) {
        if(x < 0 || y < 0 || x >= m || y >= n || v[x][y] || getSum(x)+getSum(y) > k)
            return 0;
        v[x][y] = true;
        return 1+dfs(x+d[0][0], y+d[0][1]) + dfs(x+d[1][0], y+d[1][1]);
    }

    private int getSum(int a) {
        int sum = 0;
        while(a > 0) {
            sum += a%10;
            a /= 10;
        }
        return sum;
    }
}