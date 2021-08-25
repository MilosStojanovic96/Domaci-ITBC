import java.util.Scanner;

public class Zadatak2 {
    //    Napisati funkciju koja transformise cenzurisane ruzne reci natrag u originalni oblik i vraca taj oblik nazad.
//    Funkciji se prolsedjuje niska, niz niski u kome se nalaze kljucevi i niz niski u kome se nalaze desifrovane poruke, tako da kljuc[i] -> decode[i];
//    Npr:
//    String poruka = "Jedi #$%^ !@#$!!!@# mali!"
//    String[] kljuc = {"#$%^", "!@#$!!!@#"}
//    String[] decode = {"pite", "moroncinu"}
//    String res = "Jedi pite moroncinu mali!" <-- ovo treba vratiti
//    Ni jedan kljuc nije podstring drugog (osim samog sebe, naravno)

    public static String decode(String poruka, String[] kljuc, String[] decode) {
        String[] s = poruka.split(" ");
        String res = "";
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < kljuc.length; j++) {
                if (s[i].equals(kljuc[j]))
                    s[i] = decode[j];
            }
        }
        for (int i = 0; i < s.length; i++)
            res = res.concat(s[i]).concat(" ");
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String poruka = "Jedi #$%^ !@#$!!!@# mali!";
        String[] kljuc = {"#$%^", "!@#$!!!@#"};
        String[] decode = {"pite", "moroncinu"};

        System.out.println(decode(poruka, kljuc, decode));
    }

}
