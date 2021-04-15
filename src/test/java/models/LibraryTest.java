package models;

import enums.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LibraryTest {
    Library library;
    Library.Librarian librarian;

    //Books
    Book english;
    Book maths;
    Book physics;
    Book biology;
    Book chemistry;
    Book geography;

    //Users
    User abel;
    User bella;
    User ella;
    User henry;
    User daniel;
    User lucas;

    @BeforeEach
    void setUp() {
        library = new Library("AWESOME");
        librarian = library.new Librarian("Adams");
        test_Book();
    }

    @Test
    public void addBookToCurrentListTest(){
        assertEquals("Book Added!", librarian.addBookToCurrentList(english, 1));
        assertEquals("Book Updated!", librarian.addBookToCurrentList(english, 1));
        assertEquals("Book Added!", librarian.addBookToCurrentList(maths, 2));
        assertEquals("Book Updated!", librarian.addBookToCurrentList(maths, 3));
    }

    @Test
    public void registerUserTest(){
        test_User();
        assertEquals(" * Registration of TEACHER - Abel is Successful!", librarian.registerUser(abel, abel.getLevel()));
        assertEquals(" * Registration of SENIOR_STUDENT - Bella is Successful!", librarian.registerUser(bella, bella.getLevel()));
        assertEquals(" * Registration of JUNIOR_STUDENT - Ella is Successful!", librarian.registerUser(ella, ella.getLevel()));
    }

    @Test
    public void addUserToPriorityQueueListTest(){
        test_User();
        test_registerUser();
        test_addBookToList();
        assertEquals(" * TEACHER - Abel, Your Request for 'English' is Acknowledged...!", librarian.addUserToPriorityQueueList(abel, english));
        assertEquals(" * SENIOR_STUDENT - Bella, Your Request for 'English' is Acknowledged...!", librarian.addUserToPriorityQueueList(bella, english));
        assertEquals(" * JUNIOR_STUDENT - Ella, Your Request for 'English' is Acknowledged...!", librarian.addUserToPriorityQueueList(ella, english));
    }

    @Test
    public void giveBooksUsingPriorityQueueTest(){
        test_addBookToList();
        test_User();
        test_registerUser();
        test_AddToPriorityQueue();
        assertEquals(" * 'English' has been successfully given to TEACHER - Abel", librarian.giveBooksUsingPriorityQueue(english));
        assertEquals(" * 'English' has been successfully given to SENIOR_STUDENT - Bella", librarian.giveBooksUsingPriorityQueue(english));
        assertEquals(" * Sorry Ella, all copies of the book : 'English' has been taken!", librarian.giveBooksUsingPriorityQueue(english));
    }

    @Test
    public void addUserToQueueListTest(){
        test_User();
        test_registerUser();
        assertEquals(" * JUNIOR_STUDENT - Ella, Your Request for 'English' is Acknowledged...!", librarian.addUserToQueueList(ella, english));
        assertEquals(" * SENIOR_STUDENT - Bella, Your Request for 'English' is Acknowledged...!", librarian.addUserToQueueList(bella, english));
        assertEquals(" * TEACHER - Abel, Your Request for 'English' is Acknowledged...!", librarian.addUserToQueueList(abel, english));

    }

    @Test
    public void giveBooksUsingQueueTest(){
        test_addBookToList();
        test_User();
        test_registerUser();
        test_AddToQueue();
        assertEquals(" * 'English' has been successfully given to SENIOR_STUDENT - Bella", librarian.giveBooksUsingQueue(english));
        assertEquals(" * 'English' has been successfully given to JUNIOR_STUDENT - Ella", librarian.giveBooksUsingQueue(english));
        assertEquals(" * Sorry Abel, all copies of the book : 'English' has been taken!", librarian.giveBooksUsingQueue(english));

    }

    @Test
    public void replaceReturnedBookTest(){
        test_addBookToList();
        test_User();
        test_registerUser();
        test_AddToPriorityQueue();
        test_giveBooksWithPriorityQueue();
        assertEquals(" ~ No Record found for Ella!", librarian.replaceReturnedBook(ella, english));
        assertEquals(" ~ Book from Bella has been returned Successfully!", librarian.replaceReturnedBook(bella, english));
        assertEquals(" ~ Book from Abel has been returned Successfully!", librarian.replaceReturnedBook(abel, english));
    }


    //Helper Methods
    public void test_Book(){
        biology = new Book("Biology");
        english = new Book("English");
        maths = new Book("Mathematics");
        physics = new Book("Physics");
        chemistry = new Book("Chemistry");
        geography = new Book("Geography");
    }

    public void test_addBookToList(){
        librarian.addBookToCurrentList(english, 2);
        librarian.addBookToCurrentList(maths, 1);
        librarian.addBookToCurrentList(physics, 1);
        librarian.addBookToCurrentList(geography, 1);
    }

    public void test_User(){
        abel = new User("Abel", Level.TEACHER);
        bella = new User("Bella", Level.SENIOR_STUDENT);
        ella = new User("Ella", Level.JUNIOR_STUDENT);
        henry = new User("Henry", Level.TEACHER);
        daniel = new User("Daniel", Level.SENIOR_STUDENT);
        lucas = new User("Lucas", Level.JUNIOR_STUDENT);
    }

    public void test_registerUser(){
        librarian.registerUser(abel, abel.getLevel());
        librarian.registerUser(bella, bella.getLevel());
        librarian.registerUser(ella, ella.getLevel());
        librarian.registerUser(henry, henry.getLevel());
        librarian.registerUser(daniel, daniel.getLevel());
        librarian.registerUser(lucas, lucas.getLevel());
    }
    public void test_AddToPriorityQueue(){
        librarian.addUserToPriorityQueueList(abel, english);
        librarian.addUserToPriorityQueueList(bella, english);
        librarian.addUserToPriorityQueueList(ella, english);
    }
    public void test_giveBooksWithPriorityQueue(){
        librarian.giveBooksUsingPriorityQueue(english);
        librarian.giveBooksUsingPriorityQueue(english);
        librarian.giveBooksUsingPriorityQueue(english);
    }

    public void test_AddToQueue(){
        librarian.addUserToQueueList(bella, english);
        librarian.addUserToQueueList(ella, english);
        librarian.addUserToQueueList(abel, english);
    }

    public void test_giveBooksWithQueue(){
        librarian.giveBooksUsingQueue(english);
        librarian.giveBooksUsingQueue(english);
        librarian.giveBooksUsingQueue(english);
    }
}