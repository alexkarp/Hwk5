package Graphs;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Graph airplanes = new Graph();
		debugCityList(airplanes.newFlights());
	}
	
	public static void debugNetworks(LinkedList<LinkedList<Node>> networks) {
		int i;
		for(LinkedList<Node> network: networks) {
			i = 1;
			for(Node city: network) {
				System.out.println(i + ". " + city.cityname);
				i++;
			}
			System.out.println("");
		}
	}
	
	private static void debugCityList(LinkedList<CityPair> list) {
		for(CityPair pair: list) {
			System.out.println(pair.city1.cityname + " <-> " + pair.city2.cityname);
		}
	}

}
