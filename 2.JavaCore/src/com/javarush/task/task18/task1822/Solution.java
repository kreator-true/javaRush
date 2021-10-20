package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    private static BufferedReader reader;
    private static String fileName;
    private static String productInfo;
    private static int id;
    public static void main(String[] args) throws Exception{
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();

        if(fileName == null || fileName.isEmpty()) return;
        id = Integer.parseInt(args[0]);

        reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()){
            productInfo = reader.readLine();
            if (Integer.parseInt(productInfo.split(" ")[0]) == id){
                System.out.println(productInfo);
                break;
            }
        }
        reader.close();
    }
}
