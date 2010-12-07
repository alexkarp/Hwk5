package Levenshtein;

public class CellPoint {
	int x, y;
	
	CellPoint (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals (Object obj) {
		CellPoint second = (CellPoint)obj;
		return (this.x == second.x) && (this.y == second.y);
	}
	
	public int hashCode() {
		return (y * 10000) + x;
	}
}
