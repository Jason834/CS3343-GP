

public class Main {
	
	public static void main(String[] args)  {
		
	
		
	
		String[][]  record={{"Bread", "Milk"},
		                   {"Bread", "Diaper", "Beer", "Eggs"},
		                   {"Milk", "Diaper", "Beer", "Coke"},
		                   {"Bread", "Milk", "Diaper", "Beer"},
		                   {"Bread", "Milk", "Diaper", "Coke"}
		};
	
		String[] user_input1={"0","Coke"};
		String[] user_input2={"1","Coke"};
		String[] user_input3={"2","Coke"};
		RecommandationSystem RS = new RecommandationSystem(record);
		//RecommandationSystem RS=new RecommandationSystem("record.csv");
		RS.recommand(user_input1);
		RS.recommand(user_input2);
		RS.recommand(user_input3);
		

		
	}
	
	

}
