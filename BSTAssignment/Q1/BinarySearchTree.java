package Q1;

public class BinarySearchTree<T extends Comparable<T>> {

    Node<T> root;

    /**
     * @param key value to be inserted
     */
    public void insert(T key) {
        if (root == null) {                                 //if tree is empty
            root = new Node<>(key);
            System.out.println("INSERTROT: " + root.data);
        } else {
            Node<T> current = root;
            Node<T> parent = null;                          //stores the node before current

            while (current != null) {
                parent = current;

                if (key.compareTo(current.data) < 0) {             //if new data is <= node data
                    current = current.left;
                } else {
                    current = current.right;                        //if new data is > node data
                }
            }

            if (key.compareTo(parent.data) <= 0) {
                parent.left = new Node<>(key);
                System.out.println("INSERTING: " + parent.left.data);
            } else {
                parent.right = new Node<>(key);
                System.out.println("INSERTING: " + parent.right.data);
            }
        }


    }

    private String LNRs(Node n) {
        StringBuilder result = new StringBuilder();
        LNRs(n, result);
        return result.toString();
    }

    private void LNRs(Node node, StringBuilder result) {
        if (node == null) {
            return;
        }
        LNRs(node.left, result);
        result.append(node.data).append(" ");
        LNRs(node.right, result);
    }

    /**
     * uses helper method LNRs to make a string of all nodes using the parameter root node
     * the string is then split into an array and nodes are printed in the range k1, k2
     * @param root
     * @param k1
     * @param k2
     */
    public void printRange(Node root, int k1, int k2) {
        String[] nodes = LNRs(root).split(" ");
        for (int i = 0; i < nodes.length; i++) {
            if (Integer.parseInt(nodes[i]) >= k1 && Integer.parseInt(nodes[i]) <= k2) {
                System.out.print(nodes[i] + " ");
            }
        }
        System.out.println();
    }

    /**
     * @param key value to be found
     * @return node if value is found, null otherwise
     */
    public Node find(T key) {
        Node<T> current = root;

        if (key.compareTo(current.data) == 0) {                 //current = root here
            return current;
        }

        while (current != null) {
            if (key.compareTo(current.data) < 0) {             //if new data is < node data
                current = current.left;
            } else if (key.compareTo(current.data) > 0) {      //if new data is > node data
                current = current.right;                        //if new data is > node data
            } else {
                return current;
            }
        }
        return null;
    }

}