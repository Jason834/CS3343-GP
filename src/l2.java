import java.util.HashMap;
public class l2 {
	   static HashMap<String, Integer> l2_list = new HashMap<String, Integer>();


		 
	    public static int count(int t1,int t2) {
	    	int count=0;
	    	int[][]data=record.get();
	    	for(int i=0;i<10;i++) {
	    		if(data[i][t1]==1&&data[i][t2]==1)
	    			count++;
	    	}
	        String index = String.format("%d%d", t1, t2);
	        l2_list.put(index,count);
	    	return count;
	    }
	    
	    public static int get(int t1,int t2) {
	    	String index = String.format("%d%d", t1, t2);
	    	return l2_list.get(index);
	    }
	    
	
	}



