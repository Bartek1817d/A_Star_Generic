package algorithm.interfaces;

import java.util.Set;

import algorithm.utilities.State;

public interface Problem {

	Set<State> getNeighborStates(State state);

	boolean isDestState(State state);

	public float calculateHeuristic(State state);
	
	public float calculateDistance(State state1, State state2);

	public State getInitState();

	public State getDestState();
}
