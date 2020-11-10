package SB; 

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
