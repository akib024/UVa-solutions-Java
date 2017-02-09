import java.util.Scanner;

//Bismillahir Rahmaanir Raheem

public class Main{

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		
		int w, h, n, x1, y1, x2, y2, temp;
		
		
		while(true)
		{	
			w = reader.nextInt();
			h = reader.nextInt();
			n = reader.nextInt();
			
			int initial_area = w * h;
			int after_area = initial_area;
			boolean[][] is_visited = new boolean[w+1][h+1];
			
			if((w == 0) && (h == 0) && (n == 0))
			{
				break;
			}
			
			for(int i = 0; i < n; i++)
			{
				x1 = reader.nextInt();
				y1 = reader.nextInt();
				x2 = reader.nextInt();
				y2 = reader.nextInt();
				
				if(x1 > x2)
				{
					temp = x1;
					x1 = x2;
					x2 = temp;
				}
				
				if(y1 > y2)
				{
					temp = y1;
					y1 = y2;
					y2 = temp;
				}
				
				for(int j = x1; j <= x2; j++)
				{
					for(int k = y1; k <= y2; k++)
					{
						if(!is_visited[j][k])
						{
							is_visited[j][k] = true;
							after_area--;
						}
					}
				}
				
				
			}
			
			
			if(after_area == 0)
			{
				System.out.println("There is no empty spots.");
			}
			else if(after_area == 1)
			{
				System.out.println("There is one empty spot.");
			}
			else
			{
				System.out.println("There are "+after_area+" empty spots.");
			}
		}
		reader.close();
		
		
	}

}
