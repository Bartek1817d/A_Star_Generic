import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AStar {
	
	private Problem problem;
	private Queue<State> openSet = new PriorityQueue<State>();
	private Set<State> closedSet = new HashSet<State>();
	
	public AStar(Problem problem) {
		this.problem = problem;
	}
	
	

}
