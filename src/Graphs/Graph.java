package Graphs;

import java.util.LinkedList;

public class Graph {
	private LinkedList<Node> cities;
	private LinkedList<Node> unusedCities;
	private LinkedList<LinkedList<Node>> networks;
	
	Graph () {
		cities = new LinkedList<Node>();
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
		chicago.addEdge(chicago);
		denver.addEdge(denver);
		phoenix.addEdge(houston);
		houston.addEdge(phoenix);
		houston.addEdge(tulsa);
		tulsa.addEdge(tulsa);
		
		cities.add(boston);
		cities.add(worcester);
		cities.add(chicago);
		cities.add(denver);
		cities.add(phoenix);
		cities.add(houston);
		cities.add(tulsa);
	}
	
	public LinkedList<LinkedList<Node>> getNetworks() {
		networks = new LinkedList<LinkedList<Node>> ();
		unusedCities = new LinkedList<Node> ();
		
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
					unusedCities.add(city);
				}
			}
		}
		
		return networks;
		//return (unusedCities.size() > 0) ? retryConnections(): networks;
	}
	
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
	
	private LinkedList<LinkedList<Node>> retryConnections() {
		for(Node city: unusedCities) {
			if (networks.size() == 0) {
				LinkedList<Node> locations = new LinkedList<Node>();
				locations.add(city);
				networks.add(locations);
				unusedCities.remove(city);
			} else {
				boolean foundNetwork = false;
				for (LinkedList<Node> network: networks) {
					if (this.connectsToNetwork(network, city)) {
						network.add(city);
						unusedCities.remove(city);
						foundNetwork = true;
					}
				}
				
				if (!foundNetwork && !unusedCities.contains(city)) {
					unusedCities.add(city);
				}
			}
		}
		
		return (unusedCities.size() > 0) ? retryConnections(): networks;
	}
}
