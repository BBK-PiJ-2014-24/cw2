package cw2Assessment;

import java.util.StringTokenizer; 

public class FractionCalculator {

	// Fields
	// ------
	
	private Fraction f1;
	private Fraction f2;
	private boolean endProgram;

	// Constructor
	// -----------
	public FractionCalculator(){
		f1 = new Fraction(0,1);
		f2 = new Fraction(0,1);
		endProgram = false;
	}
	
	// getter
	// ------
	public boolean getEndProgram(){
		return endProgram;
	}
	
	
	// evaluate() 
	// ----------
	public Fraction evaluate(Fraction fInput, String strInput){
		
		String delim = " ";
		StringTokenizer inputStream = new StringTokenizer(strInput, delim);
		String tok1="";
		String tok2="";
		String tok3="";
		Fraction zeroFr = new Fraction(0,1);
		int cutStrLength = 0;
		
		
		if(!inputStream.hasMoreTokens()) { // if no more tokens
			return f1;
		}
		else{
			if(f1.equals(zeroFr)){			// if no fraction in memory
				tok1 = inputStream.nextToken();
				char c1 = tok1.charAt(0);
				if(!Character.isDigit(c1)){ // checking if first entry is not fraction
					f1 = zeroFr;
					return CalcCmd(f1,tok1);
				}
				f1 = TokToFraction(tok1);
				cutStrLength++;
				}
			if(!inputStream.hasMoreTokens()) { // Check Again if no more tokens
				return f1;
			}	
			tok2 = inputStream.nextToken();
			char c2 = tok2.charAt(0);	
			if(Character.isLetter(c2))   
				f1 = CalcCmd(f1,tok2);			// Cmd Operation
			else{
				tok3 = inputStream.nextToken();
				char c3 = tok3.charAt(0);
				if(!Character.isDigit(c3)){ // checking if third entry is not fraction
					f1 = zeroFr;
					return CalcCmd(f1,tok3);
				}
				f2 = TokToFraction(tok3);
				f1 = CalcOp(f1,f2,tok2);		// Arithmetic Operation
				cutStrLength++;
			} 
			
		// edit String for Next Recursion	
		cutStrLength += tok1.length()+tok2.length()+tok3.length();
		String newStrInput = strInput.substring(cutStrLength);   
		newStrInput = newStrInput.trim();
		
		return evaluate(f1,newStrInput);
		
		}  // end outer else body
	} // end evaluate
	

	
	// TokToFraction()  - Convert String-Token to Fraction Object
	// ---------------
		public Fraction TokToFraction(String tok){
			StringTokenizer s = new StringTokenizer(tok, "/");
			int num =  Integer.parseInt(s.nextToken());
			int denom;
			if(s.hasMoreElements())
				denom = Integer.parseInt(s.nextToken());
			else
				denom = 1;
			Fraction f = new Fraction(num, denom);
			return f;
			
		}// end TokToFraction
		
		
	// CalcCmd -  Method for the Calculator's String Commands 
	// -------------------------------------------------------
		
	public Fraction CalcCmd(Fraction f1, String cmd){
		
		Fraction result = new Fraction(0,1);
		//char c = cmd.charAt(0);
		//c  = Character.toLowerCase(c);
		
		switch(cmd){
			case "a":
			case "A":
			case "abs":	
				result = f1.absValue();
				break;
			case "c":
			case "C":
			case "clear":	
				result = new Fraction(0,1);
				break;
			case "n":
			case "N":
			case "neg":	
				result = f1.negate();
				break;
			case "Quit":	
			case "quit":
			case "q":
				result = new Fraction(0,1);
				endProgram = true;
				System.out.println("Goodbye");
				break;
			default:
				result = new Fraction(0,1);
				System.out.println("Error!");
				break;
		}// end switch
		
		return result;
		
	} // end CalcCmd
		
	
	// CalcOp - Method for the Operation on 2 Fractions
	// ------------------------------------------------
		
	private Fraction CalcOp(Fraction f1, Fraction f2, String operator){
	
		Fraction result = new Fraction(0,1);
		char op = operator.charAt(0); 
		
		switch(op){
			case '+':
				result = f1.add(f2);
				break;
			case '-':
				result = f1.subtract(f2);
				break;
			case '*':
				result = f1.multiply(f2);
				break;
			case '/':
				result = f1.divide(f2);
				break;
			default:
				System.out.println("Faulty Input. Exiting...");
				break;
				
		} // end switch
	
		return result;
		
	} // end CalcOp
} // end class


