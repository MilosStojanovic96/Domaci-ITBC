import java.util.Scanner;

public class Zadatak3 {
    //   3. Napisati funkciju koja za prosledjeni password proverava da li je validan, tj.:
//   Da li postoji barem jedno veliko slovo. (Hint: Hmm, sta je bese ono Strahinja pominjao da pogledamo osim, String i Integer klasa ?")
//   Je duzi od 8 karaktera.

    public static boolean passwordChecker (String s) {
        String [] help = new String[s.length()];
        char[] ch = s.toCharArray();
        for (int i = 0; i <ch.length; i++) {
            if (Character.isUpperCase(ch[i]) && help.length > 8) {
                return true;
            }
        } return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        System.out.println("Enter a password: ");
        String password = sc.nextLine();
        if (passwordChecker(password) == true) {
            System.out.println("Congrats you have entered a valid password!");
        }
    }

}
