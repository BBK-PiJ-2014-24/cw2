package old;

import java.util.Scanner;

import java.util.StringTokenizer; 


public class StrToken {

	
	private StringTokenizer stTok;
	
	public static void main(String[] args){
		
		StrToken m = new StrToken();
		String str = " Hello to the Java World";
		
		String delim = " ";
		m.stTok = new StringTokenizer(str, delim);
		m.miracle(m.stTok);
		m.miracle(m.stTok);
		m.miracle(m.stTok);
		
		System.out.println();
		m.miracle2(str);
		m.miracle2(str);
		m.miracle2(str);

		
		
	}
	
public void miracle(StringTokenizer s){
	String word = s.nextToken();
	System.out.println(word);
	
}

public void miracle2(String s){
	String delim = " ";
	StringTokenizer methodToken = new StringTokenizer(s,delim); 

	String word = methodToken.nextToken();
	System.out.println(word);
}

}
