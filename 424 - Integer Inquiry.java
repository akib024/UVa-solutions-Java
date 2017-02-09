/*
Bismillahir Rahmaanir Raheem
 */

package ja;

import java.util.Scanner;

public class Main424 {
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        
        String s1 = null, s2 = null;
        
        boolean is_there_s2 = false;
        
        do{
            
            if(is_there_s2)
            {
                s2 = add(s1, s2);
            }
            else
            {
                s2 = reader.nextLine();
                is_there_s2 = true;
                //continue;
            }
            
            s1 = reader.nextLine();
            
        }while(!s1.equals("0"));
        
        System.out.println(s2);
        
        
    }

    private static String add(String s1, String s2) 
    {
        String s3;
        if(s2.length() > s1.length())
        {
            s3 = s1;
            s1 = s2;
            s2 = s3;
        }
        
        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int max_len = s1.length(), min_len = s2.length(), sum;
        s2 = "";
        boolean is_there_carry = false;
        
        for(int i = 0; i < max_len; i++)
        {
            if(i < min_len)
            {
                if(is_there_carry)
                {
                    sum = 1;
                }
                else
                {
                    sum = 0;
                }
                
                sum += c1[i] + c2[i] - 96;
                
                if(sum > 9)
                {
                    sum = sum % 10;
                    s2 = s2 + sum;
                    is_there_carry = true;
                }
                else
                {
                    s2 = s2 + sum;
                    is_there_carry = false;
                }
                
                //System.out.println(c3[i]);
            }
            else
            {
                if(is_there_carry)
                {
                    sum = 1;
                }
                else
                {
                    sum = 0;
                }
                
                sum += c1[i] - 48;
                
                if(sum > 9)
                {
                    sum = sum % 10;
                    s2 = s2 + sum;
                    is_there_carry = true;
                }
                else
                {
                    s2 = s2 + sum;
                    is_there_carry = false;
                }
                
                //System.out.println(c3[i]);
            }
        }
        
        //s2 = new String(c3);
        s2 = new StringBuilder(s2).reverse().toString();
        
        if(is_there_carry)
        {
            s2 = 1 + s2;
        }
        
        int len = s2.length();
        s1 = "";
        for(int i = 0; i < len; i++)
        {
            if(s2.charAt(i) != '0')
            {
                s2 = s2.substring(i);
                break;
            }
        }
        
        return s2;
    }
    
}
