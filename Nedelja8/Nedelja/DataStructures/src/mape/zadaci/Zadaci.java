package mape.zadaci;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Zadaci {

    /*
    * 1. Najmanje ponavljanje
    *
    * Za zadati niz brojeva, ispisati onaj broj koji se najmanje puta ponavlja,
    * ako je unapred poznato da je takav broj jedinstven
    * */

    // [1, 2, 1, 3, 3, 3, 4, 1, 2, 3, 5, 4] -> 5 (1)
    // >  -> <
    public static int najmanjePonavljanje(int[] arr){
        /*
        * Strategija:
        * 1. Napravimo mapu ponavljanja: {broj} -> {broj_ponavljanja}
        * 2. Trazimo broj sa najmanjim ponavljanjem
        * */

        HashMap<Integer, Integer> mapa = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            if (mapa.containsKey(t)){
                //t je u mapi
                mapa.put(t, mapa.get(t) + 1);
            }
            else{
                //t nije u mapi
                mapa.put(t, 1);
            }
        }

        /*int min = Integer.MAX_VALUE;
        int ret = Integer.MAX_VALUE;*/
        int min = 0;
        int ret = 0;
        boolean isFirst = true;
        for(Map.Entry<Integer, Integer> e : mapa.entrySet()){
            if (isFirst || min > e.getValue()){
                min = e.getValue();
                ret = e.getKey();
                isFirst = false;
            }
        }
        return ret;
    }


    /*
    * 2. Najopasnija posada
    *
    * Svetska vlada je izdala poternice za poznate pirate u fiktivnoj valuti 'Belly'.
    * Za prosledjen spisak pirata, formata:
    * "{Ime}, {Posada}, {nagrada_u_Belly-ima}", vratiti ime Posade koja u zbiru ima najvecu poternicu
    *
    * NPR:
    * "Roronoa Zoro, Strawhat, 320000"
    * "Trafalgar D. Water Law, Heart, 500000"
    * "Nami, Strawhat, 66000",
    * "Brook, Strawhat, 84000",
    * "Bepo, Heart, 500"
    *
    * Resenje: "Heart"
    * */

    public static String wanted(ArrayList<String> posters){
        /*
        * Primecujemo:
        * - Ime nije bitno
        * */

        /*
        * Strategija:
        * - Za svaki string splitovati po ','; trimovati ga i gledati 1. i 2. clan niza
        * 1. Pravimo mapu
        *   - nova posada ima poternicu 0
        *   - kako pronalazimo nove clanove posade to povecavamo poternicu za datu posadu
        * 2. Nazalicmo maximum mape
        * */

        HashMap<String, Integer> mapa = new HashMap<>();

        for(String s : posters){
            String[] token = s.split(",");
            String posada = token[1].trim();
            int novac = Integer.parseInt(token[2].trim());
            if (mapa.containsKey(posada)){
                mapa.put(posada, mapa.get(posada) + novac);
            }
            else{
                mapa.put(posada, novac);
            }
        }

        int max = Integer.MIN_VALUE;
        String res = "";
        for(Map.Entry<String, Integer> e : mapa.entrySet()){
            if (max < e.getValue()){
                max = e.getValue();
                res = e.getKey();
            }
        }
        return res;
    }

    /*
    * 3. Molekularna formula
    *
    * Hemijske formule molekula nam daju odlican opis toga koliko kojih atoma ima u molekulu,
    * kao i na koji nacin su oni povezani, dok nam molekularna formula daje samo opis broja atoma koji
    * ucestvuju u gradjenju datog molekula. Vas zadatak je da datu hemijsku formulu pretvorite u njenu molekularnu.
    * (Gde su elementi poredjanji po leksikografskom poretku)
    *
    * NPR:
    * H2S04 -> H2O4S1
    * X2(S04)3 -> O12S3X2
    * */

    public static String molekul(String hemija){
        /*
         * Strategija:
         * Sa levo na desno
         * Kada naidjes na Element gledaj desno od njega:
         * |- Ako stek nije prazan, dodaj na stack taj simbol
         * | ako desno nema nista -> uvecaj ga za 1
         * | ako je desno od njega slovo -> uvecaj ga za 1
         * | ako je desno od njega broj -> uvecaj ga za broj
         * Kada naidjes na Broj zanemari ga
         * Kada naidjes na otvorenu zagradu stavi je na stack
         * Kada naidjes na zatvorenu zagrad:
         * |- Ako je desno od nje nista, stavi da je broj 1
         * |- AKo je desno od nje Element, stavi da je broj 1
         * |- AKo je desno od nje Broj, stavi da je broj Broj
         * | Popujemo sa steka redom:
         * || Ako je ) -> break
         * || Ako je broj -> zanemari
         * || Ako je Element -> *= sa brojem
         * TreeMap -> String
         * */
        TreeMap<String, Integer> mapa = new TreeMap<>();
        char[] chars = hemija.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (Character.isAlphabetic(current)){
                //Slovo
                if (!stack.isEmpty())
                    stack.push(current+"");
                if ((i+1) < chars.length){
                    //Gledaj desno
                    if (Character.isDigit(chars[i+1])){
                        //Uvecaj za broj
                        if (mapa.containsKey(current+"")){
                            mapa.put(current+"", mapa.get(current+"") + Character.getNumericValue(chars[i+1]));
                        }
                        else{
                            mapa.put(current+"", Character.getNumericValue(chars[i+1]));
                        }
                    }
                    else{
                        //Uvzecaj za 1
                        if (mapa.containsKey(current+"")){
                            mapa.put(current+"", mapa.get(current+"") + 1);
                        }
                        else{
                            mapa.put(current+"", 1);
                        }
                    }
                }
                else{
                    //Desno nema nista, uvecaj za 1
                    if (mapa.containsKey(current+"")){
                        mapa.put(current+"", mapa.get(current+"") + 1);
                    }
                    else{
                        mapa.put(current+"", 1);
                    }
                }
            }
            else if(current == '('){
                //(
                stack.push("(");
            }
            else if(Character.isDigit(current)){}
            else{
                //)
                //C((OH)2S)4 za domaci
                int x = 1;
                if ((i+1) < chars.length && Character.isDigit(chars[i+1])){
                    x = Character.getNumericValue(chars[i+1]);
                }
                while (!stack.isEmpty()){
                    String top = stack.pop();
                    if (top.equals("("))
                        break;
                    else if (Character.isDigit(top.charAt(0))){}
                    else{
                        //Hemijski element *=
                        if (mapa.containsKey(top)){
                            mapa.put(top, mapa.get(top) * x);
                        }
                        else{
                            mapa.put(top, x);
                        }
                    }
                }
            }
        }
        //System.out.println(mapa);
        String res = "";
        for(Map.Entry<String, Integer> e : mapa.entrySet()){
            res += e.getKey();
            res += String.valueOf(e.getValue());
        }
        return res;
    }

    /*
    * 4. Frekvencija znaka
    *
    * Za prosledjenu String, vratiti koji karakter se ponavlja najvise puta
    * */

    // "Neki string" -> {n, i}

    public static Set<Character> frekvencija(String s){
        /*
        * Strategija:
        * 1. Pretvori string u niz karaktera
        * 2. Napravi mapu pojavljivanja karaktera iz stringa
        * 3. Naci sve koji se ponavljaju max broj puta
        * */

        //1.
        s = s.toLowerCase();
        char[] chars = s.toCharArray();

        //2.
        HashMap<Character, Integer> mapa = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char t = chars[i];
            if (mapa.containsKey(t)){
                mapa.put(t, mapa.get(t) + 1);
            }
            else{
                mapa.put(t, 1);
            }
        }

        //3.
        //a) naci max value
        int max = Integer.MIN_VALUE;
        for(Integer i : mapa.values()){
            if (max < i)
                max = i;
        }

        //b) u set ubaci sve one kljuceve kojima je vrednost = max
        HashSet<Character> res = new HashSet<>();
        for(Character c : mapa.keySet()){
            if (mapa.get(c) == max)
                res.add(c);
        }
        return res;
    }




    /*
    * 5. Proizvodi
    * Noja apisati program koji vraca listu svih proizvoda kprodavnica treba da naruci za sutradan,
    * ako je poznato da je svaka prodavnica zakonom duzna da prilikom otvaranja u maloprodaji sadrzi
    * barem 5 stvari svake stavke.
    *
    * Npr:
    * {
    * "Sapun" -> 4
    * "Torta" -> 10
    * "Hleb" -> 0
    * "Supa" -> 7
    * "Papir" -> 17
    * "Koka kola" -> 3
    * }
    * Resenje: ["Sapun", "Helb", "Koka kola"]
    * */

    public static ArrayList<String> nabavka(TreeMap<String, Integer> proizvodi){
        /*
        * Strategija:
        * 1. Proci kroz celu mapu
        * 2. Ako je vrednost kljuca manja ili jednaka od 4, u array listu ubaciti taj kljuc
        * */
        ArrayList<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> e : proizvodi.entrySet()){
            if (e.getValue() <= 4)
                res.add(e.getKey());
        }
        return res;
    }




    /*
    * 6. Deljivost
    * Za proslednjen broj n, vratiti look-up table, koji govori da li je broj i prost ili ne
    * (2 <= i <= n)
    *
    * NPR:
    * n = 10
    * {
    * 2 -> true
    * 3 -> true
    * 4 -> false
    * 5 -> true
    * 6 -> false
    * 7 -> true
    * 8 -> false
    * 9 -> false
    * 10 -> false
    * }
    * */

    /*

    * */

    private static boolean isPrime(int k){
        for (int i = 2; i <= Math.sqrt(k) + 1; i++) {
            if (k % i == 0)
                return false;
        }
        return true;
    }

    public static HashMap<Integer, Boolean> lookUp(int n){
        /*
        * 1. Prodjemo from od 2 do n
        * 2. Za svaki broj i proveri da li je prost
        * 3. Resenje ubaciti u mapu
        * 4. Vratiti map
        * */
        HashMap<Integer, Boolean> mapa = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            mapa.put(i, isPrime(i));
        }
        return mapa;
    }


    private static HashMap<Integer, Boolean> primeLookUp = new HashMap<>();
    // [{2, true}, {3, true}, {4, false}, {5, true} ... {11, true}]

    private static boolean isPrime2(int k){
        for(Integer e : primeLookUp.keySet()){
            if (primeLookUp.get(e) && k % e == 0)
                return false;
        }
        return true;
    }

    public static void makeLookUp(int n){
        for (int i = primeLookUp.size() + 1; i <= n; i++) {
            primeLookUp.put(i, isPrime2(i));
        }
    }


    /*
    * 7. Fibonacijev niz
    * Fibonacijev niz je onaj niz koji pocinje sa 0, 1, a svaki sledeci broj je dobijen kao zbir prethodna dva.
    * Formalnije, Fibonacijev niz je zadat rekurentno kao:
    * | fib(0) = 0
    * | fib(1) = 1
    * | fib(n) = fib(n-1) + fib(n-2), za n >= 2;
    * Za proslednjen broj n, naci n-ti Fibonacijev broj.
    * */


    // 0 1 1 2 3 5 8 13 21 ...
    public static int fib(int n){
        /*
        * Strategija:
        * 1. Napravimo staticku mapu
        * 2. Ako je duzina > n --> mozemo odmah da nadjemo n
        * 3. Ako nije onda upisujemo redom do n
        * */
        return 0;
    }

    /*
    * 8. Sortiranje
    * Sortirati ucenike po broju osvojenih poena na testu, opadajuce
    * */

    public static ArrayList<String> sortiranje(HashMap<String, Integer> bodovi){
        /*
        * - trazimo max mape + dodati u listu + brisemo
        * */
        /*
        * Strategija:
        * 1. Naci najveci element, dodati ga u listu i izbaciti iz mape
        * 2. Ponovoti 1. sve dok mapa ne bude prazna
        * */
        ArrayList<String> res = new ArrayList<>();
        while(!bodovi.isEmpty()){
            //trazimo max
            int max = Integer.MIN_VALUE;
            String s = "";
            for(Map.Entry<String, Integer> e : bodovi.entrySet()){
                if (e.getValue() > max){
                    max = e.getValue();
                    s = e.getKey();
                }
            }
            res.add(s);
            bodovi.remove(s);
        }
        return res;
    }

    /*
     * 9. Za proslednjen niz borjeva, izbaciti sve duplikate i
     * ispisati sve brojeve u opadajucem poretku
     * */

    public static void zad9(int[] arr){
        /*
        * Stragija:
        * 1. Ubaciti u TreeSet
        * 2. Koristimo stack [1, 2, 3, 4, 5]
        * 3. Popujemo stack u listu [5, 4, 3, 2, 1]
        * */
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for(Integer i : set){
            stack.push(i);
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        /* 4. zadatak
        String test = "Neki string";
        Set<Character> skupResenja = frekvencija(test);
        for(Character c : skupResenja){
            System.out.println(c);
        }*/

        /* 5. zadatak
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Sapun", 4); map.put("Torta", 10); map.put("Helb", 0);
        map.put("Papir", 17); map.put("Supa", 7); map.put("Koka kola", 3);
        ArrayList<String> res = nabavka(map);
        System.out.println(res);*/

        /* 8. zadatak
        *
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 10); map.put("b", 20); map.put("c", 20); map.put("d", 15);
        System.out.println(sortiranje(map));*/

        /*
        * 9.zadatak
        * */
        zad9(new int[]{1, 1, 4, 5, 6, 2, 3, 4, 1});
    }










}
