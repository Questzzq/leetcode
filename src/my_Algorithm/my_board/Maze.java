package my_Algorithm.my_board;

import java.util.ArrayDeque;
import java.util.Queue;

public class Maze {
    public static void main(String[] args) {
        char[][] board = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,2};
        Maze maze = new Maze();
        System.out.println(maze.nearestExit(board, entrance));
    }

    private int start_x, start_y;
    private int m;
    private int n;
    int[][] d = {{0, 1},{1,0},{0,-1},{-1,0}}; // 顺时针,右下左上

    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;
        start_x = entrance[0];
        start_y = entrance[1];
        boolean[][] v = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        v[start_x][start_y] = true;
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        int[] cur;
        int nx, ny;
        while(!queue.isEmpty()) {
            cur = queue.peek();
            if(isEnd(cur[0], cur[1]) && maze[cur[0]][cur[1]] == '.') {
                return cur[2];
            } else {
                for(int i = 0; i < 4; i++) {
                    nx = cur[0]+d[i][0];
                    ny = cur[1]+d[i][1];
                    if(isValid(nx, ny) && maze[nx][ny] != '+' && !v[nx][ny]) {
                        v[nx][ny] = true;
                        int[] next = new int[3];
                        next[0] = nx; next[1] = ny; next[2] = cur[2]+1;
                        System.out.println(next[0] + " " + next[1] + " " + next[2]);
                        queue.offer(next);
                    }
                }
            }
            queue.poll();
        }
        return -1;
    }

    private boolean isEnd(int x, int y) {
        if(x == start_x && y == start_y) return false;
        return x == 0 || y == 0 || x == m-1 || y == n-1;
    }

    private boolean isValid(int x, int y) {
        return !(x < 0 || y < 0 || x >= m || y >= n);
    }
}
