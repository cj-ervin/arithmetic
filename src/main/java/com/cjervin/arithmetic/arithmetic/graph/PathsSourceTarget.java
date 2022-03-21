package com.cjervin.arithmetic.arithmetic.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ervin
 * @Date 2022/3/21
 */
public class PathsSourceTarget {


    //graph = [[1,2],[3],[3],[]]，
    // 记录所有路径
    List<List<Integer>> res = new LinkedList<>();

    /**
     * 图 -- 所有可能的路径
     * <p>
     * https://leetcode-cn.com/problems/all-paths-from-source-to-target/solution/suo-you-ke-neng-de-lu-jing-by-changxiaoj-ollp/
     *
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 维护递归过程中经过的路径
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int i, LinkedList<Integer> path) {
        path.add(i);
        int length = graph.length;
        if (i == length - 1) {
            //表明该路径已经走到了终点
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for (int m : graph[i]) {
            traverse(graph, m, path);
        }
        //走到这里表示，该路径还没有走到终点已经无路可走了
        //所以要 removeLat 删掉当前节点，为什么不 path.remove(),删掉所有节点
        //因为现在只知道当前节点无法到达终点，没准返回上一级节点，人家又其他节点可以到达终点
        path.removeLast();
    }


}
