package algorithm.interfaces;

import java.util.Set;

import algorithm.utilities.State;

public interface Problem {

	Set<State> getNeighborStates(State state);

	boolean isDestState(State state);

	public float heuresticFunction(State state);

	public State getInitState();

	public State getDestState();
}
