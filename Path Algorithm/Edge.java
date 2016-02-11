/*
 * represents the edges that connect vertices in the graph
 */
public class Edge {
	/*
	 * Fields for the nodes that make up the edge, and the busLine
	 */
	private Node u,v;
	private String busLine;
	
	/*
	 * Constructor creates anew edge (u,v) with the busLine 
	 */
	public Edge(Node u,Node v, String busLine){
		this.u=u; 
		this.v=v;
		this.busLine=busLine;
	}
	
	/*
	 * returns the first endpoint of edge 
	 */
	public Node firstEndpoint(){
		return this.u;
	}
	
	/*
	 * returns the second endpoint of edge
	 */
	public Node secondEndpoint(){
		return this.v;
	}
	
	/*
	 * returns the associated busline of the edge 
	 */
	public String getBusLine(){
		return this.busLine;
	}
}
