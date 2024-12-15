package dinic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DinicMaxFlow {

	private final Graph graph;
	private int[] level; // Mảng lưu lớp của từng đỉnh
	private int[] ptr; // Mảng chỉ số con trỏ để theo dõi cạnh kế tiếp khi duyệt DFS

	// Khởi tạo thuật toán Dinic với số lượng đỉnh
	public DinicMaxFlow(int vertices) {
		graph = new Graph(vertices);
	}

	// Phương thức thêm cạnh vào đồ thị
	public void addEdge(int from, int to, int capacity) {
		graph.addEdge(from, to, capacity);
	}

	// Tìm giá trị luồng cực đại từ đỉnh nguồn đến đỉnh đích
	public int maxFlow(int source, int sink) {
		int maxFlow = 0;

		// Lặp lại cho đến khi không thể tạo thêm đồ thị lớp
		while (bfsLevelGraph(source, sink)) {
			ptr = new int[graph.adjList.size()]; // Đặt lại con trỏ DFS
			int flow;
			// Lặp DFS để tìm luồng tăng cường
			while ((flow = dfsFindAugmentingPath(source, sink, Integer.MAX_VALUE)) > 0) {
				maxFlow += flow; // Cộng dồn luồng tăng cường vào tổng luồng
			}
		}

		return maxFlow;
	}

	// Tạo đồ thị lớp bằng BFS
	private boolean bfsLevelGraph(int source, int sink) {
		level = new int[graph.adjList.size()];
		Arrays.fill(level, -1); // Đặt tất cả các lớp ban đầu là -1
		level[source] = 0; // Lớp của đỉnh nguồn là 0
		Queue<Integer> queue = new LinkedList();
		queue.add(source);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Edge edge : graph.getNeighbors(u)) {
				// Nếu đỉnh kề chưa được gán lớp và còn dung lượng dư	
				if (level[edge.to] == -1 && edge.capacity > edge.flow) {
					level[edge.to] = level[u] + 1; // Gán lớp cho đỉnh kề
					queue.add(edge.to);
				}
			}
		}
		return level[sink] != -1; // Trả về true nếu đỉnh đích có lớp
	}

	// Tìm đường tăng cường bằng DFS
	private int dfsFindAugmentingPath(int u, int sink, int flowIn) {
		if (u == sink) { // Nếu đã đến đỉnh đích, trả về luồng đầu vào
			return flowIn;
		}
		for (; ptr[u] < graph.getNeighbors(u).size(); ptr[u]++) {
			Edge edge = graph.getEdge(u, ptr[u]);
			// Chỉ tiếp tục nếu cạnh thuộc đồ thị lớp và còn dung lượng dư
			if (level[edge.to] == level[u] + 1 && edge.capacity > edge.flow) {
				int flowToV = Math.min(flowIn, edge.capacity - edge.flow); // Dòng chảy khả dụng
				int flowSent = dfsFindAugmentingPath(edge.to, sink, flowToV); // Gọi đệ quy
				if (flowSent > 0) { // Nếu tìm được luồng tăng cường
					edge.flow += flowSent; // Cập nhật dòng chảy trên cạnh xuôi
					graph.getEdge(edge.to, edge.reverseIndex).flow -= flowSent; // Cập nhật dòng chảy trên cạnh ngược
					return flowSent;
				}
			}
		}
		return 0; // Không tìm thấy luồng tăng cường
	}
}
