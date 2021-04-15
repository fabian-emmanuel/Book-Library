package models;

import enums.Level;

public class User implements Comparable<User>{
    private String name;
    private Level level;
    private int id;

    public User(String name, Level level){
        this.name = name;
        this.level = level;
        this.id = level.equals(Level.TEACHER) ? 1 : level.equals(Level.SENIOR_STUDENT) ? 2 : 3;
    }

    public void requestBook(Book book){
        System.out.println("  ....Processing request for '" + book.getTitle()+"' ...." );
    }
    public void returnBook(Book book){
        System.out.println("  ....Processing return of '"+book.getTitle()+"' ....");
    }
    public Level getLevel() { return level; }
    public String getName() { return name; }
    public int getId() { return id; }
    public String toString(){ return name; }

    //Compare Each User Objects by their ID
    @Override
    public int compareTo(User user) {
        if(this.getId() > user.getId())
            return 1;
        else if(this.getId() < user.getId())
            return -1;
        return 0;
    }
}
