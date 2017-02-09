//Bismillahir Rahmaanir Raheem
import java.lang.reflect.Array;
import java.util.Scanner;

public class Main
{
	Scanner reader = new Scanner(System.in);
	
	protected static String nextPermutation(String incoming)
	{
		int stringLen = incoming.length();
		char[] charArray = incoming.toCharArray();
		
		int highest_i = -1;
		
		// Find the highest index 'i' such that "s[i] < s[i+1]"
		for(int i = 0; i < stringLen - 1; i += 1)
		{
			if(charArray[i] < charArray[i + 1])
			{
				if(i > highest_i)
					highest_i = i;
			}
		}
		
		/***TEST***///System.out.println("highest_i: "+highest_i);
		
		// if no such highest index 'i' exists
		if(highest_i < 0) // return the original string
			return incoming;
		
		int highest_j = highest_i + 1;
		
		// Find the highest index "j > i" such that s[j] > s[i]
		for(int j = highest_i + 1; j < stringLen; j += 1)
		{
			if(charArray[j] > charArray[highest_i])
			{
				if(j > highest_j)
					highest_j = j;
			}
		}
		
		/***TEST***///System.out.println("highest_j: "+highest_j);
		
		// Swapping s[i] with s[j]
		char temp = charArray[highest_i];
		charArray[highest_i] = charArray[highest_j];
		charArray[highest_j] = temp;
		
		// after index 'i'
		incoming = incoming.substring(0, highest_i) + charArray[highest_i];
		// Reverse the order of all of the elements till the last element
		for(int i = stringLen - 1; i > highest_i; i -= 1)
			incoming += charArray[i];
		
		// returning the next permutation
		return incoming;
	}
	
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		while(true)
		{
			String demoString = reader.nextLine();
			
			if(demoString.equals("#"))	break;
			
			String incoming = nextPermutation(demoString);
			
			if(incoming.equals(demoString))
				System.out.println("No Successor");
			else
				System.out.println(incoming);
		}
		
		reader.close();
	}
}
