Project name: Generic A*

Description: JAVA implementation of a generic "A star" algorithm that is used in simulated cars pathfinding.

How to use:
Run in cosnole mode Main.java with proper ".bmp" file, default is "resources/test1000x1000.bmp"

/resources folder is containing set of ".bmp" files for testing purposes

Set of rules:
- Cars can have diffrent speeds
- Cars can jump above short walls
- In one jump car can change his speed by 1 point

Heuristic function description:
Shortest distance in one axis

Avialable iterfaces:
- Problem 
     - Set<State> getNeighborStates(State state);
     - boolean isDestState(State state);
     - float calculateHeuristic(State state);
     - float calculateDistance(State state1, State state2);
     - State getInitState();
     - State getDestState();
  
