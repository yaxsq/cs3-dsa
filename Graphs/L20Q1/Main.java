package L20Q1;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(5);

        // Adding vertices
        graph.addVertex("N1", 1);
        graph.addVertex("N2", 1);
        graph.addVertex("N3", 3);
        graph.addVertex("N4", 2);
        System.out.println("Initial");
        graph.print();

        // Adding edges
        graph.addEdge("n1", "n2");
        graph.addEdge("n1", "N4");
        graph.addEdge("n3", "n2");
        graph.addEdge("n3", "n1");
        System.out.println("Edges added");
        graph.print();

        System.out.println("Invalid Edge: ");
        graph.addEdge("n2", "n5");              // error bc n5 does not exist
        graph.print();

        // Find function
        System.out.println("Find n1: " + graph.findVertex("n1"));

        // FindVertexFriendList
        System.out.println("Find n3 in FL: " + graph.findVertexFriendsList("n3"));
        System.out.println("Find n4 in FL: " + graph.findVertexFriendsList("n4"));

        // Delete
        graph.deleteVertex("n2");
        System.out.println("\nDeleting N2");
        graph.print();

        // Deleting edge
        graph.deleteEdge("n1", "n4");               // deletes normally
        System.out.print("Null expected: ");
        graph.deleteEdge("n1", "n2");
        graph.print();

    }

}