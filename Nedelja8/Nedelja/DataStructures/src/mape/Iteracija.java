package mape;

import java.util.Map;
import java.util.TreeMap;

public class Iteracija {

    public static void main(String[] args) {
        TreeMap<String, Integer> mapa = new TreeMap<>();
        mapa.put("b", 1);
        mapa.put("a", 0);
        mapa.put("c", 2);
        mapa.put("d", 3);
        /*String[] kljucevi;
        int[] vrednosti;
        for (int i = 0; i < kljucevi.length; i++) {
            mapa.put(kljucevi[i], vrednosti[i]);
        }*/

        //I nacin : kroz kljuceve
        for(String s : mapa.keySet()){
            System.out.println(s);
        }
        System.out.println("-----");

        //II nacin: kroz vrednosti
        for(Integer i : mapa.values()){
            System.out.println(i);
        }
        System.out.println("----------");

        //III nacin: kroz celu mapu //for [i, n)
        //foreach za svaki ... tipa ... prodji kroz celu listu (neceg slicno)
        for(Map.Entry<String, Integer> e : mapa.entrySet()){ //map.size() = broj 31
            // {, ("b", 1) ...}
            // ("a", 0) e.getValue() = 0
            System.out.println(e);
        }
    }
}
