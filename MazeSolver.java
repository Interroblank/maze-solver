// Interroblank, 2019

package MazeSolver;

import java.util.TreeSet;
import java.util.ArrayList;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.BreadthFirstPaths;

public class MazeSolver {
	
	public static String solve(char[][] grid) {
		
		int vert = 0;
		
		// Loop through the 'grid' and determine number of vertices.
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				vert++;
			}
		}
		
		// Construct a graph with the appropriate number of vertices.
		Graph gridGraph = new Graph(vert);
		
		// As edges are flung into the graph, the start, finish, and obstruction values will be held here.
		// Empty spaces will also be noted.
		int start = 0;
		int finish = 0;
		TreeSet<Integer> obstructions = new TreeSet<Integer>();
		TreeSet<Integer> available = new TreeSet<Integer>();
		
		// Initialize 'vertNum' counter, starting from zero.
		int vertNum = -1;
		
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				// Fling each value from the grid into an appropriate holder.
				
				vertNum++;
				
				if (grid[i][j] == 's')
					{ start = vertNum; }
					// System.out.println("Start Identified: " + start); }
				if (grid[i][j] == 'f')
					{ finish = vertNum; }
					// System.out.println("Finish Identified: " + finish); }
				if (grid[i][j] == '*')
					{ obstructions.add(vertNum); }
					// System.out.println("Obstruction Added: " + vertNum); }
				else {available.add(vertNum);}
			}
		}
		
		// Reset 'vertNum' counter.
		vertNum = -1;
		
		// Check each value in the grid against adjacent values (left, right, above, and below).
		// Using the 'vertNum' information of each value, determine whether or not to draw an edge.
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				
				vertNum++;
				
				// Conditional block for catching obstructions.

				if(obstructions.contains(vertNum) == true)
				{
					continue;
				}
				
				// Block for processing start, finish, and empty spaces.
				else
				{
					// If the value to the left is not an obstruction (and exists), draw an edge.
					if(obstructions.contains(vertNum - 1) == false)
					{ 
						if((vertNum - 1) == start || (vertNum - 1) == finish || available.contains(vertNum - 1) == true)
						{
							// This conditional block exists to prevent edges from looping around the outside of the 'grid'.
							if(vertNum % grid.length != 0)
							{ gridGraph.addEdge(vertNum, vertNum - 1); }
						}
					}
					
					// If the value to the right is not an obstruction (and exists), draw an edge.
					if(obstructions.contains(vertNum + 1) == false)
					{ 
						if((vertNum + 1) == start || (vertNum + 1) == finish || available.contains(vertNum + 1) == true)
						{
							// This conditional block exists to prevent edges from looping around the outside of the 'grid'.
							if(((vertNum + 1) % grid.length) != 0)
							{ gridGraph.addEdge(vertNum, vertNum + 1); }
						}
					}
					
					// If the value above is not an obstruction (and exists), draw an edge.
					if(obstructions.contains(vertNum - grid[i].length) == false)
					{ 
						if((vertNum - grid[i].length) == start || (vertNum - grid[i].length) == finish || available.contains(vertNum - grid[i].length) == true)
						{ gridGraph.addEdge(vertNum, vertNum - grid[i].length); }
					}
					
					// If the value below is not an obstruction (and exists), draw an edge.
					if(obstructions.contains(vertNum + grid[i].length) == false)
					{ 
						if((vertNum + grid[i].length) == start || (vertNum + grid[i].length) == finish || available.contains(vertNum + grid[i].length) == true)
						{ gridGraph.addEdge(vertNum, vertNum + grid[i].length); }
					}
				}
			}
		}
		
		// Initialize a 'BreadthFirstPaths' object with the resulting graph.
		// Determine the shortest path from 'start' to 'finish'.
		BreadthFirstPaths solver = new BreadthFirstPaths(gridGraph, start);
		Iterable<Integer> solution = solver.pathTo(finish);
		
		// Returns 'null' if there is no solution.
		if(solution == null)
		{ return null; }
	
		// System.out.println("'BreadthFirstPaths' Result: ");
		// solution.forEach(System.out::println);
		
		// Fling values from the 'solution' object into an 'ArrayList<Integer>' and then a generic array.
		ArrayList<Integer> translator = new ArrayList<Integer>();
		solution.forEach(translator::add);
		Object[] translatorArray = translator.toArray();
		
		// for(int i = 0; i < translatorArray.length; i++)
		// { System.out.print(translatorArray[i] + ", "); }
		// System.out.println("\n");
		
		String translatedSolution = "";
		
		// Translate the resulting array into an appropriate solution string.
		// Determine direction by looking at numerical difference between 'vertNum' of adjacent points.
		for(int i = 0; i < translatorArray.length - 1; i++)
		{
			
			int current = (int) translatorArray[i];
			int next = (int) translatorArray[i + 1];
			
			// If the next value is to the left, add an 'L' to 'translatedSolution'.
			if(next + 1 == current)
			{ translatedSolution = translatedSolution + "L"; }
			
			// If the next value is to the right, add an 'R' to 'translatedSolution'.
			if(next - 1 == current)
			{ translatedSolution = translatedSolution + "R"; }
			
			// If the next value is above, add 'D' to 'translatedSolution'.
			if(next - grid.length == current)
			{ translatedSolution = translatedSolution + "D"; }
			
			// If the next value is below, add 'U' to 'translatedSolution'.
			if(next + grid.length == current)
			{ translatedSolution = translatedSolution + "U"; }
		}
		
		// Return 'translatedSolution'.
		// System.out.println("Returned Solution: " + translatedSolution);
		return(translatedSolution);
		
	}
	
}