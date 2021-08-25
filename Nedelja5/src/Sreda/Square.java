package Sreda;

public class Square extends Shape {
    private double a;

    public Square(String name, double a) {
        super(name);
        this.a = a;
    }

    @Override
    public double circumference() {
        double O = 4 * a;
        return O;
    }

    @Override
    public double area() {
        double P = a * a;
        return P;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
