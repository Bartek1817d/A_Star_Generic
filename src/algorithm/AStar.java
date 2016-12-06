package algorithm;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import algorithm.interfaces.Problem;
import algorithm.utilities.Node;
import algorithm.utilities.State;

public class AStar {

	private Problem problem;
	private Queue<Node> openSet = new PriorityQueue<Node>();
	private Set<Node> closedSet = new HashSet<Node>();

	public AStar(Problem problem) {
		this.problem = problem;
	}

	public Node run() {
		openSet.add(new Node(problem.getInitState()));

		while (!openSet.isEmpty()) {
			Node node = openSet.poll();
			//System.out.println("Processing node: " + node);
			if (problem.isDestState(node.getState())) {
				System.out.println("Found");
				return node;
			}
			closedSet.add(node);
			float g = node.getG();
			Set<State> neighbors = problem.getNeighborStates(node.getState());
			for (State neighbor : neighbors) {
				//System.out.println("Processing neighbor: " + neighbor);
				Node neigh_node = new Node(neighbor);
				if (closedSet.contains(neigh_node)) {
					continue;
				}
				if (!openSet.contains(neigh_node)) {
					neigh_node.setParent(node);
					neigh_node.setH(problem.calculateHeuristic(neighbor));
					neigh_node.setG(g + problem.calculateDistance(neighbor, node.getState()));
					openSet.add(neigh_node);
				} else {
					float newG = g + problem.calculateDistance(neighbor, node.getState());
					if (newG < neigh_node.getG()) {
						neigh_node.setParent(node);
						neigh_node.setG(newG);
					}
				}
			}
		}
		return null;
	}

	public void generatePath(Node node) {
		if (node.getParent() != null)
			generatePath(node.getParent());

		System.out.println(node);
	}
	
}
