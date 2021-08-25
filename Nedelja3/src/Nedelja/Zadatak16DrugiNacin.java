package Nedelja;

import java.util.ArrayList;

public class Zadatak16DrugiNacin {
    public static ArrayList<Double> novaLista(ArrayList<Double> arr) {
        ArrayList<Double> x = new ArrayList<>();
        for (Double el : arr) {
            x.add(el * 2 + 2);
        }
        return x;
    }

    public static void main(String[] args) {
        ArrayList<Double> y = new ArrayList<>();
        System.out.println(novaLista(y));
    }

}
