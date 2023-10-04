public class main {

    public static void main(String[] args) {

        DoubleLinkedList dll = new DoubleLinkedList();
        HTList htl = new HTList();

        System.out.println(dll.length());                        //should be 0
        System.out.println(htl.length());                        //should be 0

        htl.addSorted(3);                               //inserting 1 2 3
        htl.addSorted(1);
        htl.addSorted(2);
        System.out.println("INITIAL: " + htl.toString());         //should be 1 2 3
        System.out.println("TAIL: " + htl.getTail().data);          //should be 3
        System.out.println("FIND 2: " + htl.find(2).data);                 //should be 2

        dll.addSorted(3);                               //inserting 1 2 3
        dll.addSorted(1);
        dll.addSorted(2);
        System.out.println("INITIAL: " + dll.toString());         //should be 1 2 3
        System.out.println("FIND 2: " + dll.find(2).data);                 //should be 2


        try {
            System.out.println("\nFIND 4: " + htl.find(4).data);                 //should be null
        } catch (NullPointerException ex) {
        }
        try {
            System.out.println("FIND 4: " + dll.find(4).data);                 //should be null
        } catch (NullPointerException ex) {
        }


        htl.delete(2);
        System.out.println("\nREMOVING 2 >>> " + htl.toString());                       //should be 1 3
        dll.delete(2);
        System.out.println("REMOVING 2 >>> " + dll.toString());                       //should be 1 3


        htl.addAsTail(5);
        htl.addAsTail(4);
        System.out.println("\nADDED UNSORTED 5 4: " + htl.toString());                       //should be 1 3 5 4

        dll.add(5);
        dll.add(4);
        System.out.println("ADDED UNSORTED 5 4: " + dll.toString());                       //should be 1 3 5 4


        htl.delete(1);
        System.out.println("\nREMOVING 1 >>> " + htl.toString());                       //should be 3 5 4
        htl.delete(5);
        System.out.println("REMOVING 5 >>> " + htl.toString());                       //should be 3 4

        dll.delete(1);
        System.out.println("REMOVING 1 >>> " + dll.toString());                       //should be 3 5 4
        dll.delete(5);
        System.out.println("REMOVING 5 >>> " + dll.toString());                       //should be 3 4

        System.out.println();
        htl.addAsHead(9);
        System.out.print("ADDED 9 AS HEAD ");
        htl.print();                                                                //should be 9 3 4

        htl.addAsTail(-1);
        System.out.print("ADDED -1 AS TAIL ");                                      //should be 9 3 4 -1
        htl.print();

        dll.addAsHead(9);
        System.out.print("ADDED 9 AS HEAD ");                                     //should be 9 3 4
        dll.print();

        htl.addAsTail(9);
        htl.addAsHead(-1);
        htl.addAsHead(-1);
        System.out.print("ADDED 9 AS TAIL, -1 AS HEAD TWICE ");
        htl.print();
        htl.removeAll(9);
        htl.removeFirst(-1);
        htl.removeAll(-1);
        System.out.print("REMOVED ALL 9, FIRST -1, ALL -1 ");
        htl.print();

        dll.addAsTail(9);
        dll.addAsHead(-1);
        dll.addAsHead(-1);
        System.out.print("ADDED 9 AS TAIL, -1 AS HEAD TWICE ");
        dll.print();
        dll.removeAll(9);
        dll.removeFirst(-1);
        dll.removeAll(-1);
        System.out.print("REMOVED ALL 9, FIRST -1, ALL -1 ");
        dll.print();


        htl.reverseList();
        System.out.println("\nREVERSED: " + htl.toString());                       //should be 4 3
        htl.reverseList();
        System.out.println("REVERSED: " + htl.toString());                       //should be 3 4

        dll.reverseList();
        System.out.println("REVERSED: " + dll.toString());                       //should be 4 3
        dll.reverseList();
        System.out.println("REVERSED: " + dll.toString());                       //should be 3 4


        System.out.println("\n" + htl.isEmpty());                        //should be false
        System.out.println(htl.length());                         //should be 2

        System.out.println(dll.isEmpty());                        //should be false
        System.out.println(dll.length());                         //should be 2


        htl.popHead();
        System.out.print("\nPOPPED HEAD ");
        htl.print();

        dll.popHead();
        System.out.print("POPPED HEAD ");
        dll.print();


        int[] append = {3, 5, 1};

        dll.addAll(new DoubleLinkedList(append));
        System.out.print("\nAPPENDED WITH 3, 5, 1");
        dll.print();

        htl.addAll(new HTList(append));
        System.out.print("\nAPPENDED WITH 3, 5, 1");
        htl.print();


        htl.clearList();
        System.out.println("CLEARED: " + htl.toString());                       //should be Empty
        dll.clearList();
        System.out.println("CLEARED: " + dll.toString());                       //should be Empty


        dll.addAll(new DoubleLinkedList(append));
        System.out.print("\nAPPENDED WITH 3, 5, 1");
        dll.print();

        htl.addAll(new HTList(append));
        System.out.print("\nAPPENDED WITH 3, 5, 1");
        htl.print();

    }

}
