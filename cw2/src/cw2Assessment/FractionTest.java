package cw2Assessment;

/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	Fraction i = new Fraction(5,6);
	Fraction j = new Fraction(11,10);
	Fraction k = new Fraction(-1,10);
	Fraction l = new Fraction(1,10);
	
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

        // extend with extra tests
		// -----------------------

	if (!i.equals(g.divide(h))) System.out.println("Divide failed");
	if (!j.equals(g.add(h))) System.out.println("Addition failed");
	if (!k.equals(g.subtract(h))) System.out.println("Subtraction failed");
	if (!k.equals(l.negate())) System.out.println("negation failed");
	if (!l.equals(k.absValue())) System.out.println("modulus failed");

	
    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
