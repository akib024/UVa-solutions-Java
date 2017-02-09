//Bismillahir Rahmaanir Raheem
//package temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
	static int[] track = new int[729 + 1]; // 9 * (9 ^ 2)
	static List<Integer> record = new ArrayList<>();
	
	public static void main(String[] args) 
	{
		track[1] = 1;
		
		Scanner reader = new Scanner(System.in);
		int input, happiness;
		
		int tc = reader.nextInt();
		
		
		for(int i = 1; i <= tc; i++)
		{
			input = reader.nextInt();
			
			happiness = is_happy(input);
			
			if(happiness == 1)
			{
				System.out.println("Case #"+i+": "+input+" is a Happy number.");
			}
			else
			{
				System.out.println("Case #"+i+": "+input+" is an Unhappy number.");
			}
		}
		
		reader.close();
	}

	private static int is_happy(int n)
	{
		int return_it = 0;
		
		if(n <= 729)
		{
			if(track[n] != 0)
			{
				return track[n];
			}
		}
		
		if(record.contains(n))
		{
			return -1;
		}
		else
		{
			record.add(n);
			
			int incoming = n;
			int sum = 0;
			int remainder = 0;
			
			while(incoming != 0)
			{
				remainder = incoming % 10;
				sum += remainder * remainder;
				incoming /= 10;
			}
			
			//System.out.println("Passing sum is: "+sum);
			if(n <= 729)
			{
				track[n] = is_happy(sum);
				return_it = track[n];
			}
			else
			{
				return_it = is_happy(sum);
			}
		}

		record.clear();
		
		return return_it;
	}

}
