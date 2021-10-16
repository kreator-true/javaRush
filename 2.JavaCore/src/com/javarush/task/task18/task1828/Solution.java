package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    private static BufferedReader reader;
    private static BufferedWriter writer;

    private static String operation;
    private static String fileName;

    private static List<Product> products;

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();

        if (fileName == null || fileName.isEmpty()) return;
        operation = args[0];

        if(operation.isEmpty() || operation == null) return;
        writeToList();

        if(operation.equals("-u")) update(new Product(args[1], args[2], args[3], args[4]));
        else if(operation.equals("-d")) delete(args[1]);

    }

    private static void writeToList() throws IOException {
        products = new ArrayList<>();
        reader = new BufferedReader(new FileReader(fileName));
        String productInfo;

        while (reader.ready()){
            productInfo = reader.readLine();
            products.add(new Product(productInfo.substring(0, 8).trim(),
                                    productInfo.substring(8, 38).trim(),
                                    productInfo.substring(38, 46).trim(),
                                    productInfo.substring(46, productInfo.length()).trim()));
        }
        reader.close();

    }

    private static void writeToFile() throws IOException {
        writer = new BufferedWriter(new FileWriter(fileName));
        for (Product product : products)
            writer.write(product.toString() + "\n");

        writer.close();
    }

    private static void update(Product product) throws IOException {
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).id.equals(product.id)){
                products.remove(i);
                products.add(i, product);
                break;
            }
        }
        writeToFile();
    }

    private static void delete(String id) throws IOException {
        products.removeIf(p -> p.id.equals(id));
        writeToFile();
    }
}
