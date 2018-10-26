package directed_2;

import edu.princeton.cs.algs4.Stack;

public class DirectedCycle_d2 {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	private boolean[] onStack;
	
	public DirectedCycle_d2(Digraph_d2 graph) {
		onStack = new boolean[graph.numberOfVertices()];
		edgeTo = new int[graph.numberOfVertices()];
		marked = new boolean[graph.numberOfVertices()];
		for(int i = 0; i < graph.numberOfVertices(); i++) {
			if(!marked[i])
				dfs(graph, i);
		}
	}
	
	private void dfs(Digraph_d2 graph, int from) {
		onStack[from] = true;
		marked[from] = true;
		for(int current : graph.adj(from)) 
			if(this.hasCycle())
				return;
			else if(!marked[current]) {
				edgeTo[current] = from;
				dfs(graph, current);
			} else if(onStack[current]) {
				cycle = new Stack<Integer>();
				for(int i = from; i != current; i = edgeTo[i]) {
					cycle.push(i);
				}
				cycle.push(current);
				cycle.push(from);
			}
		onStack[from] = false;
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}

}
