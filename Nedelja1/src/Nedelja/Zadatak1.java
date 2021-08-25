import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) {
        //Na standardni ulaz se unose imena dva tima, a zatim i 6 celih pozitivnih brojeva koji oznacavaju broj osvojenih zlatnih,
        // srebrnih odnosno bronzanih medalja, tim redom. Prva 3 broja se odnose na prvi tim a druga tri broja na drugi tim.
        // Pobednicki tim je onaj koji ima vise osvojenih medalja, a u slucaju da oba tima imaju isto onda se gleda ko ima vise osvojenih zlatnih medalja.
        // Ako i tada nema pobednika onda se gledaju srebrne medalje i na kraju bronzane. Na standarni izlazi ispisati ime pobednickog tima,
        // a ako oba tima imaju potpuno iste medalje, ispisati nisku "Nereseno".

        System.out.println("Enter two teams, and 6 whole numbers from witch first 3 represent number of medals of a first team (in order: Gold, Silver, Bronze), and second 3 numbers represent number of medals of a second team (in order: Gold, Silver, Bronze).");
        Scanner sc = new Scanner(System.in);

        // Unosimo imena timova i njihove medalje
        String timA = sc.nextLine();
        String timB = sc.nextLine();
        int gA = sc.nextInt();
        int gB = sc.nextInt();
        int sA = sc.nextInt();
        int sB = sc.nextInt();
        int bA = sc.nextInt();
        int bB = sc.nextInt();

        // Proveravamo da li jedan tim ima vise medalja od drugog
        int sumA = gA + sA + bA;
        int sumB = gB + sB + bB;
        if (sumA > sumB)
            System.out.println(timA);
        else if (sumB > sumA)
            System.out.println(timB);
            // Ako ova dva uslova nisu ispunjena, onda imaju isti broj medalja
            // Dakle dalje proveravamo broj pojedinacnih medalja redom
        else if (gA > gB)
            System.out.println(timA);
        else if (gB > gA)
            System.out.println(timB);
        else if (sA > sB)
            System.out.println(timA);
        else if (sB > sA)
            System.out.println(timB);
        else if (bA > bB)
            System.out.println(timA);
        else if (bB > bA)
            System.out.println(timB);
            // Ako nista od ovoga ne prodje, to znaci da su potpuno isti
        else
            System.out.println("Nereseno");


    }
}
