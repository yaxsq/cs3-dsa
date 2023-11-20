package L22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private ArrayList<Vertex> adjacencyList;
    private boolean[] visitedNodes;

    public Graph() {
        adjacencyList = new ArrayList<>();
    }

    public void addVertex(String label) {
        adjacencyList.add(new Vertex(label));
    }

    public void addEdge(String l1, String l2) {
        try {
            find(l1).LL.add(find(l2));
//        find(l2).LL.add(find(l1));
        } catch (NullPointerException ex) {
            System.out.println("addEdge()   Node not found");
        }
    }

    private Vertex find(String label) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (adjacencyList.get(i).label.equalsIgnoreCase(label)) {
                return adjacencyList.get(i);
            }
        }
        return null;
    }

    private int findIndex(String label) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (adjacencyList.get(i).label.equalsIgnoreCase(label)) {
                return i;
            }
        }

        return -1;
    }

    public void DFS(String source) {
        Stack<Vertex> stack = new Stack<>();
        Vertex start = find(source);

        if (start == null) {
            System.out.println("Source not found");
            return;
        }

        visitedNodes = new boolean[adjacencyList.size()];
        stack.push(start);
        visitedNodes[findIndex(start.label)] = true;
        System.out.print(start.label + " ");

        while (!stack.isEmpty()) {
            Vertex current = stack.peek();
            Vertex nextNeighbor = findUnvisitedNeighbor(current);

            if (nextNeighbor != null) {
                visitedNodes[findIndex(nextNeighbor.label)] = true;
                System.out.print(nextNeighbor.label + " ");
                stack.push(nextNeighbor);
            } else {
                stack.pop();
            }
        }
    }

    private Vertex findUnvisitedNeighbor(Vertex v) {
        for (Vertex neighbor : v.LL) {
            if (!visitedNodes[findIndex(neighbor.label)]) {
                return neighbor;
            }
        }
        return null;
    }

    public void BFS(String source) {
        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = find(source);

        if (start == null) {
            System.out.println("Source vertex not found");
            return;
        }

        visitedNodes = new boolean[adjacencyList.size()];
        queue.add(start);
        visitedNodes[findIndex(start.label)] = true;
        System.out.print(start.label + " ");

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            for (Vertex neighbor : current.LL) {
                if (!visitedNodes[findIndex(neighbor.label)]) {
                    visitedNodes[findIndex(neighbor.label)] = true;
                    System.out.print(neighbor.label + " ");
                    queue.add(neighbor);
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println(adjacencyList.get(i).toString());
        }
    }

}
