import java.util.HashMap;
public class l4 {


	static HashMap<String, Integer> l4_list = new HashMap<String, Integer>();

		 
	    public static int count(int t1,int t2,int t3,int t4) {
	    	int count=0;
	    	int[][]data=record.get();
	    	for(int i=0;i<10;i++) {
	    		if(data[i][t1]==1&&data[i][t2]==1&&data[i][t3]==1&&data[i][t4]==1)
	    			count++;
	    	}
	    	String index = String.format("%d%d%d%d", t1, t2,t3,t4);
	        l4_list.put(index,count);
	    	return count;
	    	
	    	
	    }
	    public static int get(int t1,int t2,int t3,int t4) {
	    	String index = String.format("%d%d%d%d", t1, t2, t3, t4);
	    	return l4_list.get(index);
	    }
	




}
