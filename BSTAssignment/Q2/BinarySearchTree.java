package Q2;

import java.util.ArrayList;

public class BinarySearchTree {

    Node root;

    /**
     * @param word    value to be inserted
     * @param meaning
     */
    public void insert(String word, String meaning) {
        if (root == null) {                                 //if tree is empty
            root = new Node(word, meaning);
//            System.out.println("INSERTROOT: " + root.word + root.meaning);            // debugging
        } else {
            Node current = root;
            Node parent = null;                          //stores the node before current

            while (current != null) {
                parent = current;

                if (word.equalsIgnoreCase(current.word) || word.compareToIgnoreCase(current.word) < 0) {             //if new data is <= node data
                    current = current.left;
                } else {
                    current = current.right;                        //if new data is > node data
                }
            }

            if (word.equalsIgnoreCase(parent.word) || word.compareToIgnoreCase(parent.word) < 0) {
//            if (word.equalsIgnoreCase(parent.word)) {
                parent.left = new Node(word, meaning);
//                System.out.println("INSERTING: " + parent.left.word);             // debugging
            } else {
                parent.right = new Node(word, meaning);
//                System.out.println("INSERTING: " + parent.right.word);            // debugging
            }
        }


    }

    /**
     * @param word value to be found
     * @return node if value is found, null otherwise
     */
    public Node find(String word) {
        Node current = root;

        if (word.equalsIgnoreCase(current.word)) {                 //current = root here
            return current;
        }

        while (current != null) {
            if (word.equalsIgnoreCase(current.word)) {
                return current;
            } else if (word.compareToIgnoreCase(current.word) < 0) {             //if new data is < node data
                current = current.left;
            } else {                                                             //if new data is > node data
                current = current.right;
            }
        }
        return null;
    }


    /**
     * recursively prints all nodes from the right to left starting from the parameter
     *
     * @param n
     */
    public void LNR(Node n) {
        if (n != null) {
            LNR(n.left);
            System.out.println(n);
            LNR(n.right);
        }
    }

    public ArrayList<Node> LNRs(Node n) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        temp(n, nodes);
        return nodes;
    }

    private void temp(Node n, ArrayList<Node> nodes) {
        if (n == null) {
            return;
        }
        temp(n.left, nodes);
        nodes.add(n);
        temp(n.right, nodes);
    }

    public void delete(String word) {
        root = deleteNode(root, word);
    }

    private Node deleteNode(Node root, String word) {
        if (root == null) {
            return root;
        }

        int comp = word.compareToIgnoreCase(root.word);

        if (comp < 0) {                                         // lower
            root.left = deleteNode(root.left, word);
        } else if (comp > 0) {                                  // greater
            root.right = deleteNode(root.right, word);
        } else {                                                // one or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.word = minValue(root.right);               // two children

            root.right = deleteNode(root.right, root.word);
        }
        return root;
    }

    private String minValue(Node node) {
        String minValue = node.word;
        while (node.left != null) {
            minValue = node.left.word;
            node = node.left;
        }
        return minValue;
    }

}