package undirected_3;

import java.net.URL;

import edu.princeton.cs.algs4.*;
import undirected_2.SymbolGraph_u2;

public class EdgeWeightedGraph {
	private final int V;
	private int E;
	private Bag<Edge>[] adj;
	
	public EdgeWeightedGraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Edge>();
		}
	}
	
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
    /**
     * String representation of this graph.
     */
	public String toString(SymbolGraph_u2 sg) {
		String s = V + " vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++) {
			s += sg.name(v) + ": ";
			for(Edge e : this.adj(v))
				s += e + " "; 
			s += "\n";
		}
		return s;
	}
	
	public Iterable<Edge> adj(int v){
		return adj[v];
	} 
	public Iterable<Edge> edges(){
		Bag<Edge> bag = new Bag<Edge>();
		for(int v = 0; v < V; v++) 
			for(Edge e : adj[v])
				if(e.other(v) > v)
					bag.add(e);
			return bag;
	}
}
