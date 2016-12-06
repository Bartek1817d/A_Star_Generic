package algorithm;

import java.io.IOException;

import algorithm.implementations.ProblemImpl;
import algorithm.utilities.Node;

public class Main {

	public static void main(String[] args) throws IOException {
		ProblemImpl problem = new ProblemImpl();
		problem.praseFromBMP("resources/test07.bmp");
		System.out.println("Starting point: " + problem.getInitState().getPosition());
		System.out.println("Destination point: " + problem.getDestState().getPosition());
		AStar aStar = new AStar(problem);
		Node destNode = aStar.run();
		aStar.generatePath(destNode);
	}

}
