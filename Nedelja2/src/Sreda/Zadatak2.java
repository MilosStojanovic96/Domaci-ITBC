package Sreda;

import java.util.Scanner;

public class Zadatak2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert a number.");
        int number = sc.nextInt();
        int n = 1;
        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                n = n * i;
            }
            System.out.println("Factorial of this number is: " + n);

        } else {
            System.out.println("You didn't insert a number that is bigger then 0");
        }

    }

}
