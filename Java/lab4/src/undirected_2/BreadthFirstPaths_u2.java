package undirected_2;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import java.net.URL;
import java.util.*;


public class BreadthFirstPaths_u2 {
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private final int source;		//source 

    /**
     * Computes the shortest path between the source vertex {@code s}
     * and every other vertex in the graph {@code graph}.
     * @param graph the graph
     * @param source the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public BreadthFirstPaths_u2(Graph_u2 graph, int source) {
        marked = new boolean[graph.numberOfVertices()];
        edgeTo = new int[graph.numberOfVertices()];
        this.source = source;
        bfs(graph, source);
    }

    // breadth-first search from a single source
    private void bfs(Graph_u2 graph, int source) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[source] = true;
        queue.enqueue(source);
        while(!queue.isEmpty()) {
        	int v = queue.dequeue();
        	for(int w : graph.adj(v))
        		if(!marked[w]) {
        			edgeTo[w] = v;
        			marked[w] = true;
        			queue.enqueue(w);
        		}
        }
    }

    /**
     * Is there a path between the source vertex {@code s} (or sources) and vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a path, and {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Returns a shortest path between the source vertex {@code s} (or sources)
     * and {@code v}, or {@code null} if no such path.
     * @param  v the vertex
     * @return the sequence of vertices on a shortest path, as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
        	return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
}
