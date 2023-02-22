import java.util.ArrayList;

public class SortArrayList{
	
	public static ArrayList<String> mergeSort(ArrayList<String> arr, int start, int end) {
		
	    if (start < end) {
	    	
	        int mid = (start + end) / 2; //get the middle index
	        
	        ArrayList<String> left = mergeSort(arr, start, mid);  //store value on the left side
	        
	        ArrayList<String> right = mergeSort(arr, mid+1, end);  //store value on the right side
	        
	        return merge(left, right);
	    }
	    else {
	    	
	        ArrayList<String> result = new ArrayList<>();
	        
	        result.add(arr.get(start));
	        
	        return result;
	        
	    }
	}

	public static ArrayList<String> merge(ArrayList<String> left, ArrayList<String> right) {
		
	    ArrayList<String> result = new ArrayList<>();  //create a new arraylis that will contain the sorted element
	    
	    int i = 0, j = 0;
	    
	    while (i < left.size() && j < right.size()) {
	    	
	        if (left.get(i).compareTo(right.get(j)) < 0) {  //Compares two strings lexicographically
	        	
	            result.add(left.get(i));
	            
	            i++;
	        }
	        else {
	            result.add(right.get(j));
	            
	            j++;
	        }
	    }
	    while (i < left.size()) {
	    	
	        result.add(left.get(i));
	        
	        i++;
	    }
	    while (j < right.size()) {
	    	
	        result.add(right.get(j));
	        
	        j++;
	    }
	    return result;
	}

}


