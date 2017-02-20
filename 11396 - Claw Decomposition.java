//Bismillahir Rahmaanir Raheem
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		Map <Integer, Node> nodeObject;
		List <Node> nodeList;
		
		while(true)
		{
			int node = reader.nextInt();
			if(node == 0)	break;
			
			nodeObject = new HashMap<>();
			nodeList = new ArrayList<>();
			
			while(true)
			{
				int x = reader.nextInt();
				int y = reader.nextInt();
				
				if(x == 0 && y == 0)	break;
				
				if(!nodeObject.containsKey(x))
				{
					Node n = new Node(x);
					nodeObject.put(x, n);
					nodeList.add(n);
				}
				
				if(!nodeObject.containsKey(y))
				{
					Node n = new Node(y);
					nodeObject.put(y, n);
					nodeList.add(n);
				}
				
				nodeObject.get(x).adjacencyList.add(nodeObject.get(y));
				nodeObject.get(y).adjacencyList.add(nodeObject.get(x));
			}
			
			if(isClaws(nodeList)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}	
		}
		reader.close();
	}

	private static boolean isClaws(List<Node> nodeList) {
		while(!nodeList.isEmpty())
		{
			Queue <Node> q = new LinkedList<>();
			
			Node head = nodeList.get(0);
			head.color = 1;
			
			q.add(head);
			
			while(!q.isEmpty())
			{
				Node u = q.poll();
				nodeList.remove(u);
				
				List <Node> uList = u.adjacencyList;
				
				for(Node n : uList)
				{
					if (n.color == 0)
					{
						if(u.color > 0)
							n.color = -1;
						else
							n.color = 1;
						
						q.offer(n);
					} else if (u.color == n.color){
							return false;
					}
				}
			}
		}
		return true;
	}

}

class Node{
	protected int value, color;
	protected List<Node>adjacencyList;
	
	public Node(int v)
	{
		value = v;
		color = 0;
		adjacencyList = new  ArrayList<>();
	}
}
