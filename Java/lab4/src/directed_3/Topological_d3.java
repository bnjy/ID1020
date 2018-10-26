package directed_3;

import edu.princeton.cs.algs4.*;

public class Topological_d3 {
	private Iterable<Integer> order;
	
    /**
     * Determines whether the graph has a topological order and, if so,
     * finds such a topological order.
     * @param graph the digraph
     */
	public Topological_d3(Digraph_d3 graph) {
		DirectedCycle_d3 cycleFinder = new DirectedCycle_d3(graph);
		if(!cycleFinder.hasCycle()) {
			DepthFirstOrder_d3 dfs = new DepthFirstOrder_d3(graph);
			order = dfs.reversePost();
		}
	}
	
    /**
     * Returns a topological order if the digraph has a topologial order.
     * @return a topological order of the vertices (as an interable).
     */
	public Iterable<Integer> order(){
		return order;
	}
}
