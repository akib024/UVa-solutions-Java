//Bismillahir Rahmaanir Raheem
import java.util.Scanner;
import java.util.Stack;

public class Main
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		String s;
		int size;
		int max_area;
		int tc = reader.nextInt();
		
		for(int i = 0; i < tc; i++)
		{
			s = reader.next();
			size = s.length();
			
			char[][] matrix = new char[size][size];
			
			for(int j = 0; j < size; j++)
			{
				matrix[0][j] = s.charAt(j);
			}
			
			for(int j = 1; j < size; j++)
			{
				s = reader.next();
				for(int k = 0; k < size; k++)
				{
					matrix[j][k] = s.charAt(k);
				}
			}
			
			max_area = get_area(matrix, size);
			
			if(i > 0)	System.out.println();
			System.out.println(max_area);
		}
	}

	private static int get_area(char[][] matrix, int size)
	{
		int[][] record = new int[size][size];
		int tree;
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				tree = 0;
				while((i - tree) >= 0)
				{
					if(matrix[i - tree][j] == '1')
					{
						++record[i][j];
					}else
					{
						break;
					}
					tree++;
				}
			}
		}
		
		Stack<Integer> stk = new Stack<>();
		int maxima = Integer.MIN_VALUE;
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				//int stk_head = stk.peek();
				if(stk.isEmpty())
				{
					stk.push(j);
					stk.push(record[i][j]);
				}
				else if(record[i][j] > stk.peek())
				{
					stk.push(j);
					stk.push(record[i][j]);
				}
				else
				{
					int lst_indx = 0, lst_elemnt, area;
					while(record[i][j] <= stk.peek())
					{
						lst_elemnt = stk.pop();
						lst_indx  = stk.pop();
						area = lst_elemnt * (j - lst_indx);
						maxima = Math.max(area, maxima);
						
						if(stk.isEmpty())break;
					}
					
					stk.push(lst_indx);
					stk.push(record[i][j]);
				}
			}
			
			int temp_j = size;
			while(!stk.isEmpty())
			{
				int lst_elemnt = stk.pop();
				int lst_indx = stk.pop();
				int area = lst_elemnt * (temp_j - lst_indx);
				maxima = Math.max(maxima, area);
			}
			
		}
		
		return maxima;
	}

}
