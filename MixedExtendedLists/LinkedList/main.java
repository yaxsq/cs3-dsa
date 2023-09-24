public class main {

    public static void main(String[] args) {

//        Node node = new Node("HELLO");
//        System.out.println(node.getData());
//
//        Node n2 = new Node(22);
//        System.out.println(n2.getData());
//
//        Node n3 = new Node(22);
//        System.out.println(n3.getData());
//
//        Node n4 = new Node("HELLO");
//        System.out.println(node.getData());
//
//        if (n3.data.equals(n2.data)) {
//            System.out.println("EQUAL");
//        }
//        if (n4.data.equals(node.data)){
//            System.out.println("EQUAL STRS");
//        }

        LinkedList LL = new LinkedList();
        LL.insert(22);
        LL.insert(32);
        LL.insert(42);
        LL.insert(52);
        System.out.println("INITIAL >" + LL.toString());               //4 ele
        System.out.println(LL);

        LL.delete(32);
        System.out.println("REMOVED 32 >" + LL.toString());
        LL.delete(22);
        System.out.println("REMOVED 22@HEAD >" + LL.toString());       //2 ele
        System.out.println(LL);

        LL.insert(22);
        LL.insert(62);
        System.out.println("UPDATED >" + LL.toString());               //42 52 22 62 /4ele

        LL.insertInMiddle(333);
        System.out.println("MIDDLE >" + LL.toString());               //42 52 333 22 62 /5ele

        System.out.println("GET 2: " + LL.getNode(2));          //333
        LL.insertNth(1, 0);
        LL.insertNth(2, 1);
        LL.insertNth(8, 999);                           //error
        System.out.println("Nth >" + LL.toString());               //1 2 42 52 333 22 62 /5ele


        System.out.println(LL.find(52));                          //true
//        System.out.println("REMOVED 52 " + list.toString());

        LL.clear();
        System.out.println("CLEARED " + LL.toString());

//        LinkedList list = new LinkedList();
//        list.insert("T1");
//        list.insert("T2");
//        list.insert("T3");
//        list.insert("T4");
//        System.out.println("INITIAL >" + list.toString());               //four elements
//
//        list.delete("T2");
//        System.out.println("REMOVED T2 >" + list.toString());
//        list.delete("T1");
//        System.out.println("REMOVED T1@HEAD >" + list.toString());      //two elements T3 T4
//
//        list.insert("T1");
//        list.insert("T6");
//        System.out.println("ADDED 2 NODES >" + list.toString());        //four elements T3 T4 T1 T6
//
//        System.out.println(list.find("T5"));                      //false
//        System.out.println(list.find("T6"));                      //true
////        System.out.println("REMOVED 52 " + list.toString());
//
//        list.clear();
//        System.out.println("CLEARED " + list.toString());

    }

}
