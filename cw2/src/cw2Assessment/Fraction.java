package cw2Assessment;
/*
 * CW2 coursework submiited by Stewart Newnham (Pt. MSc Computer Science)
 */
public class Fraction {
    private int numerator;
    private int denominator;

    // Constructor
    // ----------
    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
	    // this should use exceptions
            return;
        }
        
        // hack to ensure right convention of displaying neg fractions
        if (denom<0){
        	denom = -1*denom;
        	num = -1*num;
        }
        
        int gcd = myGcd(num, denom);  // common denomintator
        gcd = Math.abs(gcd);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    

        
    }
    

    // to String
    // ---------
    @Override
    public String toString() {
        if(getDenominator()==1)
        	return "" + getNumerator();
        else
        	return "" + getNumerator() + '/' + getDenominator();
    }

    // getter/setters
    // --------------
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    // equals object
    // ------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    // hashCode()
    // ----------
    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    // multiply()
    // ----------
    public Fraction multiply(Fraction other) {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }

    
    // divide()
    // --------
    
    public Fraction divide(Fraction other){
    	Fraction ans;
    	Fraction o;
    	int num = other.getNumerator();
    	int denom = other.getDenominator();
    	int temp = num;
    	
    	// invert other fraction
    	num = denom;
    	denom = temp;
    	o =  new Fraction(num,denom);
    	
    	ans = this.multiply(o);
    	
    	return ans;
    }
    
    // add()
    // -----
    
    public Fraction add(Fraction other){
    	Fraction ans;
    	int denom = this.denominator*other.getDenominator();
    	int num = this.numerator*other.getDenominator() + other.getNumerator()*this.denominator;
    	ans = new Fraction(num,denom);		
	 return ans;
    }
    
    // subtract()
    // ----------
    
    public Fraction subtract(Fraction other){
    	Fraction ans;
    	int denom = this.denominator*other.getDenominator();
    	int num = this.numerator*other.getDenominator() - other.getNumerator()*this.denominator;
    	ans = new Fraction(num,denom);	
    	
    	
	 return ans;
    }
    
    // absValue()
    // ----------
    
    public Fraction absValue(){
    	Fraction ans;
    	int num = this.numerator;
    	int denom = this.denominator;
    	
    	if(num <0)
    		num = Math.abs(num);
    	if(denom<0)
    		denom = Math.abs(denom);
    	
    	ans = new Fraction(num, denom);
    	return ans;		
    }
    
    // negate()
    // --------
    
    public Fraction negate(){
    	Fraction ans;
    	int num = this.numerator;
    	int denom = this.denominator;
    	
    	ans = new Fraction(num,denom);
    	ans.setNumerator(-1*ans.getNumerator());
 
    	return ans;
    }
    
    
    
    // Gcd
    // ---
    public int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
