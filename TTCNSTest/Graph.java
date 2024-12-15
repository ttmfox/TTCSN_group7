package TTCNSTest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Graph {
	private int[][] capacity; // Ma trận dung lượng
	private int numberElements; // Số lượng đỉnh
	private int sink;
	private int source;
	Scanner scanner = new Scanner(System.in);

	public Graph() {
	}

	// Thêm một cạnh với dung lượng cho trước
	public void addEdge(int from, int to, int capacityValue) {
		if (from < 0 || from >= numberElements || to < 0 || to >= numberElements) {
			throw new IllegalArgumentException("Chỉ số đỉnh không hợp lệ.");
		}
		if (capacityValue < 0) {
			throw new IllegalArgumentException("Dung lượng phải là số không âm.");
		}
		this.capacity[from][to] += capacityValue;
	}

	public void inPut() {
		try {
			System.out.print("Nhập số đỉnh của đồ thị: ");
			this.numberElements = scanner.nextInt();
			if (numberElements <= 0) {
				throw new IllegalArgumentException("Số đỉnh phải lớn hơn 0.");
			}
			this.capacity = new int[numberElements][numberElements];
			System.out.print("Nhập số cạnh của đồ thị: ");
			int numEdges = scanner.nextInt();
			if (numEdges < 0) {
				throw new IllegalArgumentException("Số cạnh phải là số không âm.");
			}
			System.out.println("Nhập các cạnh dưới dạng: from to capacity");
			for (int i = 0; i < numEdges; i++) {
				System.out.print("Cạnh " + (i + 1) + ": ");
				int from = scanner.nextInt();
				int to = scanner.nextInt();
				int capa = scanner.nextInt();
				addEdge(from, to, capa);
			}
			System.out.print("Nhập đỉnh nguồn: ");
			this.source = scanner.nextInt();
			System.out.print("Nhập đỉnh đích: ");
			this.sink = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
		} catch (IllegalArgumentException e) {
			System.out.println("Lỗi: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	public int[][] getCapacity() {
		return capacity;
	}

	public int getNumberElements() {
		return numberElements;
	}

	public int getSink() {
		return sink;
	}

	public int getSource() {
		return source;
	}
}
