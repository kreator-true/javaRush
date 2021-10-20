package com.javarush.task.task17.task1711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    static Person person;
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]){
            case ("-c") :
                synchronized (allPeople) {
                    addPerson(args);
                }
                break;
            case ("-u") :
                synchronized (allPeople) {
                    updatePerson(args);
                }
                break;
            case ("-d") :
                synchronized (allPeople) {
                    removePerson(args);
                }
                break;
            case ("-i") :
                synchronized (allPeople) {
                    printPerson(args);
                }
                break;
        }
    }

    public static void addPerson(String[] args) {
        try {
            for(int i = 1; i < args.length; i+=3) {
                Date date = dateFormat.parse(args[i + 2]);
                person = args[i + 1].equals("м") ? Person.createMale(args[i], date)
                        : Person.createFemale(args[i], date);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void updatePerson(String[] args) {
        try {
            for(int i = 1; i < args.length; i+=4) {
                person = allPeople.get(Integer.parseInt(args[i]));
                person.setName(args[i + 1]);
                person.setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                person.setBirthDate(dateFormat.parse(args[i + 3]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void removePerson(String[] args)  {
        try {
            for(int i = 1; i < args.length; i++) {
                person = allPeople.get(Integer.parseInt(args[i]));
                person.setName(null);
                person.setBirthDate(null);
                person.setSex(null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void printPerson(String[] args) {
        try {
            for(int i = 1; i < args.length; i++) {
                Person person = allPeople.get(Integer.parseInt(args[i]));
                System.out.printf("%s %s %s \n", person.getName(), person.getSex().equals(Sex.MALE) ? "м" : "ж",
                        simpleDateFormat.format(person.getBirthDate()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
