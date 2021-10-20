package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File fileName = null;
        while (true) {
            try {
                fileName = new File(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileInputStream fileInputStream = new FileInputStream(fileName)){

            } catch (FileNotFoundException e){
                System.out.println(fileName);
                break;
            }
            catch (IOException e) {
            }
        }
    }
}
