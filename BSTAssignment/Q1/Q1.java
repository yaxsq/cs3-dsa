package Q1;

public class Q1 {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);

        Node five = bst.find(5);
        Node three = bst.find(3);

        bst.printRange(five, 4, 8);                     // 4 5 8
        bst.printRange(five, 1, 3);                     // 1 2 3
        bst.printRange(three, 1, 5);                    // 3 4

        Node eight = bst.find(8);
        bst.printRange(eight, 0, 99);                   // 8

    }

}
