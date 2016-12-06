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
		return state.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return state.equals(((Node) obj).getState());
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

}
