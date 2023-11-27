import java.util.*;

class Vertex {
    String name;
    int age;
    LinkedList<Vertex> friendsList;

    Vertex(String name, int age) {
        this.name = name;
        this.age = age;
        friendsList = new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(", ").append(age).append(", Friends: ");

        for (Vertex friend : friendsList) {
            builder.append(friend.name).append(", ");
        }

        if (!friendsList.isEmpty()) {
            builder.delete(builder.length() - 2, builder.length());
        }

        builder.append("]");
        return builder.toString();
    }
}
