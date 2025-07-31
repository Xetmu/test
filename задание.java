/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   		System.out.print("Input Expression : ");
    		String str="";
    		try{
       			str = reader.readLine();
    		}
    		catch(IOException ioe){
      			System.err.println("Неправильный формат строки!");  
    		}
    		String result = calc(str);
		System.out.println(result);
	}
	
	public static String calc(String str) {
        	return String.valueOf(isRightNumber(str));
	}
	private static Integer isRightNumber(String input)
	{
		String[] words = input.split(" ");
		if(words.length%2==0)
	        {
	        	System.err.println("throws Exception "); 
	        	throw new ArithmeticException();
		}
	      
	        if(words.length==1)
	        {
	        	System.err.println("throws Exception //т.к. строка не является математической операцией"); 
	        	throw new ArithmeticException();
	        }
	        
	        if(words.length!=3)
		        for(int i = 0; i< words.length; i++)
		        {
				if((i%2)==0)
			        {
			        	Integer k = Integer.valueOf(words[i]);
			        	if(!(-1<k&&k<11)){
			        	System.err.println("Некорректный ввод, на месте числа иной символ"); 
			                throw new ArithmeticException();
			            	}
			        }
			        if((i%2)==1)
			        {
			        	if(!((words[i].equals("+")||(words[i].equals("-"))||(words[i].equals("*"))||(words[i].equals("/"))))){
			        		System.err.println(i + words[i] + "Некорректный ввод, на месте знака операции иной символ"); 
			                	throw new ArithmeticException();
			            	}
			         }
			         if(i==(words.length-1)){
			         	System.err.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)"); 
			                throw new ArithmeticException();
			         }
		        }
	        try {
		        Integer i1 = Integer.valueOf(words[0]);
		        Integer i2 = Integer.valueOf(words[2]);
		        if(i1<0 || i1>10 || i2<0 || i2>10)
		        {
				System.err.println("Неправильный формат строки!");  
		        	throw new ArithmeticException();
		        }
		        switch(words[1]){
		        	case "+":
		               		return (i1+i2);
		                
		        	case "-":
		               		return (i1-i2);
	
		           	case "/":
		               		if(i2==0)
		                    		System.err.println("Делить на ноль нельзя!");  
		               			return (i1/i2);     
		           	case "*":
		               		return (i1*i2);    
		           	default:
		           		System.err.println("Неправильный формат строки!");  
		           		throw new ArithmeticException();   
		        }
	        }
	        catch (NumberFormatException e) {  
			System.err.println("Неправильный формат строки!"); 
	        	throw new ArithmeticException();
	        }
	    
	
		}
	
}
