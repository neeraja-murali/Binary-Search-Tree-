//FileName:FindCommonAncestor
//Assignment 5 (CS1027) 
//Name: Neeraja Murali Dharan 
/*Purpose: This program reads a tree file name and builds a tree, 
 * prompts the user to enter two elements, and using the method 
 * patToRoot, prints out the common ancestor of the two elements
 */

import java.io.*;

public class FindCommonAncestor {
	public static void main(String[] args){
		
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedBinaryTree<String> linkedBinaryTree = null;
		TreeBuilder<String> theTreeBuilder = null;
		
		String firstElement=null, secondElement=null; //holds the two elements entered by the user 

		try{
			//builds a binary tree from the textfile read 
			theTreeBuilder = new TreeBuilder<String>(args[0]);
			linkedBinaryTree = theTreeBuilder.buildTree();
			
			//prints out all the elements in the binary tree using the toString method 
			System.out.println("The tree contains: " + linkedBinaryTree.toString());
			
			//prompts user to enter the first and second elements
			System.out.print("Enter first element: ");
			firstElement = consoleReader.readLine();
			System.out.print("Enter second element: ");
			secondElement=consoleReader.readLine(); 
			
			/*calls the function lowestCommonAncestor and prints out the lowest common ancestor
			 *  found for the two elements entered by the user 
			 */
			System.out.println("The lowest common ancestor is: " + 
					linkedBinaryTree.lowestCommonAncestor(firstElement,secondElement) );
		}
		/*catches exceptions if the textfile can't be read or opened and 
		the element entered by the user cannot be found in the binary tree*/
		catch( MalformedTreeFileException e) {
			System.out.println( e.getMessage());
		}
		catch( IOException e){
			System.out.println("Error reading file: " + args[0] + "\n" + e.getMessage());
		}
		catch (ElementNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
}
