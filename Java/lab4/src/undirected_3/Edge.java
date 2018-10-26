package undirected_3;

public class Edge implements Comparable<Edge> {
	private final int vertex;
	private final int otherVertex;
	private final double weight;

	public Edge(int vertex, int otherVertex, double weight) {
		this.vertex = vertex;
		this.otherVertex = otherVertex;
		this.weight = weight;
	} 
	
	public double weight() {
		return weight;
	}
	
	public int either() {
		return vertex;
	}
	
	public int other(int inputVertex) {
		if(inputVertex == vertex)
			return otherVertex;
		
		else if(inputVertex == otherVertex)
			return vertex;
		
		else throw new RuntimeException("Inconsistent edge");
	}
	
	public int compareTo (Edge that) {
		if(this.weight() < that.weight())
			return -1;
		else if (this.weight() > that.weight())
			return +1;
		else
			return 0;
	}
	
	public String toString() {
		return String.format("%d-%d %.2f", vertex, otherVertex, weight);
	}
}
