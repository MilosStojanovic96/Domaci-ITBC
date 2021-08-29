package Nedelja;

public class WaterPokemon extends Pokemon {
    public WaterPokemon(String name, int health) {
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
        return "Vodom";
    }

    @Override
    public String defend() {
        return "Vodom";
    }

    @Override
    public String wins() {
        return "Fire type";
    }

    @Override
    public String loses() {
        return "Grass type";
    }
}
