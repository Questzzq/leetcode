package my_Algorithm;

public class MyUnionFind {
    public static void main(String[] args) {
        int t[][] = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(t));
    }

    public static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] father = new int[len];
        for(int i = 0; i < len; i++) {
            father[i] = i;
        }
        for(int i = 0; i < len; i++) {
            for(int j = i+1; j < len; j++) {
                if (isConnected[i][j] == 1){
                    union(father, i, j);
                }
            }
        }
        int res = 0;
        for(int i = 1; i < len; i++) {
            if(father[i] == i) {
                res++;
            }
        }
        return res;
    }

    private static void union(int[] father, int a, int b) {
        father[find(father, a)] = find(father, b);
    }

    private static int find(int[] father, int x) {
        if(father[x] != x) {
            father[x] = find(father, father[x]);
        }
        return father[x];
    }
}

class Test {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] father = new int[len];
        for(int i = 0; i < len; i++)
            father[i] = i;
        for(int i = 0; i < len; i++) {
            for(int j = i+1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(father, i, j);
                }
            }
        }
        int res = 0;
        for(int i = 1; i < len; i++) {
            if(father[i] == i) {
                res++;
            }
        }
        return res;
    }

    private void union(int[] father, int a, int b) {
        father[find(father, a)] = find(father, b);
    }

    private int find(int[] father, int x) {
        if(father[x] != x) {
            father[x] = find(father, father[x]);
        }
        return father[x];
    }
}