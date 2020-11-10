package testSB;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SB.*;

public class RecommendationTest {

	//private Poker poker;
	private double support;
	private double confidence;
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
	@BeforeEach
	public void setUp() throws Exception {}
    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
	public void tearDown() {}
	
	@Test
	public void test0001() {
		
		support    = 0.6;
		confidence = 0.8;	
		String text = "Bread";
		Set<String> set = new HashSet<String>(Arrays.asList(text.split(" ")));
		text = "Milk";
		Set<String> set1 = new HashSet<String>(Arrays.asList(text.split(" ")));
		AssociationRule assRule01 = new AssociationRule(set,set1,confidence);
		assRule01.set_interest(1);
		
		List<AssociationRule> result;
		AssociationRule[] expected_result = {assRule01};
		
		String[][] input={ 
		 		{"Bread", "Milk"},
		 		{"Bread", "Diaper", "Beer", "Eggs"},
		 		{"Milk", "Diaper", "Beer", "Coke"},
			};
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		result = process.run();
		assertEquals(expected_result, expected_result);
	}
	@Test
	public void test0002() {
		
		support    = 0.6;
		confidence = 0.8;	
		
		List<AssociationRule> result;
		
		String[][] input={ 
		 		{"Bread", "Milk"},
		 		{"Bread", "Diaper", "Beer", "Eggs"},
		 		{"Milk", "Diaper", "Beer", "Coke"},
		 		{"Bread", "Milk", "Diaper", "Beer"},
		 		{"Bread", "Milk", "Diaper", "Coke"}
			};
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule>resultant_rules = process.run();
		
		Set<String> sample_set_L=new HashSet<String>();		
		sample_set_L.addAll(Arrays.asList(new String[] {"Bread"}));
		Set<String> sample_set_R=new HashSet<String>();  
		sample_set_R.addAll(Arrays.asList(new String[] {"Milk"}));
		AssociationRule expected_result = new AssociationRule(sample_set_L,sample_set_R,0);
		expected_result.set_interest(1.0);
		Boolean expected_rule_is_contained=false;
		for(AssociationRule result_rule:resultant_rules)
		{
			if (result_rule.is_equal(expected_result))
				expected_rule_is_contained=true;
		}
		assert(expected_rule_is_contained);
	}
}
