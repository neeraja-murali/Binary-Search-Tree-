/*
 * class to represent a Node object, that acts as the 
 * vertices in the graph 
 */
public class Node {
	/*
	 * Name and mark of the node
	 */
	private boolean marked;
	private int name;
	
	/*
	 * constructor creates a new node with specified name
	 */
	public Node (int name){
	 this.marked=false;
	 this.name=name;
	}
	
	/*
	 * getter method returns the mark of the node
	 */
	public boolean getMark(){
		return this.marked;
	}
	
	/*
	 * setter methods sets the mark of node to mark
	 */
	public void setMark(boolean mark){
		this.marked=mark;
	}
	
	/*
	 * getter method returns the name of the node 
	 */
	public int getName(){
		return this.name;
	}

}
