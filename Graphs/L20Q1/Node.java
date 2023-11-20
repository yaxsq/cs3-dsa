package L20Q1;

class Node {

    Vertex v;
    Node next;

    Node(Vertex v) {
        this.v = v;
        next = null;
    }

    @Override
    public String toString() {
        if (v != null) {
            return ">> " + v.toString();
        }
        return "<<";
    }
}
