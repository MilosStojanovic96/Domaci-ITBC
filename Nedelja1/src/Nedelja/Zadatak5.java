package Nedelja;

import java.util.Scanner;

public class Zadatak5 {
    public static void main(String[] args) {
        //Skriveni broj broja n je broj dobijen ponavljanjem postupka sabiranja svih njegovih cifara dokle god nije jednocifren.
        // Napisati program koji za uneti celobrojni pozitivan broj racuna njegov skriven broj.
        // Npr. skriveni broj broja 4567 je 4 jer je 4567 --> 4+5+6+7 = 22 --> 2+2 = 4; broja 9999 je 9 jer je 9999 --> 9+9+9+9 = 36 --> 3+6 = 9.

        Scanner sc = new Scanner(System.in);

        /*
         * Ovaj zadatak nimalo nije lak! Hajde prvo da vidimo sta nam se trazi
         * Skriveni broj nekog broja je JEDNOCIFREN broj dobijen PONAVLJANJEM
         * postupka SABIRANJA njegovih CIFARA
         * Dakle, imamo broj n i sabiramo njegove cifre sve dok ne dobijemo jednocifren broj
         * Taj postpuak ponavljanja ce biti jedna petlja, dok ce druga petlja u njoj biti
         * ona koja sabira njegove cifre. Dve petlje, jedna u drugoj
         * Npr broj 55559999
         * 1. 55559999 -> 5+5+5+5+9+9+9+9 = 56
         * 2. 56 -> 5 + 6 = 11
         * 3. 11 -> 1 + 1 = 2
         * 4. 2 KRAJ
         * Znaci ponavljamo postupak sve dok na kraju nije jednocifren broj ( u ovom slucaju u 4 koraka, al inace moze
         * da bude u 1, 2, 3, 4, itd)
         * Hajde to da i ispisemo u kod
         * */

        int n = sc.nextInt();

        // Radimo sve dok n nije jednocifreni broj, dakle while petlja
        while (n > 9){
            // Sabiramo sve njegove cifre
            int sum = 0;
            while (n != 0){
                sum += n % 10; // Na sumu dodajemo poslednju cifru
                n /= 10; // Unistavamo poslednju cifru
            }
            // Sada nam je n unisteno, dakle moramo neku novu vrednost da mu dodelimo
            // To je upravo vrednost sum
            n = sum;
        }

        System.out.println(n);

        /*
         * Ispisimo prethodni kod korak po korak za slucaj 1234
         * n = 1234
         * n > 9 -> 1234 > 9 -> true
         * |   int sum = 0
         * |   n != 0 -> 1234 != 0 -> true
         * |   |   sum += 1234 % 10 -> sum = 0 + 4 -> sum = 4
         * |   |   n /= 10 -> n = 1234 / 10 -> n = 123
         * |   n != 0 -> 123 != 0 -> true
         * |   |   sum += 123 % 10 -> sum = 4 + 3 -> sum = 7
         * |   |   n /= 10 -> n = 123 / 10 -> n = 12
         * |   n != 0 -> 12 != 0 -> true
         * |   |   sum += 12 % 10 -> sum = 7 + 2 -> sum = 9
         * |   |   n /= 10 -> n = 12 / 10 -> n = 1
         * |   n != 0 -> 1 != 0 -> true
         * |   |   sum += 1 % 10 -> sum = 9 + 1 -> sum = 10
         * |   |   n /= 10 -> n = 1 / 10 -> n = 0
         * |   n != 0 -> 0 != 0 -> false
         * |   n = sum -> n = 10
         * n > 9 -> 10 > 9 -> true
         * |   int sum = 0
         * |   n != 0 -> 10 != 0 -> true
         * |   |   sum += 10 % 10 -> sum = 0 + 0 -> sum = 0
         * |   |   n /= 10 -> n = 10 / 10 -> n = 1
         * |   n != 0 -> 1 != 0 -> true
         * |   |   sum += 1 % 10 -> sum = 0 + 1 -> sum = 1
         * |   |   n /= 10 -> n = 1 / 10 -> n = 0
         * |   n != 0 -> 0 != 0 -> false
         * |   n = sum -> n = 1
         * n > 9 -> 1 > 9 -> fasle
         * System.out.println(n) -> 1
         * */

    }
}
