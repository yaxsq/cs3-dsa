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
     * recursively prints all nodes from the right to left starting from the parameter
     * @param n
     */
    public void LNR(Node n) {
        if (n != null) {
            LNR(n.left);
            System.out.println(n.data);
            LNR(n.right);
        }
    }

    /**
     * recursively prints all nodes from the left to right starting from the parameter
     * @param n starting node
     */
    public void LRN(Node n) {
        if (n != null) {
            LRN(n.right);
            System.out.println(n.data);
            LRN(n.left);
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

    /**
     * @param key value to be found
     * @return Node[2] containing parent and current nodes
     */
    public Node[] findPC(T key) {
        Node[] arr = new Node[2];

        if (key.compareTo(root.data) == 0) {                 //current = root here
            arr[0] = arr[1] = root;
            return arr;
        }

        Node<T> current = root;

        while (current != null) {
            arr[0] = current;                                   //storing previous reference

            if (key.compareTo(current.data) < 0) {             //if new data is < node data
                current = current.left;
            } else if (key.compareTo(current.data) > 0) {      //if new data is > node data
                current = current.right;
            } else if (key.compareTo(current.data) == 0){      //if new data == node data
                arr[1] = current;
                return arr;
            }
        }
        return null;
    }

    /**
     * @return minimum value in the BST
     */
    public Node minimum() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * @return maximum value in the BST
     */
    public Node maximum() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    /**
     * updates the parent's pointer to null
     * @param ref array containing parent and child node - child is to be deleted
     */
    public void deleteNoChild(Node[] ref) {
        if (ref[0].left == ref[1]) {
            ref[0].left = null;
        } else {
            ref[0].right = null;
        }
    }

    /**
     * connects the parent to the grandchild, removing the child
     * @param ref array containing parent and child node - child is to be deleted
     */
    public void deleteOneChild(Node[] ref){
        if (ref[0].left == ref[1]) {                            //if the child is to the left of the parent
            if (ref[1].left != null) {                              //if the grandchild is at the left
                ref[0].left = ref[1].left;                              //updates parent's left to the grandchild
            } else {                                                //if the grandchild is at the right
                ref[0].left = ref[1].right;                             //updates parent's left to the grandchild
            }
        } else {
            if (ref[1].left != null) {                              //if the grandchild is at the left
                ref[0].left = ref[1].left;                              //updates parent's left to the grandchild
            } else {                                                //if the grandchild is at the right
                ref[0].left = ref[1].right;                             //updates parent's left to the grandchild
            }
        }
    }

    /**
     * @param key value to be deleted
     */
    public void delete(T key) {
        Node[] ref = findPC(key);

        if (ref[1].left == null && ref[1].right == null) {                      // leaf node
            deleteNoChild(ref);
        } else if (ref[1].left == null || ref[1].right == null) {               // one child
            deleteOneChild(ref);
        } else {                                                                // mid node
//            ref[1] = this.maximum();
            System.out.println("INCOMPLETE");
        }

    }

}