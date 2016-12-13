package algorithm.implementations;

import algorithm.utilities.State;

public class ProblemImpl extends AbstractProblem {

	private static long heuristicCalls = 0;
	
	public static long getHeuristicCalls() {
		return heuristicCalls;
	}

	@Override
	public float calculateHeuristic(State state) {
		heuristicCalls++;
		int minStepsX = calculateMinNumberOfSteps(state.getPosition().getX(), state.getVelocity().getX(),
				destState.getPosition().getX());
		int minStepsY = calculateMinNumberOfSteps(state.getPosition().getY(), state.getVelocity().getY(),
				destState.getPosition().getY());
		return Math.max(minStepsX, minStepsY);
	}

	@Override
	public float calculateDistance(State state1, State state2) {
		// return Math.abs(state1.getPosition().getX() -
		// state2.getPosition().getX())
		// + Math.abs(state1.getPosition().getY() -
		// state2.getPosition().getY());
		return 1;
	}
	
	private int calculateMinNumberOfSteps(int start, int speed, int end) {
		int distance = Math.abs(start - end);
		int speedTowardsTarget = speed;
		if(end < start) {
			speedTowardsTarget = -speedTowardsTarget;
		}
		return calculateMinNumberOfSteps(distance, speedTowardsTarget);
	}
	
	private int calculateMinNumberOfSteps(int distance, int speedTowardsTarget) {
		if(speedTowardsTarget < 0) {
			int speedAwayFromTarget = -speedTowardsTarget;
			return minStepsToGoThrough(distanceWhileStoppingFrom(speedAwayFromTarget) + distance) + speedAwayFromTarget;
		} else {
			int distanceWhileStoppingFromStartSpeed = distanceWhileStoppingFrom(speedTowardsTarget);
			if(distanceWhileStoppingFromStartSpeed > distance) {
				return minStepsToGoThrough(distanceWhileStoppingFromStartSpeed - distance) + speedTowardsTarget;
			} else {
				return minStepsToGoThroughStartingAtVo(distance - distanceWhileStoppingFromStartSpeed, speedTowardsTarget) + speedTowardsTarget;
			}
		}
	}
	
	private int distanceWhileStoppingFrom(int v) {
		return v2o(v);
	}
	
	private int minStepsToGoThrough(int x) {
		return Math.min(o2v2oSteps(x), o2vv2oSteps(x));
	}
	
	private int minStepsToGoThroughStartingAtVo(int x, int v0) {
		return Math.min(vo2v2voSteps(x, v0), vo2vv2voSteps(x, v0));
	}
	
	private int v2o(int v) {
		return v * (v - 1) / 2;
	}
	
	private int o2v2oSteps(int x) {
		return (int) Math.ceil(2 * Math.sqrt(x));
	}
	
	private int o2vv2oSteps(int x) {
		return (int) Math.ceil(Math.sqrt(1 + 4 * x));
	}
	
	private int vo2v2voSteps(int x, int v0) {
		return (int) Math.ceil(2 * (Math.sqrt(x + v0 * v0) - v0 * v0));
	}
	
	private int vo2vv2voSteps(int x, int v0) {
		return (int) Math.ceil(Math.sqrt(1 + 4 * (x + v0 * v0)) - 2 * v0 * v0);
	}

}
