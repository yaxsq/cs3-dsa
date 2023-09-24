public class Student implements Comparable<Student> {

    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(int id) {
        this.name = "STU" + id;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * @param stu the object to be compared
     * @return 0 if the ages are same, this.age - input.age is returned otherwise
     */
    public int compareTo(Student stu) {
        if (this.id == stu.id) {
            return 0;
        } else if (this.id < stu.id) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "N: " + this.name + "<  >>  ID: " + this.id + "<";
    }

}
