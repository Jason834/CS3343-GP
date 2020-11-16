
import java.util.Set;

public class AssociationRule {
	
	double confidence,interest;
	Set<String> left,right;
	
	AssociationRule(Set<String> left,Set<String> right,double confidence){
		this.left=left;
		this.right=right;
		this.confidence=0;
		this.interest=0;
	}
	
	void set_interest(double interest){
		this.interest=interest;
	}	
	
	public boolean is_equal(AssociationRule B ) {
		return this.left.equals(B.left) && this.right.equals(B.right) && this.confidence==B.confidence && this.interest==B.interest;
		
	}

}
