import java.util.*;
public class StackExpTestDay1
{
 public static double evalAns(String exp)
 {
   Stack<Double> s = new Stack<Double>();
   for(int i = 0; i < exp.length(); i++)
   {
     char c = exp.charAt(i);
     if(c == '1' || c == '2' || c == '3' ||
        c == '4' || c == '5' || c == '6' ||
        c == '7' || c == '8' || c == '9'  )
     {s.push(Double.parseDouble(exp.substring(i,i+1)));}
     else
     {
       if(c != '!')
       {
         double num1 = s.pop();
         double num2 = s.pop();
         switch (c)
         {
           case '+':
             
             s.push(num1+num2);
             break;
           case '-':
             
             s.push(num2-num1);
             break;
           case '*':
             
             s.push(num1*num2);
             break;
           case '/':
             
             s.push(num2/num1);
             break;
           case '%':
             
             s.push(num2%num1);
             break;
           case '^':
             
             s.push(Math.pow(num2,num1));
             break;
         }
       }
       else
       {
         double num1 = s.pop();
         double n = num1;
         for(double x = num1-1; x>=1; x--)
         {n*=x;}
         s.push(n);
         break;}
     }
     
   }
   return s.pop();
 }
 
  public static void main(String[] args)
  {
    double answer, yourAns;
    String exp;
  int c=0, w=0;
    
    exp = "256++";
    System.out.println("Testing Post-fix Single Digit Operation");
    System.out.println("Operations tested: +,-,*,/,%,^,!");
    System.out.println("Testing 2+5+6");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 13;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }
    
    System.out.println();
    exp = "256*+9-";
    System.out.println("Testing 2+5*6-9");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 23;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }
    
    System.out.println();
    exp = "111+3^+2/";
    System.out.println("Testing (1+(1+1)^3)/2");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 4.5;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
    exp = "12+3*23+%";
    System.out.println("Testing (1+2)*3%(2+3)");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 4;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
    exp = "473%-!";
    System.out.println("Testing (4-7%3)!");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 6;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
  System.out.println("Number of correct answer: " + c);
  System.out.println("Number of incorect answer: " + w);
  System.out.println("Accuracy: " + Math.round((double)c/(c+w)*100) + "%");
  }
}

