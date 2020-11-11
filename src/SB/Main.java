package SB;

import java.util.List;

public class Main {
	
	public static void main(String[] args)  {
		
//		String[][] input={
//				{"Bread", "Milk"},
//                {"Bread", "Diaper", "Beer", "Eggs"},
//                {"Milk", "Diaper", "Beer", "Coke"},
//                {"Bread", "Milk", "Diaper", "Beer"},
//                {"Bread", "Milk", "Diaper", "Coke"}
//			};
				
	
		
		String[][] input={  
		 		{"Coke", "Chips", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush", "Shampoo"},
		 		{"Shampoo", "Washing Powder", "Toothbrush", "Toothpaste"},
		 		{"T-shirt", "Washing Powder", "Toothbrush", "Coke", "Chips"},
		 		{"Pen", "Tape", "Toothbrush", "Coke", "Chips"},
		 		{"Coke", "Chips", "Pills", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush", "Shampoo", "Washing Powder"},
		 		{"Pen", "Tape", "T-shirt", "Toothbrush", "Toothpaste"},
		 		{"T-shirt", "Toothbrush"},
		 		{"T-shirt", "Toothpaste"},
		 		{"Coke", "Pen", "Chips"},
		 		{"Coke", "T-shirt", "Chips"},
		 		{"Coke", "Tape", "Chips"},
		 		{"Tape", "Chips", "Pills"},
		 		{"Coke", "Tape", "Chips", "Pills", "Toothbrush"},
		 		{"Tape", "Chips", "Pills", "Toothpaste", "Toothbrush"},
		 		{"Shampoo", "Tape", "Pills", "T-shirt", "Toothbrush"}
			};
	

		
		double support = 0.2, confidence = 0.6;	
	
		Record R= new Record(input);
		//Record R= new Record("Record.csv");        //input by file
		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule> resultant_rules = process.run();
		System.out.println();
		
	}
	
	

}
