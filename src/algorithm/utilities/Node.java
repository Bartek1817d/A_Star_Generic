package algorithm.utilities;

public class Node implements Comparable<Node> {
	private State state;
	private float g, h;

	public Node(State state) {
		super();
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	@Override
	public boolean equals(Object other) {
		Node OtherNode = (Node) other;
		return state.equals(OtherNode.getState());
	}

	@Override
	public int compareTo(Node other) {
		float f = g + h;
		float otherF = other.getG() + other.getH();
		if (f > otherF)
			return 1;
		else if (f == otherF)
			return 0;
		else
			return -1;
	}

	@Override
	public String toString() {
		return "[state: " + state + "], [g=" + g + "], [h=" + h + "], [f=" + (g + h) + "]";
	}

	/*
	 * public static void main(String argv[]) { Queue<Node> queue = new
	 * PriorityQueue<Node>();
	 * 
	 * Node node1 = new Node(new State(new Point<Integer>(1, 1), new
	 * Point<Integer>(2, 2))); Node node2 = new Node(new State(new
	 * Point<Integer>(1, 1), new Point<Integer>(2, 2)));
	 * 
	 * node1.setG(1); node2.setG(2);
	 * 
	 * node1.setH(2); node2.setH(2);
	 * 
	 * queue.add(node1); queue.add(node2);
	 * 
	 * System.out.println(queue); }
	 */
}
