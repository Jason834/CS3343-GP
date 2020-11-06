
import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		
	
		
		List<List<String>>data=new ArrayList<>();
		
		
		String[][] input={{"Bread", "Milk"},
		                   {"Bread", "Diaper", "Beer", "Eggs"},
		                   {"Milk", "Diaper", "Beer", "Coke"},
		                   {"Bread", "Milk", "Diaper", "Beer"},
		                   {"Bread", "Milk", "Diaper", "Coke"}
		};
	

		for(int i=0;i<input.length;i++) {
			List<String> strings =  new ArrayList<String>(Arrays.asList(input[i]));
			data.add(strings);
		}
		
		double support =0.6,confidence=0.8;
		

		SB process = new SB(data,support,confidence);
		
		process.run();

		
	}
}
