//Bismillahir Rahmaanir Raheem
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Main
{
	static List <Integer> visited = new ArrayList<>();
	static List <Integer> finalList = new ArrayList<>();
	
	private static List<Integer> dijkstra(int[][] grid, List<Integer> intList, int src, int dst) //List<Integer> nodeList) 
	{
		int[] distance = new int[intList.size() + 1];
		int[] prev = new int[intList.size() + 1];
		
		visited.clear();
		finalList.clear();
		
		for(int i : intList)
		{
			distance[i] = Integer.MAX_VALUE;
			prev[i] = -1;
		}
		distance[src] = 0;
		
		while(!intList.isEmpty())
		{
			int lowestDistance = Integer.MAX_VALUE;
			int lowestNode = 0;
			int lowestNodeIndex = 0, j = -1;
			
			for(int i : intList)
			{
				j += 1;
				if(distance[i] < lowestDistance)
				{
					if(!visited.contains(i))
					{
						lowestDistance = distance[i];
						lowestNode = i;
						lowestNodeIndex = j;
					}
				}
			}
			
			if(lowestNode == dst)
			{
				finalList.add(lowestDistance);
				break;
			}
			
			visited.add(lowestNode);
			intList.remove(lowestNodeIndex);
			
			for(int i : intList)
			{
				if(grid[lowestNode][i] != Integer.MAX_VALUE)
				{
					int newDistance = distance[lowestNode] + grid[lowestNode][i];
					if(newDistance < distance[i])
					{
						distance[i] = newDistance;
						prev[i] = lowestNode;
					}
				}
			}
		}
		
		while(prev[dst] != -1)
		{
			finalList.add(dst);
			dst = prev[dst];
		}finalList.add(src);
		
		return finalList;
	}
	
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		int[][] intersection = new int[11][11];
		List <Integer> intList = new ArrayList<>();
		int testCase = 0;
		
		while(true)
		{
			int totalIntersection = reader.nextInt();
			if(totalIntersection == 0)	break;
			
			intList.clear();
			for(int thisIntersection = 1; thisIntersection <= totalIntersection; thisIntersection += 1)
			{
				Arrays.fill(intersection[thisIntersection], Integer.MAX_VALUE);
				intersection[thisIntersection][thisIntersection] = 0;
				intList.add(thisIntersection);
				
				int totalStreet = reader.nextInt();
				while(totalStreet > 0)
				{
					int nextIntersection = reader.nextInt();
					int delay = reader.nextInt();
					intersection[thisIntersection][nextIntersection] = delay;
					totalStreet -= 1;
				}
			}
			
			int src = reader.nextInt();
			int dst = reader.nextInt();
			
			List <Integer> ansList = dijkstra(intersection, intList, src, dst);
			int size = ansList.size();
			System.out.print("Case "+(++testCase)+": Path =");
			for(int i = size - 1; i > 0; i -= 1)
				System.out.print(" "+ansList.get(i));
			System.out.print(";");
			System.out.println(" "+ansList.get(0)+" second delay");
		}
		
		reader.close();
	}

}
