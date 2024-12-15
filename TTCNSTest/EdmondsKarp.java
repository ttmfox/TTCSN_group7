package TTCNSTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EdmondsKarp {
	private int[][] capacity;
	private int[][] flow;
	private int numberElements;

	public EdmondsKarp(Graph graph) {
		this.numberElements = graph.getNumberElements();
		this.capacity = graph.getCapacity();
		this.flow = new int[numberElements][numberElements];
	}

	public int findMaxFlow(int source, int sink) {
		if (source < 0 || source >= numberElements || sink < 0 || sink >= numberElements) {
			throw new IllegalArgumentException("Đỉnh nguồn hoặc đích không hợp lệ.");
		}
		int maxFlow = 0;
		while (true) {
			int[] parent = new int[numberElements];
			Arrays.fill(parent, -1);
			Queue<Integer> queue = new LinkedList<>();
			queue.add(source);
			parent[source] = source;
			while (!queue.isEmpty() && parent[sink] == -1) {
				int current = queue.poll();
				for (int next = 0; next < numberElements; next++) {
					if (parent[next] == -1 && capacity[current][next] - flow[current][next] > 0) {
						parent[next] = current;
						queue.add(next);
						if (next == sink) {
							break;
						}
					}
				}
			}
			if (parent[sink] == -1) {
				break;
			}
			int pathFlow = Integer.MAX_VALUE;
			for (int v = sink; v != source; v = parent[v]) {
				int u = parent[v];
				pathFlow = Math.min(pathFlow, capacity[u][v] - flow[u][v]);
			}
			for (int v = sink; v != source; v = parent[v]) {
				int u = parent[v];
				flow[u][v] += pathFlow;
				flow[v][u] -= pathFlow;
			}
			maxFlow += pathFlow;
		}
		return maxFlow;
	}
}
