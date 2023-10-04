public class main {

    private static DoublyLinkedList_Q1 movieDLL;
    private static DoublyLinkedList_Q2 sublistDLL;

    public static void main(String[] args) {

        movieDLL = new DoublyLinkedList_Q1();
        sublistDLL = new DoublyLinkedList_Q2();
        setUpMovies();


        /*  QUESTION 1  */

        System.out.println("\n>>>>>>>>>> QUESTION 1 <<<<<<<<<<\n\nMOVIES: " + movieDLL);

        movieDLL.delete("pulp fiction");                    //deleting movies
        movieDLL.delete("avatar");
        movieDLL.delete("inception");
        movieDLL.delete("rocky");
        movieDLL.delete("casablanca");
        System.out.println("\nAFTER DELETING: Pulp Fiction, Avatar, Inception, Rocky, Casablanca");
        System.out.println("MOVIES: " + movieDLL);          // remaining movies

        Node yourName = null;                                   //nodes to store movies
        Node theMatrix = null;
        System.out.println("SEARCHING: ");
        try {
            System.out.println("FOUND: " + movieDLL.find("Your name").title);
            yourName = movieDLL.find("your name");                                      //saving movie nodes
            theMatrix = movieDLL.find("the matrix");
            System.out.println("FOUND: " + movieDLL.find("princess Mononoke").title);
            System.out.println("FOUND: " + movieDLL.find("Matrix 2").title);            //throws null exception
        } catch (NullPointerException ex) { }

        System.out.println("\n\nSETTING CAST FOR Your Name, The Matrix");                   //setting up cast lists
        DoublyLinkedList_Cast yourNameCast = new DoublyLinkedList_Cast();
        yourNameCast.add("Ryunosuke Kamiki");
        yourNameCast.add("Mone Kamishiraishi");
        yourName.setCast(yourNameCast);
        DoublyLinkedList_Cast theMatrixCast = new DoublyLinkedList_Cast();
        theMatrixCast.add("Keanu Reeves");
        theMatrixCast.add("Carrie-Anne Moss");
        theMatrix.setCast(theMatrixCast);
        System.out.println("MOVIES: " + movieDLL);                                  //printing all movies to check cast list



        /*  QUESTION 2  */

        System.out.println("\n\n>>>>>>>>>> QUESTION 2 <<<<<<<<<<\nMOVIES: " + sublistDLL);
        System.out.println("LENGTH " + sublistDLL.length());

        sublistDLL.delete("akira");                                 //deleting movies
        sublistDLL.delete("avatar");
        sublistDLL.delete("casablanca");
        sublistDLL.delete("the godfather");
        sublistDLL.delete("my neighbor totoro");
        System.out.println("\nAFTER DELETING: Akira, Avatar, Casablanca, The Godfather, My Neighbor Totoro");
        System.out.println("MOVIES: " + sublistDLL);          // remaining movies

        System.out.println("SEARCHING: ");
        try {
            yourName = sublistDLL.find("your name");
            theMatrix = sublistDLL.find("the Matrix");
            System.out.println("FOUND: " + sublistDLL.find("Your name").title);
            System.out.println("FOUND: " + sublistDLL.find("princess Mononoke").title);
            System.out.println("FOUND: " + sublistDLL.find("Matrix 2").title);            //throws null exception
        } catch (NullPointerException ex) { }

        System.out.println("\n\nSETTING CAST FOR Your Name, The Matrix");                   //setting up cast lists
        yourName.setCast(yourNameCast);
        theMatrix.setCast(theMatrixCast);
        System.out.println("MOVIES: " + sublistDLL);                                  //printing all movies to check cast list
    }

    public static void addMovie(String title, String year) {
        movieDLL.add(title, year);
        sublistDLL.add(title, year);
    }

    /**
     * calls addMovie to add all these movies the both lists
     */
    public static void setUpMovies() {
        addMovie("The Shawshank Redemption", "1994");
        addMovie("Inception", "2010");
        addMovie("Jurassic Park", "1993");
        addMovie("Avatar", "2009");
        addMovie("Eternal Sunshine of the Spotless Mind", "2004");
        addMovie("The Godfather", "1972");
        addMovie("Forrest Gump", "1994");
        addMovie("The Dark Knight", "2008");
        addMovie("Pulp Fiction", "1994");
        addMovie("Schindler's List", "1993");
        addMovie("The Matrix", "1999");
        addMovie("Gladiator", "2000");
        addMovie("Django Unchained", "2012");
        addMovie("The Pianist", "2002");
        addMovie("Fight Club", "1999");
        addMovie("The Lord of the Rings: The Fellowship of the Ring", "2001");
        addMovie("The Departed", "2006");
        addMovie("Inglourious Basterds", "2009");
        addMovie("The Social Network", "2010");
        addMovie("My Neighbor Totoro", "1988");
        addMovie("Princess Mononoke", "1997");
        addMovie("Howl's Moving Castle", "2004");
        addMovie("Nausicaä of the Valley of the Wind", "1984");
        addMovie("Cowboy Bebop: The Movie", "2001");
        addMovie("Ghost in the Shell", "1995");
        addMovie("Your Name", "2016");
        addMovie("Akira", "1988");
        addMovie("Grave of the Fireflies", "1988");
        addMovie("Demon Slayer: Mugen Train", "2020");
        addMovie("Dragon Ball Z: Resurrection 'F'", "2015");
        addMovie("One Punch Man: A Hero Nobody Knows", "2020");
        addMovie("The Green Mile", "1999");
        addMovie("La La Land", "2016");
        addMovie("Gone with the Wind", "1939");
        addMovie("Spirited Away", "2001");
        addMovie("Casablanca", "1942");
        addMovie("Rocky", "1976");
    }

}
