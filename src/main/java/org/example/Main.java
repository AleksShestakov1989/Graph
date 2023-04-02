package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        calcPaths(graph);
    }

    public static int dfs(Graph graph, int v, int mark, int[] marks) {
        marks[v] = mark;
        int size = 1;
        for (int vv : graph.adjacent(v)) {
            if (marks[vv] == 0) {
                size += dfs(graph, vv, mark, marks);
            }
        }
        return size;
    }

    public static void calcPaths(Graph graph) {
        int[] marks = new int[graph.size()];
        ArrayList<Integer> markSizes = new ArrayList<>();
        markSizes.add(0);
        for (int v = 0; v < graph.size(); v++) {
            if (marks[v] == 0) {
                int nextMark = markSizes.size();
                int size = dfs(graph, v, nextMark, marks);
                markSizes.add(size);
            }
        }
        int[] answer = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            answer[i] = markSizes.get(marks[i]) - 1;
        }
        System.out.println("Сколько достижимо городов для каждого города: " + Arrays.toString(answer));
    }
}
