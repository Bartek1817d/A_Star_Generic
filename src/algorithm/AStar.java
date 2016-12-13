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
		Node initNode = new Node(problem.getInitState());
		initNode.setH(problem.calculateHeuristic(initNode.getState()));
		openSet.add(initNode);

		while (!openSet.isEmpty()) {
			Node node = openSet.poll();
			if (problem.isDestState(node.getState())) {
				System.out.println("Found");
				return node;
			}
			closedSet.add(node);
			float g = node.getG();
			Set<State> neighbors = problem.getNeighborStates(node.getState());
			for (State neighbor : neighbors) {
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

	public int generatePath(Node node, int steps) {
		int result = steps;
		if (node.getParent() != null)
			result = generatePath(node.getParent(), steps + 1);

		System.out.println(node);
		return result;
	}
	
}
