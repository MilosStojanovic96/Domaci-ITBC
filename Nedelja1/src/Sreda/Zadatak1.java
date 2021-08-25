package Sreda;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) {
        System.out.println("Unesite dva cela broja. ");
        Scanner sc = new Scanner(System.in);
        int firstInteger = sc.nextInt();
        int secondInteger = sc.nextInt();
        System.out.println("Zbir ovih brojeva je: " + (firstInteger + secondInteger));
        System.out.println("Razlika ovih brojeva je: " + (firstInteger - secondInteger));
        System.out.println("Proizvod ovih brojeva je: " + (firstInteger * secondInteger));
        System.out.println("Kolicnik ovih brojeva je: " + (firstInteger / secondInteger));
        System.out.println("Ostatak pri deljenju ovih brojeva je: " + (firstInteger % secondInteger));
    }
}
