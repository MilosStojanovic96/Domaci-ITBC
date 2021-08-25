package Nedelja;

import java.util.Scanner;

public class Zadatak6 {
    public static void main(String[] args) {

        //Potrebno je nacrtati u konzoli pomocu znaka * jednakostranicni trougao proizvoljne duzine stranice, kao u test primerima.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*
         * Dakle pravimo jednakostranicni trougao sa zvezdicama, tako da
         * izmedju svake dve zvezdice ima razmak
         * Npr za 6 imamo
         * |     *     |
         * |    * *    |
         * |   * * *   |
         * |  * * * *  |
         * | * * * * * |
         * |* * * * * *|
         *
         * Uspraven crte oznacavju pocetak i kraj reda, njih ne ispisujemo, oni su tu samo
         * radi lakseg snalazenja.
         * Kod ovakvih zadataka bitno je da primetimo neko pravilo i sa cime raspolazemo.
         * Mi raspolazemo sa promenjivom n, sto je duzina stranice
         * Primetimo da u nultom redu imamo 5 razmaka, 1 zvezdicu, 5 razmaka
         * U Prvom redu imamo 4 razmaka, 2 zvezdice, 4 razmaka
         * U Drugom redu imamo 3 razmaka, 3 zvezdice, 3 razmaka
         * Dakle u svakom narednom redu imamo jedan manje razmak na pocetku i kraju slike,
         * kao i jednu vise zvezdicu u sredini.
         * Za i-ti red imamo formulu n-i-1 razmaka, i+1 zvezdicu
         * Npr za prvi red, i = 1, imamo 6-1-1 = 4 razmaka, 1+1= 2 zvezdice itd.
         * Jos jedno pravilo koje treba da primetimo je da se krajnja leva zvezdica uvek pomera
         * za tacno jedno mesto ulevo, a krajnja desna zvezdica za jedno mesto udesno
         * (u nultom redu krajnja leva zvezdica je na istoj poziciji kao i krajnja desna zvezdica,
         * te imamo samo jednu zvezdicu).
         * Ove pozicije cemo cuvati u promenjivima i na lukav nacin odredjivati da li u ovoj sredini
         * ide razmak ili zvezdica!
         * */

        for (int i = 0; i < n; i++) { // Prolazimo kroz redove
            // Odredujemo kranje pozicije zvezdica
            int left = n - i - 1; // jer prvu poziciju racunamo od 0
            int right = n + i - 1;
            // Deklarisacemo boolean prethodnoJeRazmak, koja cuva da li je prethodni ispisan znak razmak ili ne
            boolean prethodnoJeRazmak = true;
            for (int j = 0; j < 2 * n; j++) { // Prolazimo korz kolone, primetite da u svakom redu imamo 12 kolona!
                // Pitamo se da li smo levo od kranje leve zvezdice
                if (j < left) {
                    // Ako jesmo ispisujemo razmak
                    System.out.print(" ");
                    prethodnoJeRazmak = true; // Upisali smo razmak
                }
                // U suprotnom, da li smo desno od kranje desne zvezdice
                else if (j > right) {
                    // Ako jesmo ispisujemo razmak
                    System.out.print(" ");
                    prethodnoJeRazmak = true; // Upisali smo razmak
                }
                // Inace smo u sredini
                else {
                    // Ako je prethodno upisan razmak upisujemo zvezdicu
                    if (prethodnoJeRazmak) {
                        System.out.print("*");
                        prethodnoJeRazmak = false; // Upisali smo zvezdicu
                    }
                    // Inace smo upisali zvezdicu, pa treba da upisemo razmak
                    else {
                        System.out.print(" ");
                        prethodnoJeRazmak = true; // Upisali smo razmak
                    }
                }
            }
            // Kada smo obradili ceo red, prelazimo u novi red
            System.out.println();

            /*
             * Isprobajte ovaj koda za unose 0, 1, 2, 3, 4, 5, 6, 16
             * I pogledajte kako radi!
             * */
        }
    }
}
