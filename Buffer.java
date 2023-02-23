import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Buffer {
	
	public static List<String> innerList = new ArrayList<>();
	
	public static List<List<String>> outerList = new ArrayList<>();
	
	int count;
	
	 void bufferFile(String fileName) throws FileNotFoundException {
		
		BufferedReader br = null;
		
		String line = "";
		
		try {
			
			br = new BufferedReader(new FileReader(fileName));
			
			line = br.readLine();
			
			while((line=br.readLine()) != null) {  //read the file and add them into innerlist and outerlist. 
				
				innerList.add(line.split(",")[2]); //separated by comma. 
				
				outerList.add(innerList);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
	
		}
		
   }
}
