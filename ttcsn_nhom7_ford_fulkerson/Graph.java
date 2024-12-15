/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcsn_nhom7_ford_fulkerson;

/**
 *
 * @author DELL 5625
 */
public class Graph {
    private int V; // Số lượng đỉnh trong đồ thị
    private int[][] capacityMatrix; // Ma trận dung lượng

    public Graph(int V, int[][] capacityMatrix) {
        this.V = V;
        this.capacityMatrix = capacityMatrix;
    }

    public int getVertexCount() {
        return V;
    }

    public int[][] getCapacityMatrix() {
        return capacityMatrix;
    }
}
