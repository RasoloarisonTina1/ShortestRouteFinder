package nodes;

public abstract class RouteFinder <T extends Node> {
	private final NodeSpecialist<T> helper;
	
	public RouteFinder (NodeSpecialist<T> helper) {
		this.helper = helper;
	}
	
	public NodeSpecialist<T> getHelper() {
		return helper;
	}

	public abstract <S extends T> Route<T> getShortestRoute(S start, S goal);
}
