package algorithm.implementations;

import algorithm.utilities.State;

public class ProblemImpl extends AbstractProblem {

	@Override
	public float calculateHeuristic(State state) {

		int x = state.getPosition().getX();
		int y = state.getPosition().getY();
		int destX = destState.getPosition().getX();
		int destY = destState.getPosition().getY();

		int vx = state.getVelocity().getX();
		int vy = state.getVelocity().getY();

		int diffX = destX - x;
		int diffY = destY - y;

		float resX = 0, resY = 0;

		if (diffX > 0)
			resX = (-2 * vx + 1 + (float) Math.sqrt(4 * vx * vx - 4 * vx + 1 + 8 * diffX)) / 2;
		else if (diffX < 0)
			resX = (-2 * vx - 1 + (float) Math.sqrt(4 * vx * vx + 4 * vx + 1 - 8 * diffX)) / -2;

		if (diffY > 0)
			resY = (-2 * vy + 1 + (float) Math.sqrt(4 * vy * vy - 4 * vy + 1 + 8 * diffY)) / 2;
		else if (diffY < 0)
			resY = (-2 * vy - 1 + (float) Math.sqrt(4 * vy * vy + 4 * vy + 1 - 8 * diffY)) / -2;

		return Math.max(resX, resY);
	}

	@Override
	public float calculateDistance(State state1, State state2) {
		return Math.abs(state1.getPosition().getX() - state2.getPosition().getX())
				+ Math.abs(state1.getPosition().getY() - state2.getPosition().getY());
	}

}
