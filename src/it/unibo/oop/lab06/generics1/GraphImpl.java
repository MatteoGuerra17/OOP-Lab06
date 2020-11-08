package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

//	public List<String> l1 = new LinkedList<>();
	Map<N, Set<N>> grafo = new HashMap<>();
	
	public void addNode(N node) {
		if(!grafo.containsKey(node)) {
			grafo.put(node, null);
		}
	}

	public void addEdge(N source, N target) {
		if(grafo.get(source) == null) {
			Set<N> edge = new HashSet<>();
			edge.add(target);
			grafo.put(source, edge);
		} else {
			grafo.get(source).add(target);
		}
	}

	public Set<N> nodeSet() {
		return new HashSet<>(grafo.keySet());
	}

	public Set<N> linkedNodes(N node) {
		return grafo.get(node);
	}

	public List<N> getPath(N source, N target) {
//		List<N> l = new ArrayList<>();
//		if(source.equals(grafo.containsKey(source)) && target.equals(grafo.get(target))) {
//			l.add(source);
//			l.add(target);
//			return l;
//		} else {
//			
//		}
		return null;
	}

}
