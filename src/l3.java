import java.util.HashMap;

public class l3 {

	static HashMap<String, Integer> l3_list = new HashMap<String, Integer>();

		 
	    public static int count(int t1,int t2,int t3) {
	    	int count=0;
	    	int[][]data=record.get();
	    	for(int i=0;i<10;i++) {
	    		if(data[i][t1]==1&&data[i][t2]==1&&data[i][t3]==1)
	    			count++;
	    	}
	    	String index = String.format("%d%d%d", t1, t2,t3);
	        l3_list.put(index,count);
	    	return count;
	    }
	    public static int get(int t1,int t2,int t3) {
	    	String index = String.format("%d%d%d", t1, t2,t3);
	    	return l3_list.get(index);
	    }
	   


}
