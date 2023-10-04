public class Student implements Comparable<Student> {

    String name;
    int age, id;

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Student(int age, int id) {
        this.name = "STU" + id;
        this.age = age;
        this.id = id;
    }

    /**
     * @param stu the object to be compared
     * @return 0 if the ages are same, this.age - input.age is returned otherwise
     */
    @Override
    public int compareTo(Student stu) {
        if (this.age == stu.age) {
            return 0;
        } else {
            return this.age - stu.age;
        }
    }

    @Override
    public String toString() {
        return ("NAME>" + name + "  AGE>" + age + " ID>" + id);
    }
}
