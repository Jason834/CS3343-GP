import java.util.HashMap;
import java.util.List;

public class Normal implements Membership{
	
	private static double support =0.4,confidence=0.6;	
	private List<AssociationRule> Rules;
	
	public HashMap<String, Double> get_recommandation(Record R,List<String> items) {
		
		boolean has_rule=false;
		HashMap<String, Double> recommandList = new HashMap<String, Double>();
		
		System.out.print("You are Normal Member\n");
		RuleGenerator process = new RuleGenerator(R,support,confidence);
		this.Rules = process.run();
		
		for(AssociationRule rule:Rules) {
			
			if(items.containsAll(rule.left)) {
				has_rule=true;
				if(rule.right.size()==1) {
					double price = PriceList.get_price(rule.right);
					System.out.print("You bought "+rule.left+" , you probably need "+rule.right +" with $"+price+"\n");
					recommandList.put(rule.right.toString(), price);
				}
				else
				{
					int discount = rule.right.size()/2*5;
					double price = (double)PriceList.get_price(rule.right)*(double)(100-discount)/(double)100;
					System.out.print("You bought "+rule.left+" , you can buy "+rule.right +" with "+ discount+"% off only $"+price+"\n");
					recommandList.put(rule.right.toString(), price);
				}
			}
		}
		
		if(!has_rule) {
			System.out.print("Thank You \n");
		}
		
		return recommandList;
	};
}

