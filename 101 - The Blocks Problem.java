/*
Bismillahir Rahmaanir Raheem
 */

import java.util.*;
//import java.util.Stack;

public class Main101
{
    static List <Deque> list = new ArrayList<>();
    static List <Integer> position = new ArrayList<>();
    private static int n;
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        
        //initializing the list 
        for(int i = 0; i < n; i++)
        {
            Deque <Integer> temp_deq = new LinkedList<>();
            
            temp_deq.addFirst(i);
            list.add(temp_deq);
            
            position.add(i);
        }
        //System.out.println(list);
        //System.out.println(position);
        
        while(true)
        {
            //System.out.println("come back korse");
            String op1 = reader.next();
            if("quit".equals(op1))
            {
                //System.out.println("Quit-o kaj kore");
                quit();
                break;
            }
            
            int num1 = reader.nextInt();
            
            String op2 = reader.next();
            
            int num2 = reader.nextInt();
            
            if((num1 == num2) || (Objects.equals(position.get(num1), position.get(num2))))
            {
                //System.out.println("Illegal command");
                continue;
            }
            
            if(op1.contains("move"))
            {
                if(op2.contains("onto"))
                {
                    move_onto(num1, num2);
                }
                else
                {
                    move_over(num1, num2);
                }
            }
            else 
            {
                if(op2.contains("onto"))
                {
                    pile_onto(num1, num2);
                }
                else
                {
                    pile_over(num1, num2);
                }
            }
        }
        //System.out.println(list);
        //System.out.println(position);
    }
    
    private static void move_onto(int num1, int num2) 
    {
        //System.out.println("move_onto kaj kore !!!");
        int stck_no = position.get(num1);
        Deque <Integer> dick = list.get(stck_no);
        
        while(true)
        {
            if(dick.peekFirst()!= num1)
            {
                int init = dick.removeFirst();
                list.get(init).addFirst(init);
                position.set(init, init);
            }
            else
            {
                dick.removeFirst();
                break;
            }
        }
        
        stck_no = position.get(num2);
        dick = list.get(stck_no);
        
        while(true)
        {
            if(dick.peekFirst() != num2)
            {
                int init = dick.removeFirst();
                list.get(init).addFirst(init);
                position.set(init, init);
            }
            else    break;
        }
        
        dick.addFirst(num1);
        position.set(num1, stck_no);
        
        //System.out.println(list);
        //System.out.println(position);
    }

    private static void move_over(int num1, int num2) 
    {
        //System.out.println("move_over kaj kore !!!");
        int stck_no = position.get(num1); // koto number stack-e "num1" ache oi number-ta "stck_no"-e rakhlam
        Deque <Integer> dick = list.get(stck_no); // sei stack ta "dick" dia dhorlam
        
        while(true)
        {
            if(dick.peekFirst()!= num1) // dekhtesi "dick"-er mathay jate "num1" na thake
            {
                int init = dick.removeFirst(); // "num1" na hoile "dick" theke pop kortesi r "init"-e rakhtesi
                list.get(init).addFirst(init); // "list"-er "init"-number stack-er mathay "inti" push kortesi
                position.set(init, init); // "init"-position-er value "init" loira ditasi
            }
            else
            {
                dick.removeFirst();// "num1" thakle "dick" theke pop kortesi
                break;
            }
        }
        
        stck_no = position.get(num2);// koto number stack-e "num2" ache oi number-ta "stck_no"-e rakhlam
        dick = list.get(stck_no);// sei stack ta "dick" dia dhorlam
        
        dick.addFirst(num1);// "dick"-er mathay "num1" push korlam
        position.set(num1, stck_no);//"num1"-ta koto number stack-e ache se jonno "position" of "num1" = "stck_no" koira dilam
        
        //System.out.println(list);
        //System.out.println(position);
    }

    private static void pile_onto(int num1, int num2) 
    {
        //System.out.println("pile_onto kaj kore !!!");
        int stck_no = position.get(num1); // koto number stack-e "num1" ache oi number-ta "stck_no"-e rakhlam
        Deque <Integer> dick = list.get(stck_no); // sei stack ta "dick" dia dhorlam
        Deque <Integer> temp_dick = new LinkedList<>();
        
        while(true)
        {
            if(dick.peekFirst()!= num1) // dekhtesi "dick"-er mathay jate "num1" na thake
            {
                int init = dick.removeFirst(); // "num1" na hoile "dick" theke pop kortesi r "init"-e rakhtesi
                temp_dick.addFirst(init);
            }
            else
            {
                temp_dick.addFirst(dick.removeFirst());
                break;
            }
        }
        
        stck_no = position.get(num2);
        dick = list.get(stck_no);
        
        while(true)
        {
            if(dick.peekFirst() != num2)
            {
                int init = dick.removeFirst();
                list.get(init).addFirst(init);
                position.set(init, init);
            }
            else break;
        }
        
        while(true)
        {
            if(!temp_dick.isEmpty())
            {
                int init = temp_dick.removeFirst();
                dick.addFirst(init);
                position.set(init, stck_no);
            }
            else break;
        }
        
        //System.out.println(list);
        //System.out.println(position);
    }

    private static void pile_over(int num1, int num2) 
    {
        //System.out.println("aah ... pile_over kaj kore !!!");
        int stck_no = position.get(num1); // koto number stack-e "num1" ache oi number-ta "stck_no"-e rakhlam
        Deque <Integer> dick = list.get(stck_no); // sei stack ta "dick" dia dhorlam
        Deque <Integer> temp_dick = new LinkedList<>();
        
        while(true)
        {
            if(dick.peekFirst() != num1) // dekhtesi "dick"-er mathay jate "num1" na thake
            {
                int init = dick.removeFirst(); // "num1" na hoile "dick" theke pop kortesi r "init"-e rakhtesi
                temp_dick.addFirst(init);
            }
            else
            {
                temp_dick.addFirst(dick.removeFirst());
                break;
            }
        }
        
        stck_no = position.get(num2);
        dick = list.get(stck_no);
        
        while(!temp_dick.isEmpty())
        {
            int init = temp_dick.removeFirst();
            dick.addFirst(init);
            position.set(init, stck_no);
        }
        
        //System.out.println(list);
        //System.out.println(position);
    }

    private static void quit() {
        Deque dick = new LinkedList();
        for(int i = 0; i < n; i++)
        {
            System.out.print(i + ":");
            dick = list.get(i);
            while(!dick.isEmpty())
            {
                System.out.print(" " + dick.removeLast());
            }
            System.out.println();
        }
    }
}
