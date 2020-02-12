package longestPathInDAG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Leetcode
 * Created by Ventus on 2019/11/21 3:53 PM
 */

public class Graph {
    public int vertices;

    public HashMap<Integer, ArrayList<AdjListNode>> adjs;

    public Graph(int v) {
        vertices = v;
        adjs = new HashMap<>();
    }

    public void addEdge(int u, int v, int weight) {
        AdjListNode node = new AdjListNode(v, weight);
        ArrayList<AdjListNode> uNodes = adjs.get(u);
        if (null == uNodes) {
            uNodes = new ArrayList<>();
        }
        uNodes.add(node);
        adjs.put(u, uNodes);
    }

    public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        ArrayList<AdjListNode> adjListNodes = adjs.get(v);
        if (null == adjListNodes) return;
        for (int i = 0; i < adjListNodes.size(); i++) {
            AdjListNode node = adjListNodes.get(i);
            if (!visited[node.getV()]) {
                topologicalSortUtil(node.getV(), visited, stack);
            }
        }
        stack.push(v);
    }

    public void longestPath(int s) {
        Stack<Integer> stack = new Stack<>();
        int[] dist = new int[this.vertices];
        boolean[] visited = new boolean[this.vertices];

        for (int i = 0; i < visited.length; i++)  {
            visited[i] = false;
            dist[i] = Integer.MIN_VALUE;
        }

        dist[0] = 0;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.empty()) {
            int u = stack.peek();
            stack.pop();

            if (dist[u] != Integer.MIN_VALUE) {
                ArrayList<AdjListNode> node = adjs.get(u);
                if (null != node) {
                    for (AdjListNode n : node) {
                        if (dist[n.getV()] < dist[u] + n.getWeight()) {
                            dist[n.getV()] = dist[u] + n.getWeight();
                        }
                    }
                }
            }
        }

        for (int d : dist) {
            if (d != Integer.MIN_VALUE) {
                System.out.println(d);
            } else {
                System.out.println("Null");
            }
        }
    }

    public class AdjListNode {
        int v;
        int weight;

        public AdjListNode(int v, int w) {
            this.v = v;
            this.weight = w;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
