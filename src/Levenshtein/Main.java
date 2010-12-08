package Levenshtein;
/**
 * @author Alexander Karp and Merrielle Ondreicka
 *
 */
public class Main {
	
	public static void main(String[] args) {
		System.out.print("Levenshtein distance: " + (new LevTest()).lev("alexander", "merrielle"));
		System.out.print("Levenshtein distance: " + (new LevTest()).lev("iphone", "android"));

	}
}
