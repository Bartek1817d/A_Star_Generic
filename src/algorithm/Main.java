package algorithm;

import java.io.IOException;

import algorithm.implementations.ProblemImpl;
import algorithm.utilities.Node;

public class Main {

	public static void main(String[] args) throws IOException {
		ProblemImpl problem = new ProblemImpl();
		problem.praseFromBMP("resources/test06.bmp");
		System.out.println("Starting point: " + problem.getInitState().getPosition());
		System.out.println("Destination point: " + problem.getDestState().getPosition());
		AStar aStar = new AStar(problem);
		long t1 = System.currentTimeMillis();
		Node destNode = aStar.run();
		long t2 = System.currentTimeMillis();
		aStar.generatePath(destNode);
		System.out.println("Time: " + (t2 - t1) / 1000.0 + "s");
	}
}
