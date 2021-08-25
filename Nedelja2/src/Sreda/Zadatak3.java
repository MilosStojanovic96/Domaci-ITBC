import java.util.Scanner;

public class Zadatak3 {
    public static boolean netacno(boolean b) {
        if (b == false) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean broj(int i) {
        if (i > 49) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean decimala(int i, double d) {
        if (Math.floor(d) > (i * 2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean bid(boolean b, int i, double d) {
        if (netacno(b) && broj(i) && decimala(i, d)) {
            System.out.println("Boolean");
            System.out.println("Integer");
            System.out.println("Double");
            return true;
        } else if (netacno(b) && broj(i)) {
            System.out.println("Boolean");
            System.out.println("Integer");
            return true;
        } else if (netacno(b) && decimala(i, d)) {
            System.out.println("Boolean");
            System.out.println("Double");
            return true;
        } else if (broj(i) && decimala(i, d)) {
            System.out.println("Integer");
            System.out.println("Double");
            return true;
        } else if (netacno(b)) {
            System.out.println("Boolean");
            return true;
        } else if (broj(i)) {
            System.out.println("Integer");
            return true;
        } else if (decimala(i, d)) {
            System.out.println("Double");
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        double d = sc.nextDouble();
        boolean b = sc.nextBoolean();
        System.out.println(bid(b, i, d));


    }
}
