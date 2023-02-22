import java.util.Scanner;


public class GetInput{
	
	String choice = "";  //user's choice
	
	String search = ""; // word of the tag
	
	int occurences = 0;  
	
	boolean found;
	
	boolean isNumeric(String str) { //checking if the input is numeric
		
	    try {
	    	
	        Double.parseDouble(str);
	        
	        return true;
	        
	    } catch (NumberFormatException e) {
	    	
	        return false;
	    }
	}
	
	void userInput() {
			
		System.out.println("Search by Tag or Tag Count? (Enter T or C... or EXIT to exit):");
		
		Scanner sc = new Scanner(System.in);
		
		choice = sc.nextLine();
		
	}
	void processInput() {
		
		userInput();
		
		if(choice.equals("T")) {
			
			System.out.println("Tag to search for: ");
			
			Scanner tag = new Scanner(System.in);
			
			search = tag.nextLine();  //Word that user is searching for
			
			getFrequcncy();
			
			tag.close();
			
		}
		else if (choice.equals("C")) {
			
			System.out.println("Count to search for: ");
			
			Scanner tagCount = new Scanner(System.in);
			
			search = tagCount.nextLine();
			
			tagCount.close();
			
			if(isNumeric(search)) {  //Skip the reading part in user doesn't enter numeric number.
				
				occurences = Integer.parseInt(search);
				
				for(int i = 0; i < GetCount.frequency.size();i++) {
					
					if(GetCount.frequency.get(i) == occurences) {
						
						System.out.println("Tags with " + occurences + " occurences: ");
						
						System.out.println("* " + GetCount.unique.get(i));
					}
					
				}
				
			}else{
				
				System.out.println("Is " + search + " even a number? C'mon, man!");
				
			}
			
		}else if(choice.equals("EXIT")){
			
			System.out.println("Bye!");
		}
		else {
			
			processInput();  //ask again if user enters something program can't interpret. 
		}
	
		
	}
	void getFrequcncy() { // Calculating the frequency of the word user asked. 
		
		for(int i = 0; i < GetCount.unique.size(); i++) {
			
			if(GetCount.unique.get(i).equals(search)) {  //if unique contains the tag find its frequency. 
				
				found = true;
				
				System.out.println("It appears "+GetCount.frequency.get(i) +" times"); //Appears this many times 
			}
		}
		if (found == false) {
			
			System.out.println("Tag \"" + search+ "\" does not exist.");
			
		}
	}
}

