package algorithm;

import java.io.IOException;

import algorithm.implementations.ProblemImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		ProblemImpl problem = new ProblemImpl();
		problem.praseFromBMP("resources/example.bmp");
		AStar aStar = new AStar(problem);
		aStar.run();
	}

}
