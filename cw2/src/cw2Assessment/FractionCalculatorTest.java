package cw2Assessment;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sun.tools.xjc.runtime.ZeroOneBooleanAdapter;


public class FractionCalculatorTest {

	// Class Fields
	// ------------
	Fraction zeroFr = new Fraction(0,1);
	FractionCalculator fc = new FractionCalculator();
	
	public static void main (String[] args){
	
	// Main's Initialization & Declarations
	// -------------------------------------	
	 
		FractionCalculatorTest runFrCalc = new FractionCalculatorTest();	
		Fraction ans = runFrCalc.zeroFr;
		Scanner importConsole = new Scanner(System.in);
		String strInput;
		
	// Test evaluate() Method
	// ----------------------
		
		System.out.println("Testing Evaluate");
		System.out.println("-----------------\n");
		runFrCalc.TestData();
		System.out.println("\n");
		
	// Launch Calculator
	// -----------------	
		
		System.out.println("Stewart Newnham's Fraction Calculator");
		System.out.println("--------------------------------------\n");
		
		
	// Input Data
	// ----------	
		
	while(!runFrCalc.fc.getEndProgram()){	
		System.out.print("Input: ");
		strInput = importConsole.nextLine();
		ans = runFrCalc.fc.evaluate(ans, strInput);
		if(!runFrCalc.fc.getEndProgram())
			System.out.println("ans = "+ ans);
		}		
		importConsole.close();
	}// end main		
		
		
//  ******** Testing **********
// ----------------------------	

public void TestData(){
	
	// Test
	// ----
	
		String strInput0 = "1/2";  // fraction without cmd or operator test
		Fraction fAnsw0 = new Fraction(1,2);
		testEvaluate(zeroFr,strInput0,fAnsw0,"Test 0 Fail", "Test 0 Pass");
		
		String strInput1 = "1/2 + 3 - 3/4 * 6/1 / 4";  // multiple operator test
		Fraction fAnsw1 = new Fraction(33,8);
		testEvaluate(zeroFr,strInput1,fAnsw1,"Test 1 Fail", "Test 1 Pass");
		
		String strInput2 = "-2 n + 3/4 n a * 8";   // mutiple cmd and operator test
		Fraction fAnsw2 = new Fraction(22,1);
		testEvaluate(zeroFr,strInput2,fAnsw2,"Test 2 Fail", "Test 2 Pass");
		
		String strInput3 = "-2 n neg N";  // test cmd pemutations for negation
		Fraction fAnsw3 = new Fraction(2,1);
		testEvaluate(zeroFr,strInput3,fAnsw3,"Test 3 Fail", "Test 3 Pass");
		
		String strInput4 = "-2 a n A neg abs";  // test cmd pemutations for abs
		Fraction fAnsw4 = new Fraction(2,1);		
		testEvaluate(zeroFr,strInput4,fAnsw4,"Test 4 Fail", "Test 4 Pass");
		
		String strInput5 = "2 c 2 clear 2 C 2";  // test cmd pemutations for clear
		Fraction fAnsw5 = new Fraction(2,1);		
		testEvaluate(zeroFr,strInput5,fAnsw5,"Test 5 Fail", "Test 5 Pass");	
		
		String strInput6 = "c";  // test c cmd as first entry 
		Fraction fAnsw6 = new Fraction(0,1);
		testEvaluate(zeroFr,strInput6,fAnsw6,"Test 6 Fail", "Test 6 Pass");
		
		String strInput7 = "a";  // test abs cmd as first entry 
		Fraction fAnsw7 = new Fraction(0,1);
		testEvaluate(zeroFr,strInput7,fAnsw7,"Test 7 Fail", "Test 7 Pass");
		
		String strInput8 = "q";  // test q cmd as first entry 
		Fraction fAnsw8 = new Fraction(0,1);
		testEvaluate(zeroFr,strInput8,fAnsw8,"Test 8 Fail", "Test 8 Pass");
		
		String strInput9 = "z";  // test bad input  
		Fraction fAnsw9 = new Fraction(0,1);
		testEvaluate(zeroFr,strInput9,fAnsw9,"Test 9 Fail", "Test 9 Pass");
		
		String strInput10 = "1/2 + z + 1/2";  // test bad input in middle of string 
		Fraction fAnsw10= new Fraction(0,1);
		testEvaluate(zeroFr,strInput10,fAnsw10,"Test 10 Fail", "Test 10 Pass");
		
		String strInput11 = "1/2 z + 1/2";  // test bad input in middle of string 
		Fraction fAnsw11= new Fraction(0,1);
		testEvaluate(zeroFr,strInput11,fAnsw11,"Test 11 Fail", "Test 11 Pass");
		
	
	} // end TestData


	// testEvaluate()
	// --------------
	public void testEvaluate(Fraction f,String str, Fraction fAnsw, String errorMsg, String passMsg){
		
		FractionCalculator calc = new FractionCalculator();
		Fraction evalFr = calc.evaluate(f,str);

		if(!evalFr.equals(fAnsw))
			System.out.println(errorMsg);
		else
			System.out.println(passMsg);
	} // end TestEvaluate
} // end class

