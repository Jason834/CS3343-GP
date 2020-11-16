
import java.util.*;

public class RecommandationSystem {
	private Record R;
	private Membership MS;
	
	
	
	RecommandationSystem (String[][] input){
		this.R = new Record(input);
	}
	
	RecommandationSystem(String filename){
		this.R = new Record(filename);
	}
	
	public HashMap<String, Double> recommand(String[] input) {
		
		int member=Integer.parseInt(input[0]); 
		HashMap<String, Double> recommandList = new HashMap<String, Double>();	
		List<String> items=new ArrayList<>();
		
		for(int i =1;i<input.length;i++) {
			items.add(input[i]);
		}
		
		if(member==0) {
			MS= new Visitor();
			recommandList = MS.get_recommandation(R, items);
		}
		else if(member==1) {
			MS= new Normal();
			recommandList = MS.get_recommandation(R, items);
		}
		else if(member==2) {
			MS= new VIP();
			recommandList = MS.get_recommandation(R, items);
		}
		else {
			System.out.println("ERROR: Unauthorised Access");
			return recommandList;
		}
		
		R.add(items);
		
		return recommandList;
	}

	
}

