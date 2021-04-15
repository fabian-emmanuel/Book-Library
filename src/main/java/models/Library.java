package models;

import enums.Level;
import java.util.*;

public class Library {
    String name;
    public Map<Book, Integer> currentBookList = new HashMap<>();
    public Map<User, Book> borrowedBookRecord = new HashMap<>();
    public Map<User, Level> registeredUsersList = new HashMap<>();
    public Queue<User> queueList = new LinkedList<>();
    public PriorityQueue<User> priorityQueueList = new PriorityQueue<>();

    public Library(String name) {
        this.name = name;
    }

    public Map<User, Level> getRegisteredUsersList() {
        return registeredUsersList;
    }

    public Map<User, Book> getBorrowedBookRecord() {
        return borrowedBookRecord;
    }

    public PriorityQueue<User> getPriorityQueueList() {
        return priorityQueueList;
    }

    //   LIBRARIAN CLASS
    public class Librarian{
        String name;

        public Librarian(String name){
            this.name = name;
        }

        public Map<Book, Integer> getCurrentBookList(){
            return currentBookList;
        }

        public Queue<User> getQueueList(){
            return queueList;
        }

        public String addBookToCurrentList(Book book, int copies) {
            if(currentBookList.containsKey(book)){
                currentBookList.put(book, currentBookList.get(book) + copies);
                return "Book Updated!";
            }else {
                currentBookList.put(book, copies);
                return "Book Added!";
            }
        }

        public String registerUser(User user, Level level) {
            if(registeredUsersList.containsKey(user)){
               return " * User "+ user.getName() +" is Already Registered!";
            } else{
            registeredUsersList.put(user, level);
            return " * Registration of " + level + " - " + user.getName()  +" is Successful!";
            }
        }

        // *****************BEGINNING OF IMPLEMENTATION ONE(1) USING PRIORITY QUEUE**********************//
        // Add Users To The Priority Queue List
        public String addUserToPriorityQueueList(User user, Book book) {
            user.requestBook(book);
            if(registeredUsersList.containsKey(user)){
                priorityQueueList.add(user);
                return " * "+ user.getLevel() +" - "+ user.getName() + ", Your Request for '"+book.getTitle()+ "' is Acknowledged...!";
            } else return "No Book request made from "+user.getName();
        }
        // Give Out Books To Users On The Priority Queue List
        public String giveBooksUsingPriorityQueue(Book book) {
            User user = priorityQueueList.peek();
            if (currentBookList.containsKey(book) && currentBookList.get(book) > 0) {
                currentBookList.put(book, currentBookList.get(book) - 1);
                borrowedBookRecord.put(user, book);
                priorityQueueList.peek();
                return " * '" + book.getTitle() + "' has been successfully given to " +  priorityQueueList.peek().getLevel() + " - " + priorityQueueList.poll().getName();
            } else if (borrowedBookRecord.containsValue(book)) {
                return " * Sorry "+ priorityQueueList.poll().getName() + ", all copies of the book : '" + book.getTitle() + "' has been taken!";
            }else {
                return " * Dear "+ priorityQueueList.peek().getName() + ", The book : '" + book.getTitle() + "' you requested for is not available at the moment!";
            }
        }
        // *****************END OF IMPLEMENTATION ONE(1) USING PRIORITY QUEUE**********************//

        // *****************BEGINNING OF IMPLEMENTATION TWO(2) USING QUEUE**********************//
        // Add Users to Queue List
        public String addUserToQueueList(User user, Book book) {
            user.requestBook(book);
            if(registeredUsersList.containsKey(user)) {
                queueList.add(user);
                return " * " + user.getLevel()+ " - " + user.getName() + ", Your Request for '" + book.getTitle() +"' is Acknowledged...!";
            } else return "No Book request made from "+ user.getName();
        }
        // Give out Books to Users on the Queue List
        public String giveBooksUsingQueue(Book book) {
            User user = queueList.peek();
            if (currentBookList.containsKey(book) && (currentBookList.get(book) > 0)) {
                currentBookList.put(book, currentBookList.get(book) - 1);
                borrowedBookRecord.put(user, book);
                queueList.peek();
                return " * '" + book.getTitle() + "' has been successfully given to " + queueList.peek().getLevel() + " - " + queueList.poll().getName();
            } else if (borrowedBookRecord.containsValue(book)) {
                return " * Sorry " + queueList.poll().getName() + ", all copies of the book : '" + book.getTitle() + "' has been taken!";
            }  else {
                return " * Dear " + queueList.peek().getName() + ", The book : '" + book.getTitle() + "' you requested for is not available at the moment!";
            }
        }
        // *****************END OF IMPLEMENTATION TWO(2) USING QUEUE**********************//

        // REPLACE RETURNED BOOKS
        public String replaceReturnedBook(User user, Book book) {
            if(borrowedBookRecord.containsKey(user) && borrowedBookRecord.containsValue(book)){
                System.out.println(" ~ The User "+ user.getName()+" is returning '"+ book.getTitle() +"'");
                user.returnBook(book);
                borrowedBookRecord.remove(user, book);
                currentBookList.put(book, currentBookList.get(book) + 1);
                return " ~ Book from "+ user.getName() +" has been returned Successfully!";
            }else if(borrowedBookRecord.containsKey(user) && !borrowedBookRecord.containsValue(book)){
                System.out.println(" ~ The User "+ user.getName()+" is returning '"+ book.getTitle() +"'");
                user.returnBook(book);
                return "Dear "+user.getName()+", The book you collected is not '"+book.getTitle()+"'";
            }else {
                System.out.println(" ~ The User "+ user.getName()+" is returning '"+ book.getTitle() +"'");
                user.returnBook(book);
                return " ~ No Record found for " + user.getName()+"!";
            }
        }

}
}