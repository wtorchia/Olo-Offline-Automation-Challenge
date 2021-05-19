package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.jupiter.api.Test;
import com.google.gson.Gson;

import test.dto.Posts; 


/*
 * Base class for all tests
 * Contains constatants and utils for testing. 
 */
public class BaseTest {
	
	static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
	
	static final String POSTS_BASE = "posts";
	
	
	//Set true to see debug outputs.
	protected boolean debug = false;
	
	
	public BaseTest(){
		
	}

	
	//Reads URL and restuns the JSON serialized into a string. 
	public String readUrl(String urlString) throws Exception {

		BufferedReader reader = null;
	    
		try {
	    
			if(debug) System.out.println("Getting URL : " + urlString);
			
			
			URL url = new URL(urlString);
			
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        
	        StringBuffer buffer = new StringBuffer();
	        
	        int read;
	        
	        char[] chars = new char[1024];
	        
	        while ((read = reader.read(chars)) != -1) {
	        	
	        	buffer.append(chars, 0, read);
	        
	        }
	        
	        if(debug) System.out.println("URL returned  : " + buffer.toString());
	      
	        return buffer.toString();
	    } 
		
		finally {
	        
			if (reader != null) {
				
				reader.close();
				
			}
	            
	    }
	}
	

	


}
