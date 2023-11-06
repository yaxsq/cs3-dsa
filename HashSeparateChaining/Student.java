public class Student {

    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name + "__" + this.id;
    }
}
