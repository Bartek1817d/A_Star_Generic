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

		// algorithm to implement
		while (!openSet.isEmpty()) {
			Node node = openSet.poll();
			if (problem.isDestState(node.getState()) && !openSet.isEmpty() && openSet.peek().getF() > node.getF()) {
				System.out.println("Found");
				return node;
			}
			closedSet.add(node);
			Set<State> neighbors = problem.getNeighborStates(node.getState());
			for (State neighbor : neighbors) {
				Node neigh_node = new Node(neighbor);
				if (closedSet.contains(neigh_node))
					continue;
				if (!openSet.contains(neigh_node)) {
					neigh_node.setParent(node);
					neigh_node.setH(problem.calculateHeuristic(neighbor));
					neigh_node.setG(problem.calculateDistance(neighbor, node.getState()));
					openSet.add(neigh_node);
				} else {
					float newG = problem.calculateDistance(neighbor, node.getState());
					if (newG < neigh_node.getG()) {
						neigh_node.setParent(node);
						neigh_node.setG(newG);
					}
				}
			}
		}
		return null;
	}

	/*public static void main(String args[]) {
		Set<Node> closedSet = new HashSet<Node>();
		State state1 = new State(new Point<Integer>(1, 1), new Point<Integer>(1, 1));
		State state2 = new State(new Point<Integer>(1, 1), new Point<Integer>(1, 1));
		Node node1 = new Node(state1);
		Node node2 = new Node(state2);
		closedSet.add(node1);
		System.out.println(state1.equals(state2));
	}*/

}
