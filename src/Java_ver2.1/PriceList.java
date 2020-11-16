
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PriceList {
	
	static HashMap<String,Integer> price_table = new HashMap<String,Integer>();
	static String[][] input={{"Bread", "12"},
	                   {"Diaper", "100"},
	                   {"Milk", "10"},
	                   {"Beer", "16"},
	                   {"Egg", "15"},
	                   {"Coke","5"}
	};
	
	public static void init(String[][] input) {
		for(int i=0;i<input.length;i++) {
			 price_table.put(input[i][0],Integer.parseInt(input[i][1]));  
		}
	}
	
	
	public static int get_price(Set<String> items) {
		int sum=0;
		if(price_table.isEmpty()) {
			init(input);
		}
		for(String name:items) {
			sum+=price_table.get(name);
		}
		return sum;
		
	}
	public void init(String file_name){
		try (Scanner scanner = new Scanner(new File(file_name));) {
			 while (scanner.hasNextLine()) {
				 String[] data = scanner.nextLine().split(",");
				 price_table.put(data[0],Integer.parseInt(data[1]));  
			 }
		} catch (FileNotFoundException e) {
			System.out.print("cannot open file" + file_name +"\n");
		}	
	}
	
}
