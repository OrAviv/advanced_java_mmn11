import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! you are required to insert two rational numbers: ");
        System.out.println("First Number numerator: ");
        int first_num = scanner.nextInt();
        System.out.println("First Number denominator: ");
        int first_denom = scanner.nextInt();
        while (first_denom == 0)
        {
            System.out.println("Error! please insert non zero denominator");
            first_denom = scanner.nextInt();
        }

        System.out.println("Second Number numerator: ");
        int second_num = scanner.nextInt();
        System.out.println("Second Number denominator: ");
        int second_denom = scanner.nextInt();
        while (second_denom == 0)
        {
            System.out.println("Error! please insert non zero denominator");
            second_denom = scanner.nextInt();
        }

        Rational r1 = new Rational(first_num, first_denom);
        Rational r2 = new Rational(second_num, second_denom);

        System.out.println("first rational is greater then the second: "+r1.greaterThan(r2));
        System.out.println("first rational is equal to the second: "+r1.equals(r2));
        System.out.println(r1.toString()+" reduced value is: "+r1.reduce().toString());
        System.out.println(r2.toString()+" reduced value is: "+r2.reduce().toString());
        System.out.println(r1.reduce().toString()+" + "+r2.reduce().toString()+" = "+r1.plus(r2).reduce().toString());
        System.out.println(r1.reduce().toString()+" - "+r2.reduce().toString()+" = "+r1.minus(r2).reduce().toString());
        System.out.println(r1.reduce().toString()+" * "+r2.reduce().toString()+" = "+r1.multiply(r2).reduce().toString());
    }
}