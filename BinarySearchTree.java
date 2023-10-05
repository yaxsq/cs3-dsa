public class BinarySearchTree<T extends Comparable<T>> {

    Node<T> root;

    public void insert(T key) {
        if (root == null) {
            root = new Node<>(key);
            System.out.println("INSERTROT: " + root.data);
            return;
        } else {
            Node<T> current = root;
            Node<T> parent = null;

            while (current != null) {
                parent = current;

                if (key.compareTo(current.data) <= 0 && current.data != null) {
                    current = current.left;
                } else {
                    current = current.right;
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

    public void LNR(Node n) {
        if (root != null) {
            LNR(root.left);
            System.out.println(root.data);
            LNR(root.right);
        }
    }
//
//    public void LRN(Node n){
//
//    }
//
//    public Node find(T key){
//
//    }
//
//    public Node minimum() {
//
//    }
//
//    public Node maximum() {
//
//    }
//
//    public void deleteNoChild(T p) {
//
//    }
//
//    public void deleteOneChild(T p){
//
//    }
//
//    public void delete(T key) {
//        Node[] ref = find(data);
//
//        if (node t has no child)
//    }


    @Override
    public String toString() {
        return "";
    }
}
