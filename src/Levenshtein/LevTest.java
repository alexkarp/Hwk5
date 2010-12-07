package Levenshtein;

import java.util.Hashtable;

public class LevTest {
	private Hashtable<CellPoint, Integer> results;
	public int calculations;
	
	LevTest () {
		results = new Hashtable<CellPoint, Integer>();
	}
	
	public int lev(String str1, String str2) {
		calculations = 0;
		System.out.println("");
		System.out.println("---------------------------------");
		System.out.println("Comparing \"" + str1 + "\" and \"" + str2 + "\"");
		System.out.println("");
		int lev = this.levenshtein(" " + str1, " " + str2, str1.length(), str2.length());
		System.out.println("Number of Calculations: " + calculations);
		return lev;
	}
	
	public int levenshtein(String str1, String str2, Integer pos1, Integer pos2) {
		CellPoint current = new CellPoint(pos1, pos2);
		
		if (results.containsKey(current)) return this.results.get(current);
		
		// Keep track of the number of calculations to show that we're actually saving operations
		calculations++;
		
		if (pos1 == 0) {
			this.results.put(current, pos2);
			return pos2;
		}
		
		if (pos2 == 0) {
			this.results.put(current, pos1);
			return pos1;
		}
		
		if (str1.charAt(pos1) == str2.charAt(pos2)) {
			int lev = this.levenshtein(str1, str2, (pos1 - 1), (pos2 - 1));
			this.results.put(current, lev);
			return lev;
		}
		
		int lev = this.minumum((this.levenshtein(str1, str2, (pos1 - 1), pos2) + 1), 
							   (this.levenshtein(str1, str2, pos1, (pos2 - 1)) + 1), 
							   (this.levenshtein(str1, str2, (pos1 - 1), (pos2 - 1)) + 1));
		this.results.put(current, lev);
		return lev;
	}
	
	private int minumum (int num1, int num2, int num3) {
		if(num1 <= num2 && num1 <= num3) return num1;
		if(num2 <= num1 && num2 <= num3) return num2;
		return num3;
	}
}
