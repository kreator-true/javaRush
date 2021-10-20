package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception{
        String fileName;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!(fileName = reader.readLine()).equals("exit")){
            new ReadThread(fileName).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private Map<Integer, Integer> charsAmount;
        private String fileName;
        private int key;
        private int value;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
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
            }catch (Exception e){
                e.printStackTrace();
            }
            mostValue();
        }

        public void mostValue(){
            value = 0;
            for (Map.Entry<Integer, Integer> ch : charsAmount.entrySet()){
                if(ch.getValue() > value){
                    key = ch.getKey();
                    value = ch.getValue();
                }
            }
            Solution.resultMap.put(fileName, key);
        }
    }
}
