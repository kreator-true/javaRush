package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        logger.debug("set value1, value2. value3",  value1, value2, value3);
    }

    public static void main(String[] args) {
        Solution solution = new Solution(22, "22", new Date());
        solution.calculateAndSetValue3(222);
        solution.printString();
        solution.printDateAsLong();
        solution.divide(21,  0);
    }

    public void calculateAndSetValue3(long value) {
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            logger.trace("tracking value1", value1);
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("chnge value 1",  value1);
        } else {
            value1 = (int) value;
            logger.debug("chnge value 1",  value1);
        }
    }

    public void printString() {
        logger.trace("tracking value2", value2);
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("tracking valu32", value3);
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        try {
            logger.trace("tracking", number1, number2);
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("Not divide", number2);
        }
    }

    public void setValue1(int value1) {
        logger.debug("change value1", value1);
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        logger.debug("change value2", value2);
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        logger.debug("change value3", value3);
        this.value3 = value3;
    }
}
