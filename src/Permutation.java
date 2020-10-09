public class Permutation { 
	static int min_support=0;
  
    /* arr[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in arr[] 
    index  ---> Current index in data[] 
    r ---> Size of a combination to be printed */
    static void combinationUtil(int arr[], int n, int r, 
                          int index, int data[], int i) 
    { 
        // Current combination is ready to be printed,  
        // print it 
        if (index == r) { 
            int count=0;
            switch(r) {
            case 1:
            	count=l1.count(data[0]);
            	break;
            case 2:
            	count=l2.count(data[0],data[1]);
            	break;
            case 3:
            	count=l3.count(data[0],data[1],data[2]);
            	break;
            case 4:
            	count=l4.count(data[0],data[1],data[2],data[3]);
            	break;
            }
       	 
            if(count>=min_support) {
           	System.out.print("Item: ");
            for (int j = 0; j < r; j++) {
                System.out.print(data[j]);
            }
            System.out.print(" count= "+count);
            System.out.println(""); 
            return; 
            }
        } 
  
        // When no more elements are there to put in data[] 
        if (i >= n) 
            return; 
  
        // current is included, put next at next 
        // location 
        data[index] = arr[i]; 
        combinationUtil(arr, n, r, index + 1,  
                               data, i + 1); 
  
        // current is excluded, replace it with 
        // next (Note that i+1 is passed, but 
        // index is not changed) 
        combinationUtil(arr, n, r, index, data, i + 1); 
    } 
  
    // The main function that prints all combinations 
    // of size r in arr[] of size n. This function  
    // mainly uses combinationUtil() 
    static void printCombination(int arr[], int n, int r) 
    { 
        // A temporary array to store all combination 
        // one by one 
        int data[] = new int[r]; 
  
        // Print all combination using temprary 
        // array 'data[]' 
        combinationUtil(arr, n, r, 0, data, 0); 
    } 
  
    /* Driver function to check for above function */
    public static void get(int r,int arr[]) 
    {   
        int n = arr.length; 
        printCombination(arr, n, r); 
    } 
} 