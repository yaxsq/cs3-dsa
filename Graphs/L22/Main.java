package L22;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addVertex("N1");
        graph.addVertex("N2");
        graph.addVertex("N3");

        graph.addEdge("n1", "n3");
        graph.addEdge("n2", "n1");
        graph.addEdge("n2", "n3");

        graph.display();

        System.out.println();
        graph.DFS("N1");
        System.out.println();
        graph.DFS("N3");
        System.out.println();

        graph.BFS("N1");
        System.out.println();
        graph.BFS("N3");
    }

}
