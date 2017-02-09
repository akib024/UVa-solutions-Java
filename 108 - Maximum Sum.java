//Bismillahir Rahmaanir Raheem

import java.util.Arrays;
import java.util.Scanner;

class Kadane_Array
{
	int[] arr;
	int max_curr, maxima, left, right, len;
	
	Kadane_Array(int[] arr, int row) 
	{
		this.arr = arr;
		max_curr = maxima = Integer.MIN_VALUE;
		len = row;
	}

	public void get_sub_array() 
	{
		for(int i = 0; i < len; i++)
		{
			if(max_curr < 0)
			{
				max_curr = arr[i];
				left = i;
			}
			else
			{
				max_curr += arr[i];
			}
			
			if(max_curr > maxima)
			{
				maxima = max_curr;
				right = i;
			}
		}
		
		//return this;
	}
}

class Kadane_Matrix
{
	int[][] matrix;
	int row, column, curr_sum, max_sum, left, right, up, down;
	
	Kadane_Matrix(int[][] matrix, int row) 
	{
		this.matrix = matrix;
		
		this.column = this.row = row;
//		this.column = column;
		curr_sum = max_sum = Integer.MIN_VALUE;
	}

	public void get_matrix()
	{
		int[] sub_mat = new int[row];
		
		for(int L = 0; L < row; L++)
		{
			//filling all the elements of sub_array zero
			Arrays.fill(sub_mat, 0);
			
			for(int R = L; R < column; R++)
			{
				for(int i = 0; i < row; i++)
				{
					sub_mat[i] += matrix[i][R];
				}
				
				Kadane_Array KA = new Kadane_Array(sub_mat, row);
				KA.get_sub_array();
				curr_sum = KA.maxima;
				
				if(curr_sum > max_sum)
				{
					max_sum = curr_sum;
					
					left = L;
					right = R;
					up = KA.left;
					down = KA.right;
				}
			}
		}
	}
	
	
}

public class Main
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		//System.out.println("What is the number of rows?");
		//int row = reader.nextInt();
		
		//System.out.println("What is the number of columns?");
		while(reader.hasNext())
		{
			int n = reader.nextInt();
			
			int[][] matrix = new int[n][n];
			
//			System.out.println("Now insert them sequentially:");
			
			//inserting them sequentially
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					matrix[i][j] = reader.nextInt();
				}
			}
			
			//passing matrix
			Kadane_Matrix KM = new Kadane_Matrix(matrix, n);
			KM.get_matrix();
			
			//printing them all
			System.out.println(KM.max_sum);
//			System.out.println("And the sub-matrix is:");
//			
//			for(int i = KM.up; i <= KM.down; i++)
//			{
//				for(int j = KM.left; j <= KM.right; j++)
//				{
//					System.out.print(matrix[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		
		reader.close();
	}

}
