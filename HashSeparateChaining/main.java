public class main {

    public static void main(String[] args) {

        HashTableLL<Student> students = new HashTableLL<>(5);
        students.displayTable();

        // Insert
        students.insert(new Student("ST1", 1));
        students.insert(new Student("ST2", 4));
        students.insert(new Student("ST3", 5));
        students.insert(new Student("ST4", 7));
        students.insert(new Student("ST5", 9));
        students.insert(new Student("ST6", 10));
        students.insert(new Student("ST7", 2));
        Student student = new Student("ST8", 12);
        students.insert(student);
        students.displayTable();

        // Find
        System.out.println("\nFIND " + students.find(student));

        // Delete
        System.out.println("\nDeleting ST8 at Node 2");
        students.delete(student);
        students.displayTable();

    }

}
