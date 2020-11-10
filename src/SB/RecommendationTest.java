package testRecommendation;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Recommendation.*;

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
		
		List<AssociationRule> result;
		//List<AssociationRule> expected_result = {new AssociationRule(set(["a"]),set(["a"]),confidence)};
		
		String[][] input={ 
		 		{"Bread", "Milk"},
		 		{"Bread", "Diaper", "Beer", "Eggs"},
		 		{"Milk", "Diaper", "Beer", "Coke"},
		 		{"Bread", "Milk", "Diaper", "Beer"},
		 		{"Bread", "Milk", "Diaper", "Coke"}
			};
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		result = process.run();
		//assertEquals(expected_result, result);
	}
}
