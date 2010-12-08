package Graphs;

import java.util.LinkedList;
/**
 * @author Alexander Karp and Merrielle Ondreicka
 *
 */
public class Graph {
	/**
	 * Stores a list of cities.
	 */
	private LinkedList<Node> cities;
	/**
	 * Stores a list of networks.
	 */
	private LinkedList<LinkedList<Node>> networks;
	
	/**
	 * Initializes the points on the graph.
	 */
	Graph () {
		this.cities = new LinkedList<Node>();
		initPoints();
	}
	
	Node boston = new Node("Boston");
	Node worcester = new Node("Worcester");
	Node hartford = new Node("Hartford");
	Node chicago = new Node("Chicago");
	Node denver = new Node("Denver");
	Node phoenix = new Node("Phoenix");
	Node houston = new Node("Houston");
	Node tulsa = new Node("Tulsa");
	
	private void initPoints() {
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
		
		this.cities.add(boston);
		this.cities.add(worcester);
		this.cities.add(hartford);
		this.cities.add(chicago);
		this.cities.add(denver);
		this.cities.add(phoenix);
		this.cities.add(houston);
		this.cities.add(tulsa);
	}
	
	/**
	 * Groups all of the cities into networks based on which cities can travel to the other ones.
	 * @return LinkedList<LinkedList<Node>>
	 */
	public LinkedList<LinkedList<Node>> getNetworks() {
		networks = new LinkedList<LinkedList<Node>> ();
		
		for(Node city: cities) {
			if (networks.size() == 0) {
				LinkedList<Node> locations = new LinkedList<Node>();
				locations.add(city);
				networks.add(locations);
			} else {
				boolean foundNetwork = false;
				for (LinkedList<Node> network: networks) {
					if (this.connectsToNetwork(network, city)) {
						network.add(city);
						foundNetwork = true;
					}
				}
				
				if (!foundNetwork) {
					LinkedList<Node> locations = new LinkedList<Node>();
					locations.add(city);
					networks.add(locations);
				}
			}
		}
		
		return networks;
	}
	
	/**
	 * Checks to see whether the given city is part of a established network.
	 * @param network
	 * @param city
	 * @return boolean
	 */
	private boolean connectsToNetwork(LinkedList<Node> network, Node city) {
		for (Node networkCity: network) {
			for (Node connectingCity: city.connects) {
				if (networkCity.equals(connectingCity)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Creates a list of new flights which should be implemented to connect all of the given networks using the least number of additions.
	 * @return LinkedList<CityPair>
	 */
	public LinkedList<CityPair> newFlights () {
		LinkedList<LinkedList<Node>> flights = this.getNetworks();
		LinkedList<CityPair> newFlights = new LinkedList<CityPair>();
		Node flight = new Node("Blank City");
		for(LinkedList<Node> citiesInNetwork: flights) {
			if (cities.contains(flight)) {
				newFlights.add(new CityPair(flight, citiesInNetwork.getFirst()));
			}
			flight = citiesInNetwork.getFirst();
		}
		
		return newFlights;
	}
}
