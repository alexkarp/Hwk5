package Graphs;
import java.util.LinkedList;
/**
 * @author Alexander Karp and Merrielle Ondreicka
 *
 */
public class Node {
	/**
	 * Stores the name of the city.
	 */
    String cityname;
    /**
     * Stores a list of the cities that it connects to.
     */
    LinkedList<Node> connects;
  
    /**
     * Initializes the variables.
     * @param cityname
     */
    Node(String cityname) {
    	this.cityname = cityname ;
    	this.connects = new LinkedList<Node>();
    }
  
    /**
     * Adds a city to the 'connects' list.
     * @param toNode
     */
    public void addEdge(Node toNode) {
    	this.connects.add(toNode);
    }
}
