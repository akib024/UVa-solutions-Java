import java.util.Scanner;

//Bismillahir Rahmaanir Raheem
public class Main
{

	public static void main(String[] args)
	{
		String input;
		Scanner reader = new Scanner(System.in);
		
		String[] map = new String[26];
		map[0] = "";
		map[1] = "1";
		map[2] = "2";
		map[3] = "3";
		map[4] = "";
		map[5] = "1";
		map[6] = "2";
		map[7] = "";
		map[8] = "";
		map[9] = "2";
		map[10] = "2";
		map[11] = "4";
		map[12] = "5";
		map[13] = "5";
		map[14] = "";
		map[15] = "1";
		map[16] = "2";
		map[17] = "6";
		map[18] = "2";
		map[19] = "3";
		map[20] = "";
		map[21] = "1";
		map[22] = "";
		map[23] = "2";
		map[24] = "";
		map[25] = "2";
		
		while(reader.hasNext())
		{
			input = reader.nextLine();
			
			int len = input.length(), i;
			
			//input += " ";
			
			char c1, c2;
			int indx1, indx2;
			
			for(i = 0; i < len; i++)
			{
				c1 = input.charAt(i);
				indx1 = c1 - 65;
				if(i < len - 1)
				{
					c2 = input.charAt(i+1);
					indx2 = c2 - 65;
					
					if(map[indx1] == map[indx2])
					{
						continue;
					}
				}
				//int indx = c1 - 65;
				System.out.print(map[indx1]);
			}
			System.out.println();
		}
		reader.close();
	}

}
