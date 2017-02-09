//Bismillahir Rahmaanir Raheem
import java.util.Scanner;

public class Main{
	static double fSqrt3_2 = Math.sin(Math.PI/3);

	public static void main(String[] args)
	{
		//System.out.println(fSqrt3_2);
		Scanner reader = new Scanner(System.in);
		
		while(reader.hasNext())
		{
			float a = reader.nextFloat();
			float b = reader.nextFloat();
			
			int pipe_no, grid;
			grid = pipe_no = (int)a * (int)b;
			String pattern = "grid";
			
			if(a <= 1 || b <= 1)
			{
				System.out.println(pipe_no+" "+pattern);
				continue;
			}
			
			int skew = Math.max(get_skew(a,b), get_skew(b,a));
			
			if(skew > grid)
			{
				pipe_no = skew;
				pattern = "skew";
			}
			System.out.println(pipe_no+" "+pattern);
		}
		
		reader.close();
	}

	private static int get_skew(float a, float b)
	{
		//koyta column oita fixed, arekta barbe naki kombe oita pore hiseb korbo
		int col = (int)a;
		
		//ses column-ta 0.5-er besi hoile arekta column barbe
		boolean extra = (a - (int)a >= 0.5) ? true : false;
		
		//1ta row constant, baki row-gula fSqrt3_2 difference-er jonno paoa jabe
		int rows = (int) ((b - 1) / fSqrt3_2 + 1);
		
		//mul(row,col) return back kora hobe, tobe extra column na thakle ordhek row theke...
		//...ekta kore column bad jabe
		return col * rows - (extra ? 0 : rows / 2);
	}

}
