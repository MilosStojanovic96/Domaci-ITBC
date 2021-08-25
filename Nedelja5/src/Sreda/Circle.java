package Sreda;

public class Circle extends Shape {
    private double r;

    public Circle(String name, double r) {
        super(name);
        if (r > 0) {
            this.r = r;
        } else {
            this.r = 10;
            System.out.println("Postavljena podrazumevana vrednost: 10 (jer ste uneli ne pozitivnu");
        }

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
