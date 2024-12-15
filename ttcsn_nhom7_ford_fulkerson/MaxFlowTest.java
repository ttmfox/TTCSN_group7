
package ttcsn_nhom7_ford_fulkerson;

public class MaxFlowTest {

   // Thử nghiệm 1: Đồ thị mẫu
    public  void testSampleGraph() {
        int[][] capacityMatrix = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };
        Graph graph = new Graph(6, capacityMatrix);
        MaxFlow maxFlow = new MaxFlow(graph);
        int source = 0;
        int sink = 5;

        System.out.println("Test 1 (Sample Graph): Max Flow = " + maxFlow.fordFulkerson(source, sink));
    }

    // Thử nghiệm 2: Không có đường đi
    public void testNoPath() {
        int[][] capacityMatrix = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        Graph graph = new Graph(4, capacityMatrix);
        MaxFlow maxFlow = new MaxFlow(graph);
        int source = 0;
        int sink = 3;

        System.out.println("Test 2 (No Path): Max Flow = " + maxFlow.fordFulkerson(source, sink));
    }              
 // Thử nghiệm 3: Nhiều đường đi
    public  void testMultiplePaths() {
        int[][] capacityMatrix = {
            {0, 10, 10, 0, 0},
            {0, 0, 0, 4, 8},
            {0, 0, 0, 8, 4},
            {0, 0, 0, 0, 10},
            {0, 0, 0, 0, 0}
        };
        Graph graph = new Graph(5, capacityMatrix);
        MaxFlow maxFlow = new MaxFlow(graph);
        int source = 0;
        int sink = 4;

        System.out.println("Test 3 (Multiple Paths): Max Flow = " + maxFlow.fordFulkerson(source, sink));
    }

    // Thử nghiệm 4: Kết nối đầy đủ
    public void testFullyConnected() {
        int[][] capacityMatrix = {
            {0, 5, 5, 5},
            {0, 0, 5, 5},
            {0, 0, 0, 5},
            {0, 0, 0, 0}
        };
        Graph graph = new Graph(4, capacityMatrix);
        MaxFlow maxFlow = new MaxFlow(graph);
        int source = 0;
        int sink = 3;

        System.out.println("Test 4 (Fully Connected): Max Flow = " + maxFlow.fordFulkerson(source, sink));
    }

    // Thử nghiệm 5: Có chu trình
    public void testWithCycle() {
        int[][] capacityMatrix = {
            {0, 3, 0, 3},
            {0, 0, 4, 0},
            {3, 0, 0, 2},
            {0, 0, 0, 0}
        };
        Graph graph = new Graph(4, capacityMatrix);
        MaxFlow maxFlow = new MaxFlow(graph);
        int source = 0;
        int sink = 3;
            
        System.out.println("Test 5 (With Cycle): Max Flow = " + maxFlow.fordFulkerson(source, sink));
    }

}
