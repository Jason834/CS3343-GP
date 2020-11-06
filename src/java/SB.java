
import java.util.*;
public class SB {
	List<List <String>> raw_data;
	double support;
	double confidence;
	SB(List<List <String>> raw_data,double support,double condfidence){
		this.raw_data=raw_data;
		this.support=support;
		
	}
	
	public int get_count(Set<String> target,List<List<String>> raw_data) {
		int count=0;
		for(int i=0;i<raw_data.size();i++) {
			if(raw_data.get(i).containsAll(target)) {
				count+=1;
			}
		}
		return count;
	}
	
	public void print_all(Set<String> items) {
		String[] temp = items.toArray(new String[0]);
		for(int x=0;x<temp.length;x++) {
			System.out.printf("%s ", temp[x]);								//print all string in the array
		}
	}
	
	
	
	public List <Item_subset>  find_frequent_itemset(List<List<String>> raw_data,List<String> all_items,int bottom_line) {
		List <Item_subset>  result = new ArrayList<>();
		int max_size=get_max_size(raw_data);
		for(int i=1;i<max_size+1;i++) {
			List<Set<String>> all_subset;
			boolean early_quit=true;
			all_subset=get_all_subsets(all_items,i);									//get all subset into memory
			for(int j=0;j<all_subset.size();j++) {
				int count = get_count(all_subset.get(j),raw_data);						//find the confidence of the target
				if(count>=bottom_line) {											//check if it pass the confidence
					early_quit=false;
					//String[] temp = all_subset.get(j).toArray(new String[0]);
					//for(int x=0;x<all_subset.get(j).size();x++) {
					//	System.out.printf("%s ", temp[x]);								//print all string in the array
					//}
					print_all(all_subset.get(j));
					System.out.printf("appears %d times \n",count);
					result.add(new Item_subset(all_subset.get(j),count));			//add the occurrence to the array
				}
			}
			if(early_quit)
				break;
		}
		return result;
	}
	
	
	
	
	public List <AssociationRule> find_confident_rule( List <Item_subset> frequent_items,double confidence) {
		int max_size=get_max_size(raw_data);
		List <AssociationRule> selected_rules=new ArrayList<>();
		for(int i=1;i<max_size;i++) {
			HashMap<String,Integer> candidate= new HashMap<String, Integer>();;
			List<Item_subset> target=new ArrayList<>();
			for(Item_subset each_fre:frequent_items) {
				//Item_subset each_fre=frequent_items.get(j);
				if(each_fre.size==i) {												
					String[] temp =each_fre.items.toArray(new String[0]);			
					String idx = String.join("",temp);
					candidate.put(idx,each_fre.occurrence);			//add the occurrence to the hash map
				}
				else {
					target.add(each_fre);
				}
					
			}
			for(int x=0;x<target.size();x++) {
				Item_subset each_tar = target.get(x);
				//Set<String> sourceSet = each.items;
				List<String> item_list = new ArrayList<>(each_tar.items);				//change from set to list
				for(int y=1;y<=each_tar.size;y++) {
					List<Set<String>> possible_candidates=new ArrayList<>();
					possible_candidates=get_all_subsets(item_list,x);
					for(Set<String> each_can:possible_candidates){
						//Set<String> each_can=possible_candidates.get(z);
						String[] temp =each_can.toArray(new String[0]);			
						String idx = String.join("",temp);
						if(candidate.containsKey(idx)) {														//check key
							double local_confidence;
							System.out.printf("occurence=%d , candiate=%d \n",each_tar.occurrence,candidate.get(idx));
							local_confidence=(double)each_tar.occurrence/(double)candidate.get(idx);
							each_tar.items.remove(each_can);													//remove candidate from the item
							System.out.printf("{%f} for", local_confidence);
							System.out.print(each_can+" -> "+each_tar.items+" \n");
							if(local_confidence>=confidence) {
								selected_rules.add(new AssociationRule(each_can,each_tar.items,local_confidence));
							}
						}
					}
				}	
			}
		}
		
		
		return selected_rules;
	}
		
	public void find_interest(List <AssociationRule> selected_rules,List<List<String>>raw_data ) {
		for(AssociationRule each : selected_rules) {
			//AssociationRule each = selected_rules.get(i); 
			int count=get_count(each.right,raw_data);
			double natural_occurrence = (double)count/(double)raw_data.size();
			each.set_interest( Math.abs(Math.round((double)each.confidence-natural_occurrence)));
		}
		
		
		//return 0.1;
	}
	
	public void get_recommendation( List <AssociationRule> result_interest) {
		int top=10;
		int count =0;
		for(AssociationRule each:result_interest) {
		//	AssociationRule each=result_interest.get(i);
			if (count>top)
				break;
			System.out.print("If you buy{"+each.left+"} , you will probably buy{"+each.right+"}\n");
			count+=1;
		}
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

	public static List<Set<String>> get_all_subsets(List<String> superSet, int k) {
	    List<Set<String>> res = new ArrayList<>();
	    get_all_subsets(superSet, k, 0, new HashSet<String>(), res);
	    return res;
	}
	
	
	

	
	
	
	
	public List<String>get_all_items(List<List<String>> raw_data) {
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
	
	
	
	
	public int get_max_size(List<List<String>> raw_data) {
		int max = 0;
		for(int i=0;i<raw_data.size();i++) {
			if(raw_data.get(i).size()>max)
				max=raw_data.get(i).size();
		}
		return max;
	}
	
	
	public void run() {
		int bottom_line=(int)this.support*this.raw_data.size();
		List <String> all_items;
		//set of all items
		all_items=get_all_items(this.raw_data);
		//find frequenlty appear items
		List<Item_subset> frequent_items;
		frequent_items = find_frequent_itemset(this.raw_data,all_items,bottom_line);
		List<AssociationRule> selected_rules= find_confident_rule(frequent_items,confidence);
		find_interest(selected_rules,raw_data);
		get_recommendation(selected_rules);
		
		
			 
	}
	

	
}
