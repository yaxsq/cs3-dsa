public class HashTable {

    private String[] table;
    public int linearCollisions = 0;
    public int quadraticCollisions = 0;

    public HashTable(int s) {
        table = new String[s + (s / 3)];
    }

    /**
     * converting string to int by summing all ascii values
     *
     * @param v string to be converted
     * @return sum of all characters' ascii values
     */

    public int strToInt(String v) {
        int sum = 0;

        for (int i = 0; i < v.length(); i++) {
            sum += v.charAt(i);
        }
        return sum;
    }

    /**
     * @param sum ascii sum of a string
     * @return hash value
     */
    public int hash(int sum) {
        return sum % table.length;
    }

    /**
     * @param sum ascii sum of a string
     * @param i   iteration number
     * @return a new hash value (linear)
     */
    public int rehashLinear(int sum, int i) {
        return (hash(sum) + i) % table.length;
    }

    /**
     * @param sum ascii sum of a string
     * @param i   iteration number
     * @return a new hash value (quadratic)
     */
    public int rehashQuadratic(int sum, int i) {
        return (int) ((hash(sum) + Math.pow(i, 2)) % table.length);
    }

    public void insert(String v) {
        int sum = strToInt(v);
        int hash = hash(sum);

        if (table[hash] == null) {
            table[hash] = v;
        } else {
            int collisions = 0;

            // LINEAR
            for (int i = 1; i < table.length - hash; i++) {
                if (table[rehashLinear(sum, i)] == null) {
                    table[hash] = v;
                    if (collisions > 0)
                        System.out.println("COLLISIONS FOR " + v + " > " + collisions);
                    return;
                }
                collisions++;
                linearCollisions++;

            // QUADRATIC
//            for (int i = 1; i < table.length - hash; i++) {
//                if (table[rehashQuadratic(sum, i)] == null) {
//                    table[hash] = v;
//                    if (collisions > 0)
//                        System.out.println("COLLISIONS FOR " + v + " " + collisions);
//                    return;
//                }
//                collisions++;
//                quadraticCollisions++;
            }
        }

    }

    public boolean search(String v) {
        int sum = strToInt(v);
        int hash = hash(sum);

        if (table[hash].equalsIgnoreCase(v)) {
            return true;
        } else {

            // LINEAR
            for (int i = 1; i < table.length - hash; i++) {
                if (table[rehashLinear(sum, i)].equalsIgnoreCase(v)) {
                    return true;
                }
            }

            // QUADRATIC
//            for (int i = 0; i < table.length - hash; i++) {
//                if (table[rehashQuadratic(sum, i)].equalsIgnoreCase(v)) {
//                    return true;
//                }
//            }
        }

        return false;
    }

    public boolean delete(String v) {
        int sum = strToInt(v);
        int hash = hash(sum);

        if (table[hash].equalsIgnoreCase(v)) {
            table[hash] = "XXXXX";
            return true;
        } else {

            // LINEAR
            for (int i = 0; i < table.length - hash; i++) {
                if (table[rehashLinear(sum, i)].equalsIgnoreCase(v)) {
                    table[rehashLinear(sum, i)] = "XXXXX";
                    return true;
                }
            }

            // QUADRATIC
//            for (int i = 0; i < table.length - hash; i++) {
//                if (table[rehashQuadratic(sum, i)].equalsIgnoreCase(v)) {
//                    table[rehashQuadratic(sum, i)] = "XXXXX";
//                    return true;
//                }
//            }
        }

        return false;
    }

    public void displayTable() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null)                           // used for a cleaner output
                System.out.println(table[i]);
        }

        // LINEAR
        System.out.println("LINEAR COLLISIONS: " + linearCollisions);

        // QUADRATIC
//        System.out.println("QUADRATIC COLLISIONS: " + quadraticCollisions);
    }

}