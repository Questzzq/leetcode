package jianzhioffer;

class Twelve {
    public static void main(String[] args) {
        char[][] board = {{'A'}};
        String words = "A";
        Twelve twelve = new Twelve();
        System.out.println(twelve.exist(board, words));
    }

    private int m;
    private int n;
    private boolean flag;
    private String word;
    private final int[][] d = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    private boolean[][] v;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.v = new boolean[m][n];
        this.flag = false;
        this.word = word;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word.length() == 1 && board[i][j] == word.charAt(0)) {
                    return true;
                }
                if(board[i][j] == word.charAt(0)) {
                    dfs(board, v, new StringBuilder(), i, j);
                    if(flag)  return true;
                }
            }
        }
        return false;
    }

    private boolean isInArea(int x, int y) {
        return !(x < 0 || x >= m || y < 0 || y >= n);
    }

    private void dfs(char[][] board, boolean[][] v, StringBuilder path, int x, int y) {
        if(flag || !isInArea(x, y)) {
            return;
        }
        if(path.length() == word.length()) {
            flag = true;
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(isInArea(x, y) && !v[x][y]) {
                if(board[x][y] == word.charAt(path.length())) {
                    path.append(board[x][y]);
                    v[x][y] = true;
                    dfs(board, v, path, x+d[i][0], y+d[i][1]);
                    path.deleteCharAt(path.length()-1);
                    v[x][y] = false;
                }
            }
        }
    }
}