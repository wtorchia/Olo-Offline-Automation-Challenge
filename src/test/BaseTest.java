package test;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


/*
 * Base class for all tests
 * Contains constants and utils for testing. 
 */
public class BaseTest {
	
	static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
	
	static final String POSTS_BASE = "posts/";
	
	static final String COMMENTS_BASE = "comments";
	
	static final String COMMENT_ID = "postId=";
		
	//Set true to see debug outputs.
	protected boolean debug = false;
	
	public BaseTest(){
		
	}

	
	//Reads URL and returns the JSON serialized into a string. 
	protected String readUrl(String urlString) throws Exception {

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
	
	
	protected void checkIntValue(int expected, int value) {
		
		if (debug) System.out.println("Checking if int " + expected + " equals : " + value);
		
		try {
			
			
			assert(expected == value);
			
		}
		catch (AssertionError e) {
			
			fail("Expected : " + expected + " got : " + value );
			
		}
		
	}
	
	
	protected void checkTextPresent(String full, String value) {
		
		if (debug) System.out.println("Checking if text " + full + " contains : " + value);
		
		try {
			
			
			assert(full.contains(value));
			
		}
		catch (AssertionError e) {
			
			fail("Expected : " + value + " in  : " + full );
			
		}
		
	}
	
}
