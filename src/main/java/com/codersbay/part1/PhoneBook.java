package com.codersbay.part1;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {
    private int size = 1;
    public Person[] person = new Person[size];


    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sB.append(person[i]);
            sB.append("\n");
        }
        return sB.substring(0, (sB.length() - 1));
    }

    public void insert(String firstname, String surname, int telephoneNumber) {
        if (firstname == null || surname == null || telephoneNumber == 123456789) {
            return;
        }
        Person newPerson = new Person(firstname, surname, telephoneNumber);
        if (person[size - 1] == null) {
            //wenn noch keine Person eingefügt wurde erstelle die erste Person
            person[size - 1] = newPerson;

        } else {
            //erhöhe Index um 1 und erhöhe Array um 1
            increase();
            //füge an der um 1 erhötem Array and der stelle Index (auch um 1 erhöht) die neue Person ein
            person[size - 1] = newPerson;
        }
    }
    public void remove(int index){
        if (index > size || index < 0) {
            System.out.println("Index ist nicht in der Größe der Array enthalten");
            return;
        }
        Person[] tempPerson = new Person[(person.length-1)];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i == index){
                continue;
            } else {
                tempPerson[j] = person[i];
                j++;
            }
        }
        size--;
        person = Arrays.copyOf(tempPerson,size);

    }
    public void update(int index, String firstname, String surname, int telephoneNumber) {
        if (firstname == null || surname == null || telephoneNumber == 123456789) {
            return;
        }
        System.out.println("Alter Eintrag: " + person[index]);
        Person newPerson = new Person(firstname, surname, telephoneNumber);
        person[index] = newPerson;
        System.out.println("Neuer Eintrag: " + person[index]);
    }

    private void increase() {
        ++size;
        //laut SonarLint besser copyOf verwenden alls mit fori Schleife
        person = Arrays.copyOf(person, size);
    }

    public void printAndAsk(int index) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Für den nächsten Eintrag drücken Sie n");
        System.out.println("Für den vorherigen Eintrag drücken Sie b");
        System.out.println("Falls Sie keinen weiteren Eintrag sehen wollen drücken Sie x");
        String element = scanner.nextLine();
        switch (element) {
            case "n":
                if(index >= size-1){
                    System.out.println("Keine weiteren Einträge verfügbar.");
                    System.out.println("Dies ist der letzte Eintrag:");
                    System.out.println(person[index]);
                    printAndAsk(index);
                    break;
                }
                index++;
                System.out.println(person[index]);
                printAndAsk(index);
                break;
            case "b":
                if (index < size) {
                    System.out.println("Keine weiteren Einträge verfügbar.");
                    System.out.println("Dies ist der erste Eintrag:");
                    System.out.println(person[index]);
                    printAndAsk(index);
                    break;
                }
                index--;
                System.out.println(person[index]);
                printAndAsk(index);
                break;

            case "x":
                break;
        }
    }

    public void print() {
        System.out.println(person[0]);
        printAndAsk(0);
    }
}