package algorithm.utilities;

public class Point<T> {
	private T x, y;

	public Point(T x, T y) {
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object other) {
		@SuppressWarnings("rawtypes")
		Point otherPoint = (Point) other;
		return x == otherPoint.getX() && y == otherPoint.getY();
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
