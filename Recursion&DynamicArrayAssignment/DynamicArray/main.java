public class main {

    public static void main(String[] args) {

        DynamicArray<Student> students = new DynamicArray<>();
        System.out.println(students.toString());

        students.add(new Student(15, 0));
        students.add(new Student(12, 1));
        students.add(new Student(10, 2));
        students.add(new Student(11, 3));
        students.add(new Student(12, 4));
        students.add(new Student(9, 5));
        students.add(new Student(7, 6));
        students.add(new Student(14, 7));

        System.out.println(students.toString());

        students.sortStudents(students);

        System.out.println(students.toString());




//        MyArrayList<Integer> list = new MyArrayList<Integer>();
//        System.out.println(list.toString());                            //printing empty list

//        list.add(2);
//        list.add(4);                                                    //add
//        list.add(1);
//        list.add(7);
//
//        System.out.println(list.toString() + "\n PRINT");
//        list.print();
//
//        list.add(3);
//        list.add(3);
//        list.add(8);                                                    //add
//        list.add(9);
//        list.add(10);
//        list.add(15);
//        System.out.println("LENGTH " + list.length());
//        list.print();
//        System.out.println(list.length());

//        list.addToFront(13);                                                  //adding to front
//        System.out.println(list.toString() + "\n SIZE " + list.length());
//        list.update(0, null);
//        list.update(6, null);
//        list.update(10, null);
//        System.out.println(list.toString());
//        list.addToFront(22);
//        System.out.println(list.toString());
//        list.addToFront(32);
//        System.out.println(list.toString());

//        list.addToEnd(13);
//        System.out.println(list.toString() + "\n SIZE " + list.length());       //adding to end

//        list.reverse();
//        System.out.println(list.toString() + " < REVERSE \n SIZE " + list.length());       //reverse

//        list.removeFirst(10);                                                     //remove first
//        System.out.println(list.toString());
//        list.removeAll(3);                                                        //remove all
//        System.out.println(list.toString());


        /*
        System.out.println(list.toString());

        list.add(11);
        System.out.println("LENGTH " + list.length());

        System.out.println(list.toString());

        System.out.println(list.find(9));                           //find

        System.out.println(list.get(2));
        System.out.println(list.get(1));                                    //retrieve
        System.out.println();

        list.update(2, 89);                                     //replace
        System.out.println(list.toString());

        list.remove(3);                                                 //delete
        System.out.println(list.toString());
        */

//        list.clear();
//        System.out.println(list.toString());

    }

}
