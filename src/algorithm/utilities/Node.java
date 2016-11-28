package algorithm.utilities;

public class Node implements Comparable<Node> {
	
	private Node parent;
	private State state;
	private float g, h;

	public Node(State state) {
		this.state = state;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public float getF() {
		return g + h;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(g);
		result = prime * result + Float.floatToIntBits(h);
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (Float.floatToIntBits(g) != Float.floatToIntBits(other.g))
			return false;
		if (Float.floatToIntBits(h) != Float.floatToIntBits(other.h))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public int compareTo(Node other) {
		if (getF() > other.getF())
			return 1;
		else if (getF() == other.getF())
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
