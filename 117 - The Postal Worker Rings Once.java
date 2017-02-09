//Bismillahir Rahmaanir Raheem
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		String nput;
		String deadend = "deadend";
		
		boolean newCase = true;
		
		int[][] grid = new int[26][26];
		int[] degree = new int[26];
		int minimal = 0;
		
		List <Integer> nodeList = new ArrayList<>();
		
		while(reader.hasNext())
		{
			nput = reader.next();
			
			if(nput.equals(deadend))
			{
				int src = 0, dst = 0;
				boolean isOdd = false;
				for(int i = 0 ; i < 26; i += 1)
				{
					if(degree[i]%2 != 0)
					{
						if(isOdd)
						{
							dst = i;
							break;
						}
						else
						{
							src = i;
							isOdd = true;
						}
					}
				}
				
				if(isOdd)
				{
					//System.out.println(src +" "+ dst);
					//System.out.println((char)(src + 97) +" "+ (char)(dst + 97));
					minimal += dijkstra(grid, src, dst, nodeList);
				}
				
				System.out.println(minimal);
				
				newCase = true;
				continue;
			}
			
			if(newCase)
			{
				newCase = false;
				
				minimal = 0;
				Arrays.fill(degree, 0);
				nodeList.clear();
				
				for(int i = 0; i < 26; i += 1)
				{
					Arrays.fill(grid[i], Integer.MAX_VALUE);
					grid[i][i] = 0;
				}
				
			}
			
			int length = nput.length();
			minimal += length;
			
			int firstChar = (int)nput.charAt(0) - 97;
			int lastChar = (int)nput.charAt(length - 1) - 97;
			
			if(!nodeList.contains(firstChar))
				nodeList.add(firstChar);
			if(!nodeList.contains(lastChar))
				nodeList.add(lastChar);
			
			grid[firstChar][lastChar] = length;
			grid[lastChar][firstChar] = length;
			
			degree[firstChar] += 1;
			degree[lastChar] += 1;
		}
		
		reader.close();
	}

	private static int dijkstra(int[][] grid, int src, int dst, List<Integer> nodeList) 
	{
		int[] distance = new int[26];
		List <Integer> visited = new ArrayList<>();
		
		for(int i : nodeList)
		{
			distance[i] = Integer.MAX_VALUE;
		}
		distance[src] = 0;
		
		while(!nodeList.isEmpty())
		{
			int lowestDistance = Integer.MAX_VALUE;
			int lowestNode = 0;
			int lowestNodeIndex = 0, j = -1;
			
			for(int i : nodeList)
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
			
			if(lowestNode == dst)	return lowestDistance;
			
			visited.add(lowestNode);
			nodeList.remove(lowestNodeIndex);
			
			for(int i : nodeList)
			{
				if(grid[lowestNode][i] != Integer.MAX_VALUE)
				{
					distance[i] = Math.min(distance[i], distance[lowestNode] + grid[lowestNode][i]);
				}
			}
		}
		
		return 0;
	}

}
