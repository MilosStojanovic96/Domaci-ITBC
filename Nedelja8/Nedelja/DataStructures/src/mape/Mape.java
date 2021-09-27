package mape;

import java.util.ArrayList;
import java.util.HashMap;

public class Mape {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        /*
        * imena -> duzuzinu imena
        * "Strahinja" -> 9 = string.size()
        * */

        /*
        * Izgleda mape:
        * [
        *  {"Strahinja", 5},
        *  {"Aleksandar", 10},
        *  {"Maja", 4},
        *  {"Sara", 4},
        * ]
        * */

        map.put("Strahinja", 9);
        map.put("Aleksandar", 10);
        map.put("Maja", 4);
        map.put("Sara", 4);
        System.out.println(map);

        map.put("Strahinja", 5);
        System.out.println(map);

        //update = put


        int x = map.get("Aleksandar");
        System.out.println(x);

        System.out.println(map.containsKey("ksjdskjd")); // map.containsValue()

        map.remove("Sara");
        System.out.println(map);

        //map.isEmpty()
        //map.size();

        // map.values(); <- Kolekciju svih vrednosti
        ArrayList<Integer> ar = new ArrayList<>(map.values());


    }
}
