import java.util.ArrayList;
public class Posta {
    private ArrayList<Poruka> poruke;

    public Posta(ArrayList<Poruka> poruke) {
        this.poruke = poruke;
    }

    public Posta() {
        poruke = new ArrayList<>();
    }

    public Poruka get(int x) {
        return poruke.get(x);
    }

    public void add(Poruka p) {

        for (Poruka el : poruke) {
            if (el.getId() == p.getId()) {
                return;
            }
        }
        poruke.add(p);

    }

    public void remove(Poruka p) {
        for (Poruka el : poruke) {
            if (el.getId() == (p.getId())) {
                poruke.remove(p);
                return;
            }
        }
    }

    public void send(Poruka p) {
        for (Poruka el : poruke) {
            if (el.getId() == (p.getId())) {
                System.out.println(p);
                poruke.remove(p);
                return;
            }
        }
    }

    public void change(Poruka p, String msg) {
        for (Poruka el : poruke) {
            if (el.getPoruka().equals(p.getPoruka())) {
                p.setPoruka(msg);
                return;
            }
        }
    }

    public int isplata(Poruka p) {
        if (poruke.contains(p)) {
            return p.getSuma();
        }
        return 0;
    }

    @Override
    public String toString() {
        String rez = "";
        for (Poruka el : poruke) {
            if (el.getSuma() >= 0) {
                rez += el.getPosiljalac() + " salje " + el.getSuma() + " para " + el.getPrimalac() + "-u, uz poruku: " + "\n" + el.getPoruka() + "\n";

            }
            if (el.getSuma() < 0) {
                rez += el.getPosiljalac() + " primac " + el.getSuma() + " para od " + el.getPrimalac() + "-a, uz poruku: " + "\n" + el.getPoruka() + "\n";
            }
        }
        return rez;
    }

}
