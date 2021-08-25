package Sreda;

public class Square extends Rectangle {
    public Square(String name, double a, double b) {
        super(name, a, b);

    }

    @Override
    public double circumference() {
        if (getA() == getB()) {
            double O = (2 * getA()) + (2 * getB());
            return O;
        } else {
            System.out.println("Postavljena podrazumevana vrednost obima: 0. (Jer unete vrednosti za stranice kvadrata nisu jednake.) ");
            return 0;
        }
    }

    @Override
    public double area() {
        if (getA() == getB()) {
            double P = getA() * getB();
            return P;
        } else {
            System.out.println("Postavljena podrazumevana vrednost povrsine: 0. (Jer unete vrednosti za stranice kvadrata nisu jednake.) ");
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
