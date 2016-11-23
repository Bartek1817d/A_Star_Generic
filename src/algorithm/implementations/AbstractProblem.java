package algorithm.implementations;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

import algorithm.interfaces.Problem;
import algorithm.utilities.Point;
import algorithm.utilities.State;

public abstract class AbstractProblem implements Problem {
	private State initState;
	private State destState;
	private char map[][];

	public void praseFromBMP(String path) throws IOException {

		BufferedImage image = ImageIO.read(new File(path));
		map = new char[image.getWidth()][image.getHeight()];
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				int color = image.getRGB(x, y);
				if (color == Color.BLACK.getRGB()) {
					map[x][y] = 1;
				} else if (color == Color.GREEN.getRGB()) {
					initState = new State(new Point<Integer>(x, y), new Point<Integer>(0, 0));
					map[x][y] = 2;
				} else if (color == Color.RED.getRGB()) {
					destState = new State(new Point<Integer>(x, y), new Point<Integer>(0, 0));
					map[x][y] = 3;
				} else {
					map[x][y] = 0;
				}
			}
		}
	}

	@Override
	public Set<State> getNeighborStates(State state) {
		Set<State> states = new HashSet<State>();
		int middleX = state.getPosition().getX() + state.getVelocity().getX();
		int middleY = state.getPosition().getY() + state.getVelocity().getY();
		for (int x = middleX - 1; x <= middleX + 1; x++) {
			for (int y = middleY - 1; y <= middleY + 1; y++) {
				if (map[x][y] != 1) {
					Point<Integer> newPosition = new Point<Integer>(x, y);
					Point<Integer> newVelocity = new Point<Integer>(x - state.getPosition().getX(),
							y - state.getPosition().getY());
					states.add(new State(newPosition, newVelocity));
				}
			}
		}
		return states;
	}

	@Override
	public boolean isDestState(State state) {
		return state.equals(destState);
	}

	@Override
	public abstract float heuresticFunction(State state);

	@Override
	public State getInitState() {
		return initState;
	}

	@Override
	public State getDestState() {
		return destState;
	}

}
