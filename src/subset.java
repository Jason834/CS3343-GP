import java.util.*;
public class subset {
	 // Print all subsets of given set[] 
    static void printSubsets(int set[],int input[],double input_count) 
    { 
        int n = set.length; 
        Set<Integer> input_set = new HashSet<Integer>();
       int input_size=input.length;
        for (int z=0;z<input_size;z++) {
    	   input_set.add(input[z]);
    	   System.out.print("add:"+set[z]);       
       }
       System.out.print("to the set");
        // Run a loop for printing all 2^n 
        // subsets one by one 
        for (int i = 0; i < (1<<n); i++) 
        { 
            System.out.print(""); 
            
            // Print current subset
            int count=0;
            int [] temp = new int[10];
            Set<Integer> data = new HashSet<Integer>();
            System.out.print("check: ");
            for (int j = 0; j < n; j++) 
            {
            	
                // (1<<j) is a number with jth bit 1 
                // so when we 'and' them with the 
                // subset number we get which numbers 
                // are present in the subset and which 
                // are not 
            	
                if ((i & (1 << j)) > 0) {
                	//System.out.print(set[j] + " "); 
                	data.add(set[j]);
                	System.out.print("adding "+set[j]+" ");
                	temp[count]=set[j];
                	count++;
                      
                }
                	
                
            }
            if(data.containsAll(input_set)) {
            	System.out.println("yes");
            	data.clear();
           
            
            double sup=0;
            switch(count) {
            case 1:
            	sup=l1.get(temp[0]);
            	break;
            case 2:
            	sup=l2.get(temp[0],temp[1]);
            	break;
            case 3:
            	sup=l3.get(temp[0],temp[1],temp[2]);
            	break;
            case 4:
            	sup=l4.get(temp[0],temp[1],temp[2],temp[3]);
            	break;
            }
            double con=sup/input_count;
            System.out.print("sup= "+sup+" ,confidence= "+con);
            System.out.println(""); 
            }else {
            	System.out.println("no");
            	data.clear();
            }
           
        } 
    } 
  
    // Driver code 
    public static void find(int input[]) 
    { 
    	double count =0;
    	int size= input.length;
    	switch(size) {
           case 1:
           	count=l1.get(input[0]);
           	break;
           case 2:
           	count=l2.get(input[0],input[1]);
           	break;
           case 3:
           	count=l3.get(input[0],input[1],input[2]);
           	break;
           case 4:
           	count=l4.get(input[0],input[1],input[2],input[3]);
           	break;
           }
    	System.out.println("count="+count);
    	int data []= {0,1,2,3,4};
        printSubsets(data,input,count); 
    } 
}
