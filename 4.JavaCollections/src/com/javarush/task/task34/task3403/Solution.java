package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public static void main(String[] args) {
        new Solution().recurse(132);
    }
    public void recurse(int n) {
        if(n <= 1) return;
        recurse(n/dividenumber(n));
    }

    public int dividenumber(int n) {
        int i = 2;
        for ( ; i < n; i++){
            if(n%i == 0) break;
        }
        System.out.println(i);
        return i;
    }
}
