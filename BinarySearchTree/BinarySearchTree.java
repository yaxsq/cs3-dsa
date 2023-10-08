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

                if (key.compareTo(current.data) <= 0) {             //if new data is <= node data
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

    /**
     * recursively prints all nodes from the left to right starting from the parameter
     * @param n root node
     */
    public void traverse(Node n) {
        if (n != null) {
            traverse(n.left);
            System.out.println(n.data);
            traverse(n.right);
        }
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