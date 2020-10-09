
public class record {


	 static int [][] data= new int[10][5];
	
	
	public static void init() 
    { 
    	
    	 int i,j;
    	 for(i=0;i<10;i++) {
    		// System.out.print("T"+i+": ");
    	 	for(j=0;j<5;j++) {
    	 		int random=(int)(Math.random()*2);
    	 		data[i][j]=random;
    	 		//System.out.print(random);
    	 	}
    	 	//System.out.println();
    	 	 	
    	 }
    	 
    }
	public static int[][] get(){
		return data;
}

}
