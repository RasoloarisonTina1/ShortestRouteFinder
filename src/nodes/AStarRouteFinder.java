package nodes;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class AStarRouteFinder <T extends Node> extends RouteFinder<T> {

	private Set<T> closedSet;	// The set of nodes already evaluated.
	private Set<T> openSet;	// The set of tentative nodes to be evaluated, initially containing the start node
	private Map<T, T> cameFrom;	// The map of navigated nodes.
	
	private Map<T, Integer> gScore;	// Cost from start along best known path.
	private Map<T, Integer> fScore;	// Estimated total cost from start to goal through y.
	
	public AStarRouteFinder(NodeSpecialist<T> helper) {
		super(helper);
	}

	@Override
	public <S extends T> Route<T> getShortestRoute(S start, S goal) {
		init(start, goal);
		while (! openSet.isEmpty()) {
			T currentNode = getLowestScore(openSet, fScore);	//the node in openset having the lowest f_score[] value
			if (currentNode.equals(goal))
				return new Route<T>(cameFrom, goal);
			openSet.remove(currentNode);
			closedSet.add(currentNode);
			Iterator<T> it = getHelper().getAdjacents(currentNode);
			while (it.hasNext()) {
				T neighbour = it.next();
				if (closedSet.contains(neighbour))
					continue;
				int tentativeGScore = gScore.get(currentNode) + getHelper().getDistBetween(currentNode, neighbour);
				if ((! openSet.contains(neighbour)) || (tentativeGScore <= gScore.get(neighbour))) {
					cameFrom.put(neighbour, currentNode);
					gScore.put(neighbour, tentativeGScore);
					fScore.put(neighbour, gScore.get(neighbour) + getHelper().getHeuristicDist(neighbour, goal));
					if (! openSet.contains(neighbour))
						openSet.add(neighbour);
				}
			}
		}
		
		return null;
	}

	private void init(T start, T goal) {
		this.closedSet = new HashSet<T>();
		this.openSet = new HashSet<T>();
		this.openSet.add(start);
		this.cameFrom = new HashMap<T, T>();
		this.gScore = new HashMap<T, Integer>();
		gScore.put(start, 0);
		this.fScore = new HashMap<T, Integer>();
		fScore.put(start, gScore.get(start) + getHelper().getHeuristicDist(start, goal));
	}

	private T getLowestScore(Set<T> set, Map<T, Integer> scores) {
		int lowestScore = Integer.MAX_VALUE;
		T bestNode = null;
		for (T currentNode : set) {
			int currentScore = scores.get(currentNode);
			if (currentScore < lowestScore) {
				lowestScore = currentScore;
				bestNode = currentNode;
			}
		}
		return bestNode;
	}
}
