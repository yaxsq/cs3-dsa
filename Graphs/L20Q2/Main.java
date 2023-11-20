package L20Q2;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(3);
        graph.display();

        // Adding vertices
        graph.addVertex("N1");
        graph.addVertex("N2");
        graph.addVertex("N3");
        System.out.println("Adding vertices");
        graph.display();

        // Adding edges
        graph.addEdge("n1", "n3");
        System.out.println("N1, N3");
        graph.display();

        graph.addEdge("n2", "n1");
        System.out.println("N2, N1");
        graph.display();

        graph.addEdge("n1", "n1");
        System.out.println("N1, N1");
        graph.display();

    }

}
