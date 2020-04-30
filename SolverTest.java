// Interroblank, 2019

package MazeSolver;

public class SolverTest {
	
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

	public static void main(String[] args) {
		simpleTest_1();
		simpleTest_2();
		simpleTest_3();
	}
}