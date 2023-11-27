import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private Vertex[] adjacencyList;
    private int count;

    public Graph(int size) {
        adjacencyList = new Vertex[size];
        count = 0;
    }

    public void addVertex(String n, int a) {
        adjacencyList[count++] = new Vertex(n, a);
    }

    public void addEdge(String n1, String n2) {
        Vertex v1 = findVertex(n1);
        Vertex v2 = findVertex(n2);
        if (v1 != null && v2 != null) {
            v1.friendsList.add(findVertex(n2));
            v2.friendsList.add(findVertex(n1));
        }
    }

    public Vertex findVertex(String name) {
        for (int i = 0; i < count; i++) {
            if (adjacencyList[i] != null && adjacencyList[i].name.equalsIgnoreCase(name)) {
                return adjacencyList[i];
            }
        }
        return null;
    }

    public void BFS() {
        boolean[] visited = new boolean[count];
        Queue<Vertex> queue = new ArrayDeque<>();

        Vertex firstVertex = adjacencyList[0];              // starting at the first vertex
        visited[0] = true;
        queue.add(firstVertex);
        System.out.print(" " + firstVertex.name);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            LinkedList<Vertex> neighbors = currentVertex.friendsList;

            for (Vertex neighbor : neighbors) {       // visiting all neighbours
                int nIndex = getIndex(neighbor);

                if (nIndex != -1 && !visited[nIndex]) {
                    visited[nIndex] = true;
                    queue.add(neighbor);
                    System.out.print(" " + neighbor.name);
                }
            }
        }
        System.out.println();
    }

    public void shortestPath(String l1, String l2) {
        boolean[] visited = new boolean[count];                     // BFS
        int[] previousNodes = new int[count];
        Queue<Vertex> queue = new ArrayDeque<>();

        int start = -1, end = -1;
        for (int i = 0; i < count; i++) {
            if (adjacencyList[i].name.equalsIgnoreCase(l1)) {
                start = i;
            } else if (adjacencyList[i].name.equalsIgnoreCase(l2)) {
                end = i;
            }
        }

        if (start == -1 || end == -1) {
            System.out.println("Invalid vertices");
            return;
        }

        visited[start] = true;
        queue.add(adjacencyList[start]);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            LinkedList<Vertex> neighbors = currentVertex.friendsList;

            for (Vertex neighbor : neighbors) {
                int nIndex = getIndex(neighbor);

                if (nIndex != -1 && !visited[nIndex]) {
                    visited[nIndex] = true;
                    queue.add(neighbor);
                    previousNodes[nIndex] = getIndex(currentVertex);
                }
            }
        }

        System.out.println("Shortest path from " + l1 + " to " + l2 + ":");
        printShortestPath(start, end, previousNodes);
    }

    private void printShortestPath(int start, int end, int[] previousNodes) {
        if (start != end && !isNull(previousNodes) ) {          // checking if path exists
            LinkedList<String> path = new LinkedList<>();
            int current = end;

            while (current != start) {
                path.addFirst(adjacencyList[current].name);
                current = previousNodes[current];
            }

            path.addFirst(adjacencyList[start].name);

            for (String node : path) {
                System.out.print(node + " > ");
            }
            System.out.println("End");
        }
    }

    private boolean isNull(int[] previousNodes) {
        for (int i = 0; i < previousNodes.length; i++) {
            if (previousNodes[i] != 0) {
                return false;
            }
        }
        System.out.println(" No path ");
        return true;
    }

    private int getIndex(Vertex v) {
        for (int i = 0; i < count; i++) {
            if (adjacencyList[i] == v) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (adjacencyList[i] != null) {
                result.append(adjacencyList[i].toString()).append("\n");
            }
        }
        return result.toString();
    }

    public void print() {
        System.out.println(toString());
    }

}