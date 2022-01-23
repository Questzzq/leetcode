package my_Algorithm.my_board;

import java.util.HashSet;
import java.util.Set;

public class MyTest {
    public static void main(String[] args) {
        char[][] board = {
                {'.','.','4',	'.','.','.',	'6','3','.'},
                {'.','.','.',	'.','.','.',	'.','.','.'},
                {'5','.','.',	'.','.','.',	'.','9','.'},

                {'.','.','.',	'5','6','.',	'.','.','.'},
                {'4','.','3',	'.','.','.',	'.','.','1'},
                {'.','.','.',	'7','.','.',	'.','.','.'},

                {'.','.','.',	'5','.','.',	'.','.','.'},
                {'.','.','.',	'.','.','.',	'.','.','.'},
                {'.','.','.',	'.','.','.',	'.','.','.'}
        };
        System.out.println(isValidSudoku(board));
//        Set<Character> set = new HashSet<>();
//        set.add('1');
//        System.out.println(set.add('1'));
//        System.out.println(set.add('2'));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        // 先判断行
        for (int i = 0; i < 9; i++) {
            char[] t = new char[9];
            set.clear();
            for (int j = 0; j < 9; j++) {
                t[j] = board[i][j];
                if (!set.add(board[i][j])) {
//                    return false;
                }
            }
//            for(char ch: t) {
//                System.out.print(ch + " ");
//            }
//            System.out.println();
        }
        // 再判断列
        for (int j = 0; j < 9; j++) {
            set.clear();
            char[] t = new char[9];
            for (int i = 0; i < 9; i++) {
                t[i] = board[i][j];
                if (!set.add(board[i][j])) {
//                    return false;
                }
            }
            for(char ch: t) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
        // 判断每一个小3x3
        for (int row = 0; row <= 6; row+= 3) {
            for(int col = 0; col <= 6; col += 3) {
                char[][] temp = new char[3][3];
                set.clear();
                for (int i = row, p = 0; i < row + 3; i++, p++) {
                    for (int j = col, q = 0; j < col + 3; j++, q++) {
                        temp[p][q] = board[i][j];
                        if(board[i][j] != '.' && !set.add(board[i][j])) {
//                            return false;
                        }
                    }
                }
                printChar(temp);
            }
        }
        return true;
    }

    private static void printChar(char[][] temp) {
        for(int pp = 0; pp < 3; pp++) {
            for(int qq = 0; qq < 3; qq++) {
                System.out.print(temp[pp][qq] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
