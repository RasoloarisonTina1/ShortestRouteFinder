package test;

import java.util.Iterator;

import nodes.AStarRouteFinder;
import nodes.Route;
import nodes.RouteFinder;

public class Launcher {
	public static void main(String[] args) {
		ConcreteNode a, b, c, d, e;
		a = new ConcreteNode("A");
		b = new ConcreteNode("B");
		c = new ConcreteNode("C");
		d = new ConcreteNode("D");
		e = new ConcreteNode("E");

		a.addAdjacent(b, 5);
		b.addAdjacent(d, 5);
		b.addAdjacent(c, 15);
		c.addAdjacent(e, 15);
		d.addAdjacent(e, 10);

		RouteFinder<ConcreteNode> router = new AStarRouteFinder<ConcreteNode>(
				new Map());
		Route<ConcreteNode> route = router.getShortestRoute(a, e);

		if (route == null) {
			System.out.println("No solution found");
		} else {
			Iterator<ConcreteNode> it = route.iterator();
			while (it.hasNext()) {
				ConcreteNode node = it.next();
				System.out.print(node.getName() + " --> ");
			}
			System.out.println("Destination found");
		}
	}
}
