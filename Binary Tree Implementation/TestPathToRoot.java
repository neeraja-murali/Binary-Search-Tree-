//FileName:TestPathToRoot
//Assignment 5 (CS1027) 
//Name: Neeraja Murali Dharan 
/*Purpose: This program reads a tree file name and builds a tree, 
 * and using the method getPathToRoot, finds the path from each element in the binary 
 * tree to the root and outputs this pat
 */

import java.io.*;
import java.util.Iterator;

public class TestPathToRoot {

	public static void main(String[] args) {
		//builds a binary tree from the textfile read 
		LinkedBinaryTree<String> theTree = null;
		TreeBuilder<String> theTreeBuilder = null;

		try{
			theTreeBuilder = new TreeBuilder<String>(args[0]);
			theTree = theTreeBuilder.buildTree();
		}
		//catches exceptions associated with opening or reading the file 
		catch( MalformedTreeFileException e){
			System.out.println( e.getMessage());
		}
		catch( IOException e){
			System.out.println("Error reading file: " + args[0] + "\n" + e.getMessage());
		}


		Iterator <String> treeElements=theTree.iteratorInOrder(); //creates an iterator to store elements of tree
		Iterator <String> pathFromCurrent=null; 
		String current; 

		//while loop to send in each of the element in the iterator to the function to obtain the path to root 
		while (treeElements.hasNext()){
			current=treeElements.next();
			try{
				pathFromCurrent=theTree.pathToRoot(current);
			}
			//catches exception if element is not found in the node 
			catch (ElementNotFoundException e){
				System.out.println(e.getMessage());
			}
			//prints out the path for each element in the iterator 
			System.out.print("For element: "+ current +" - the path to root is: ");
			while (pathFromCurrent.hasNext()){
				System.out.print(pathFromCurrent.next()+" ");
			}
			System.out.println(" ");
		}
	}
}
