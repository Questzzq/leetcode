package my_Algorithm.my_board;

public class MyBFS {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String target = "FCE";
        System.out.println(exist(board, target));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] direction = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        boolean[][] v = new boolean[m][n];
        boolean[] flag = new boolean[1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    dfs(board, v, new StringBuilder(), word, direction, i, j, flag);
                    if(flag[0]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isInArea(int x, int y, int m, int n) {
        return !(x < 0 || x >= m || y < 0 || y >= n);
    }

    private static void dfs(char[][] board, boolean[][] v,
                            StringBuilder path, String s, int[][] direction, int x, int y, boolean[] flag) {
        if(flag[0] || !isInArea(x, y, board.length, board[0].length)) {
            return;
        }
        if(path.length() == s.length()) {
            System.out.println(path);
            flag[0] = true;
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(isInArea(x, y, board.length, board[0].length) && !v[x][y]) {
                if(board[x][y] == s.charAt(path.length())) {
                    path.append(board[x][y]);
                    v[x][y] = true;
                    dfs(board, v, path, s, direction, x+direction[i][0], y+direction[i][1], flag);
                    path.deleteCharAt(path.length()-1);
                    v[x][y] = false;
                }
            }
        }
    }
}
