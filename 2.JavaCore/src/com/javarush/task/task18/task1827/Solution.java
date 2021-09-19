package com.javarush.task.task18.task1827;


import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int id = 0;
        //String[] param = args[0].split(" ");

        BufferedReader reader;
        //reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = "E:\\IntellijIDEAProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1827\\tables.txt";
        //reader.close();

        reader = new BufferedReader(new FileReader(filePath));

        String[] pars = reader.readLine().replaceAll("[а-яА-Я]", "").split(" ");
        System.out.println(Arrays.toString(pars));



    }
}
