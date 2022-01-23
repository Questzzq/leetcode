package my_dfs;

import java.util.ArrayList;
import java.util.List;

class NewSolution {
    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        NewSolution solution = new NewSolution();
        List<List<Integer>> list = solution.allPathsSourceTarget(graph);
        for(List<Integer> li: list) {
            for(int i: li) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int len = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        boolean[] v = new boolean[len];
        List<Integer> path = new ArrayList<>();
        v[0] = true;
        path.add(0);
        dfs(list, path, graph, v, len-1);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> path, int[][] graph, boolean[] v, int t) {
        if(!path.isEmpty() && path.get(0) == 0 && path.get(path.size()-1) == t) {
            if(!list.contains(path)) {
                list.add(new ArrayList<>(path));
            }
            return;
        }
        if(path.isEmpty()) {
            path.add(0);
            v[0] = true;
            return;
        }
        int pre = path.get(path.size()-1);
        System.out.println("pre " + pre);
        int[] next = graph[pre];
        for(int i: next) System.out.println("next[ "+pre+" ] "+i);
        for(int i = 0; i < next.length; i++) {
            if(!v[next[i]]) {
                path.add(next[i]);
                v[next[i]] = true;
                dfs(list, path, graph, v, t);
                path.remove(path.size()-1);
                v[next[i]] = false;
            }
        }
    }
}