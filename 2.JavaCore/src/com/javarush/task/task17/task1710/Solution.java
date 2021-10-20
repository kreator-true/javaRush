package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpledate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static int indexperson;
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception{
        /*try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(true) {
                String param = reader.readLine();
                if(param.isEmpty()) break;
                args = param.split(" ");
                test(args);
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
        String param = args[0];
        if(param.equals("-c")) addPerson(args);
        if(param.equals("-u")) updatePerson(args);
        if(param.equals("-d")) removePerson(args);
        if(param.equals("-i")) printPerson(args);

    }
    public static void addPerson(String[] args) throws ParseException {
        Date date = simpledate.parse(args[3]);
        Person person = args[2].equals("м") ? Person.createMale(args[1], date)
                                            : Person.createFemale(args[1], date);
        allPeople.add(person);
        System.out.println(allPeople.indexOf(person));

    }

    public static void  updatePerson(String[] args) throws ParseException {
        indexperson = Integer.parseInt(args[1]);
        allPeople.get(indexperson).setName(args[2]);
        allPeople.get(indexperson).setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
        allPeople.get(indexperson).setBirthDate(simpledate.parse(args[4]));
    }

    public static void removePerson(String[] args){
        indexperson = Integer.parseInt(args[1]);
        allPeople.get(indexperson).setName(null);
        allPeople.get(indexperson).setBirthDate(null);
        allPeople.get(indexperson).setSex(null);
    }

    public static void printPerson(String[] args){
        indexperson = Integer.parseInt(args[1]);
        Person person = allPeople.get(indexperson);
        System.out.printf("%s %s %s \n", person.getName(), person.getSex().equals(Sex.MALE) ? "м" : "ж",
                simpleDateFormat.format(person.getBirthDate()));
    }

    public void test(String[] args) throws Exception{
        if(args[0].equals("-a")) System.out.println(Arrays.toString(allPeople.stream().toArray()));
        if(args[0].equals("-c")) addPerson(args);
        if(args[0].equals("-u")) updatePerson(args);
        if(args[0].equals("-d"))  removePerson(args);
        if(args[0].equals("-i")) printPerson(args);
    }

}
