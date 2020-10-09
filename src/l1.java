import java.util.HashMap;
public class l1 {


	 static HashMap<String, Integer> l1_list = new HashMap<String, Integer>();
	 
    public static int count(int target) {
    	int count=0;
    	int[][]data=record.get();
    	for(int i=0;i<10;i++) {
    		if(data[i][target]==1)
    			count++;
    	}
    	String index = String.format("%d", target);
        l1_list.put(index,count);
    	return count;
    }
    public static int get(int target) {
    	String index = String.format("%d", target);
    	return l1_list.get(index);
    }
}

