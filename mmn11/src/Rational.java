public class Rational
{
    private int numerator;
    private int denominator;

    public Rational (double numerator, double denominator)
    {
        this.setRatio(numerator, denominator);
    }

    private void setRatio(double numerator, double denominator)
    {
        if ((numerator % (int)numerator == 0) && (denominator > 0 && denominator % (int)denominator == 0))
        {
            this.numerator = (int)numerator;
            this.denominator = (int)denominator;
        }
        else
            this.setBadValue();
    }

    protected int getNumerator()
    {
        return this.numerator;
    }

    protected int getDenominator()
    {
        return this.denominator;
    }

    @Override
    public String toString()
    {
        if (this.getNumerator() == 0)
            return String.valueOf(this.getNumerator());
        else
            return this.getNumerator()+"/"+this.getDenominator();
    }

    private void setBadValue()
    {
        this.numerator = 0;
        this.denominator = 1;
    }

    public boolean greaterThan(Rational rational)
    {
        return (this.getNumerator() * rational.getDenominator() > this.getDenominator() * rational.getNumerator());
    }

    public boolean equals (Rational rational)
    {
        return (this.getNumerator() * rational.getDenominator() == this.getDenominator() * rational.getNumerator());
    }

    public Rational plus (Rational rational)
    {
        return new Rational((this.getNumerator()*rational.getDenominator()) + (this.getDenominator()*rational.getNumerator()) , this.getDenominator()*rational.getDenominator());
    }

    public Rational minus (Rational rational)
    {
        return new Rational((this.getNumerator()*rational.getDenominator()) - (this.getDenominator()*rational.getNumerator()) , this.getDenominator()*rational.getDenominator());
    }

    public Rational multiply (Rational rational)
    {
        return new Rational(this.getNumerator()*rational.getNumerator() , this.getDenominator()*rational.getDenominator());
    }

    public Rational reduce ()
    {
        if (this.getNumerator() == 0)
            return new Rational(this.getNumerator(), this.getDenominator());
        int divisor = this.gcd(this.getNumerator(), this.getDenominator());
        if (divisor < 0)
            divisor *= -1;
        return new Rational(this.getNumerator()/divisor, this.getDenominator()/divisor);

    }

    private int gcd (int a, int b)
    {
        if (b == 0)
            return a;
        else
           return this.gcd(b, a%b);
    }
}