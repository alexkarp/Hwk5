package Levenshtein;

/**
 * @author Alexander Karp and Merrielle Ondreicka
 *
 */
public class CellPoint {
	/**
	 *Stores the x and y values of the cell.
	 */
	int x, y;
	
	/**
	 * Initializes the variables.
	 */
	CellPoint (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Compares two CellPoints and returns whether they are equal.
	 * @param Object obj
	 * @return boolean
	 */
	public boolean equals (Object obj) {
		CellPoint second = (CellPoint)obj;
		return (this.x == second.x) && (this.y == second.y);
	}
	
	/**
	 * Calculates the hash code for a cell point
	 * @return int
	 */
	public int hashCode() {
		return (y * 10000) + x;
	}
}
