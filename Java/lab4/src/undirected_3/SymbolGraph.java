package undirected_3;

import java.net.MalformedURLException;
import java.net.URL;
import edu.princeton.cs.algs4.*;
import undirected_3.EdgeWeightedGraph;

public class SymbolGraph {

	private ST<String, Integer> st;
	private String[] keys;
	private EdgeWeightedGraph graph;
	private Edge edge;
	
	/**
	 * Initialize a graph from a URL and using a specified string as delimiter.
	 * Each line in URL contains the name of the vertex (nod), followed by a list of the names
	 * of the vertices adjacent to that vertex, separated by the delimiter.
	 * @param url
	 * @param delimiter
	 */
	public SymbolGraph(URL url, String delimiter) {
		
        //First pass builds the index by reading strings to associate
        //distinct strings with an index
		st = new ST<String,Integer>();
		In in = new In(url);
		while(!in.isEmpty()) {
			String[] a = in.readLine().split(delimiter);
			for(int i = 0; i < a.length; i++) {
				if (!st.contains(a[i]))
					st.put(a[i], st.size());
			}
		}
		
		//inverted index to get string keys in an array
		keys = new String[st.size()];
		for (String name : st.keys()) {
			keys[st.get(name)] = name;
		}
		
        // second pass builds the graph by connecting first vertex on each
        // line to all others
		graph = new EdgeWeightedGraph (st.size());
		in = new In(url);
		while(in.hasNextLine()) {
			String[] a = in.readLine().split(delimiter);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++) {
				int w = st.get(a[i]);
				graph.addEdge(edge);
			}
		}
	}
	
	/**
	 * Does the graph contain the vertex?
	 * @param s the name of the vertex
	 * @return true if s is the name of a vertex, false if not
	 */
	public boolean contains(String s) {
		return st.contains(s);
	}
	
	/**
	 * Returns the integer associated with the vertex named s
	 * @param s the name of the vertex
	 * @return the integer associated with the vertex
	 */
	public int index(String name) {
		return st.get(name);
	}
	
	/**
	 * Returns the name associated with the given integer.
	 * @param v the integer corresponding to a vertex (between 0 and (V-1))
	 * @return the name associated with the given integer.
	 */
	public String name(int v) {
		return keys[v];
	}
	
    /**
     * Returns the graph associated with the symbol graph.
     * @return the graph associated with the symbol graph
     */
	public EdgeWeightedGraph graph(){
	 return graph;	
	}
	
    public static void main(String[] args) throws MalformedURLException {
    	URL url = new URL("https://introcs.cs.princeton.edu/java/data/contiguous-usa.dat");
    	String delimiter = " ";
    	SymbolGraph sg = new SymbolGraph(url, delimiter);
    	
        StdOut.println(sg.graph);
    }
}
