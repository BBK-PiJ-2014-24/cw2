package old;


import java.util.Scanner;
import java.util.StringTokenizer; 

import cw2Assessment.Fraction;

public class FractionCalculatorOld {

	// Fields
	// ------
	
	private Fraction f1;
	private Fraction f2;
	private Fraction fZero = new Fraction(0,1);
	private Fraction answer;
	private boolean fractionFlag; // Flag to Determine if Fraction is Stored (if yes, true)
	private String operator;
	private String tok1;
	private String tok2;
	private String tok3;
	
	// Constructor
	// -----------
	public FractionCalculatorOld(){
		System.out.println("Welcome to Stewart Newnham's Fraction Calculator\n");
		answer = new Fraction(0,1);
		f1 = new Fraction(0,1);
		f2 = new Fraction(0,1);
		fractionFlag = false;
		operator = "";
		tok1 = "";
		tok2 = "";
		tok3 = "";
	}
	
	// LAUNCH
	// ======
	public void launch(){
		
	// Initializations & Declarations
	// ------------------------------	
	Scanner importConsole = new Scanner(System.in);
	String strInput;  // The input String From Console
	
	StringTokenizer inputStream;
	String delim = " ";
	
	char operator; // field for storing operator {+,-,*,/}
	

	Fraction frTok;
	String stTok;
	Fraction zeroFr = new Fraction(0,1);
	
	
	// Input Data:
	// ----------
	System.out.println("Input: ");
	strInput = importConsole.nextLine();
	inputStream = new StringTokenizer(strInput, delim);
	
	
	// Push the tokens through the Calculator
	// --------------------------------------
	while(inputStream.hasMoreTokens()) { 
		if(f1.equals(zeroFr)){
			tok1 = inputStream.nextToken();
			f1 = TokToFraction(tok1);
			}
		else{
			tok2 = inputStream.nextToken();
			char c2 = tok2.charAt(0);	
			if(Character.isLetter(c2))   
				f1 = evaluate(f1,tok2);			// Cmd Operation
			else{
				tok3 = inputStream.nextToken(); 
				f2 = TokToFraction(tok3);
				f1 = evaluate(f2,tok2);		// Arithmetic Operation
			}
		} // end 
	}  // end while loop
	System.out.println("answer: " + f1.toString());
	importConsole.close();
	} // end launch
	

	// Evaluate Input - Does as it says on the tin...
	// --------------	
			
	public Fraction evaluate(Fraction f, String s){		
			
		char c = s.charAt(0);
	
			if(Character.isLetter(c)){ 
				answer = CalcCmd(f,s);  // Calc Cmd Operation
			}	
			else { 
				answer = CalcOp(f1,f,s); // Calc Arithmetic Operation
			}	
			return answer;
	
	}// end evaluate
		
		
	
	
	// ==================================================================
	

	
	
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
		char c = cmd.charAt(0);
		c  = Character.toLowerCase(c);
		
		switch(c){
			case 'a':
				result = f1.absValue();
				break;
			case 'c':
				result = new Fraction(0,1);
				break;
			case 'n':
				result = f1.negate();
				break;
			case 'q':
				System.out.println("Quit. Exiting...");
				break;
			default:
				System.out.println("Faulty Input. Exiting...");
				break;
		}// end switch
		
		return result;
		
	} // end CalcCmd
		
	
	// CalcOp - Method for the Operation of 2 Fractions
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


/*		
if(!fractionFlag){   // If a fraction is NOT in memory
	f1 = f; 
	if(!Character.isLetterOrDigit(c)){ 
		operator = s;		// store operator
		fractionFlag = true; // flag that a Fraction is stored
	}
	else{
		answer = CalcCmd(f,s);
		System.out.println(answer);
	}
} 
else { // else if a fraction IS in memory
	f2 = f;
	operator = s;
	answer = CalcOp(f1,f2,operator);
	f1 = answer;  // answer becomes new stored Fraction
	fractionFlag = true;
	operator = ""; // clear operator memory
	}	
*/	