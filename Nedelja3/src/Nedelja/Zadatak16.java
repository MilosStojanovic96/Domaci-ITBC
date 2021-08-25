package Nedelja;

import java.util.ArrayList;

public class Zadatak16 {
    //Napisati funkciju koja prima ArrayList-u double-a i vraca ArrayList-u
    // ciji su elementi za 2 veci od dupliranih elemenata iz prosledjene liste.

    public static ArrayList<Double> doubleElementsBiggerBy2(ArrayList<Double> arr) {
        ArrayList<Double> y = new ArrayList<Double>(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            y.add((arr.get(i) * 2) + 2);
        }

        return y;
    }

    public static void main(String[] args) {
        ArrayList<Double> arr = new ArrayList<>();
        arr.add(7.0);
        arr.add(5.0);
        arr.add(4.0);
        arr.add(5.1);
        System.out.println(doubleElementsBiggerBy2(arr));


    }
}
