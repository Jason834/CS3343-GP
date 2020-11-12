
import java.util.*;

public class RecommandationSystem {
	private Record R;
	private Membership MS;
	
	
	
	RecommandationSystem(String[][] input){
		this.R=new Record(input);
	}
	
	RecommandationSystem(String filename){
		this.R=new Record(filename);
	}
	
	public void recommand(String[] input) {
		int member=Integer.parseInt(input[0]);
		List<String> items=new ArrayList<>();
		for(int i =1;i<input.length;i++) {
			items.add(input[i]);
		}
		if(member==0) {
			MS= new Visitor();
			MS.get_recommandation(R, items);
		}else
		if(member==1) {
			MS= new Normal();
			MS.get_recommandation(R, items);
		}else
		if(member==2) {
			MS= new VIP();
			MS.get_recommandation(R, items);
		}
		R.add(items);
	}

	
}

