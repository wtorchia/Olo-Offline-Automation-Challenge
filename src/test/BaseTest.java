package test;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
	
	
	//Takes in the URL and JSON data as a string to be posted. Returns JSON response as a string.  
	protected String postJSONToURL(String destinationURL, String json) throws IOException {
		
		if(debug) System.out.println("Connecting to URL destinationURL");
		
		URL url = new URL (destinationURL);
		
		HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
		
		httpConnection.setRequestMethod("POST");
		
		httpConnection.setRequestProperty("Content-Type", "application/json; utf-8");
		
		httpConnection.setRequestProperty("Accept", "application/json");
		
		httpConnection.setDoOutput(true);
		
	    try {
		
	    	if(debug) System.out.println("Posting data : " + json);
	    	
			OutputStream os = httpConnection.getOutputStream() ;
			
		    byte[] input = json.getBytes("utf-8");
			
			os.write(input, 0, input.length);			
	    }
	    catch(Exception e) {
	    	
	    	fail("Could not get output stream to  URL : " + destinationURL );
	    	
	    	
	    	return null;
	    }
	    
		
		try{
			
			if(debug) System.out.println("Reading response");
			
			BufferedReader br = new BufferedReader( new InputStreamReader(httpConnection.getInputStream(), "utf-8"));
			
			StringBuilder response = new StringBuilder();
		    
			String responseLine = null;
		    
			while ((responseLine = br.readLine()) != null) {
			
				response.append(responseLine.trim());
		     
			}
			
			return (response.toString());
				    
		} catch(Exception e) {
	    	
	    	fail("Could not get get a reponse from URL : " + destinationURL );
	    	
	    	return null;
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
