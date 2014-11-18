package old;
import cw2Assessment.Fraction;


public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fraction f1 = new Fraction(4,-8);
		System.out.println(f1.getNumerator());
		System.out.println(f1.getDenominator());
	
		Fraction f2 = new Fraction(2,3);
		
		Fraction a = f1.add(f2);
		Fraction s = f1.subtract(f2);
		Fraction m = f1.multiply(f2);
		Fraction d = f1.divide(f2);
		Fraction ab = s.absValue();
		Fraction n = a.negate();
		Fraction b = new Fraction(5,2);
		String str = b.toString();
				
		
		System.out.println("add " + a.getNumerator()+"/"+a.getDenominator());
		System.out.println("sub " + s.getNumerator()+"/"+s.getDenominator());
		System.out.println("mul " + m.getNumerator()+"/"+m.getDenominator());
		System.out.println("div " + d.getNumerator()+"/"+d.getDenominator());
		System.out.println("abs " + ab.getNumerator()+"/"+ab.getDenominator());
		System.out.println("neg " + n.getNumerator()+"/"+n.getDenominator());
		System.out.println("Str " + b.getNumerator()+"/"+b.getDenominator() +" " + str);
		System.out.println("hashcode: " + f1.hashCode());
		System.out.println("hashcode: " + a.hashCode());
	}

}
