
class Main 
{ 
    
    public static void main(String[] args) 
    { 
    	int i,j;
    	record.init();
    	int [][]data = record.get();
    	for(i=0;i<10;i++) {
    		 System.out.print("T"+i+": ");
    	 	for(j=0;j<5;j++) {
    	 		System.out.print(data[i][j]);
    	 	}
    	 	System.out.println();
    	 }
    	 
    	int arr []= {0,1,2,3,4};
    	 Permutation.get(1,arr);
    	 Permutation.get(2,arr); 
    	 Permutation.get(3,arr);
    	 Permutation.get(4,arr);
 
    	 int set[]= {1,2};
    	 subset.find(set);
    	
    } 
    
    
   
   
    
    
    
    
    
    
} 