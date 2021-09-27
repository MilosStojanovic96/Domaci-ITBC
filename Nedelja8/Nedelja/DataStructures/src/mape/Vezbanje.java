package mape;

import java.util.*;

public class Vezbanje {

    /*
    * 1. Najbolji ucenik
    * Na standardnom ulazu se unose parovi ime - bodovi, koji oznacavaju koliko je neki ucenik
    * imao bodova na testu. Ispisati na standardni izlazi ime osobe koja je najbolje uradila test,
    * ako se zna da nikoje dve osobe nemaju isti broj bodova.
    * */
    public static void najboljiUcenik(Scanner sc){
        HashMap<String, Integer> bodovi = new HashMap<>();
        while(sc.hasNext()){
            String ime = sc.next();
            int b = sc.nextInt();
            bodovi.put(ime, b);
        }

        int max = 0;
        String ime = "";
        for(String s : bodovi.keySet()){
            if (bodovi.get(s) > max){
                max = bodovi.get(s);
                ime = s;
            }
        }
        System.out.println(ime);
    }

    /*
    * 2. Duplikati***
    * Za zadati niz brojeva, ispisati sve duplikate niza.
    * [1, 2, 3, 4, 4, 2, 3, 5, 6] -> 2 3 4
    * mapa: [{1, 1}, {2, 2}, {3, 2}, {4, 2}, {5, 1}, {6, 1}]
    * */

    public static void duplikati(int[] arr){
        HashMap<Integer, Integer> brojPonavljanja = new HashMap<>();
        //Upis u mapu
        for (int i = 0; i < arr.length; i++) {
            int trenutni = arr[i];
            if (brojPonavljanja.containsKey(trenutni)){
                //uvecati njegov broj ponavlja
                brojPonavljanja.put(trenutni, brojPonavljanja.get(trenutni) + 1); //arr[i] = arr[i]+1;
            }
            else{
                brojPonavljanja.put(trenutni, 1);
            }
        }
        //System.out.println(brojPonavljanja);
        //Ispis iz mape
        for(Map.Entry<Integer, Integer> e : brojPonavljanja.entrySet()) {
            if (e.getValue() > 1){
                System.out.print(e.getKey() + " ");
            }
        }
        System.out.println();
    }

    /*
    * 3. Broj ponavljanja
    * Za svaki broj iz niza, ispisati koliko puta se ponavlja u nizu
    * [1, 2, 3, 4, 4, 2, 3, 5, 6] ->
    * 1 - 1
    * 2 - 2
    * 3 - 2
    * 4 - 2
    * 5 - 1
    * 6 - 1
    * */

    public static void ponavljanje(int[] arr){
        HashMap<Integer, Integer> brojPonavljanja = new HashMap<>();
        //Upis u mapu
        for (int i = 0; i < arr.length; i++) {
            int trenutni = arr[i];
            if (brojPonavljanja.containsKey(trenutni)){
                //uvecati njegov broj ponavlja
                brojPonavljanja.put(trenutni, brojPonavljanja.get(trenutni) + 1); //arr[i] = arr[i]+1;
            }
            else{
                brojPonavljanja.put(trenutni, 1);
            }
        }
        //System.out.println(brojPonavljanja);
        //Ispis iz mape
        for(Map.Entry<Integer, Integer> e : brojPonavljanja.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        System.out.println();
    }

    /*
    * 4. Najveci duplikat
    * Ispisati koji broj se najvise puta ponavlja u nizu, ako znamo
    * da je takav broj jedinstven i pozitivan.
    * [1, 1, 1, 2, 2, 2, 2, 3, 3, 4] -> 2
    * */

    public static void najveciDuplikat(int[] arr){
        /*
        * 1. Napravimo mapu ponavljanja {broj, broj_ponavljanja}
        * 2. Nadjemo maximum vrednosti (values)
        * 3. Ispisem njegov key.
        * */
        HashMap<Integer, Integer> mapa = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (mapa.containsKey(arr[i])){
                mapa.put(arr[i], mapa.get(arr[i]) + 1);
            }
            else{
                mapa.put(arr[i], 1);
            }
        }

        int max = 0;
        int broj = -1;
        for(Map.Entry<Integer, Integer> e : mapa.entrySet()){
            if (e.getValue() > max){
                max = e.getValue();
                broj = e.getKey();
            }
        }
        System.out.println(broj);
    }

    /*
    * 5. Najveci duplikatI
    * Ispisati sve brojeve koji se najvise puta ponavljaju u nizu.
    * [1, 1, 1, 2, 2, 2, 2, 3, 3, 4] -> 2
    * [1, 1, 2, 1, 3, 3, 4, 3, 5, 2, 5, 5] -> 1, 3, 5
    * */

    public static void najveciDuplikatI(int[] arr){
        /*
        * Strategija:
        * 1. Napravimo mapu ponavljanja {broj, broj_ponavljanja}
        * 2. Nadjemo maximum vrednosti (values)
        * 3. Svi oni koji se ponavljaju maximum broj puta, ispisati
        * */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        int max = 0;
        for(Integer value : map.values()){
            if (max < value)
                max = value;
        }
        for(Integer key : map.keySet()){
            if (map.get(key) == max)
                System.out.print(key + " ");
        }
        System.out.println();
    }

    /*
    * 6. Najvisa osoba
    * Za zadat niz osoba, pronaci najvisu osobu
    * */

    public static void najvisaOsoba(ArrayList<Osoba> list){
        HashMap<Osoba, Double> visine = new HashMap<>();
        //Popunjavamo mapu
        for(Osoba o : list){
            visine.put(o, o.getHeight());
        }
        //Trazimo najvisu osobu
        Osoba najvisa = list.get(0);
        for(Osoba o : visine.keySet()){
            if (o.getHeight() > najvisa.getHeight()){
                najvisa = new Osoba(o.getIme(), o.getPrezime(), o.getHeight());
            }
        }
        System.out.println(najvisa);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //najboljiUcenik(sc);
        int[] test = new int[]{1, 2, 3, 4, 4, 2, 3, 5, 6};
        //duplikati(test);
        //ponavljanje(test);
        int[] test2 = new int[]{1, 1, 1, 2, 2, 1, 2, 2, 3, 3, 4};
        //najveciDuplikat(test2);
       // najveciDuplikatI(test2);
        ArrayList<Osoba> osobe = new ArrayList<>(Arrays.asList(
                new Osoba("a", "a", 100.4),
                new Osoba("b", "b", 84.5),
                new Osoba("c", "c", 81.5)
        ));
        najvisaOsoba(osobe);
    }
}
