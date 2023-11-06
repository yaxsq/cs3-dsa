public class HashTableLL<T> {

    private LinkedList<T>[] table;

    /**
     * Order depends on the length of the linked list at the node and if the linked list has a tail pointer
     * in this case, the order would be dependent on the load factor of the list
     * for insert, search and delete: best case is O(1), worst case is O(n), big oh is O(n/m)
     * using a small list would bring the average time closer to n, a larger list would bring it closer to O(1)
     *
     * if the linked list had a tail pointer, insertion would be O(1) in every case
     * search and delete would be same
     *
     */

    public HashTableLL(int s) {
        table = new LinkedList[s + (s / 3)];

        // Can be used to initialize all LLs at once
//        for (int i = 0; i < table.length; i++) {
//            if (table[i] == null) {
//                table[i] = new LinkedList<>();
//            }
//        }
    }

    /**
     * takes the object as input, converts it into a string using toString(), and sums all the ascii values of all characters
     * the sum is modded by the size of the table to make a hash key
     *
     * @param obj value
     * @return hash key
     */

    private int hash(T obj) {
        String toStr = obj.toString();
        int sum = 0;

        for (int i = 0; i < toStr.length(); i++) {
            sum += toStr.charAt(i);
        }

        return sum % table.length;
    }

    /**
     * gets the hash from the hash function and inserts the obj into the linked list at that node
     *
     * @param obj value
     */
    public void insert(T obj) {
        int hash = hash(obj);

        if (table[hash] == null) {
            table[hash] = new LinkedList<>();
        }

        table[hash].insert(obj);
        System.out.println(obj + " inserted at " + hash);
    }

    /**
     * goes to the node in the list using the hash
     * calls the find method for the linked list which returns true or false
     *
     * @param obj value
     * @return true if object is found
     */
    public Boolean find(T obj) {
        return table[hash(obj)].find(obj);
    }

    /**
     * goes to the node in the list using the hash
     * calls the delete method for the linked list which searches for the value and deletes it
     *
     * @param obj value
     */
    public void delete(T obj) {
        table[hash(obj)].delete(obj);
    }

    public void displayTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println("NODE " + i + "  " + table[i]);
        }
    }

}
