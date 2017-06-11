import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main 
{
	
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		String input;
		List<String> ls = new ArrayList<>();
		
		while(reader.hasNext())
		{
			input = reader.next();
			
			if(input.equals("-999999"))
			{
				System.out.println(maximum_product(ls));
				ls.clear();
			}
			else
			{
				ls.add(input);
			}
		}
		
		reader.close();

	}
	
	private static String maximum_product(List<String> ls) 
	{
		int len = ls.size();
		
		BigInteger curr_max = new BigInteger(ls.get(0));
		BigInteger curr_min;
		BigInteger prev_max = new BigInteger(ls.get(0));
		BigInteger prev_min = new BigInteger(ls.get(0));
		BigInteger answer   = new BigInteger(ls.get(0));
		
		BigInteger running;
		
		
		for(int i = 1; i < len; i += 1)
		{
			running = new BigInteger(ls.get(i));
			
			curr_max = running.max(running.multiply(prev_max));
			curr_max = curr_max.max(running.multiply(prev_min));
			
			curr_min = running.min(running.multiply(prev_max));
			curr_min = curr_min.min(running.multiply(prev_min));
			
			answer = answer.max(curr_max);
			prev_max = curr_max;
		    prev_min = curr_min;
		}
		
		return String.valueOf(answer);
	}
}
