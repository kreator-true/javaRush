package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    private static BufferedReader reader;
    private static String fileName;
    public static void main(String[] args) throws Exception{
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fileName));

        int count = 0;
        String[] str;

        while(reader.ready()){
            str = reader.readLine().split("\\W");
            for(String s : str){
                if(s.equals("world")) count++;
            }

        }
        reader.close();

        System.out.println(count);


    }
}
