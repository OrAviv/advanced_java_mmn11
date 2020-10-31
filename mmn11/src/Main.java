public class Main {

    public static void main(String[] args)
    {
        Rational r1 = new Rational(15,-15);
        Rational r2 = new Rational(10, 15);
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println("greaterThan: "+r1.greaterThan(r2));
        System.out.println("equals: "+r1.equals(r2));
        Rational plus = r1.plus(r2);
        System.out.println("plus: "+plus.toString());
        Rational minus = r1.minus(r2);
        System.out.println("minus: "+minus.toString());
        Rational multiply = r1.multiply(r2);
        System.out.println("multiply: "+multiply.toString());
        Rational reduce = r1.reduce();
        System.out.println("reduce: "+reduce.toString());
    }
}