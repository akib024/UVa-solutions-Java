
import java.util.Scanner;

/* Bismillahir Rahmaanir Raheem*/
class Main {
    
    static int calculation(int a, int b){
        int max = 1;
            int u = 0, v = 0;
            if(a > b){
                u = b;
                v = a;
            }
            else{
                u = a;
                v = b;
            }
            
            for(int i = u; i <= v; ++i){
                int length = 1;
                int wheel = i;
                
                if(u == 0)continue;
                while(true){
                    if(wheel == 1){
                        break;
                    }
                    
                    if(wheel % 2 != 0){
                        wheel = wheel * 3 + 1;
                    }
                    else{
                        wheel = wheel / 2;
                    }
                    
                    ++length;
                }
                
                if(length > max){
                    max = length;
                }
                
                
            }
        return max;
    }
   
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 0, b = 0;
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            a = input.nextInt();
            b = input.nextInt();
            int max = calculation(a, b);
            /*int max = 1;
            int u = 0, v = 0;
            if(a > b){
                u = b;
                v = a;
            }
            else{
                u = a;
                v = b;
            }
            
            for(int i = u; i <= v; ++i){
                int length = 1;
                int wheel = i;
                
                if(u == 0)continue;
                while(true){
                    if(wheel == 1){
                        break;
                    }
                    
                    if(wheel % 2 != 0){
                        wheel = wheel * 3 + 1;
                    }
                    else{
                        wheel = wheel / 2;
                    }
                    
                    ++length;
                }
                
                if(length > max){
                    max = length;
                }
                
                
            }*/
            
            System.out.println(a + " " + b + " " + max);
        }
        
    }

}
