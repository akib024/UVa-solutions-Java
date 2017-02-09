import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Bismillahir Rahmaanir Raheem

public class Main
{
	static int R;
	static int C;
	static boolean[][] mine;
	static boolean[][] visited;

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		while(true)
		{
			R = reader.nextInt();
			C = reader.nextInt();
			
			if(R == 0 && C == 0)break;
			
			mine = new boolean[R][C];
			
			int r = reader.nextInt();
			
			for(int i = 0; i < r; i++)
			{
				int row_indx = reader.nextInt();
				int col_no = reader.nextInt();
				
				int col_indx;
				while(col_no > 0)
				{
					col_indx = reader.nextInt();
					mine[row_indx][col_indx] = true;
					col_no--;
				}
			}
			
			int src_row = reader.nextInt();
			int src_col = reader.nextInt();
			
			int dst_row = reader.nextInt();
			int dst_col = reader.nextInt();
			
			int time = bfs(src_row, src_col, dst_row, dst_col);
			System.out.println(time);
			
		}
		
		reader.close();
	}

	private static int bfs(int src_row, int src_col, int dst_row, int dst_col) 
	{
		visited = new boolean[R][C];
		int[][] level = new int[R][C];
		
		level[src_row][src_col] = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(src_row);
		q.add(src_col);
		
		while(!q.isEmpty())
		{
			int curr_row = q.poll();
			int curr_col = q.poll();
			
			if(curr_row == dst_row && curr_col == dst_col)
			{
				break;
			}
			
			if(is_forward_valid(curr_row, curr_col))
			{
				q.add(curr_row + 1);
				q.add(curr_col);
				level[curr_row + 1][curr_col] = level[curr_row][curr_col] + 1;
				visited[curr_row + 1][curr_col] = true;
			}
			
			if(is_backward_valid(curr_row, curr_col))
			{
				q.add(curr_row - 1);
				q.add(curr_col);
				level[curr_row - 1][curr_col] = level[curr_row][curr_col] + 1;
				visited[curr_row - 1][curr_col] = true;
			}
			
			if(is_upward_valid(curr_row, curr_col))
			{
				q.add(curr_row);
				q.add(curr_col + 1);
				level[curr_row][curr_col + 1] = level[curr_row][curr_col] + 1;
				visited[curr_row][curr_col + 1] =  true;
			}
			
			if(is_downward_valid(curr_row, curr_col))
			{
				q.add(curr_row);
				q.add(curr_col - 1);
				level[curr_row][curr_col - 1] = level[curr_row][curr_col] + 1;
				visited[curr_row][curr_col - 1] = true;
			}
		}
		
		return level[dst_row][dst_col];
	}

	private static boolean is_downward_valid(int curr_row, int curr_col) 
	{
		if(curr_col - 1 >= 0)
		{
			if(!mine[curr_row][curr_col - 1])
			{
				if(!visited[curr_row][curr_col - 1])
				{
					return true;
				}
			}
		}
		return false;
	}

	private static boolean is_upward_valid(int curr_row, int curr_col) 
	{
		if(curr_col + 1 < C)
		{
			if(!mine[curr_row][curr_col + 1])
			{
				if(!visited[curr_row][curr_col + 1])
				{
					return true;
				}
			}
		}
		return false;
	}

	private static boolean is_backward_valid(int curr_row, int curr_col) 
	{
		if(curr_row - 1 >= 0)
		{
			if(!mine[curr_row - 1][curr_col])
			{
				if(!visited[curr_row - 1][curr_col])
				{
					return true;
				}
			}
		}
		return false;
	}

	private static boolean is_forward_valid(int curr_row, int curr_col)
	{
		if(curr_row + 1 < R)
		{
			if(!mine[curr_row + 1][curr_col])
			{
				if(!visited[curr_row + 1][curr_col])
				{
					return true;
				}
			}
		}
		return false;
	}

}
