package test;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import test.dto.Posts;

public class PostsTest extends BaseTest {

	@Test
	public void test_Get_Posts_Count() throws Exception {
		
		String json = readUrl(BASE_URL + POSTS_BASE);
		
	    Gson gson = new Gson();  
	    
	    Posts[] postsArray = gson.fromJson(json, Posts[].class);

	    //100 results will always come back. Real API would have a variable number
	    assert(postsArray.length == 100);
		
	}
	
	
	//Spot check first and last entries. 
	@Test
	public void test_Get_Posts_FirstPost() throws Exception {
		
		String json = readUrl(BASE_URL + POSTS_BASE);
		
	    Gson gson = new Gson();  
	    
	    Posts[] postsArray = gson.fromJson(json, Posts[].class);
	    
	    
	    if(debug) {
	    	
		    System.out.println("userID :" + postsArray[0].userId );
		    System.out.println("ID :" + postsArray[0].id );
		    System.out.println("Title :" + postsArray[0].title );
		    System.out.println("Body :" + postsArray[0].body );
		    
	    }
	    
	    assert(postsArray[0].userId == 1);
	    
	    assert(postsArray[0].id == 1);
	    
	    assert(postsArray[0].title.equals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    assert(postsArray[0].body.contains("quia et suscipit"));
	    assert(postsArray[0].body.contains("suscipit recusandae consequuntur expedita et cum"));
	    assert(postsArray[0].body.contains("reprehenderit molestiae ut ut quas totam"));
	    assert(postsArray[0].body.contains("nostrum rerum est autem sunt rem eveniet architecto"));
	    
	}
	

	@Test
	public void testPosts_LastPost() throws Exception {
		
		String json = readUrl(BASE_URL + POSTS_BASE);
		
	    Gson gson = new Gson();  
	    
	    Posts[] postsArray = gson.fromJson(json, Posts[].class);
	    
	    if(debug) {
	    
		    System.out.println("userID :" + postsArray[99].userId );
		    System.out.println("ID :" + postsArray[99].id );
		    System.out.println("Title :" + postsArray[99].title );
		    System.out.println("Body :" + postsArray[99].body );
		    
	    }
	    
	    assert(postsArray[99].userId == 10);
	    
	    assert(postsArray[99].id == 100);
	    
	    assert(postsArray[99].title.equals("at nam consequatur ea labore ea harum"));
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    assert(postsArray[99].body.contains("cupiditate quo est a modi nesciunt soluta"));
	    assert(postsArray[99].body.contains("ipsa voluptas error itaque dicta in"));
	    assert(postsArray[99].body.contains("autem qui minus magnam et distinctio eum"));
	    assert(postsArray[99].body.contains("accusamus ratione error aut"));
	    		
	 
	    
	}
	
	
}
