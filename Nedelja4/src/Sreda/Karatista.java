
public class Karatista {
    private String ime;
    private int godine;
    private String rang;
    private String[] kata;

    public Karatista(String ime, int godine, String rang, String[] kata) {
        if (Character.isUpperCase(0)) {
            this.ime = ime;
        } else {
            this.ime = "Pogresno ste uneli ime";
        }

        if (godine <= 0) {
            this.godine = 18;
            System.out.println("Postavljena podrazumevana vrednost (jer ste uneli ne pozitivnu");
        } else {
            this.godine = godine;
        }

        if ((Character.isDigit(0) && Character.isUpperCase(1) && Character.isLowerCase(2) && Character.isLowerCase(3)) || (Character.isDigit(0) &&  Character.isDigit(1) && Character.isUpperCase(2) && Character.isLowerCase(3) && Character.isLowerCase(4))) {
            this.rang = rang;
        } else {
            System.out.println("Uneli ste pogresan rang.");
        }

        this.kata = kata;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        if (Character.isUpperCase(0)) {
            this.ime = ime;
        } else {
            this.ime = "Nije promenjeno pogresno uneseno ime";
        }
    }
    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        if (godine <= 0) {
            System.out.println("Nije promeljena vrednost");
            return;
        }
        this.godine = godine;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        if ((Character.isDigit(0) && Character.isUpperCase(1) && Character.isLowerCase(2) && Character.isLowerCase(3)) || (Character.isDigit(0) &&  Character.isDigit(1) && Character.isUpperCase(2) && Character.isLowerCase(3) && Character.isLowerCase(4))) {
            this.rang = rang;
        } else {
            System.out.println("Niste promenili unos ranga, idalje nije validan.");
        }
    }
    public String[] getKata() {
        return kata;
    }

    public void setKata(String[] kata) {
     this.kata = kata;
    }

    public void napadni(int index) {
        System.out.println("Karatista " + ime + " napada sa " + kata[index] + " katom.");
    }
    public void vatreniNapad() {
        double nasumicniIndeks = Math.floor(Math.random() * kata.length - 1);
        String nasumicnaKata = kata[(int) nasumicniIndeks];
        System.out.println("Karatista " + ime + " napada sa " + nasumicnaKata + " katom.");
    }

    public void log() {
        String znaKate = "";
        for (int i = 0; i < kata.length; i++) {
            znaKate = znaKate + ", " + i;
        }
        System.out.println("Karatista: " + ime + ", " + godine + ", " + rang + " zna naredne kate " + znaKate);
    }

}
