import java.util.Scanner;

//Bismillahir Rahmaanir Raheem

public class Main
{
	//static int column, row;
	//static int[][] grid = new int[50+1][50+1];
	
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		int column = reader.nextInt();
		int row = reader.nextInt();
		new CurrenPosition(column, row);
		
		while(reader.hasNext())
		{
			int init_x = reader.nextInt();
			int init_y = reader.nextInt();
			char init_dir = reader.next().charAt(0);
			
			CurrenPosition cp = new CurrenPosition(init_x, init_y, init_dir);
			cp.mov_rob(reader.next());
			if(cp.lost)
			{
				System.out.println(cp.x+" "+cp.y+" "+cp.dir+" "+"LOST");
			}
			else
			{
				System.out.println(cp.x+" "+cp.y+" "+cp.dir);
			}
		}
		 
	}

}

class CurrenPosition
{
	static int column;
	static int row;
	static boolean LOST[][] = new boolean[50+1][50+1];
	
	public CurrenPosition(int column, int row) 
	{
		this.column = column;
		this.row = row;
	}
	
	int x;
	int y;
	char dir;
	boolean lost;
	
	public CurrenPosition(int init_x, int init_y, char init_dir)
	{
		x = init_x;
		y = init_y;
		dir = init_dir;
		lost = false;
	}

	public void mov_rob(String next)
	{
		int len = next.length();
		char command;
		
		for(int i = 0; i < len; i++)
		{
			if(!lost)
			{
				command = next.charAt(i);
				
				switch(command)
				{
					case 'L':
						lookToLeft();
						break;
						
					case 'R':
						lookToRight();
						break;
			
					default: // case 'F':
						samneJao();
				}
			}
			else return;
		}
	}

	private void samneJao()
	{
		switch(dir)
		{
			case 'N':
				if(y + 1 > row)
				{
					if(!LOST[x][y])
					{
						LOST[x][y] = true;
						lost = true;
					}
					else break;
				}
				else
				{
					y += 1;
				}
				break;
				
			case 'E':
				if(x + 1 > column)
				{
					if(!LOST[x][y])
					{
						LOST[x][y] = true;
						lost = true;
					}
					else break;
				}
				else
				{
					x += 1;
				}
				break;
				
			case 'S':
				if(y - 1 < 0)
				{
					if(!LOST[x][y])
					{
						LOST[x][y] = true;
						lost = true;
					}
					else break;
				}
				else
				{
					y -= 1;
				}
				break;
				
			default://caes 'W':
				if(x - 1 < 0)
				{
					if(!LOST[x][y])
					{
						LOST[x][y] = true;
						lost = true;
					}
					else break;
				}
				else
				{
					x -= 1;
				}
				break;
		}
	}

	private void lookToRight() 
	{
		switch(dir)
		{
			case 'N':
				dir = 'E';
				break;
				
			case 'E':
				dir = 'S';
				break;
				
			case 'S':
				dir = 'W';
				break;
				
			default://caes 'W':
				dir = 'N';
				break;
		}
	}

	private void lookToLeft() 
	{
		switch(dir)
		{
			case 'N':
				dir = 'W';
				break;
				
			case 'W':
				dir = 'S';
				break;
				
			case 'S':
				dir = 'E';
				break;
				
			default://caes 'E':
				dir = 'N';
				break;
		}
	}	
}