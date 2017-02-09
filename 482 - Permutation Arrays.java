//Bismillahir Rahmaanir Raheem
import java.util.Scanner;

public class Main{

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		int tc = Integer.parseInt(reader.nextLine());
		boolean is_first = true;
		
		for(int i = 0; i < tc; i++)
		{
			reader.nextLine();
			
			String s1 = reader.nextLine();
			s1 = s1.replaceAll("\\s+", " ").trim();
			//System.out.println(s1);
			s1 += " ";
			
			String s2 = reader.nextLine();
			s2 = s2.replaceAll("\\s+", " ").trim();
			//System.out.println(s2);
			s2 += " ";
			
			int[] indx = new int[1000];
			String[] str = new String[1000];
			
			int len, index, j;
			
			String temp_string = "";
			len = s1.length();
			
			for(j = 0, index = 0 ; j < len; j++)
			{
				//System.out.println("Dhukse!!!");
				
				char temp_char = s1.charAt(j);
				if(temp_char == ' ')
				{
					indx[index++] = Integer.parseInt(temp_string);
					temp_string = "";
					
				}
				else
				{
					temp_string += temp_char;
				}
			}
			
			int size = index;
			len = s2.length();
			temp_string = "";
			
			for(j = 0, index = 0; j < len; j++)
			{
				char temp_char = s2.charAt(j);
				if(temp_char == ' ')
				{
					str[index++] = temp_string;
					temp_string = "";
					
				}
				else
				{
					temp_string += temp_char;
				}
			}
			
			
			for(j = 0; j < size - 1; j++)
			{
				for(int k = j + 1; k < size; k++)
				{
					if(indx[j] > indx[k])
					{
						int temp = indx[j];
						indx[j] = indx[k];
						indx[k] = temp;
						
						String temp_str = str[j];
						str[j] = str[k];
						str[k] = temp_str;
					}
				}
			}
			
			
			if(is_first)
			{
				is_first = false;
			}
			else
			{
				System.out.println();
			}
				
			for(j = 0; j < size; j++)
			{
				System.out.println(str[j]);
			}
		}
		reader.close();
	}

}
