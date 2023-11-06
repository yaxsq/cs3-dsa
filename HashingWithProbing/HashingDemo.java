import java.io.*;

public class HashingDemo {

    public static void main(String args[]) {

        HashTable table = new HashTable(35000);

        try {
            FileInputStream fStream = new FileInputStream("src/Dictionary.csv");
            DataInputStream in = new DataInputStream(fStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            System.out.println(fStream.available());
            String strLine;

            while ((strLine = br.readLine()) != null) {
                String[] word = strLine.split(",");
                table.insert(word[0]);
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        table.displayTable();

        // LINEAR OR QUADRATIC WORKS ONE AT A TIME
        // GO TO hashTable AND REMOVE ONE FOR THE OTHER TO WORK

        // DELETE
        System.out.println("\n" + table.delete("telecommunications"));
        table.displayTable();

        // SEARCH
        System.out.println(table.search("war"));
        try { System.out.println(table.search("amogus")); } catch (NullPointerException ex) { System.out.println("Not found"); }

    }

}
