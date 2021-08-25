public class Test {

    public static void main(String[] args) {
        String[] kate1 = new String[]{"Ichi", "Ni", "San", "Shi"};
        String[] kate2 = new String[]{"I", "Fu", "Mi",};

        Karatista k1 = new Karatista("Strahinja", 23, "1Dan", kate1);
        Karatista k2 = new Karatista("Kyoufune", 10, "3Kyu", kate2);
        Karatista f1 = new Karatista("Fail1", -1, "5Kyu", kate1);
        Karatista f2 = new Karatista("Fail2", 15, "11Kyu", kate1);
        Karatista f3 = new Karatista("Fail3", 15, "11Dan", kate1);
        Karatista f4 = new Karatista("Fail4", 15, "5Kyu", new String[0]);

        System.out.println("-------------");
        k1.napadni(0);
        k1.vatreniNapad();
        k1.log();
        System.out.println("-------------");
        k2.napadni(0);
        k2.vatreniNapad();
        k2.log();
        System.out.println("-------------");
        f1.napadni(0);
        f1.vatreniNapad();
        f1.log();
        System.out.println("-------------");
        f2.napadni(0);
        f2.vatreniNapad();
        f2.log();
        System.out.println("-------------");
        f3.napadni(0);
        f3.vatreniNapad();
        f3.log();
        f4.napadni(0);
        f4.vatreniNapad();
        f4.log();
        System.out.println("-------------");

    }
}
