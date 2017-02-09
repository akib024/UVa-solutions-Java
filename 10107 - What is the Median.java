//Bismillahir Rahmaanir Raheem
import java.util.Scanner;

class PriorityQueue
{
	private int[] array;
	//private int head;
	private int length;
	
	protected PriorityQueue(int i)
	{
		array = new int[i];
		//head = 0;
		length = 0;
	}

	protected void offer(int nextInt) 
	{
		array[length++] = nextInt;
		
		if(length > 1)
		{
			int indx = length - 1;
			while(array[indx] < array[indx-1])
			{
				array[indx] = array[indx] ^ array[indx-1];
				array[indx-1] = array[indx-1] ^ array[indx];
				array[indx] = array[indx] ^ array[indx-1];
				
				indx -= 1;
				if(indx == 0)break;
			}
		}
	}

	protected void poll() 
	{
		
	}

	protected int get(int indx) 
	{
		return array[indx];
	}

}


public class Main
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		PriorityQueue pq = new PriorityQueue(10000);
		
		boolean odd = true;
		int indx = 0;
		
		while(reader.hasNext())
		{
			pq.offer(reader.nextInt());
			
			if(odd)
			{
				System.out.println(pq.get(indx));
				odd = false;
			}
			else
			{
				System.out.println( ( pq.get(indx) + pq.get(++indx) ) / 2);
				odd = true;
			}
		}

	}

}
