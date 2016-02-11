/*
 * Adjacency list to represent the edges associated with each node
 */

import java.util.*;
public class List {
	/*
	 * Fields include node and associated list of edges 
	 */
	private Node node; 
	private LinkedList<Edge>list;
	
	/*
	 * constructor creates a new List with specified node and empty list
	 */
	public List(Node node){
		this.node=node; 
		this.list=new LinkedList<Edge>();
	}
	
	/*
	 * returns the node associated with list
	 */
	public Node getNode(){
		return this.node;
	}
	
	/*
	 * returns list of edgegs associated with node 
	 */
	public LinkedList<Edge> getEdge(){
		return this.list;
	}
	
	/*
	 * sets node associated to a node sent in as parameter 
	 */
	public void setNode(Node node){
		this.node=node;
	}
	
	/*
	 * sets list of edges to list sent in as parameter
	 */
	public void setList(LinkedList<Edge> list){
		this.list=list; 
	}
	
}
