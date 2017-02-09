import java.util.Scanner;

//Bismillahir Rahmaanir Raheem

class Kadane_Algo
{
	int[] arr;
	int max_curr, maxima, left, right, len, temp_left;
	
	Kadane_Algo(int[] arr) 
	{
		this.arr = arr;
		max_curr = maxima = Integer.MIN_VALUE;
		len = arr.length;
	}

	public void get_sum() 
	{
		for(int i = 1; i < len; i++)
		{
			if(max_curr < 0)
			{
				max_curr = arr[i];
				temp_left = i;
			}
			else
			{
				max_curr += arr[i];
			}
			
			if(max_curr > maxima)
			{
				maxima = max_curr;
				left = temp_left;
				right = i;
			}
			else if(max_curr == maxima)
			{
				if((i - temp_left) > (right - left))
				{
					left = temp_left;
					right = i;
				}
			}
		}
		right += 1;
		//return this;
	}
}

public class Main
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		int tc = reader.nextInt();
		
		for(int i = 1; i <= tc; i++)
		{
			int size = reader.nextInt();
			int[] stops = new int[size];
			
			for(int j = 1; j < size; j++)
			{
				stops[j] = reader.nextInt();
			}
			
			Kadane_Algo ka = new Kadane_Algo(stops);
			ka.get_sum();
			
			if(ka.maxima < 0)
			{
				System.out.println("Route "+i+" has no nice parts");
			}
			else
			{
				System.out.println("The nicest part of route "+i+" is between stops "+ka.left+" and "+ka.right);
			}
			
		}
		reader.close();
	}

}
