import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class delraw {
	
	public static void main(String[] args) throws IOException {
		
		List<String> cr2 = new ArrayList<String>();
		List<String> jpg = new ArrayList<String>();

		//String canonicalPath = new File(".").getCanonicalPath();
		
        //System.out.println("Current directory path using canonical path method :- " + canonicalPath);

		File[] files = new File(".").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 

		String s;
		
		for (File file : files) {
		    if (file.isFile()) {
		    	
		    	s= file.getName();
		    	
		    	if (s.contains("CR2")) {
		    		cr2.add(file.getName());
		    	}
		    	else if (s.contains("JPG")){
		    		jpg.add(file.getName());
		    	}
		    	
		    }
		}
		
		for(int i=0; i<cr2.size();i++) {
			
			s=cr2.get(i);
			s=s.substring(0, s.length()-3);
			s=s+"JPG";
					
			if (!jpg.contains(s)) {
				
				File f= new File(cr2.get(i));
				f.delete();
				System.out.println(cr2.get(i) + " has been deleted!\n");
			}
			
		}
	
	
	
	}

}
