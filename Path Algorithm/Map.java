
import java.io.*;
import java.util.*;


public class Map {
	private Graph graph;
	private Node start; 
	private Node end;
	private int width,height,lineChange;
	
	//initalizes path stack 
	private Stack<Node>path=new Stack<Node>();
	
	/**
	 * Constructs a graph representation of the map specified in inputFile
	 */
	public Map(String inputFile)throws MapException, IOException, GraphException{
		try{
			//reads input file using a bufferedReader and stores each value appropriately
			BufferedReader br=new BufferedReader(new FileReader(inputFile));
			br.readLine();
			width=Integer.parseInt(br.readLine()); 
			height=Integer.parseInt(br.readLine());
			lineChange=Integer.valueOf(br.readLine());
			graph=new Graph(width*height);
			String s;
			
			//creates a two dimensional array to store the values 
			char[][]charArray=new char[(height*2)-1][(width*2)-1];
			int current=0;
			int change=0;
			int i=0;
			
			//stores all the characters in text file in 2-D array
			while ((s=br.readLine())!=null){
				charArray[i]=s.toCharArray();
				i++;
			}
			//loops through array to create edges between nodes as specified
			for (int y=0;y<(height*2-1);y++)	{
				change=current;
				for (int x=0;x<(width*2-1);x++){
					//if the text line is even
					if (y%2==0){
					
						if (charArray[y][x]=='0'){
							start=graph.getNode(current);
							current++;
							change++;
						}
						else if (charArray[y][x]=='1'){
							end=graph.getNode(current);
							current++;
							change++;
						}
						else if (charArray[y][x]==' '){
							//do nothing 
						}
						else if (charArray[y][x]=='+'){
							current++;
							change++;
						}
						else{
							graph.insertEdge(graph.getNode(current-1), graph.getNode(current), String.valueOf(charArray[y][x]));
						}
					}
					
					//if the text line is odd 
					else{
						if (charArray[y][x]==' '){
							//do nothing 
						}
						else{
							graph.insertEdge(graph.getNode(change-height-2),graph.getNode(change),String.valueOf(charArray[y][x]));
							change++;
						}
					}
				}
			}
			br.close();
		}catch (FileNotFoundException e){
			throw new MapException("File does not exist");
		}
	}	
	/**
	 * Gets the graph specified by the input file.
	 * 
	 * @return graph G
	 */
	public Graph getGraph()throws GraphException{
		if (graph==null){
			throw new GraphException("Graph could not be found");
		}
		return graph;
	}
	/**
	 * Returns an iterator through the nodes that produce a path from the
	 * starting point to the ending point
	 * 
	 * @return
	 * @throws GraphException
	 */
	public Iterator<Node> findPath()throws GraphException{
		if(path(start,end) == true){
			return path.iterator();
		}
		return null;
	}
	
	/**
	 * Creates a stack storing a path from Node u to Node v
	 * 
	 * @param s
	 * @param t
	 * @return true if there is such a path, false otherwise
	 * @throws GraphException
	 */
	private boolean path(Node u, Node v)throws GraphException{
		path.push(u);
		u.setMark(true);
		String prevBusLine="";

		if (u.equals(v)){
			return true; 
		}else{
			Iterator<Edge>edges=graph.incidentEdges(u);
			
			while (edges.hasNext()){
				Edge edge=edges.next(); 
				Node e=edge.secondEndpoint();
				
				if(edge.getBusLine() == prevBusLine){
					prevBusLine=edge.getBusLine();
					lineChange--;
					if ((e.getMark()==false)&&(lineChange>=0)){
						if (path(e,v)==true){
							return true;
						}
					lineChange++;
					}
				}
				else{
					if ((e.getMark()==false)){
						if (path(e,v)==true){
							return true;
						}
				}
			}
			}
			path.pop();
			return false;
					
		}
		
	}

	
}




	
