package dinic;

public class Main {

	public static void main(String[] args) {
		int vertices = 6; // Số lượng đỉnh trong đồ thị ví dụ
		DinicMaxFlow dinic = new DinicMaxFlow(vertices);
		// Thêm các cạnh vào đồ thị
		dinic.addEdge(0, 1, 10);
		dinic.addEdge(0, 2, 10);
		dinic.addEdge(1, 2, 2);
		dinic.addEdge(1, 3, 4);
		dinic.addEdge(1, 4, 8);
		dinic.addEdge(2, 4, 9);
		dinic.addEdge(3, 5, 10);
		dinic.addEdge(4, 3, 6);
		dinic.addEdge(4, 5, 10);
		// Tính toán và in ra luồng cực đại
		System.out.println("Maximum Flow: " + dinic.maxFlow(0, 5)); // Output maximum flow
	}
}
