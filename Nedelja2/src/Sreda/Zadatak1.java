package Sreda;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 numbers.");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();
        if (x < y && x < z) {
            System.out.println("Min number is: " + x);
        } else if (y < x && y < z) {
            System.out.println("Min number is: " + y);
        } else {
            System.out.println("Min number is: " + z);
        }


    }
}
