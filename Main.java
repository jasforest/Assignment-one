import java.io.IOException;


public class Main{

	public static void main(String[] args) throws IOException {
		
		Buffer buffer = new Buffer();
		
		GetInput getInput = new GetInput();
		
		GetCount getCount = new GetCount();
		
		String file = args[0];
		
		buffer.bufferFile(file);  //read the file using buffer reader.
		
		getCount.sortArray();  // transfer value from bufferfile to arraylist. 
		
		getCount.getFrequency(); // get the frequency
		
		getCount.getMostCount(); // Find the three most frequent words.
		
		getCount.printThreeMostCount(); 
		
		getCount.getThreeSmallest(); // Find the three lowest frequent words.
		
		getCount.printThreeSmallestCount();
		
		getInput.processInput();  //this method accepts userinput and processes it.
	}

}
