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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((velocity == null) ? 0 : velocity.hashCode());
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
		State other = (State) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (velocity == null) {
			if (other.velocity != null)
				return false;
		} else if (!velocity.equals(other.velocity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "position=" + position + ", " + "velocity=" + velocity;
	}

}
