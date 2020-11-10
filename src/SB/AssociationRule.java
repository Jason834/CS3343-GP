package SB;
import java.util.Set;
public class AssociationRule {
	double confidence,interest;
	Set<String> left,right;
	public AssociationRule(Set<String> left,Set<String> right,double confidence){
		this.left=left;
		this.right=right;
		this.confidence=0;
		this.interest=0;
	}
	
	public void set_interest(double interest){
		this.interest=interest;
	}
	
	
	public String get_str() {
		
		if(this.interest!=0)
			return String.format("{%s}=>{%s} with confidence: {%0.2f}, interest:{%s}",left,right,confidence,interest);
		else 
			return String.format("{%s}=>{%s} with confidence: {%0.2f}",left,right,confidence);
	} 
	
	public boolean is_equal(AssociationRule B ) {
		return this.left.equals(B.left)&& this.right.equals(B.right)&&this.confidence==B.confidence&&this.interest==B.interest;
		
	}

	
}
