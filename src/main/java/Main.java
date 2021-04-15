import enums.Level;
import models.Book;
import models.Library;
import models.User;

public class Main {
 public static void menu_1_start(){
     System.out.println("*".repeat(60));
     System.out.println("   IMPLEMENTATION 1 - Using Priority Queue");
     System.out.println("-".repeat(60));
     System.out.println("       BOOK REQUEST PROCESSING  ");
     System.out.println("-".repeat(60));
 }
 public static void menu_1_end(){
     System.out.println("-".repeat(60));
     System.out.println("   PRIORITY QUEUE LIST YET TO BE ATTENDED TO : ");
 }

    public static void menu_2_start(){
        System.out.println("*".repeat(60));
        System.out.println("   IMPLEMENTATION 2 - Using Queue");
        System.out.println("-".repeat(60));
        System.out.println("     BOOK REQUEST PROCESSING   ");
        System.out.println("-".repeat(60));
    }
    public static void menu_2_end(){
        System.out.println("-".repeat(60));
        System.out.println("   QUEUE LIST YET TO BE ATTENDED TO : ");
    }

    public static void main(String[] args) {

        // LIBRARY
        Library library = new Library("Awesome Library");

        // LIBRARIAN
        Library.Librarian librarian = library.new Librarian("John");

        // Books to be Added to the Book List By The Librarian
        Book biology = new Book("Biology");
        Book english = new Book("English");
        Book mathematics = new Book("Mathematics");
        Book physics = new Book("Physics");
        Book chemistry = new Book("Chemistry");
        Book geography = new Book("Geography");

        //Librarian Adds Books To The Library BookList

        librarian.addBookToCurrentList(biology, 3);
        librarian.addBookToCurrentList(english, 2);
        librarian.addBookToCurrentList(mathematics, 2);
        librarian.addBookToCurrentList(physics, 7);
        librarian.addBookToCurrentList(chemistry, 10);
        librarian.addBookToCurrentList(geography, 0);

        //Users To Be Registered By The Librarian
        User abel = new User("Abel", Level.TEACHER);
        User Magel = new User("Magel", Level.TEACHER);
        User henry = new User("Henry", Level.TEACHER);

        User harold = new User("Harold", Level.SENIOR_STUDENT);
        User daniel = new User("Daniel", Level.SENIOR_STUDENT);
        User janet = new User("Janet", Level.SENIOR_STUDENT);

        User richard = new User("Richard", Level.JUNIOR_STUDENT);
        User lucas = new User("Lucas", Level.JUNIOR_STUDENT);
        User anvil = new User("Anvil", Level.JUNIOR_STUDENT);


        //Librarian registers users
        System.out.println("*".repeat(60));
        System.out.println("   USERS REGISTRATION RESULT");
        System.out.println("*".repeat(60));
        System.out.println(librarian.registerUser(abel, abel.getLevel()));
        System.out.println(librarian.registerUser(Magel, Magel.getLevel()));
        System.out.println(librarian.registerUser(henry, henry.getLevel()));
        System.out.println("-".repeat(60));
        System.out.println(librarian.registerUser(harold, harold.getLevel()));
        System.out.println(librarian.registerUser(daniel, daniel.getLevel()));
        System.out.println(librarian.registerUser(janet, janet.getLevel()));
        System.out.println("-".repeat(60));
        System.out.println(librarian.registerUser(richard, richard.getLevel()));
        System.out.println(librarian.registerUser(lucas, lucas.getLevel()));
        System.out.println(librarian.registerUser(anvil, anvil.getLevel()));
        System.out.println(librarian.registerUser(harold, harold.getLevel()));



        // Registered Users List
        System.out.println("*".repeat(60));
        System.out.println("   REGISTERED USERS LIST");
        System.out.println(library.getRegisteredUsersList());


        // *****************BEGINNING OF IMPLEMENTATION ONE(1) USING PRIORITY QUEUE********************** //

        //Librarian Adds Users To The Priority Queue List
        menu_1_start();
        System.out.println(librarian.addUserToPriorityQueueList(abel, biology));
        System.out.println(librarian.addUserToPriorityQueueList(harold, biology));
        System.out.println(librarian.addUserToPriorityQueueList(richard, biology));
        System.out.println(librarian.addUserToPriorityQueueList(Magel, biology));
        System.out.println(librarian.addUserToPriorityQueueList(anvil, geography));

        System.out.println("-".repeat(60));
        System.out.println("Priority Queue List " + library.getPriorityQueueList());
        System.out.println();
        System.out.println("Current Book List "+librarian.getCurrentBookList());
        System.out.println("-".repeat(60));
        System.out.println(librarian.giveBooksUsingPriorityQueue(biology));
        System.out.println(librarian.giveBooksUsingPriorityQueue(biology));
        System.out.println(librarian.giveBooksUsingPriorityQueue(biology));
        System.out.println(librarian.giveBooksUsingPriorityQueue(biology));
        System.out.println(librarian.giveBooksUsingPriorityQueue(geography));
        System.out.println("-".repeat(60));
        System.out.println();
        System.out.println("Current book List " + librarian.getCurrentBookList());

        menu_1_end();
        System.out.println(library.getPriorityQueueList());

        //Priority Queue List - Users Returning Books
        System.out.println("-".repeat(60));
        System.out.println("Users in Priority Queue List - Book return");
        System.out.println();
        System.out.println(librarian.replaceReturnedBook(abel, biology));
        System.out.println(librarian.replaceReturnedBook(harold, biology));
        System.out.println(librarian.replaceReturnedBook(richard, biology));
        System.out.println(librarian.replaceReturnedBook(janet, biology));
        System.out.println("-".repeat(60));
        System.out.println("Current Book List "+librarian.getCurrentBookList());


        // *****************END OF IMPLEMENTATION ONE(1) USING PRIORITY QUEUE********************** //



        // *****************BEGINNING OF IMPLEMENTATION TWO(2) USING QUEUE**********************
        //Librarian Adds Users To The Queue List
        menu_2_start();
        System.out.println(librarian.addUserToQueueList(lucas, english));
        System.out.println(librarian.addUserToQueueList(daniel, english));
        System.out.println(librarian.addUserToQueueList(henry, english));
        System.out.println(librarian.addUserToQueueList(janet, english));
        System.out.println(librarian.addUserToQueueList(richard, chemistry));

        System.out.println("Queue List -- " + librarian.getQueueList());


        System.out.println("*".repeat(60));
        System.out.println("Current Book List "+librarian.getCurrentBookList());
        System.out.println();
        System.out.println(librarian.giveBooksUsingQueue(english));
        System.out.println(librarian.giveBooksUsingQueue(english));
        System.out.println(librarian.giveBooksUsingQueue(english));
        System.out.println(librarian.giveBooksUsingQueue(english));
        System.out.println(librarian.giveBooksUsingQueue(chemistry));

        menu_2_end();
        System.out.println(librarian.getQueueList());

        System.out.println("*".repeat(60));
        System.out.println("Current Book List " + librarian.getCurrentBookList());

        //Queue List - Users Returning Books
        System.out.println("-".repeat(60));
        System.out.println("Users in Queue List - Book return");
        System.out.println("-".repeat(60));
        System.out.println(librarian.replaceReturnedBook(henry, english));
        System.out.println(librarian.replaceReturnedBook(daniel, english));
        System.out.println(librarian.replaceReturnedBook(lucas, english));
        System.out.println(librarian.replaceReturnedBook(janet, english));
        System.out.println(librarian.replaceReturnedBook(richard, english));

        System.out.println("Current Book List " + librarian.getCurrentBookList());
        System.out.println("*".repeat(60));

        // *****************END OF IMPLEMENTATION TWO(2) USING QUEUE**********************

    }
}
