import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)  {
		
	
		
	
		String[][] record={{"Bread", "Milk"},
		                   {"Bread", "Diaper", "Beer", "Eggs"},
		                   {"Milk", "Diaper", "Beer", "Coke"},
		                   {"Bread", "Milk", "Diaper", "Beer"},
		                   {"Bread", "Milk", "Diaper", "Coke"}
		};
		RecommandationSystem RS=RecommandationSystem.getInstance("Record.csv");
		
		Scanner scanner = new Scanner(System.in);
		boolean is_end=false;
		System.out.print("Please input the membership index and the items :\n");
		 while (scanner.hasNext()&&is_end==false) {
			
	            String input[]=scanner.nextLine().split(" ");
	            if(input[0].contentEquals("exit")) {
	            	System.out.print("Thank you for using the service \n");
	            	is_end=true;
	            }else if(RS.check(input)) { 
	            	RS.recommand(input);
	            }
	            if(!is_end) 
	    	 	System.out.print("Please input the membership index and the items :\n");
	    }
		scanner.close();
	
	}
	
	

}
