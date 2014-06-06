package nodes;

import java.util.Iterator;

public interface NodeSpecialist <T extends Node> {
	public int getHeuristicDist(T start, T goal);
	public Iterator<T> getAdjacents(T node);
	public int getDistBetween(T node, T neighbour);
}
