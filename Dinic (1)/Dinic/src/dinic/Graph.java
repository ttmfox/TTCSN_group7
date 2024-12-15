package dinic;

import java.util.ArrayList;
import java.util.List;

//Lớp đại diện cho đồ thị dưới dạng danh sách kề
public class Graph {

	List<List<Edge>> adjList;

	// Khởi tạo đồ thị với số lượng đỉnh cho trước
	public Graph(int vertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// Thêm cạnh vào đồ thị
	public void addEdge(int from, int to, int capacity) {
		// Tạo cạnh xuôi và cạnh ngược
		Edge forwardEdge = new Edge(to, capacity, adjList.get(to).size());
		Edge reverseEdge = new Edge(from, 0, adjList.get(from).size());
		adjList.get(from).add(forwardEdge);
		adjList.get(to).add(reverseEdge);
	}

	// Lấy danh sách các cạnh kề của một đỉnh
	public List<Edge> getNeighbors(int vertex) {
		return adjList.get(vertex);
	}

	// Lấy cạnh từ một đỉnh theo chỉ số
	public Edge getEdge(int from, int index) {
		return adjList.get(from).get(index);
	}
}
