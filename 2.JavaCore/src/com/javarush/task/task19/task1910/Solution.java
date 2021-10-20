package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader;
        BufferedWriter writer;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(file1));
        writer = new BufferedWriter(new FileWriter(file2, true));
        while (reader.ready()){
            writer.write(reader.readLine().replaceAll("[\\p{Punct}\n]", "") + " ");

        }
        reader.close();
        writer.close();

    }
}
