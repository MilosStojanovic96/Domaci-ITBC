import java.util.Scanner;

public class Zadatak4 {
    public static void main(String[] args) {
        //Godina je prestupna ako je deljiva sa 4 i vazi da nije deljiva sa 100 ili je deljiva sa 400.
        //Korisnik unosi dve godine strogo vece od 0. Ispisati broj godina koje su prestupne u zadatom intervalu ukljucujuci i te dve.

        Scanner sc = new Scanner(System.in);
        int year1 = sc.nextInt();
        int year2 = sc.nextInt();
        /*
         * Ako koristimo for petlju, nije nam potreban nikakav uslov
         * da li su ti brojevi u dobrom poretku, jer to for petlja radi sama.
         * Takodje ako ne navedem da eksplicitno trebaju provere korektnosti unosa
         * da se obradjuju, onda to znaci da netrebaju uslovi poput year1 > 0 i slicno,
         * pretpostavljamo da korisnik nece napravit takvu gresku
         * */

        int numLeapYears = 0;

        for (int i = year1; i <= year2 ; i++)
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0))
                numLeapYears++;

        System.out.println(numLeapYears);

    }
}
