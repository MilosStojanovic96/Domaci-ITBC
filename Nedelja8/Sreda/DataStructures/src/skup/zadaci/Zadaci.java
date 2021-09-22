package skup.zadaci;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;

import java.util.ArrayList;
import java.util.TreeSet;

public class Zadaci {


    /*
    * 1. Zajednicki elementi
    * Za dva zadata niza bojeva vratiti niz onih brojeva koji se nalaze i u jednom i u drugom nizu.
    *
    * NPR:
    * [1, 2, 3, 4, 5], [2, 4, 6, 8, 10] -> [2, 4]
    * */

    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b){
        if(a == null || b == null)
            return null;
        TreeSet<Integer> skup = new TreeSet<>(a);
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : b){
            if(skup.contains(i)){
                res.add(i);
            }
        }
        if(res.isEmpty())
            return null;
        return res;
    }

    /*
    * 2. Svi elementi
    * Za dva zadata niza brojeva vratiti niz svih brojeva iz oba niza bez ponavljanja.
    * */

    public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b) {
        // a.addAll(b);
        //        TreeSet<Integer> set = new TreeSet<>(a);
        //        ArrayList<Integer> res = new ArrayList<>();
        //        res.addAll(set);
        //        return res;
        // --> moze i ovako

        if (a == null && b == null) {
            return null;
        }
        if (a == null)
            return b;
        if (b == null)
            return a;
       a.addAll(b);
       TreeSet<Integer> set = new TreeSet<>(a);
       ArrayList<Integer> res = new ArrayList<>();
       for (Integer i : set){
           res.add(i);
       }

        return res;
    }


    /*
    * 3. Razlika
    * Za dva zadata niza brojeva vratiti niz onih brojeva koji se nalaze u prvom
    * ali ne i u drugom nizu, bez ponavljanja.
    * */

    public static ArrayList<Integer> razlika(ArrayList<Integer> a, ArrayList<Integer> b) {

        if (a == null && b == null) {
            return null;
        }
        if (a == null)
            return b;
        if (b == null)
            return a;
        a.removeAll(b);
        TreeSet<Integer> set = new TreeSet<>(a);
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : set){
            res.add(i);
        }

        return res;
    }

    /*
     * 4. Napisati funkciju koja broji koliko ima duplikata u zadatom nizu.
     *
     * [1, 2, 3, 4, 4, 2, 3, 5, 6] -> 3
     * [1, 2, 3] -> 0
     * [5, 5, 5, 5, 5, 6] -> 4
     * */

    public static int ponavljanjeBroj(int[] arr){
        TreeSet<Integer> skup = new TreeSet<>();
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            skup.add(arr[i]);
            }
        return arr.length - skup.size();
        //razlika u velicina skupa i lsite je broj duplikata jer skup odmah izbaci sve duplikate
    }

    /*
     * 5. Provera permutacije
     * Za dva zadata niza brojeva proveriti da li moze da se jedan dobije od drugog.
     * Brojevi u nizu se ne ponavljaju
     *
     * NPR:
     * [1, 2, 221, 101], [101, 2, 221, 1] -> da
     * [1, 2, 3], [3, 1, 2, 4] -> ne
     * */

    public static boolean permutacija(ArrayList<Integer> p1, ArrayList<Integer> p2){
        TreeSet<Integer> skup = new TreeSet<>(p1);
        TreeSet<Integer> skup2 = new TreeSet<>(p2);
        // skup1 = [1, 2, 3],   skup2 = [1, 2]
        // return skup.equals(skup2); -> moze i ovako, samo pazi kao kad smo radili sa nasim objektima pa smo menjali equals
        return (skup.size() == skup2.size() && skup.containsAll(skup2));  // -> vraca true ako su ispunjeni uslovi
        // if(skup.size() == skup2.size() && skup.containsAll(skup2)){
        //   return true;
        // } else {
        // return false;
        // }

    }


    /*
    * 6. Neuparen element
    * Funkciji se prosledjuje niz ciji se svi elementi ponavljaju tacno dva puta,
    * osim jednog koji se ponavlja samo jednom.
    * Vratiti taj element
    *
    * Npr:
    * [1, 1, 2, 3, 3, 4, 4] -> 2
    * */

    public static int neuparen(int[] arr){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr){
            if(!set.add(i))   // -> add vraca boolean zato moze negacija
                set.remove(i);
        }
       // return set.first();  -> moze i ovako
        int x = 0;  // -> inicijalizovan jer pre toga program ga zacrveneo
        for (Integer s : set)
            x = s;
        return x;
    }


    /*
    * 7. Anagram
    * Funkcija prima 2 String i daje odgovor da/ne u odnosu na to da li je
    * jedan String anagram drugog.
    *
    * NPR:
    * "panta redovno zakasni"
    * "neopravdan izostanak"
    * Da
    * */

    public static boolean anagram(String s1, String s2){
        boolean same = true;
        s1 = s1.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\s", "");
        if (s1.length() != s2.length())
            same = false;

        TreeSet<Character> set = new TreeSet<>();
        TreeSet<Character> set2 = new TreeSet<>();

        for (char s3 : s1.toCharArray()) {
            set.add(s3);
        }
        for (char s4 : s2.toCharArray()) {
            set2.add(s4);
        }
        if (set == set2)
            same = true;



        return same;
    }


}
