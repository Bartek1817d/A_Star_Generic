import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

public abstract class ProblemImpl implements Problem {
	private State initialState;
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
					float H = heuresticFunction(x, y, 0, 0);
					initialState = new State(x, y, 0, 0, H, H);
					map[x][y] = 2;
				} else if (color == Color.RED.getRGB()) {
					destState = new State(x, y, 0, 0);
					map[x][y] = 3;
				} else {
					map[x][y] = 0;
				}
			}
		}
	}

	Set<State> getNeighborStates(State state) {
		Set<State> states = new HashSet<State>();
		int middleX = state.getX() + state.getVX();
		int middleY = state.getY() + state.getVY();
		for (int x = middleX - 1; x <= middleX + 1; x++) {
			for (int y = middleY - 1; y <= middleY + 1; y++) {
				if (map[x][y] != 0) {
					int newVX = x - state.getX();
					int newVY = y - state.getY();
					states.add(new State(x, y, newVX, newVY, heuresticFunction(x, y, newVX, newVY),
							heuresticFunction(state.getX(), state.getY(), x, y)));
				}
			}
		}
		return states;
	}

	public abstract float heuresticFunction(int x, int y, int vx, int vy);

	public abstract float distanceFunction(int x1, int y1, int x2, int y2);

	public State getInitialState() {
		return initialState;
	}

	public State getDestState() {
		return destState;
	}
	
	

}
