package test;

import java.util.Iterator;

import nodes.NodeSpecialist;

public class Map implements NodeSpecialist<ConcreteNode> {
	
	@Override
	public int getHeuristicDist(ConcreteNode start, ConcreteNode goal) {
		return 0;
	}

	@Override
	public Iterator<ConcreteNode> getAdjacents(ConcreteNode node) {
		return node.getAdjacents();
	}

	@Override
	public int getDistBetween(ConcreteNode node, ConcreteNode neighbour) {
		return node.getDistTo(neighbour);
	}

}
