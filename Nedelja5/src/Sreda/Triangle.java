package Sreda;

public class Triangle extends  Shape{
    private double a, b, c;

    public Triangle(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double circumference() {
        double O = a + b + c;
        return O;
    }

    @Override
    public double area() {
        double s = (a + b + c) /2;
        double P = Math.sqrt(s *(s - a)* (s - b) * (s - c));
        return P;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
