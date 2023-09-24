public class main {

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert("P1");
        cll.insert("P2");
        cll.insert("P3");
        cll.insert("P4");
        cll.insert("P5");
        System.out.println("LIST: " + cll.toString());
        System.out.println("LENGTH: " + cll.length());
        cll.playGame();
        System.out.println("LIST: " + cll.toString());
        System.out.println("LENGTH: " + cll.length());
    }

}
