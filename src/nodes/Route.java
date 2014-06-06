package nodes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;


public class Route <T extends Node> implements Iterable<T> {

	private LinkedList<T> nodes;
	
	public Route(Map<T, T> cameFrom, T goal) {
		nodes = reconstructRoute(cameFrom, goal);
	}

	private LinkedList<T> reconstructRoute(Map<T, T> cameFrom, T currentNode) {
		LinkedList<T> result = new LinkedList<T>();
		return reconstructRouteIn(cameFrom, currentNode, result);
	}

	private LinkedList<T> reconstructRouteIn(Map<T, T> cameFrom, T currentNode,
			LinkedList<T> nodes) {
		if (cameFrom.containsKey(currentNode))
			reconstructRouteIn(cameFrom, cameFrom.get(currentNode), nodes);
		nodes.addLast(currentNode);
		return nodes;
	}

	@Override
	public Iterator<T> iterator() {
		return nodes.iterator();
	}
}
