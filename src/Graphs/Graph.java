package Graphs;

import java.util.LinkedList;

public class Graph {
	private LinkedList<Node> cities;
	private LinkedList<Node> unusedCities;
	private LinkedList<LinkedList<Node>> networks;
	
	Graph () {
		this.cities = new LinkedList<Node>();
		initPoints();
		//this.debugList(this.cities);
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
	
	public LinkedList<LinkedList<Node>> getNetworks() {
		networks = new LinkedList<LinkedList<Node>> ();
		unusedCities = new LinkedList<Node> ();
		
		for(Node city: cities) {
			if (networks.size() == 0) {
				//System.out.println(city.cityname + " (Started new network)");
				//this.debugList(city.connects);
				LinkedList<Node> locations = new LinkedList<Node>();
				locations.add(city);
				networks.add(locations);
			} else {
				boolean foundNetwork = false;
				for (LinkedList<Node> network: networks) {
					if (this.connectsToNetwork(network, city)) {
						//System.out.println(city.cityname + " (Connects to a network)");
						network.add(city);
						foundNetwork = true;
					}
				}
				
				if (!foundNetwork) {
					//System.out.println(city.cityname + " (Started new network)");
					//this.debugList(city.connects);
					LinkedList<Node> locations = new LinkedList<Node>();
					locations.add(city);
					networks.add(locations);
				}
			}
		}
		
		return networks;
		//return (unusedCities.size() > 0) ? retryConnections(): networks;
	}
	
	private boolean connectsToNetwork(LinkedList<Node> network, Node city) {
		//if(city.cityname == "Hartford") System.out.println("Here");
		//System.out.print(city.cityname + " connects to network: ");
		//this.debugList(network);
		//System.out.println("");
		for (Node networkCity: network) {
			for (Node connectingCity: city.connects) {
				//System.out.println(networkCity.cityname + " " + connectingCity.cityname);
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
	
	private void debugList(LinkedList<Node> list) {
		for (Node city: list) {
			System.out.println(city.cityname);
		}
	}
}
