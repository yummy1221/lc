package algorithm;

import java.util.*;
// undirected graph
public class Graph {
	private final int V;	// number of vertices
	private HashSet<Integer>[] adj;		// adjacent vertex
	
	public Graph(int V) {
		this.V = V;
		adj = (HashSet<Integer>[]) new HashSet[V];
		for(int v = 0; v < V; v++) {
			adj[v] = new HashSet<Integer>();
		}
	}

	public void addEdge(int v1, int v2) {
		adj[v1].add(v2);
		adj[v2].add(v1);
	}
	
	// Iterator for vertices adjacent to v
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}
