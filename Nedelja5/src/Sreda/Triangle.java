package Sreda;

public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(String name, double a, double b, double c) {
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

        if ( c > 0) {
            this.c = c;
        } else {
            this.c = 10;
            System.out.println("Postavljena podrazumevana vrednost: 10 (jer ste uneli ne pozitivnu");
        }
    }

    @Override
    public double circumference() {
        double O = a + b + c;
        return O;
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2;
        double P = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return P;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
