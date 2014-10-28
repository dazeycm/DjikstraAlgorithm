

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Software network template for CSE283 Lab 7, FS2014.
 * 
 * @author dk
 */
public class LinkState {

	/** The link state matrix of distances.
	 * 
	 * M[i][j] is the cost of the link from node i to node j. 
	 */
	protected double[][] M;

	/** Constructor. */
	public LinkState(int n) {
		M = new double[n][];
		for(int i=0; i<n; ++i) {
			M[i] = new double[n];
			Arrays.fill(M[i], Double.POSITIVE_INFINITY);
		}
	}

	/**
	 * Adds a bidirectional link with the specified cost.
	 */
	public void link(int i, int j, double w) {
		M[i][j] = w;
		M[j][i] = w;
	}

	/**
	 * Runs Dijkstra's algorithm on the distance matrix M.
	 */
	public void calculate_shortest_paths() {
		
		TreeSet<Integer> nPrime = new TreeSet<Integer>();
		while (nPrime.size() < M.length)	{
			for(int i = 0; i < M.length; i++){
				nPrime.add(i);
				for(int j = 0; j < M[i].length; j++)	{
					
				}
			}
		}
	}

	/**
	 * Prints out the distance matrix M.
	 */
	public void print() {
		for(int i=0; i<M.length; ++i) {
			for(int j=0; j<M.length; ++j) {
				if(M[i][j] == Double.POSITIVE_INFINITY) {
					System.out.print("*    ");
				} else {
					System.out.printf("%-4.1f ", M[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Main method.
	 */
	public static void main(String[] args) {
		LinkState ls = new LinkState(6);
		ls.link(0, 1, 2.0);
		ls.link(0, 2, 1.0);
		ls.link(1, 3, 3.0);
		ls.link(1, 2, 2.0);
		ls.link(2, 3, 3.0);
		ls.link(2, 4, 1.0);
		ls.link(1, 3, 5.0);
		ls.link(3, 5, 5.0);
		ls.link(4, 5, 2.0);
		ls.link(3, 4, 1.0);

		System.out.println("Initial cost matrix:");
		ls.print();

		System.out.println("Shortest paths:");
		ls.calculate_shortest_paths();
		ls.print();
	}	
}
