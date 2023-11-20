package L22;

import java.util.LinkedList;

public class Vertex {

    String label;
    LinkedList<Vertex> LL;

    public Vertex(String label) {
        this.label = label;
        LL = new LinkedList<>();
    }

    @Override
    public String toString() {
        String ret = label + " >> ";

        for (int i = 0; i < LL.size(); i++) {
            ret += LL.get(i).label + " > ";
        }

        return ret;
    }

}
