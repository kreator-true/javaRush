package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach = new Beach("first", 1.9f, 11);
        Beach beach2 = new Beach("second", 2.0f, 10);
        System.out.println(beach.compareTo(beach2));

    }

    @Override
    public synchronized int compareTo(Beach beach) {
        int countA = 0, countB = 0;
        if (this.distance == beach.getDistance()) {
            countA++;
            countB++;
        }else if(this.distance > beach.getDistance()){
            countB++;
        }else {
            countA++;
        }

        if (this.quality == beach.getQuality()) {
            countA++;
            countB++;
        }else if(this.quality > beach.getQuality()){
            countA++;
        }else {
            countB++;
        }


        if (countA == countB) return 0;
        if (countA > countB) return 1;
        else return -1;

    }
}
