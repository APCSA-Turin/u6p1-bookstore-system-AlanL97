package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books;
    private User[] users = new User[10];
    private int numBooks = 0;

    //requires 1 empty constructor
    public BookStore() {}

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] newUsers) {
        users = newUsers;
    }

    public Book[] getBooks() {
        return books;
    }

    public void addUser(User user) { //adds a User to the next available spot in users. If there is no available space, user is not added
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        }
    } 

    public void removeUser(User user) { //removes user from users. If user is not in users, no user is removed
        //iterates through each element in user
        for (int i = 0; i < users.length; i++) {
            //checks for if user is in users
            if (users[i] == user) {
                //removes user by replacing it will null
                users[i] = null;
                //consolidates users so all null elements are in the back of users
                consolidateUsers();
                //ends the for loop
                break;
            }
        }
    }

    public void consolidateUsers() { // consolidates users so all null elements are in the back of users
        //iterates through users
        for (int i = 0; i < users.length-1; i++) {
            //checks if the current element is null
            if (users[i] == null) {
                //iterates through users to find the next User element after the null
                for (int j = i; j < users.length; j++) {
                    if (users[j] != null) {
                        //sets the null element to the next User element after it
                        users[i] = users[j];
                        //sets the next User element after the null to null
                        users[j] = null;
                        //ends the for loop
                        break;
                    }
                }
            }
        }
    }

    public void addBook(Book book) { //adds book to books
        //creates a temporary Book array with length 1 greater than books
        Book[] temp = new Book[numBooks+1];
        //checks if books is empty
        if (numBooks == 0) {
            //sets book to index 0 of temp
            temp[0] = book;
            //sets books to temp with book added
            books = temp;
            numBooks = books.length;
        } else {
            //iterates through books to set every index in temp to the elements in book
            for (int i = 0; i < books.length; i++) {
                temp[i] = books[i];
            }
            //sets the last index of temp to book
            temp[temp.length-1] = book;
            //sets books to temp with book added
            books = temp;
            numBooks = books.length;
        }
    }

    public void insertBook(Book book, int index) { //inserts a book at index
        //creates a temporary Book array with length 1 greater than books
        Book[] temp = new Book[numBooks+1];
        //iterates through all indexes in books before index to set the indexes in temp to the elements in book
        for (int i = 0; i < index; i++) {
            temp[i] = books[i];
        }
        //sets the index of temp at index to book
        temp[index] = book;
        //iterates through the rest of the indexes after index in books to set the indexes in temp to the elements in book
        for (int i = index; i < books.length; i++) {
            temp[i+1] = books[i];
        }
        //sets books to temp with book added at index
        books = temp;
        numBooks = books.length;
    }

    public void removeBook(Book book) { //removes a book
        int idx = 0;
        //checks to see if book has a quantity of more than 1
        if (book.getQuantity() > 1) {
            //iterates through books
            for (int i = 0; i < books.length; i++) {
                if (books[i] == book) {
                    //since quantity is greater than 1, the quantity of book decreases by 1
                    books[i].setQuantity(books[i].getQuantity()-1);
                }
            }
        } else {
            //creates a temporary Book array with length 1 less than length of books since quantity is 1, book will be removed completely from books
            Book[] temp = new Book[numBooks-1];
            //iterates through books
            for (int i = 0; i < books.length; i++) {
                //skips adding book to temp, causing the book to be removed from books
                if (books[i] == book) {
                    continue;
                }
                //sets every element in books to an index in temp, excluding the book being removed
                temp[idx] = books[i];
                idx++;
            }
            //sets books to temp with book removed
            books = temp;
            numBooks = books.length;
        }
    }

    //you are not tested on this method but use it for debugging purposes
    public String bookStoreBookInfo() { //returns a string with information about books
        String str = "";
        for (int i = 0; i < books.length; i++) {
            str += books[i].bookInfo() + "\n";
        }
        return str;
    } 

    //you are not tested on this method but use it for debugging purposes
    public String bookStoreUserInfo() { //returns a string with information about users
        String str = "";
        for (int i = 0; i < users.length; i++) {
            str += users[i].userInfo() + "\n";
        }
        return str;
    } 

}