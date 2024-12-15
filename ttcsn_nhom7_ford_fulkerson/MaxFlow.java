
package ttcsn_nhom7_ford_fulkerson;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class MaxFlow {
    private Graph graph;
    private int V;

    public MaxFlow(Graph graph) {
        this.graph = graph;
        this.V = graph.getVertexCount();
    }

    // Hàm thực hiện tìm kiếm đường tăng bằng thuật toán gán nhãn (BFS)
    private boolean bfsWithLabeling(int[][] residualGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                // Gán nhãn cho các đỉnh chưa thăm và có dung lượng dư dương
                if (!visited[v] && residualGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;

                    // Dừng nếu đã đến đích
                    if (v == sink) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Hàm chính thực hiện thuật toán Ford-Fulkerson
    public int fordFulkerson(int source, int sink) {
        int[][] residualGraph = new int[V][V];
        int[][] capacityMatrix = graph.getCapacityMatrix();

        // Tạo đồ thị dư ban đầu (copy từ đồ thị gốc)
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                residualGraph[u][v] = capacityMatrix[u][v];
            }
        }

        int[] parent = new int[V]; // Mảng lưu đường đi của BFS
        int maxFlow = 0; // Lưu luồng cực đại

        // Tìm đường tăng khi còn đường khả dụng
        while (bfsWithLabeling(residualGraph, source, sink, parent)) {
            // Tìm dung lượng khả dụng nhỏ nhất trên đường tăng
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            // Cập nhật luồng và đồ thị dư
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }
            // Cộng thêm luồng của đường vừa tìm được
            maxFlow += pathFlow;
        }
        return maxFlow;
    }
}
