public class main {

    public static void main(String[] args) {

        DoubleLinkedList<Integer> dl1 = new DoubleLinkedList();
        DoubleLinkedList<String> dl2 = new DoubleLinkedList();
        DoubleLinkedList<Character> dl3 = new DoubleLinkedList();

        System.out.println(dl1.length());                        //should be 0
        dl1.insertInOrder(1);
        dl1.insertInOrder(2);
        dl1.insertInOrder(3);                               //inserting 1 2 3
        System.out.println("INITIAL: " + dl1.toString());         //should be 1 2 3
        System.out.println("TAIL: " + dl1.getTail().data);          //should be 3
        System.out.println("FIND 2: " + dl1.find(2).data);                 //should be 2

        try {
            System.out.println("FIND 4: " + dl1.find(4).data);                 //should be null
        } catch (NullPointerException ex) {

        }

        dl1.delete(2);
        System.out.println("REMOVING 2 >>> " + dl1.toString());                       //should be 1 3
        dl1.insertInOrder(4);
        dl1.insertInOrder(5);
        System.out.println("ADDED 4 5: " + dl1.toString());                       //should be 1 3 4 5
        dl1.delete(1);
        System.out.println("REMOVING 1 >>> " + dl1.toString());                       //should be 3 4 5
        dl1.delete(5);
        System.out.println("REMOVING 5 >>> " + dl1.toString());                       //should be 3 4
        dl1.loopAround();                                           //should be 3 4 3  *after deleting 5
        dl1.reverseList();
        System.out.println("REVERSED: " + dl1.toString());                       //should be 4 3
        dl1.reverseList();
        System.out.println("REVERSED: " + dl1.toString());                       //should be 3 4
        System.out.println(dl1.isEmpty());                        //should be false
        System.out.println(dl1.length());                         //should be 2
        dl1.clearList();
        System.out.println("CLEARED: " + dl1.toString());                       //should be Empty

        dl2.insertInOrder("HELLO");
        dl2.insertInOrder("THIS");
        dl2.insertInOrder("IS");
        dl2.insertInOrder("LAB");
        dl2.insertInOrder("5");
        System.out.println("\n\n" + dl2.toString());
        dl2.reverseList();
        System.out.println(dl2.toString());
        dl2.delete("LAB");
        System.out.println(dl2.toString());
        System.out.println("SIZE " + dl2.length());

    }

}
