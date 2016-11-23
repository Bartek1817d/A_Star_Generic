package algorithm.utilities;

public class State {

	private Point<Integer> position, velocity;

	public State(Point<Integer> position, Point<Integer> velocity) {
		this.position = position;
		this.velocity = velocity;
	}

	public Point<Integer> getPosition() {
		return position;
	}

	public void setPosition(Point<Integer> position) {
		this.position = position;
	}

	public Point<Integer> getVelocity() {
		return velocity;
	}

	public void setVelocity(Point<Integer> velocity) {
		this.velocity = velocity;
	}

	@Override
	public boolean equals(Object other) {
		State otherState = (State) other;
		return position.equals(otherState.getPosition()) && velocity.equals(otherState.getVelocity());
	}

	@Override
	public String toString() {
		return "position=" + position + ", " + "velocity=" + velocity;
	}

	/*
	 * @Override public int compareTo(State other) { float f = g + h; float
	 * otherf = other.getG() + other.getH(); if (f < otherf) return 1; else if
	 * (f == otherf) return 0; else return -1; }
	 */

	/*
	 * public static void main(String argv[]) { State state1 = new State(new
	 * Point<Integer>(0, 0), new Point<Integer>(1, 1)); State state2 = new
	 * State(new Point<Integer>(0, 0), new Point<Integer>(1, 1));
	 * 
	 * System.out.println(state1.equals(state2)); }
	 */

}
