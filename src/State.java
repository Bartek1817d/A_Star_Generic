
public class State implements Comparable<State> {

	private int x, y, vx, vy;
	private float g, h;

	public State(int x, int y, int vx, int vy) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}

	public State(int x, int y, int vx, int vy, float h) {
		this(x, y, vx, vy);
		this.h = h;
	}

	public State(int x, int y, int vx, int vy, float h, float g) {
		this(x, y, vx, vy, h);
		this.g = g;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVX() {
		return vx;
	}

	public void setVX(int vx) {
		this.vx = vx;
	}

	public int getVY() {
		return vy;
	}

	public void setVY(int vy) {
		this.vy = vy;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}

	@Override
	public boolean equals(Object other) {
		State otherState = (State) other;
		return x == otherState.getX() && y == otherState.getY() && vx == otherState.getVX() && vy == otherState.getVY();
	}

	@Override
	public int compareTo(State other) {
		float f = g + h;
		float otherf = other.getG() + other.getH();
		if (f < otherf)
			return 1;
		else if (f == otherf)
			return 0;
		else
			return -1;
	}

}
