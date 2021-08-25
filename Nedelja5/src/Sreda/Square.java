package Sreda;

public class Square extends Rectangle {
    public Square(String name, double a, double b) {
        super(name, a, b);
    }

    @Override
    public double circumference() {
        double O = (2 * getA()) + (2 * getB());
        return O;
    }

    @Override
    public double area() {
        double P = getA() * getB();
        return P;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
