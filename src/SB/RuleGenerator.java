package SB;
import java.util.*;
public class RuleGenerator {
	//List<List <String>> raw_data;
		double support;
		double confidence;
		Record R;
		RuleGenerator(Record R,double support,double condfidence){
			
			this.support=support;
			this.R= R;
			
		}
	
		public List <AssociationRule> find_confident_rule( List <Item_subset> frequent_items,double confidence) {
			int max_size=R.get_max_size();
			//System.out.print("max size = "+max_size+"\n");
			List <AssociationRule> selected_rules=new ArrayList<>();
			for(int i=1;i<max_size;i++) {
			//	HashMap<String,Integer> candidate= new HashMap<String, Integer>();;
				List<Item_subset> right_target=new ArrayList<>();
				List<Item_subset> left_target=new ArrayList<>();
				for(Item_subset each_fre:frequent_items) {
					if(each_fre.items.size()==i) {												
						left_target.add(each_fre);
						System.out.print("add:"+each_fre.items+"to left \n");
					}
					else {
						if(each_fre.items.size()>i) {
							right_target.add(each_fre);
							System.out.print("add:"+each_fre.items+"to right \n");
						}
					}
						
				}
				for(int x=0;x<left_target.size();x++) {
					Item_subset left_set = left_target.get(x);
					System.out.print("Seraching for: "+left_set.items+"\n");
					//Set<String> sourceSet = each.items;
					for(int y=0;y<right_target.size();y++) {	
						Item_subset right_set = right_target.get(y);
						System.out.print("Checking for: "+right_set.items+"\n");
						if(right_set.items.containsAll(left_set.items)) {
							double local_confidence;
							System.out.print(left_set.items+"left occurence= "+left_set.occurrence+"||"+right_set.items+"right occurence="+right_set.occurrence+"\n");
							local_confidence=(double)right_set.occurrence/(double)left_set.occurrence;
							Set<String> right_temp= new HashSet<>(right_set.items);
							right_temp.removeAll(left_set.items);
							System.out.printf("{%1.2f} for", local_confidence);
							System.out.print(left_set.items+" -> "+right_temp+" \n");
							
							if(local_confidence>=confidence) {
								System.out.print("Adding new rule");
								selected_rules.add(new AssociationRule(left_set.items,right_temp,local_confidence));
							}
						}	else
						{
							System.out.print("No\n");
						}
					}				
				}
			}	
			return selected_rules;
		}
			
		public void find_interest(List <AssociationRule> selected_rules ) {
			for(AssociationRule each : selected_rules) {
				//AssociationRule each = selected_rules.get(i); 
				int count=R.get_count(each.right);
				double natural_occurrence = (double)count/(double)R.get_size();
				each.set_interest( Math.abs(Math.round((double)each.confidence-natural_occurrence)));
			}	
		}
		
		public void get_recommendation( List <AssociationRule> result_interest) {
			int top=10;
			int count =0;
			for(AssociationRule each:result_interest) {
				if (count>top)
					break;
				System.out.print("If you buy "+each.left+" , you will probably buy "+each.right+" With interest "+each.interest +" \n");
				count+=1;
			}
		}
		
			

		public List<AssociationRule> run() {
			int bottom_line=(int)(this.support*R.get_size());
			System.out.print("bottom line= "+ bottom_line+"\n");
			Itemset_Generator IG=new Itemset_Generator(R);
			List<Item_subset> frequent_items = IG.find_frequent_itemset(bottom_line);
			List<AssociationRule> selected_rules= find_confident_rule(frequent_items,confidence);
			find_interest(selected_rules);
			get_recommendation(selected_rules);
			return selected_rules;
		}
		
}
