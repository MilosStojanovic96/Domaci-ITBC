package Nedelja;

public class GrassPokemon extends Pokemon {

    public GrassPokemon(String name, int health) {
        super(name, health);
    }

    @Override
    public String logAll() {
        String rez = "";
        rez = "Napada: " + attack() + "\n"
                + "Brani se: " + defend() + "\n"
                + "Pobedjuje: " + wins() + "\n"
                + "Gubi od: " + loses() + "\n";
        return rez;
    }

    @Override
    public String attack() {
        return "Travom";
    }

    @Override
    public String defend() {
        return "Izbegava";
    }

    @Override
    public String wins() {
        return "Water type";
    }

    @Override
    public String loses() {
        return "Fire type";
    }
}
