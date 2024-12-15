package dinic;

//Lớp đại diện cho một cạnh trong đồ thị
public class Edge {
	
	int to, capacity, flow, reverseIndex;

	// Khởi tạo cạnh với đỉnh đến, dung lượng, và chỉ số cạnh ngược
	public Edge(int to, int capacity, int reverseIndex) {
		this.to = to;
		this.capacity = capacity;
		this.flow = 0;
		this.reverseIndex = reverseIndex;
	}
}
