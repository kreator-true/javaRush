package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String[] result = outputStream.toString().split(" ");
        String operation = result[1];
        int a = Integer.parseInt(result[0]);
        int b = Integer.parseInt(result[2]);

        System.setOut(consoleStream);
        if(operation.equals("+")) System.out.println(String.format("%d %s %d = %d", a, operation, b, a + b));
        if(operation.equals("-")) System.out.println(String.format("%d %s %d = %d", a, operation, b, a - b));
        if(operation.equals("*")) System.out.println(String.format("%d %s %d = %d", a, operation, b, a * b));

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

