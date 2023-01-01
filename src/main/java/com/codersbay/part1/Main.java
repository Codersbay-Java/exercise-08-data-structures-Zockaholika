package com.codersbay.part1;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.insert("Tobias","Bichler", 1);
        //System.out.println(phoneBook);
        phoneBook.insert("Tobias","Bichler", 2);
        phoneBook.insert("Tobias","Bichler", 3);
        //System.out.println(phoneBook);
        phoneBook.insert("Tobias","Bichler", 4);
        phoneBook.insert("Tobias","Bichler", 5);
        //System.out.println(phoneBook);

        //phoneBook.print();
        phoneBook.remove(1);
        System.out.println(phoneBook);
        phoneBook.update(1,"Tobias","Bichler", 99);
        System.out.println(phoneBook);
    }
}
