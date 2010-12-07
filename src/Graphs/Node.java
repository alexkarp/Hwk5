package Graphs;
import java.util.LinkedList;

public class Node {
    String cityname;
    LinkedList<Node> connects;
  
    Node(String cityname) {
    	this.cityname = cityname ;
    	this.connects = new LinkedList<Node>();
    }
  
    public void addEdge(Node toNode) {
    	this.connects.add(toNode);
    }
}
