package L20Q2;

public class Graph {

    private Vertex[] vertexList;
    private int[][] adjacencyMatrix;
    private int count;

    public Graph(int size) {
        vertexList = new Vertex[size];
        adjacencyMatrix = new int[size][size];
        initialiseMatrix();
        count = 0;
    }

    public void addVertex(String label) {
        vertexList[count++] = new Vertex(label);
    }

    public void addEdge(String n1, String n2) {
        if (!n1.equalsIgnoreCase(n2)) {
            adjacencyMatrix[findVertexIndex(n1)][findVertexIndex(n2)] = 1;
            adjacencyMatrix[findVertexIndex(n2)][findVertexIndex(n1)] = 1;
        } else {
            System.out.println("Same nodes");
        }
    }

    private int findVertexIndex(String n) {

        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i].label.equalsIgnoreCase(n)) {
                return i;
            }
        }

        return -1;
    }

    private void initialiseMatrix() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length ; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }
    public void display() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
