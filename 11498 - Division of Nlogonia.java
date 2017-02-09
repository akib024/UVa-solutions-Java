import java.util.Scanner;

//Bismillahir Rahmaanir Raheem
public class Main
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		while(true)
		{
			int K = reader.nextInt();
			if(K == 0) break;
			
			int div_x = reader.nextInt();
			int div_y = reader.nextInt();
			
			while(K > 0)
			{
				int res_x = reader.nextInt();
				int res_y = reader.nextInt();
				
				if(res_x == div_x || res_y == div_y)
				{
					System.out.println("divisa");
				}
				else if(res_x < div_x && res_y > div_y)
				{
					System.out.println("NO");
				}
				else if(res_x > div_x && res_y > div_y)
				{
					System.out.println("NE");
				}
				else if(res_x > div_x && res_y < div_y)
				{
					System.out.println("SE");
				}
				else
				{
					System.out.println("SO");
				}
				
				K--;
			}
		}
		
		reader.close();

	}

}
