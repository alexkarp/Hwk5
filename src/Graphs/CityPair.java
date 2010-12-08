package Graphs;
/**
 * @author Alexander Karp and Merrielle Ondreicka
 *
 */
public class CityPair {
	/**
	 * The name of one of the connecting cities.
	 */
	Node city1;
	/**
	 * The name of the other connecting city.
	 */
	Node city2;
	
	/**
	 * Initialises the variables.
	 * @param city1
	 * @param city2
	 */
	CityPair (Node city1, Node city2) {
		this.city1 = city1;
		this.city2 = city2;
	}
}
