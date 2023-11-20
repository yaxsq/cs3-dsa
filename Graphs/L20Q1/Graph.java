package L20Q1;

public class Graph {

    private Vertex[] adjacencyList;
    private int count;

    public Graph(int size) {
        adjacencyList = new Vertex[size];
        count = 0;
    }

    /**
     * adds a new vertex to the adjacencyList if there is a null node
     *
     * @param n
     * @param a
     */
    public void addVertex(String n, int a) {
        adjacencyList[count++] = new Vertex(n, a);

//        for (int i = 0; i < adjacencyList.length; i++) {
//            if (adjacencyList[i] == null) {
//                adjacencyList[i] = new Vertex(n, a);
//                return;
//            }
//        }
    }

    /**
     * goes through the adjacencyList to find n1
     * if n1 is found, n2 is added to its friendsList if n2 is found in the adjacencyList
     *
     * @param n1 node to be added to
     * @param n2 node to be added
     */
    public void addEdge(String n1, String n2) {
        for (int i = 0; i < adjacencyList.length; i++) {
            if (adjacencyList[i].name.equalsIgnoreCase(n1)) {       // if the list has a node matching with n1
                try {
                    adjacencyList[i].friendsList.insert(findVertex(n2));       // n2 is added to n1's friendList
//                    if (!findVertex(n2).friendsList.find(findVertex(n1))) {     // if n2 doesnt have n1 in its friendList
//                        addEdge(n2, n1);
//                    }
                } catch (NullPointerException ex) {
                    System.out.println("addEdge()   Second node not found");
                }
                return;
            }
        }
    }

    /**
     * deletes the vertex
     *
     * @param n
     */
    public void deleteVertex(String n) {
        LL friendList = null;

        int k;
        for (k = 0; k < adjacencyList.length; k++) {
            if (adjacencyList[k].name.equalsIgnoreCase(n)) {
                friendList = adjacencyList[k].friendsList;          // retreiving friendList
                break;
            }
        }

        clearFriendList(friendList, n);

        for (int i = 0; i < adjacencyList.length; i++) {
            if (adjacencyList[i] != null && adjacencyList[i].friendsList.find(findVertex(n))) {
                adjacencyList[i].friendsList.delete(findVertex(n));
            }
        }

        adjacencyList[k] = null;                            // deleting vertex

    }

    private void clearFriendList(LL friendList, String n) {
        while (!friendList.isEmpty()) {
            if ( (friendList.getHead() != null) && (friendList.getHead().v != null) ) {
                deleteEdge(n, friendList.getHead().v.name);
                friendList.delete(friendList.getHead().v);
            } else {
                return;
            }
        }
    }

    public void deleteEdge(String n1, String n2) {
        try {
            Vertex v1 = findVertex(n1);
            Vertex v2 = findVertex(n2);

            v1.friendsList.delete(v2);
//            v2.friendsList.delete(v1);

//            findVertex(n1).friendsList.delete(findVertex(n2));
//            findVertex(n2).friendsList.delete(findVertex(n1));
        } catch (NullPointerException ex) {
            System.out.println("deleteEdge()    null exception");
        }
    }

    public Vertex findVertex(String n) {
        for (int i = 0; i < adjacencyList.length; i++) {
//            try {
            if (adjacencyList[i] != null) {
                if (adjacencyList[i].name.equalsIgnoreCase(n)) {
                    return adjacencyList[i];
                }
            }
//            } catch (NullPointerException ex) {     }
        }
        return null;
    }

    /**
     * goes through all vertices' friendList to look for n
     * @param n
     * @return vertex which has a friendList containing the parameter
     */
    public Vertex findVertexFriendsList(String n) {
        Vertex vToFind = findVertex(n);

        for (int i = 0; i < adjacencyList.length; i++) {
            if (adjacencyList[i] != null) {
                if (adjacencyList[i].friendsList.get(vToFind) != null) {
                    return adjacencyList[i];
                }
            }
        }
        return null;
    }

    public String toString() {
        String out = "";

        for (int i = 0; i < adjacencyList.length; i++) {
            out += adjacencyList[i] + "\n";
        }
        return out;
    }

    public void print() {
        System.out.println(toString());
    }

}
