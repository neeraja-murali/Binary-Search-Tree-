import java.util.*;

public class Graph{ 
	private List[]nodeList;
	
	/**
	 * constructor creates a new graph with n nodes and no edges
	 * using an adjacency list representation 
	 * @param n The number of nodes the graph will have 0 to n-1
	 */
	public Graph(int n){
		this.nodeList=new List[n];
		for (int i=0;i<n;i++){
			Node node=new Node(i);
			nodeList[i]=new List(node);
		}
	}
	/**
	 * Inserts an edge (node u, node v) with the specified type. Throws a graph exception if either node is not 
	 * a part of the graph or if the edge is already in place.
	 */
	public void insertEdge (Node u, Node v, String busLine)throws GraphException{
		if ((u.getName()>=nodeList.length)||(v.getName()>=nodeList.length)||areAdjacent(u,v)){
			throw new GraphException("Error: Node cannot be found in graph");
		}
		else{
			Edge edgeU=new Edge(u,v,busLine);
			Edge edgeV=new Edge(v,u,busLine);
			nodeList[u.getName()].getEdge().add(edgeU);
			nodeList[v.getName()].getEdge().add(edgeV);
		}
	}
	
	/**
	 * Returns the node with name u, throwing a GraphException if it does not exist
	 */
	public Node getNode(int name)throws GraphException{
		if ((name>=nodeList.length)){
			throw new GraphException("Error: Node cannot be found in graph");
		}
		else{
			return nodeList[name].getNode();
			}
	}
	
	/**
	 * Returns an iterator over all edges incident on node u, and null if there aren't any.
	 */
	public Iterator<Edge> incidentEdges(Node u)throws GraphException{
		if ((u.getName()>=nodeList.length)){
			throw new GraphException("Error: Node cannot be found in graph");
		}
		else{
			LinkedList<Edge> list=nodeList[u.getName()].getEdge();
			return list.iterator();
		}
	}
	
	/**
	 * Returns the edge (u, v), throwing a GraphException if the endpoints don't exist
	 */
	public Edge getEdge(Node u, Node v)throws GraphException{
		if ((u.getName()>=nodeList.length)||(v.getName()>=nodeList.length)){
			throw new GraphException("Error: Node cannot be found in graph");
		}
		else{
			Iterator<Edge> itru=incidentEdges(u);
			Edge next;
			while (itru.hasNext()){	
				next=itru.next();
				if ((next.firstEndpoint().equals(u))&&(next.secondEndpoint().equals(v))){
					return next;
				}
			}
			return null;
		}
		
	}
	/**
	 * Returns true if the nodes u and v are adjacent, and false otherwise.
	 */
	public boolean areAdjacent(Node u,Node v)throws GraphException{
		if ((u.getName()>=nodeList.length)||(v.getName()>=nodeList.length)){
			throw new GraphException("Error: Node cannot be found in graph");
		}
		else{
			if ((getEdge(u,v)!=null)&& (getEdge(v,u)!=null)){
				return true;
			}
			else{
				return false;
			}
		
		}
	}

}
