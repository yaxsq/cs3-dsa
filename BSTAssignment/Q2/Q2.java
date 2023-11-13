package Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        ArrayList<Node> nodes = null;
        try {
            nodes = readFile();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

        Collections.shuffle(nodes);                             // randomizing the order of nodes
        BinarySearchTree dictionary = new BinarySearchTree();

        int count = 0;
        while (nodes.size() != 0) {                             // inserting all nodes into a BST
            Node node = nodes.remove(0);                  // removing first node from nodes and inserting in BST
            dictionary.insert(node.word, node.meaning);
            count++;
        }

        System.out.println("WORD COUNT > " + count);

        System.out.println("\n>>>>>>>> TESTING FIND");
        Node usage = dictionary.find("usage");
        System.out.println(usage);
        Node imposter = dictionary.find("imposter");                    // null
        System.out.println(imposter);
        Node impostor = dictionary.find("impostor");
        System.out.println(impostor);
        System.out.println(dictionary.find("suspicious"));
        System.out.println(dictionary.find("vent"));                    // null

        System.out.println(">>>>>>>>>> ROOT");
        System.out.println(dictionary.root.word);
        System.out.println("LEFT " + dictionary.root.left);
        System.out.println("RIGHT " + dictionary.root.right);

        System.out.println("USAGE");                                // printing left and right of a random node
        System.out.println("LEFT " + usage.left);
        System.out.println("RIGHT " + usage.right);

//        dictionary.LNR(dictionary.root);                            // TRAVERSE

        dictionary.delete("impostor");
        System.out.println("AFTER DELETING impostor >" + dictionary.find("impostor"));

        FileWriter fw = null;
        try {
            fw = new FileWriter("src/Q2/output.txt");
//            String[] nodeList = dictionary.LNRs(dictionary.root).split(">>>");
            ArrayList<Node> nodeList = dictionary.LNRs(dictionary.root);

            for (int i = 0; i < nodeList.size(); i++) {
                fw.write(nodeList.get(i).toString() + "\n");
            }

            fw.close();
            System.out.println("\noutput.txt CREATED");

        } catch (IOException ex) {  }

    }

    private static ArrayList<Node> readFile() throws FileNotFoundException {

//        try {
        File file = new File("src/Q2/Dictionary.txt");              // file reading
        Scanner in = new Scanner(file);
//        } catch (FileNotFoundException ex) {
        System.out.println("File not found");
//        }

//        ArrayList<String> word = new ArrayList<>();                             // list which stores word only
//        ArrayList<String> meaning = new ArrayList<>();                          // list which stores meaning only
        ArrayList<Node> nodes = new ArrayList<>();

        while (in.hasNextLine()) {                              // going through all lines
            String line = in.nextLine();

            if (line == null || line.equalsIgnoreCase("") || line.equalsIgnoreCase(" ")) {
                continue;                                       // in case the line is empty
            }

            String[] lineSeparated = line.split("  ");                  // [0] word, [1] meaning

//            word.add(lineSeparated[0]);                         // adding the word to the array
            String tempMeaning = "";                            // string to store the meaning in one line if separated into many lines

//            System.out.println("L0" + " " + lineSeparated[0]);                    // debugging
            for (int i = 1; i < lineSeparated.length; i++) {    // going through all lines apart from the word
//                System.out.println("L" + i + " " + lineSeparated[i]);             // debugging
                tempMeaning += lineSeparated[i];                // adding these lines to the tempMeaning string
            }
//            meaning.add(tempMeaning);                           // adding the meaning to the array

//            System.out.println("WORD " + word.get(word.size()-1) + " MEANING " + meaning.get(meaning.size()-1));
//            System.out.println("WORD " + lineSeparated[0] + " MEANING " + tempMeaning);       // debugging

//            nodes.add(new Node(word.get(word.size()-1), meaning.get(meaning.size()-1)));
            nodes.add(new Node(lineSeparated[0], tempMeaning));
//            System.out.println(nodes.get(nodes.size() - 1));                      // debugging
        }

        in.close();
        return nodes;
    }

}
