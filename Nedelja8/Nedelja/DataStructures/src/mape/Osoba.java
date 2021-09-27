package mape;

public class Osoba {
    private String ime;
    private String prezime;
    private double height;

    public Osoba(String ime, String prezime, double height) {
        this.ime = ime;
        this.prezime = prezime;
        this.height = height;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return this.ime + "\n" + this.prezime + "\n" + this.height;
    }
}
