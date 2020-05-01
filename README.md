# maze-solver
Utilizes a breadth-first search to determine the shortest path from the start of a maze to the finish.

**This code uses classes from the 'algs4' Java library. It can be downloaded here: https://algs4.cs.princeton.edu/code/**

The only method in 'MazeSolver', 'solve()', accepts a single two-dimensional array representing a maze. It then computes and returns a solution as a string where each character in the string represents a movement towards the end of the maze.

```
	public static void simpleTest_1() {
		char[][] maze = {
				{' ', ' ', 's', ' ', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'f', ' ', ' '},
		};
		String solution = MazeSolver.solve(maze);
		System.out.println(solution);
	}
```

The example method above, for instance, will print 'DDDD' when called, indicating four downward movements. The 's' character represents the starting point, and 'f' represents the finish.

```
	public static void simpleTest_2() {
		char[][] maze = {
				{' ', ' ', 's', ' ', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', '*', '*', '*', ' '},
				{' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'f', ' ', ' '},
		};
		String solution = MazeSolver.solve(maze);
		System.out.println(solution);
	}
```

The asterisks in the above example indicate obstructions. The solution path may not pass through the obstruction characters. The solution path must also stay within the bounds of the maze. So this method, when called, will print 'DRRDDDLL'.

```
	public static void simpleTest_3() {
		char[][] maze = {
				{' ', ' ', 's', '*', ' '},
				{' ', '*', '*', '*', ' '},
				{' ', ' ', ' ', ' ', '*'},
				{'*', ' ', '*', ' ', '*'},
				{' ', '*', 'f', ' ', ' '},
		};
		String solution = MazeSolver.solve(maze);
		System.out.println(solution);
	}
```

Given mazes can be (within reason) to any degree of size and complexity. If there is no path from 's' to 'f', 'solve()' will return ```null```. A call to the above method will print 'LLDDRRRDDL'.

## Solution Legend:

  *U -> Up.*

  *D -> Down.*

  *L -> Left.*

  *R -> Right.*
