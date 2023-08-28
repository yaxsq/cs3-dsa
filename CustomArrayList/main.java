public class main {

    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<Integer>();
        System.out.println(list.toString());

        list.add(2);
        list.add(4);
        list.add(1);
        list.add(7);

        System.out.println(list.toString());

        list.add(3);
        list.add(3);
        list.add(3);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(list.toString());

        list.add(11);

        System.out.println(list.toString());

        System.out.println(list.find(9));

        System.out.println(list.get(2));
        System.out.println(list.get(1));
        System.out.println();

        list.update(2, 89);
        System.out.println(list.toString());

        list.remove(3);
        System.out.println(list.toString());

//        list.clear();
//        System.out.println(list.toString());

    }

}
