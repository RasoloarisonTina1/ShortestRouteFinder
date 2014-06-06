package test;

import java.util.*;

import nodes.Node;

public class ConcreteNode implements Node {
	private static final Set<ConcreteNode> ALL_NODES = new HashSet<ConcreteNode>();
	
	private final String name;
	private final java.util.Map<ConcreteNode, Integer> adjacents = new HashMap<ConcreteNode, Integer>();	
	public ConcreteNode(String name) {
		this.name = name;
		ALL_NODES.add(this);
	}
	
	public static Set<ConcreteNode> getAllNodes() {
		return ALL_NODES;
	}

	public String getName() {
		return name;
	}
	
	public void addAdjacent(ConcreteNode node, Integer distance) {
		adjacents.put(node, distance);
	}

	public Iterator<ConcreteNode> getAdjacents() {
		return adjacents.keySet().iterator();
	}
	
	public int getDistTo(ConcreteNode neighbour) {
		return adjacents.get(neighbour);
	}
}
