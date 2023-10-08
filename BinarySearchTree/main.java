public class main {

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(2);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(4);

        System.out.println("Traversing: ");
        bst.traverse(bst.root);

        System.out.println("\nFIND 3: " + bst.find(3).data);
        System.out.println("FIND 2: " + bst.find(2).data);
        System.out.println("FIND 6: " + bst.find(6).data);
        try {
            System.out.println("FIND 9: " + bst.find(9).data);
        } catch (NullPointerException npe) {
            System.out.println("Not found");
        }

    }

}
