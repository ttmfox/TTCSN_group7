package TTCNSTest;

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.inPut();
		int source = graph.getSource();
		int sink = graph.getSink();
		EdmondsKarp ek = new EdmondsKarp(graph);
		int maxFlow = ek.findMaxFlow(source, sink);
		System.out.println("Luồng cực đại: " + maxFlow);
	}
}
