import java.io.FileNotFoundException;
import java.util.ArrayList;


public class GetCount {
	
	public static ArrayList<String> list = new ArrayList<>();  //All the tags of the file
	
	public static ArrayList<String> unique = new ArrayList<>();  //unique words extracted from the original list
	
	public static ArrayList<Integer> frequency = new ArrayList<>();  //frequency of each unique word
	
	ArrayList<Integer> indices = new ArrayList<>();  //Store the indices of the smallest count
	
	int largest1 = Integer.MIN_VALUE;
	 
    int largest2 = Integer.MIN_VALUE;
    
    int largest3 = Integer.MIN_VALUE;
    
    int smallest = 0;
    
    int secondSmallest = 0;
    
    int thirdSmallest = 0;

	void sortArray() {  //store all the value int arraylist and sort it in alphabetical order.

		for(int i = 0; i < Buffer.outerList.get(0).size();i++) {
			
			
			list.add(Buffer.outerList.get(0).get(i));
			
		}
		
		list = SortArrayList.mergeSort(list, 0, list.size()-1);

	}
	void getFrequency() throws FileNotFoundException { 
				
		int count = 1;
		
        String currentElement = list.get(0);
        
        for (int i = 1; i < list.size(); i++) {  //get the frequency by comparing the adjacent element, BigO(n)
        	
            if (list.get(i).equals(currentElement)) {
            	
                count++;
                
            } else {
            	
            	unique.add(currentElement); //add the tag into a unique arraylist when finish counting
            	
            	frequency.add(count); // also add the count into frequency. So unique and frequency will have matching indices
                
                currentElement = list.get(i);
                
                count = 1;
                
            }
 
        }
        
    	unique.add(list.get(list.size()-1));  //add the last index that was skipped.
    	
    	frequency.add(count);
    	
	}
	
	 void getMostCount() {  //getting three of the most frequent words
	        
	        for (int i = 0; i < frequency.size(); i++) {
	        	
	            int currentNumber = frequency.get(i);
	            
	            if (currentNumber > largest1) {
	            	
	                largest3 = largest2;
	                
	                largest2 = largest1;
	                
	                largest1 = currentNumber;
	                
	            } else if (currentNumber > largest2) {
	            	
	                largest3 = largest2;
	                
	                largest2 = currentNumber;
	                
	            } else if (currentNumber > largest3) {
	            	
	                largest3 = currentNumber;
	            }
	      }

	}
	 void printThreeMostCount() {  //getting three of the most frequent words' indices.
		
		for(int i = 0; i < frequency.size(); i ++) {
		 
			 if(frequency.get(i) == largest1) {
				 
				 largest1 = i;
				 
			 }else if(frequency.get(i) == largest2) {
				 
				 largest2 = i;
				 
			 }else if(frequency.get(i) == largest3) {
				 
				 largest3 = i;
		 	}
		}
		System.out.println(" ==========================================");
		
		System.out.println("*** highest 3 movies by count ***" );

		System.out.println(frequency.get(largest1) +": " + unique.get(largest1));
		
		System.out.println(frequency.get(largest2) +": " + unique.get(largest2));
		
		System.out.println(frequency.get(largest3) +": " + unique.get(largest3));
		
	
	}

	void getThreeSmallest() throws FileNotFoundException {
		
        for (int i = 0; i < frequency.size(); i++) {
        	
        	if(frequency.get(i) == 1) {  //smallest will always be one
        		
        		indices.add(i); //A list that store the first three smallest number
        		
        	}	
        }
        smallest = indices.get(0);//assign each value
        
        secondSmallest = indices.get(1);
        
        thirdSmallest = indices.get(2);
        
	}
	void printThreeSmallestCount() {
		
		System.out.println("*** Lowest 3 movies by count ***" );
		
		System.out.println(frequency.get(smallest) +": " + unique.get(smallest));
		
		System.out.println(frequency.get(secondSmallest) +": " + unique.get(secondSmallest));
		
		System.out.println(frequency.get(thirdSmallest) +": " + unique.get(thirdSmallest));
		
		System.out.println(" ==========================================");
	

	}
	
}
