package com.threelittlepigs.codecool.libraryManager.Entities;

import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Librarian")
public class Librarian extends User {

    public Librarian(String userName, String password, String firstName, String lastName, String email, Date dateOfBirth, String address, String phoneNumber, UserType userType){
        super(userName,password,firstName,lastName, email, dateOfBirth, address, phoneNumber, userType);
    }

    public Librarian() {
        super();
    }

    public void addBook(Book book){
        EntityUtility.persistEntity(book);
    }

    public void removeBook(Book book){
        EntityUtility.removeEntity(book);
    }

    public void rentBook(Book book, Member member){
        book.setRentedBy(member);
        EntityUtility.mergeEntity(book);
    }

    public void returnBook(Book book){
        book.setRentedBy(null);
        EntityUtility.mergeEntity(book);
    }

    public void payFine(Fine fine){

    }
}