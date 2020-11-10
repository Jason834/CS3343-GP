package SB;

import java.util.List;

public class Main {
	
	public static void main(String[] args)  {
		
	
		
	
		String[][] input={{"Bread", "Milk"},
		                   {"Bread", "Diaper", "Beer", "Eggs"},
		                   {"Milk", "Diaper", "Beer", "Coke"},
		                   {"Bread", "Milk", "Diaper", "Beer"},
		                   {"Bread", "Milk", "Diaper", "Coke"}
		};
	

		
		double support =0.6,confidence=0.8;	
	
		Record R=new Record(input);
		//Record R= new Record("Record.csv");        //input by file
		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule>resultant_rules=process.run();
		System.out.println();
		
	}
	
	

}
