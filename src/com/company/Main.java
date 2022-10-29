package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = 21;
        int start[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            start[i] = i;
        }



        // Ending points of segments
        int[] end = {5, 6, 7, 8, 7, 6, 4, 3, 4, 5, 6, 7, 8 , 11, 8, 7, 6, 5, 4, 3, 4, 5, 6};

        int[][] points = new int[n + 1][2];

        // Insert ranges in points[]
        for (int i = 0; i < n; i++) {
            points[i][0] = start[i];
//            System.out.print( points[i][0] );
            points[i][1] = end[i];
//            System.out.println( points[i][1] );
        }

        int h1min = 3;
        int h2max = 13;

//        su(points, h1min, h2max);
//        mooz(points);
        canat(points);

    }

    private static void canat(int[][] points) {
        int min1=0;
        int min=0;
        int min2=0;
        int indexmin=0;
        int indexmax=0;
        int max=0;

        for (int i=0;i<indexmax;i++){
            if(points[i][1] > min1){
                min1=points[i][1];
            }
        }//найдем самое максимальное точка до максимального числа
//        System.out.println(min1);
        for (int i=indexmax;i<21;i++){
            if(points[i][1] > min2){
                min2=points[i][1];
            }
        }//найдем  максимальное точка после максимального числа
         if(min1>min2){
             min=min2;
         } else min=min1;
        // сравниваем и берем низкое вершину
        for (int i=0;i<22;i++){
            if(points[i][1] == min){
                indexmin=i;
            }
        }
//найдем индек минимального вершины
        for (int i=0;i<22;i++){
            if(points[i][1] > max){
                max=points[i][1];
            }
        }//индекс минимальной точки

        for (int i=0;i<22;i++){
            if(points[i][1] == max){
                indexmax=i;
            }
        }//индекс максимальной точки
//        System.out.println(indexmax);

        int h=points[indexmax][1]-points[indexmin][1];
//        System.out.println(h);
        int range = indexmax-indexmin;
        System.out.println(Math.sqrt((h*h)+(range*range)));
    }


    private static void mooz(int[][] points) {
        int min=1000;
        int min1=10000;
        int equal=0;
        int equal1=0;
        for (int i=0;i<20;i++){
            if(points[i][1] < min){
                min=points[i][1];
            }
        }//найдем самое минимальное точка
//        System.out.print(min);
        for (int i=0;i<20;i++){
            if(points[i][1] == min){
                equal=i;
            }
        }// индекс минимального точки
//        System.out.println(equal);
        for (int i=0;i<equal;i++){
            if(points[i][1] < min1){
                min1=points[i][1];
            }
        }//найдем second самое минимальное точка
//        System.out.println(min1);
        for (int i=0;i<equal;i++){
            if(points[i][1] == min){
                equal1=i;
            }
        }
//        System.out.println(equal1); Index of second minimal point
        int sum=0;
        for(int i=equal1;i<=equal;i++){
            sum=sum+points[i][1]-min;//so to calculete we plus all posible cube and minus the minimal point so we can find each part of icecile
        }
        System.out.println(sum+"it is maximal volume of icicle");

    }

    private static void su(int[][] points, int h1min, int h2max) {
        int equal = 0;
        int sum = 0;
        for (int i = h1min+1; i <= h2max; i++) {
            if (points[h1min][1] == points[i][1]) {
                equal = i;
            }
//            System.out.print(points[h1min][1]);
//            System.out.println(points[i][1]);
//            System.out.println(equal);
        }
        for (int i=h1min+1;i<=equal;i++){
            sum=sum+(points[4][1]-points[i][1]);
        }
        System.out.println(sum+" Maximal possible volume of water");
    }
}
