package Sreda;

public class Circle extends Shape {
    private double r;

    public Circle(String name, double r) {
        super(name);
        this.r = r;
    }

    @Override
    public double circumference() {
        double O = 2 * r * Math.PI;
        return O;
    }

    @Override
    public double area() {
        double P = (r * r) * Math.PI;
        return P;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
