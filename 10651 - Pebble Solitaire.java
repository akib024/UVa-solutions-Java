//Bismillahir Rahmaanir Raheem
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{ 
	
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		int testLine = reader.nextInt();
		
		Queue<String>q = new LinkedList<>();
		
		while(testLine > 0)
		{
			String line = reader.next();
			int min_pebble = 12;
			q.add(line);
			
			/** eidar moddhe ja korar koren**/
			while(!q.isEmpty())
			{
				line = q.poll();
				char[] charArray = line.toCharArray();
				
				int this_pebble = count_pebble(charArray);
				if(this_pebble < min_pebble)
					min_pebble = this_pebble;
				
				for(int i = 0; i < 12; i += 1)
				{
					if(charArray[i] == '-')
					{
						if(can_forward(charArray, i))
						{
							charArray[i] = 'o';
							charArray[i+1] = '-';
							charArray[i+2] = '-';
							q.add(new String(charArray));
							
							charArray = line.toCharArray();
						}
						
						if(can_backward(charArray, i))
						{
							charArray[i] = 'o';
							charArray[i-1] = '-';
							charArray[i-2] = '-';
							q.add(new String(charArray));
							
							charArray = line.toCharArray();
						}
					}
				}
			}
			
			/** **/
			--testLine;
			System.out.println(min_pebble);
			
		}
		
		reader.close();
	}

	private static boolean can_forward(char[] charArray, int i)
	{
		if(i+2 < 12)
		{
			if(charArray[i+1] == 'o' && charArray[i+2] == 'o')
			{
				return true;
			}
		}
		return false;
	}

	private static boolean can_backward(char[] charArray, int i) 
	{
		if(i-2 >= 0)
		{
			if(charArray[i-1] == 'o' && charArray[i-2] == 'o')
			{
				return true;
			}
		}
		return false;
	}
	
	private static int count_pebble(char[] charArray)
	{
		int total = 0;
		
		for(char c : charArray)
			if(c == 'o')
				total += 1;
		
		return total;
	}
}
