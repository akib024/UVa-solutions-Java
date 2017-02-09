import java.util.Scanner;
import java.util.Stack;

//Bismillahir Rahmaanir Raheem


public class Main
{
	static int row;
	static int column;
	
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		while(true)
		{
			row = reader.nextInt();
			column = reader.nextInt();
			
			if(row == 0  && column == 0)	break;
			
			int[][] matrix = new int[row][column];
			
			for(int i = 0; i < row; i++)
			{
				for(int j = 0; j < column; j++)
				{
					matrix[i][j] = reader.nextInt();
				}
			}
			
			System.out.println(get_area(matrix));
		}
	}

	private static int get_area(int[][] matrix)
	{
		int[][] record = new int[row][column];
		
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				int tree = 0;
				while((i - tree) >= 0)
				{
					if(matrix[i - tree][j] == 0)
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
		
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
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
			
			int temp_j = column;
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
