package undirected_1;

import edu.princeton.cs.algs4.*;

/**
 * Class that represents a data type for determining the vertices connected
 * to a given source vertex, in an undirected graph. 
 * 
 * @author Roth
 *
 */
public class DepthFirstSearch_u1 {
	
	private boolean[] marked;		//is the vertex marked? (has dfs been called for this vertex?)
	private int[] edgeTo;			//last vertex known path to this vertex
	private final int source;		//source
	
	/**
	 * Computes the vertices in graph that are connected to the given source vertex.
	 * @param graph the graph
	 * @param source the source vertex
	 */
	public DepthFirstSearch_u1(Graph_u1 graph, int source) {
		marked = new boolean[graph.numberOfVertices()];
		edgeTo = new int[graph.numberOfVertices()];
		this.source = source;
		dfs(graph, source);
	}
	
	/**
	 * Depth first search from the vertex. Stores the path taken in an array {@code edgeTo[]}.
	 * @param graph the graph
	 * @param vertex the given vertex
	 */
	private void dfs(Graph_u1 graph, int vertex) {
		marked[vertex] = true;
		for (int w : graph.adj(vertex))
			if (!marked[w]) {
				edgeTo[w] = vertex;		//stores the node index in a int array
				dfs(graph, w);
			}
	}
	
	/**
	 * Is there a path between the source vertex and the parameter vertex?
	 * @param vertex the vertex
	 * @return {@code true} if there is a path, {@code false} if not.
	 */
	public boolean hasPathTo(int vertex) {
		return marked[vertex];
	}
	
	
	/**
	 * Returns a path between the source vertex {@code source} and the given vertex 
	 * {@code vertex}. Returns null if there is no path between the is no path between the
	 * source and the given vertex.
	 * @param vertex the vertex
	 * @return the sequence of vertices between the the source vertex and the given vertex.
	 */
	public Iterable<Integer> pathTo(int vertex){
		if (!hasPathTo(vertex))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		
		for (int x = vertex; x != source; x = edgeTo[x])
			path.push(x);
		path.push(source);
		return path;
	}
}
