import java.util.Scanner;

public class Zadatak3 {
    public static void main(String[] args) {
        //Korisnik unosi cene proizvoda koje je kupio sve dok se ne unese 0. Na standardni izlaz ispisati prosecnu cenu proizvoda.
        //Ukoliko korisnik unese negativnu vrednost za cenu proizvoda, onda taj unos treba zanemariti i nastaviti sa unosom.

        Scanner sc = new Scanner(System.in);

        /*
         * Ovde ne smemo tek tako da kazemo int x = sc.nextInt(), pa tek onda
         * da ulazimo u petlju jer to nece raditi ako odmah unesemo
         * negativan broj. Najjednostavniji nacin je prvo da udjemo u petlju
         * a onda da obradjujemo unos
         * */

        double cena = 1; // Cenu postavaljamo na proizvolju vrednost razlicitu od 0
        double sum = 0;
        int brProizvoda = 0;
        // Posto korisnik unosi sve dok ... to odmah znaci da koristimo while petlju
        while (cena != 0){
            cena = sc.nextDouble();
            /*
             * Sada na razne nacine mozemo da se pazimo negativnog unosa.
             * Ja cu da pokazem jedan koji nikome nije pao na pamet
             * */

            // Povecavamo brojac jer je korisnik uneo cenu
            brProizvoda++;
            // Proveravamo da li je broj negativan ili 0, tj <= 0
            if (cena <= 0){
                // Smanjujemo brojac
                brProizvoda--;
            }
            // Inace uvecavamo sumu
            else
                sum += cena;
        }

        // Nema potrebe da racunamo prosek posle svakog unosa, vec samo posle poslednjeg
        // Ali pazimo da nam brProizvoda nije 0, jer inace dobijamo gresku
        if (brProizvoda != 0) {
            double prosek = sum / brProizvoda;
            System.out.println(prosek);
        }
        else
            System.out.println("0");






    }
}
