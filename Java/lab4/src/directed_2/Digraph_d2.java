package directed_2;

import edu.princeton.cs.algs4.*;

public class Digraph_d2 {
	private final int numberOfVertices;
	private int numberOfEdges;
	private Bag<Integer>[] adj;
	
	public Digraph_d2(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = numberOfEdges;
		adj = (Bag<Integer>[]) new Bag[numberOfVertices];
		for(int i = 0; i < numberOfVertices; i++)
			adj[i] = new Bag<Integer>();
	}
	
	/**
	 * Returns the number of vertices in this graph.
	 * @return the number of vertices in this graph.
	 */
	public int numberOfVertices() {
		return numberOfVertices;
	}
	
	/**
	 * Returns the number of edges in this graph.
	 * @return the number of edges in this graph.
	 */
    public int numberOfEdges() {
    	return numberOfEdges;
    }
    
	/**
	 * Adds the directed edge vertex->otherVertex to this graph.
	 * @param vertex one vertex in the edge.
	 * @param otherVertex the other vertex in the edge.
	 */
    public void addEdge(int vertex, int otherVertex) {
    	adj[vertex].add(otherVertex);
    	numberOfEdges++;
    }	
    
	/**
	 * Returns the vertices adjacent to vertex param v.
	 * @param vertex the vertex.
	 * @return the bag connected to the index.
	 */
    public Iterable<Integer> adj(int vertex) {
    	return adj[vertex];
    }
    
    /**
     * Return the reverse of the graph.
     * @return the reverse of the graph.
     */
    public Digraph_d2 reverse() {
    	Digraph_d2 reverseGraph = new Digraph_d2(numberOfVertices);
    	for (int i = 0; i < numberOfVertices; i++)
    		for (int current : adj(i))
    			reverseGraph.addEdge(current, i);
    	return reverseGraph;
    }
    
    //string representation of the graph.
    public String toString(SymbolGraph_d2 sg) {
		String s = numberOfVertices + " vertices, " + numberOfEdges + " edges\n";
		for (int i = 0; i < numberOfVertices; i++) {
			s += sg.name(i) + ": ";
			for(int w : this.adj(i))
				s += sg.name(w) + " -> "; 
			s += "\n";
		}
		return s;
    }
    
}
