package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Встречаемость символов
*/

public class Solution {
    private static String fileName;
    private static Map<Integer, Integer> charsAmount;
    private static int key;
    private static int value;

    public static void main(String[] args) {
        fileName = args[0];
        if (fileName == null || fileName.isEmpty()) return;

        try(FileInputStream fileInputStream = new FileInputStream(fileName)){
            charsAmount = new HashMap<>();
            while (fileInputStream.available() > 0){
                key = fileInputStream.read();
                value = 1;
                if(charsAmount.containsKey(key)) {
                    value = charsAmount.get(key);
                    charsAmount.put(key, ++value);
                }else charsAmount.put(key, value);
            }
            charsAmount = charsAmount.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByKey())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            for (Map.Entry<Integer, Integer> cr : charsAmount.entrySet()) {
                key = cr.getKey();
                value = cr.getValue();
                System.out.println((char) key + " " + value);
            }
        }

    }
}
