package algorithm;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import algorithm.interfaces.Problem;
import algorithm.utilities.Node;

public class AStar {

	private Problem problem;
	private Queue<Node> openSet = new PriorityQueue<Node>();
	private Set<Node> closedSet = new HashSet<Node>();

	public AStar(Problem problem) {
		this.problem = problem;
	}

	public void run() {
		openSet.add(new Node(problem.getInitState()));
		
		// algorithm to implement
		
		
	}

}
