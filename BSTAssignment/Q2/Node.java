package Q2;

public class Node{

    String word;
    String meaning;
    Node left;
    Node right;

    Node(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return word + " >> " + meaning;
    }
}