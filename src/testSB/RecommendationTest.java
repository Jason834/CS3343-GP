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
	public void test_PASS_A01() {
		
		support    = 0.2;
		confidence = 0.5;
		
		String[][] input={ 
		 		{"Coke", "Chips", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush", "Shampoo"},
		 		{"Shampoo", "Washing Powder", "Toothbrush", "Toothpaste"},
		 		{"T-shirt", "Washing Powder", "Toothbrush", "Coke", "Chips"},
		 		{"Pen", "Tape", "Toothbrush", "Coke", "Chips"},
		 		{"Coke", "Chips", "Pills", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush", "Shampoo", "Washing Powder"},
		 		{"Pen", "Tape", "T-shirt", "Toothbrush", "Toothpaste"},
		 		{"T-shirt", "Toothbrush"},
		 		{"T-shirt", "Toothpaste"},
		 		{"Coke", "Pen", "Chips"},
		 		{"Coke", "T-shirt", "Chips"},
		 		{"Coke", "Tape", "Chips"},
		 		{"Tape", "Chips", "Pills"},
		 		{"Coke", "Tape", "Chips", "Pills", "Toothbrush"},
		 		{"Tape", "Chips", "Pills", "Toothpaste", "Toothbrush"},
		 		{"Shampoo", "Tape", "Pills", "T-shirt", "Toothbrush"}
			};
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule>resultant_rules = process.run();
		
		Set<String> sample_set_L = new HashSet<String>();		
		sample_set_L.addAll(Arrays.asList(new String[] {"Coke"}));
		Set<String> sample_set_R = new HashSet<String>();  
		sample_set_R.addAll(Arrays.asList(new String[] {"Chips"}));
		
		AssociationRule expected_result = new AssociationRule(sample_set_L,sample_set_R,0);
		expected_result.set_interest(1.0);
		
		Boolean expected_rule_is_contained = false;
		
		for(AssociationRule result_rule : resultant_rules)
		{
			if (result_rule.is_equal(expected_result))
				expected_rule_is_contained=true;
		}
		
		assert(expected_rule_is_contained);
	}
	
	@Test
	public void test_PASS_A02() {
		
		support    = 0.2;
		confidence = 0.5;
		
		String[][] input={ 
		 		{"Coke", "Chips", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush", "Shampoo"},
		 		{"Shampoo", "Washing Powder", "Toothbrush", "Toothpaste"},
		 		{"T-shirt", "Washing Powder", "Toothbrush", "Coke", "Chips"},
		 		{"Pen", "Tape", "Toothbrush", "Coke", "Chips"},
		 		{"Coke", "Chips", "Pills", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush", "Shampoo", "Washing Powder"},
		 		{"Pen", "Tape", "T-shirt", "Toothbrush", "Toothpaste"},
		 		{"T-shirt", "Toothbrush"},
		 		{"T-shirt", "Toothpaste"},
		 		{"Coke", "Pen", "Chips"},
		 		{"Coke", "T-shirt", "Chips"},
		 		{"Coke", "Tape", "Chips"},
		 		{"Tape", "Chips", "Pills"},
		 		{"Coke", "Tape", "Chips", "Pills", "Toothbrush"},
		 		{"Tape", "Chips", "Pills", "Toothpaste", "Toothbrush"},
		 		{"Shampoo", "Tape", "Pills", "T-shirt", "Toothbrush"}
			};
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule> resultant_rules = process.run();
		
		Set<String> sample_set_L = new HashSet<String>();		
		sample_set_L.addAll(Arrays.asList(new String[] {"Coke"}));
		Set<String> sample_set_R = new HashSet<String>();  
		sample_set_R.addAll(Arrays.asList(new String[] {"Toothbrush"}));
		
		AssociationRule expected_result = new AssociationRule(sample_set_L,sample_set_R,0);
		expected_result.set_interest(1.0);
		
		Boolean expected_rule_is_contained = false;
		
		for(AssociationRule result_rule : resultant_rules)
		{
			if (result_rule.is_equal(expected_result))
				expected_rule_is_contained=true;
		}
		
		assert(expected_rule_is_contained);
	}
	
	@Test
	public void test_PASS_A03() {
		
		support    = 0.2;
		confidence = 0.5;	
		
		String[][] input={ 
		 		{"Coke", "Chips", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush", "Shampoo"},
		 		{"Shampoo", "Washing Powder", "Toothbrush", "Toothpaste"},
		 		{"T-shirt", "Washing Powder", "Toothbrush", "Coke", "Chips"},
		 		{"Pen", "Tape", "Toothbrush", "Coke", "Chips"},
		 		{"Coke", "Chips", "Pills", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush", "Shampoo", "Washing Powder"},
		 		{"Pen", "Tape", "T-shirt", "Toothbrush", "Toothpaste"},
		 		{"T-shirt", "Toothbrush"},
		 		{"T-shirt", "Toothpaste"},
		 		{"Coke", "Pen", "Chips"},
		 		{"Coke", "T-shirt", "Chips"},
		 		{"Coke", "Tape", "Chips"},
		 		{"Tape", "Chips", "Pills"},
		 		{"Coke", "Tape", "Chips", "Pills", "Toothbrush"},
		 		{"Tape", "Chips", "Pills", "Toothpaste", "Toothbrush"},
		 		{"Shampoo", "Tape", "Pills", "T-shirt", "Toothbrush"}
			};
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule> resultant_rules = process.run();
		
		Set<String> sample_set_L = new HashSet<String>();		
		sample_set_L.addAll(Arrays.asList(new String[] {"Chips"}));
		Set<String> sample_set_R = new HashSet<String>();  
		sample_set_R.addAll(Arrays.asList(new String[] {"Toothbrush"}));
		
		AssociationRule expected_result = new AssociationRule(sample_set_L,sample_set_R,0);
		expected_result.set_interest(1.0);
		
		Boolean expected_rule_is_contained = false;
		
		for(AssociationRule result_rule : resultant_rules)
		{
			if (result_rule.is_equal(expected_result))
				expected_rule_is_contained=true;
		}
		
		assert(expected_rule_is_contained);
	}
	
	@Test
	public void test_ERR_Support() { // Dataset not enough to suppoert the association rule
		
		support    = 0.8;
		confidence = 0.5;
		
		String[][] input={ 
		 		{"Coke", "Chips", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush", "Shampoo"},
		 		{"Shampoo", "Washing Powder", "Toothbrush", "Toothpaste"},
		 		{"T-shirt", "Washing Powder", "Toothbrush", "Coke", "Chips"},
		 		{"Pen", "Tape", "Toothbrush", "Coke", "Chips"},
		 		{"Coke", "Chips", "Pills", "Toothbrush"},
		 		{"Toothpaste", "Toothbrush", "Shampoo", "Washing Powder"},
		 		{"Pen", "Tape", "T-shirt", "Toothbrush", "Toothpaste"},
		 		{"T-shirt", "Toothbrush"},
		 		{"T-shirt", "Toothpaste"},
		 		{"Coke", "Pen", "Chips"},
		 		{"Coke", "T-shirt", "Chips"},
		 		{"Coke", "Tape", "Chips"},
		 		{"Tape", "Chips", "Pills"},
		 		{"Coke", "Tape", "Chips", "Pills", "Toothbrush"},
		 		{"Tape", "Chips", "Pills", "Toothpaste", "Toothbrush"},
		 		{"Shampoo", "Tape", "Pills", "T-shirt", "Toothbrush"}
			};
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule> resultant_rules = process.run();
		
		List<AssociationRule> expected_result = new ArrayList<AssociationRule>(); // blank result
				
		assertEquals(expected_result, resultant_rules);
	}
	
	@Test
	public void test_ERR_NoData() { // No Data Input
		
		support    = 0.2;
		confidence = 0.5;
		
		String[][] input={};
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule> resultant_rules = process.run();
		
		List<AssociationRule> expected_result = new ArrayList<AssociationRule>(); // blank result
				
		assertEquals(expected_result, resultant_rules);
	}
}
