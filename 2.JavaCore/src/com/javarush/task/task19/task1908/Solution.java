package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String fileRead = reader.readLine();
        String fileWrite = reader.readLine();
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileWrite, true));
        reader = new BufferedReader(new FileReader(fileRead));

        String[] arrStr;
        while (reader.ready()){
            arrStr = reader.readLine().split(" ");
            for(String s : arrStr){
                try{
                    writer.write(Integer.parseInt(s) + " ");
                }catch (NumberFormatException ne){
                    continue;
                }
            }
        }
        reader.close();
        writer.close();

    }
}
