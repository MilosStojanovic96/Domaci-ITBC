package Sreda;

import java.util.Scanner;

public class Zadatak2 {
    public static void main(String[] args) {

        System.out.println("Unesite dva cela broja.");
        Scanner sc = new Scanner(System.in);
        int firstInteger = sc.nextInt();
        int secondInteger = sc.nextInt();
        if ((firstInteger >= 0) && (secondInteger >= 0)) {
            System.out.println("Brojevi " + firstInteger + " i " + secondInteger + " su istog znaka.");
        } else if ((firstInteger < 0) && (secondInteger < 0)) {
            System.out.println("Brojevi " + firstInteger + " i " + secondInteger + " su istog znaka.");
        } else {
            System.out.println("Brojevi " + firstInteger + " i " + secondInteger + " su suprotnog znaka.");
        }
    }
}
