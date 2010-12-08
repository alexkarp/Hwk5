package Graphs;
import tester.*;

import java.util.LinkedList;
/**
 * @author Alexander Karp and Merrielle Ondreicka
 *
 */
public class Examples {
	/**
	 * Stores the list of networks.
	 */
	LinkedList<LinkedList<Node>> networks;
	/**
	 * Stores the list of new flights needed to connect the networks.
	 */
	LinkedList<CityPair> newFlights;
	
	/**
	 * Initializes the expected results.
	 */
	Examples () {
		initNodes();
		
		LinkedList<Node> network1 = new LinkedList<Node> ();
		network1.add(boston);
		network1.add(worcester);
		network1.add(hartford);
		
		LinkedList<Node> network2 = new LinkedList<Node> ();
		network2.add(chicago);
		network2.add(denver);
		
		LinkedList<Node> network3 = new LinkedList<Node> ();
		network3.add(phoenix);
		network3.add(houston);
		network3.add(tulsa);
		
		networks = new LinkedList<LinkedList<Node>> ();
		networks.add(network1);
		networks.add(network2);
		networks.add(network3);
		
		newFlights = new LinkedList<CityPair>();
		newFlights.add(new CityPair(boston, chicago));
		newFlights.add(new CityPair(chicago, phoenix));		
	}
	
	Graph airplanes = new Graph();
	
	Node boston = new Node("Boston");
	Node worcester = new Node("Worcester");
	Node hartford = new Node("Hartford");
	Node chicago = new Node("Chicago");
	Node denver = new Node("Denver");
	Node phoenix = new Node("Phoenix");
	Node houston = new Node("Houston");
	Node tulsa = new Node("Tulsa");

	private void initNodes () {
		boston.addEdge(worcester);
		boston.addEdge(hartford);
		worcester.addEdge(boston);
		hartford.addEdge(boston);
		chicago.addEdge(denver);
		denver.addEdge(chicago);
		phoenix.addEdge(houston);
		houston.addEdge(phoenix);
		houston.addEdge(tulsa);
		tulsa.addEdge(houston);
	}
	
	/**
	 * Checks to see whether the getNetworks function is working properly
	 * @param Tester t
	 * @return boolean
	 */
	public boolean test1 (Tester t) {
		return t.checkExpect(airplanes.getNetworks(), networks);
	}
	
	/**
	 * Checks to see whether the newFlights function is working properly
	 * @param Tester t
	 * @return boolean
	 */
	public boolean test2 (Tester t) {
		return t.checkExpect(airplanes.newFlights(), newFlights);
	}
	
	
}
