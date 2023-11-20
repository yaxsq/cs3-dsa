package L20Q1;

class Vertex {

    String name;
    int age;
    LL friendsList;

    Vertex(String name, int age) {
        this.name = name;
        this.age = age;
        friendsList = new LL();
    }

    @Override
    public String toString() {
        return name + ", " + age + ", " + friendsList;
    }
}
