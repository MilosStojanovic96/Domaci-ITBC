package Sreda;

import java.util.Scanner;

public class Zadatak3 {
    public static void main(String[] args) {
        System.out.println("Uneti pozitivni celobrojni cetvorocifreni broj.");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int tmp = number;
        if (number >= 1000 && number <= 9999) {
            int j = tmp % 10;
            tmp /= 10;
            int d = tmp % 10;
            tmp /= 10;
            int s = tmp % 10;
            tmp /= 10;
            int h = tmp % 10;
            tmp /= 10;
            int proizvodPrvihDvejuCifara = h * s;
            int zbirDrugihDvejuCifara = d + j;
            System.out.println(proizvodPrvihDvejuCifara - zbirDrugihDvejuCifara);
        } else {
            System.out.println("Greska.");
        }
    }
}
