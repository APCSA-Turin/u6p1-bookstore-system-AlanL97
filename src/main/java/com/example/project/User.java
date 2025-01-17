package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name;
    private String id;
    private Book[] book = new Book[5];
    
    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getId() {
        return id;
    }

    public void setId(String newId) {
        id = newId;
    }

    public Book[] getBooks() {
        return book;
    }

    public void setBooks(Book[] newBook) {
        book = newBook;
    }

    //returns a booklist for the user, if empty, output "empty"
    public String bookListInfo() { //returns a string with information about book
        String str = "";
        for (Book books : book) {
            if (books == null) {
                str += "empty\n";
            } else {
                str += books.bookInfo() + "\n";
            }
        }
        return str;
    } 

    //returns  "Name: []\nID: []\nBooks:\n[]"
    public String userInfo() { //returns a string with formation about a User object
        return "Name: " + name + "\nId: " + id + "\nBooks: \n" + bookListInfo();
    } 
       
}