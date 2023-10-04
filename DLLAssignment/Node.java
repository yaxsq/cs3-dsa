public class Node {

    String title;
    String year;
    DoublyLinkedList_Cast cast;
    Node prev;
    Node next;

    Node(String title, String year) {
        this.title = title;
        this.year = year;
        this.prev = null;
        this.next = null;
    }

    Node(String title, String year, DoublyLinkedList_Cast cast) {
        this.title = title;
        this.year = year;
        setCast(cast);
        this.prev = null;
        this.next = null;
    }

    public void setCast(DoublyLinkedList_Cast cast) {
        this.cast = cast;
    }
}
