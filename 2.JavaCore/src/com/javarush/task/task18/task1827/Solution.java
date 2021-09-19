package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer;
        String path = reader.readLine();
        reader.close();

        String param = args[0];
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];
        int id = 0;

        if(param.equals("-c")){
            reader = new BufferedReader(new FileReader(path));
            while (reader.ready()){
                int tempId = Integer.parseInt(reader.readLine().substring(0, 8).trim());
                id = tempId > id ? tempId : id;
            }
            reader.close();
            writer = new BufferedWriter(new FileWriter(path, true));
            writer.write("\n");
            writer.write(String.format("%-8d%-30.30s%-8.8s%-4.4s", ++id, productName, price, quantity));
            writer.close();
        }
    }

}
