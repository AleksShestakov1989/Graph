package org.example;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Integer>> verticesInfo = new ArrayList<>();

    public int V;

    public Graph(int V) {
        this.V = V;
        for (int i = 0; i < V; i++) {
            verticesInfo.add(new ArrayList<>());

        }
    }

    public void addEdge(int a, int b) {
        verticesInfo.get(a).add(b);
        verticesInfo.get(b).add(a);

    }


    public ArrayList<Integer> adjacent(int v) {
        return verticesInfo.get(v);
    }


    public int size() {
        return V;
    }

}