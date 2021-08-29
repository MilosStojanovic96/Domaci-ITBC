package Sreda;

public class Square extends Rectangle {
    public Square(String name, double a, double b) {
        super(name, a, b);
    }

    @Override
    public double circumference() {
        if (getA() == getB()) {
            return super.circumference();
        } else {
            System.out.println("Unete vrednosti za stranice nisu jednake, izracunat je obim pravougaonika. Promenite ime oblika u pravougaonik (Rectangle).");
            return super.circumference();
        }
    }

    @Override
    public double area() {
        if (getA() == getB()) {
            return super.area();
        } else {
            System.out.println("Unete vrednosti za stranice nisu jednake, izracunata je povrsina pravougaonika. Promenite ime oblika u pravougaonik (Rectangle).");
            return super.area();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
