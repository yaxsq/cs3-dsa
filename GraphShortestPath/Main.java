public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(6);

        // adding vertices
        graph.addVertex("n1", 2);
        graph.addVertex("N2", 3);
        graph.addVertex("N3", 2);
        graph.addEdge("n1", "n2");
        graph.print();

        // setting up edges
        graph.addEdge("n2", "n1");
        graph.addEdge("n2", "n3");
        graph.addEdge("n3", "n2");
        graph.print();

        graph.BFS();

        // No direct link bw n1 and n3
        graph.shortestPath("n1", "n3");             // n1 > n2 > n3

        graph.addVertex("n4", 1);
        graph.addVertex("n5", 2);
        graph.shortestPath("n5", "N4");             // no path
        graph.shortestPath("n2", "n1");             // n2 to n1

        graph.addEdge("n3", "n4");
        graph.BFS();                                // n5 does not print bc unconnected with main cluster

    }

}
