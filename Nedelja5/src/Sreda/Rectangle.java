package Sreda;

public class Rectangle extends Shape {
    private double a, b;

    public Rectangle(String name, double a, double b) {
        super(name);

        if (a > 0) {
            this.a = a;
        } else {
            this.a = 10;
            System.out.println("Postavljena podrazumevana vrednost: 10 (jer ste uneli ne pozitivnu");
        }

       if (b > 0) {
           this.b = b;
       } else {
           this.b = 10;
           System.out.println("Postavljena podrazumevana vrednost: 10 (jer ste uneli ne pozitivnu");
       }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
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
