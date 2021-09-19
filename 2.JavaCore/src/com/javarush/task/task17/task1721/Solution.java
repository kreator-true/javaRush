package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));

        //read string of console
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();

        //read dato of first file
        reader = new BufferedReader(new FileReader(firstFile));
        while (reader.ready()){
            allLines.add(reader.readLine());
        }
        reader.close();

        //read data fo second file
        reader = new BufferedReader(new FileReader(secondFile));
        while (reader.ready()){
            forRemoveLines.add(reader.readLine());
        }
        reader.close();

        new Solution().joinData();

    }

    public void joinData() throws CorruptedDataException {
        int countEqulasString = 0;
        for(String remove : forRemoveLines){
            for(String all : allLines){
                if(remove.equalsIgnoreCase(all)) countEqulasString++;
            }
        }
        if(countEqulasString == forRemoveLines.size()){
            for (String remove  :  forRemoveLines) allLines.remove(remove);
        }else {
            allLines = new ArrayList<>();
            throw new CorruptedDataException();
        }

    }
}
