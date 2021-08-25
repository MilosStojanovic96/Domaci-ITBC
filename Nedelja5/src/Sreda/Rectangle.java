package Sreda;

public class Rectangle extends  Shape{
    private  double a, b;

    public Rectangle(String name, double a, double b) {
        super(name);
        this.a = a;
        this.b = b;
    }

    @Override
    public double circumference() {
        double O = (2 * a) + (2 * b);
        return O;
    }

    @Override
    public double area() {
        double P = a * b;
        return P;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
