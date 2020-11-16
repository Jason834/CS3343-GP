import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Record {
	
	private List<List<String>>raw_data;
	private static List <String> all_items;
	private int size;

	Record(List<List<String>> data){
		this.raw_data=data;
		all_items =get_all_items();
		this.size=raw_data.size();
	}
	
	Record(String[][] input) {
		List<List<String>> data = new ArrayList<>();
		
		for(int i=0;i<input.length;i++) {
			List<String> strings =  new ArrayList<String>(Arrays.asList(input[i]));
			data.add(strings);
		}
		this.raw_data=data;
		all_items =get_all_items();
		this.size=raw_data.size();
	} 
	
	Record(String file_name){
		try (Scanner scanner = new Scanner(new File(file_name));) {
			 while (scanner.hasNextLine()) {
			        raw_data.add(getRecordFromLine(scanner.nextLine()));
			 }
		} catch (FileNotFoundException e) {
			System.out.print("cannot open file" + file_name +"\n");
		}
		
	}
	public List<String>get_all_items() {										//find all items in the list 
		List<String> all_items=new ArrayList<>() ;
		for(int i=0;i<raw_data.size();i++) {
			for(int j=0;j<raw_data.get(i).size();j++) {
				String temp=raw_data.get(i).get(j);
				if(!all_items.contains(temp)){
					all_items.add(temp);
				}
			}
		}
		return all_items;
	}
	
	public int get_max_size() {
		int max = 0;
		for(int i=0;i<raw_data.size();i++) {
			if(raw_data.get(i).size()>max)
				max=raw_data.get(i).size();
		}
		return max;
	}
	
	public int get_count(Set<String> target) {
		int count=0;
		for(int i=0;i<raw_data.size();i++) {
			if(raw_data.get(i).containsAll(target)) {
				count+=1;
			}
		}
		return count;
	}
	
	
	private static void get_all_subsets(List<String> superSet, int k, int idx, Set<String> current,List<Set<String>> solution) {
	    //successful stop clause
	    if (current.size() == k) {
	        solution.add(new HashSet<>(current));
	        return;
	    }
	    //unseccessful stop clause
	    if (idx == superSet.size()) return;
	    String x = superSet.get(idx);
	    current.add(x);
	    //"guess" x is in the subset
	    get_all_subsets(superSet, k, idx+1, current, solution);
	    current.remove(x);
	    //"guess" x is not in the subset
	    get_all_subsets(superSet, k, idx+1, current, solution);
	}

	public List<Set<String>> get_all_subsets(int n) {
	    List<Set<String>> res = new ArrayList<>();
	    get_all_subsets(all_items, n, 0, new HashSet<String>(), res);
	    return res;
	}
	
	public int get_size() {
		return this.size;
	}
	
//	public void print_all(){
//		for(int i=0;i<raw_data.size();i++) {
//			System.out.print(raw_data.get(i)+"\n");
//		}
//	}
	
	private static List<String> getRecordFromLine(String line) {
	    List<String> values = new ArrayList<String>();
	    String[] data = line.split(",");
	    for(int i=1;i<data.length;i++) {
	    	values.add(data[i]);
	    }
		return values;
	}

	
	public void add(List<String> input) {
		raw_data.add(input);
	}
	
	
}
