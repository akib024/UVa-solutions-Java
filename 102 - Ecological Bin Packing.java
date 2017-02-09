package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/* Bismillahir Rahmaanir Raheem */
public class Main {
    static int b0,b1,b2,g0,g1,g2,c0,c1,c2,Min;
    static boolean record;
    static char arr[] = {'B', 'C', 'G'};
    static List<Character> result = new ArrayList<>();
    static List<Character> out_view = new ArrayList<>();
    static int[] taken = new int[10];
    
    static int calculation()
    {
        int total = 0;
        for(int i = 0; i < 3; i++)
        {
            switch(result.get(i))
            {
                case 'B':
                    switch(i)
                    {
                        case 0:
                            total += b1 + b2;
                            break;
                            
                        case 1:
                            total += b0 + b2;
                            break;
                        
                        case 2:
                            total += b0 + b1;
                            break;    
                    }
                break;
                
                case 'C':
                    switch(i)
                    {
                        case 0:
                            total += c1 + c2;
                            break;
                            
                        case 1:
                            total += c0 + c2;
                            break;
                        
                        case 2:
                            total += c0 + c1;
                            break;    
                    }
                break;
                    
                case 'G':
                    switch(i)
                    {
                        case 0:
                            total += g1 + g2;
                            break;
                            
                        case 1:
                            total += g0 + g2;
                            break;
                        
                        case 2:
                            total += g0 + g1;
                            break;    
                    }
                break;
            }    
        }
        return total;
    }
    
    static void permutation()
    {
        int total;
        
        if(result.size() == 3)
        {
            total = calculation();
            
            if(!record)
            {
                Min = total;
                record = true;
                out_view = new ArrayList<Character>(result);
            }
            else if(total < Min)
            {
                Min = total;
                out_view = new ArrayList<Character>(result);
            }
            return;
        }
        
        for(int i = 0; i < 3; i++)
        {
            if(taken[i] == 0)
            {
                taken[i] = 1; result.add(arr[i]);
                permutation();
                taken[i] = 0; result.remove(result.size() - 1);
            }
        }
        
    }
        
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext())
        {
            b0 = input.nextInt();
            g0 = input.nextInt();
            c0 = input.nextInt();
            
            b1 = input.nextInt();
            g1 = input.nextInt();
            c1 = input.nextInt();
            
            b2 = input.nextInt();
            g2 = input.nextInt();
            c2 = input.nextInt();
            
            record = false;
            permutation();
            
            for (Character temp : out_view) {
			System.out.print(temp);
		}
            System.out.println(" " + Min);
        }
        
    }

}

