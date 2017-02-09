import java.util.Scanner;

//Bismillahir Rahmaanir Raheem
public class Main{

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		
		while(true)
		{
			int n = reader.nextInt();
			if(n == 0)
			{
				break;
			}
			
			int  divisor, quotient = n;
			
			String binary = "", a = "", b = "";
			
			while(true)
			{
				divisor = quotient % 2;
				binary = divisor + binary;
				quotient /= 2;
				
				if(quotient == 0)
				{
					break;
				}
			}
			
			//System.out.println(binary);
			
			int i = 0, len = 0, j;
			try
			{
				for(i = 0; ; i++)
				{
					binary.charAt(i);
				}
			}
			catch(StringIndexOutOfBoundsException e)
			{
				len = i;
			}
			
			int count = 0;
			for(i = len - 1; i > -1 ; i--)
			{
				char c = binary.charAt(i);
				
				if(c == '1')
				{
					++count;
					divisor = count % 2;
					
					if(divisor == 1)
					{
						a = c + a;
						b = 0 + b;
					}
					else
					{
						b = c + b;
						a = 0 + a;
					}
				}
				else
				{
					a = 0 + a;
					b = 0 + b;
				}
			}
			
			//System.out.println(a);
			//System.out.println(b);
			int n_a = 0, n_b = 0, temp;
			for(i = len - 1,j = 0; i > -1; i--, j++)
			{
				temp = a.charAt(i) - 48;
				n_a += temp * Math.pow(2, j);
				
				temp = b.charAt(i) - 48;
				n_b += temp * Math.pow(2, j);
			}
			
			System.out.println(n_a+" "+n_b);
		}
	}

}
