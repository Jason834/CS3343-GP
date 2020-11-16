
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SB.*;

public class RecommendationTest {

//	private double support;
//	private double confidence;
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
	@BeforeEach
	public void setUp() throws Exception {}

	//public void tearDown() {}
	
	@Test
	public void test_Visitor_01() {
		
		String[] user_input1={"0","Milk"};
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		Record record  = new Record(input);
		
		List<String> items = new ArrayList<>();
		items.add(user_input1[1]);

		
		Visitor visitor = new Visitor();
		
		HashMap<String, Double> expected = new HashMap<String, Double>();
		expected.put("[Coke]",5.0);
		expected.put("[Diaper, Beer]",113.68);
		expected.put("[Coke, Diaper]",102.9);
		expected.put("[Bread, Diaper]",109.76);
		expected.put("[Beer]",16.0);
		expected.put("[Diaper]",100.0);
		expected.put("[Bread]",12.0);
		
		HashMap<String, Double> result = visitor.get_recommandation(record, items);
						
		assertEquals(expected,result);
	}
	
	@Test
	public void test_Visitor_02() {
		
		String[] user_input1={"0","Ice"};
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		Record record  = new Record(input);
		
		List<String> items = new ArrayList<>();
		items.add(user_input1[1]);

		
		Visitor visitor = new Visitor();
		
		HashMap<String, Double> expected = new HashMap<String, Double>();
		
		HashMap<String, Double> result = visitor.get_recommandation(record, items);
						
		assertEquals(expected,result);
	}
	
	@Test
	public void test_Normal_01() {
		
		String[] user_input1={"1","Bread"};
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		Record record  = new Record(input);
		
		List<String> items = new ArrayList<>();
		items.add(user_input1[1]);

		
		Normal normal = new Normal();
		
		HashMap<String, Double> expected = new HashMap<String, Double>();
		expected.put("[Milk]",10.0);
		expected.put("[Milk, Diaper]",104.5);
		expected.put("[Diaper, Beer]",110.2);
		expected.put("[Beer]",16.0);
		expected.put("[Diaper]",100.0);
		
		HashMap<String, Double> result = normal.get_recommandation(record, items);
						
		assertEquals(expected,result);
	}
	
	@Test
	public void test_Normal_02() {
		
		String[] user_input1={"1","Apple"};
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		Record record  = new Record(input);
		
		List<String> items = new ArrayList<>();
		items.add(user_input1[1]);

		
		Normal normal = new Normal();
		
		HashMap<String, Double> expected = new HashMap<String, Double>();
		
		HashMap<String, Double> result = normal.get_recommandation(record, items);
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_VIP_01() {
		
		String[] user_input1={"2","Coke"};
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		Record record  = new Record(input);
		
		List<String> items = new ArrayList<>();
		items.add(user_input1[1]);

		
		VIP vip = new VIP();
		
		HashMap<String, Double> expected = new HashMap<String, Double>();
		expected.put("[Milk]",10.0);
		expected.put("[Milk, Diaper]",99.0);
		expected.put("[Diaper]",100.0);
		
		HashMap<String, Double> result = vip.get_recommandation(record, items);		
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_VIP_02() {
		
		String[] user_input1={"2","Egg"};
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		Record record  = new Record(input);
		
		List<String> items = new ArrayList<>();
		items.add(user_input1[1]);

		
		VIP vip = new VIP();
		
		HashMap<String, Double> expected = new HashMap<String, Double>();
		
		HashMap<String, Double> result = vip.get_recommandation(record, items); 
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_RS_01() {
		
		String[] user_input1={"0","Coke"};
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		RecommandationSystem RS = new RecommandationSystem(input);
		
		HashMap<String, Double> expected = new HashMap<String, Double>();
		expected.put("[Milk]",10.0);
		expected.put("[Milk, Diaper]",107.8);
		expected.put("[Diaper]",100.0);
		
		HashMap<String, Double> result = RS.recommand(user_input1);		
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_RS_02() {
		
		String[] user_input1={"1","Coke"};
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		RecommandationSystem RS = new RecommandationSystem(input);
		
		HashMap<String, Double> expected = new HashMap<String, Double>();
		expected.put("[Milk]",10.0);
		expected.put("[Milk, Diaper]",104.5);
		expected.put("[Diaper]",100.0);
		
		HashMap<String, Double> result = RS.recommand(user_input1);		
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_RS_03() {
		
		String[] user_input1={"2","Coke"};
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		RecommandationSystem RS = new RecommandationSystem(input);
		
		HashMap<String, Double> expected = new HashMap<String, Double>();
		expected.put("[Milk]",10.0);
		expected.put("[Milk, Diaper]",99.0);
		expected.put("[Diaper]",100.0);
		
		HashMap<String, Double> result = RS.recommand(user_input1);		
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_RS_04() {
		
		String[] user_input1={"3","Coke"};
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		RecommandationSystem RS = new RecommandationSystem(input);
		
		HashMap<String, Double> expected = new HashMap<String, Double>();
		
		HashMap<String, Double> result = RS.recommand(user_input1);		
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_Record_01() {
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		Record r = new Record(input);
		
		List<String> expected = new ArrayList<String>();
		expected.add("Bread");
		expected.add("Milk");
		expected.add("Diaper");
		expected.add("Beer");
		expected.add("Eggs");
		expected.add("Coke");
		
		List<String>  result = r.get_all_items();
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_Record_02() {
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs", "Coke"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"},
							{"Bread"}
						   };
		
		Record r = new Record(input);
		
		int expected = 5;
		
		int  result = r.get_max_size();
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_Record_03() {
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		Record r = new Record(input);
		
		int expected = 3;
		
		Set<String> target = new HashSet<String>(); 
		target.add("Bread");
		target.add("Milk");
		
		int  result = r.get_count(target);
		
		assertEquals(expected,result);
	}
	
	
	@Test
	public void test_RuleGenerator_01() {
		
		double support = 0.4;
		double confidence = 0.6;	
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule> result = process.run();
		
		Set<String> sample_set_L = new HashSet<String>();		
		sample_set_L.addAll(Arrays.asList(new String[] {"Bread"}));
		Set<String> sample_set_R = new HashSet<String>();  
		sample_set_R.addAll(Arrays.asList(new String[] {"Milk"}));
		
		AssociationRule expected = new AssociationRule(sample_set_L,sample_set_R,0);
		expected.set_interest(1.0);
		
		Boolean expected_rule_is_contained = false;
		
		for(AssociationRule result_rule : result)
		{
			if (result_rule.is_equal(expected))
				expected_rule_is_contained = true;
		}
		
		assertEquals(true,expected_rule_is_contained);
	}
	
	@Test
	public void test_RuleGenerator_02() {
		
		double support = 0.8;
		double confidence = 0.8;	
		
		String[][] input = {
							{"Bread", "Milk"},
							{"Bread", "Diaper", "Beer", "Eggs"},
							{"Milk", "Diaper", "Beer", "Coke"},
							{"Bread", "Milk", "Diaper", "Beer"},
							{"Bread", "Milk", "Diaper", "Coke"}
						   };
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule> result = process.run();
		
		List<AssociationRule> expected = new ArrayList<AssociationRule>();
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_RuleGenerator_03() {
		
		double support = 0.4, confidence = 0.6;	
		
		String[][] input = {};
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule> result = process.run();
		
		List<AssociationRule> expected = new ArrayList<AssociationRule>();
		
		assertEquals(expected,result);
	}
	
	@Test
	public void test_RuleGenerator_04() {
		
		double support = 0;
		double confidence = 0.6;	
		
		String[][] input = {};
		
		Record R = new Record(input);

		RuleGenerator process = new RuleGenerator(R,support,confidence);
		List<AssociationRule> result = process.run();
		
		List<AssociationRule> expected = new ArrayList<AssociationRule>();
		
		assertEquals(expected,result);
	}
//	
//	@Test
//	public void test_PASS_A03() {	
//		
//		String[][] record={{"Bread", "Milk"},
//                {"Bread", "Diaper", "Beer", "Eggs"},
//                {"Milk", "Diaper", "Beer", "Coke"},
//                {"Bread", "Milk", "Diaper", "Beer"},
//                {"Bread", "Milk", "Diaper", "Coke"}
//};
//		
//		Record R = new Record(record);
//
//		RuleGenerator process = new RuleGenerator(R,support,confidence);
//		List<AssociationRule> resultant_rules = process.run();
//		
//		Set<String> sample_set_L = new HashSet<String>();		
//		sample_set_L.addAll(Arrays.asList(new String[] {"Chips"}));
//		Set<String> sample_set_R = new HashSet<String>();  
//		sample_set_R.addAll(Arrays.asList(new String[] {"Toothbrush"}));
//		
//		AssociationRule expected_result = new AssociationRule(sample_set_L,sample_set_R,0);
//		expected_result.set_interest(1.0);
//		
//		Boolean expected_rule_is_contained = false;
//		
//		for(AssociationRule result_rule : resultant_rules)
//		{
//			if (result_rule.is_equal(expected_result))
//				expected_rule_is_contained=true;
//		}
//		
//		assert(expected_rule_is_contained);
//	}
//	
//	@Test
//	public void test_ERR_Support() { // Dataset not enough to suppoert the association rule
//
//		
//		String[][] record={{"Bread", "Milk"},
//                {"Bread", "Diaper", "Beer", "Eggs"},
//                {"Milk", "Diaper", "Beer", "Coke"},
//                {"Bread", "Milk", "Diaper", "Beer"},
//                {"Bread", "Milk", "Diaper", "Coke"}
//};
//		
//		Record R = new Record(record);
//
//		RuleGenerator process = new RuleGenerator(R,support,confidence);
//		List<AssociationRule> resultant_rules = process.run();
//		
//		List<AssociationRule> expected_result = new ArrayList<AssociationRule>(); // blank result
//				
//		assertEquals(expected_result, resultant_rules);
//	}
//	
//	@Test
//	public void test_ERR_NoData() { // No Data Input
//
//		
//		String[][] input={};
//		
//		Record R = new Record(input);
//
//		RuleGenerator process = new RuleGenerator(R,support,confidence);
//		List<AssociationRule> resultant_rules = process.run();
//		
//		List<AssociationRule> expected_result = new ArrayList<AssociationRule>(); // blank result
//				
//		assertEquals(expected_result, resultant_rules);
//	}
}
