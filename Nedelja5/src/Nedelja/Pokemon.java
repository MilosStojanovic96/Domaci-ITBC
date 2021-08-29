package Nedelja;

public abstract class Pokemon implements Attackable {
    String name;
    String type;
    int health;

    public Pokemon(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract String logAll();
}
