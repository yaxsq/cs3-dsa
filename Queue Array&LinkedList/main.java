public class main {

    public static void main(String[] args) {

        QueueLL ql = new QueueLL();
        System.out.println("\n\n " + ql.isEmpty());                     //true
        ql.enqueue(1);
        ql.enqueue(2);
        ql.enqueue(3);
        System.out.println(ql.isEmpty());                               //false
        System.out.println(ql.dequeue().data);
        System.out.println(ql.dequeue().data);
        System.out.println(ql.dequeue().data);
        System.out.println(ql.isEmpty());                               //true


        QueueArray qa = new QueueArray();
        System.out.println("\n\n" + qa.isEmpty());                      //true
        System.out.println(qa.isFull());                                //false
        qa.enqueue(1);
        qa.enqueue(2);
        qa.enqueue(3);
        System.out.println(qa.isEmpty());                               //false
        System.out.println(qa.isFull());                                //false
//        try {
        System.out.println(qa.dequeue());
        System.out.println(qa.dequeue());
        System.out.println(qa.dequeue());
//        } catch (NullPointerException npe) {}
        System.out.println(qa.isEmpty());                               //true
        System.out.println(qa.isFull());                                //false

        for (int i = 0; i < 10; i++) {
            qa.enqueue(i);
        }
        System.out.println(qa.isEmpty());
        System.out.println(qa.isFull());

        qa.enqueue(11);
        qa.enqueue(12);

        System.out.println(qa.queue.length);
        System.out.println(qa.isEmpty());
        System.out.println(qa.isFull());




    }

}
