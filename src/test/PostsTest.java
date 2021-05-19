package test;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import test.dto.Posts;

public class PostsTest extends BaseTest {

	@Test
	public void testPosts_Count() throws Exception {
		
		String json = readUrl(BASE_URL + POSTS_BASE);
		
	    Gson gson = new Gson();  
	    
	    Posts[] posts = gson.fromJson(json, Posts[].class);

	    //100 results will always come back. Real API would have a variable number
	    assert(posts.length == 100);
		
	}
	
	
	//Spot check first and last entries. 
	@Test
	public void testPosts_FirstPost() throws Exception {
		
		String json = readUrl(BASE_URL + POSTS_BASE);
		
	    Gson gson = new Gson();  
	    
	    Posts[] posts = gson.fromJson(json, Posts[].class);
	    
	    
	    if(debug) {
	    	
		    System.out.println("userID :" + posts[0].userId );
		    System.out.println("ID :" + posts[0].id );
		    System.out.println("Title :" + posts[0].title );
		    System.out.println("Body :" + posts[0].body );
		    
	    }
	    
	    assert(posts[0].userId == 1);
	    
	    assert(posts[0].id == 1);
	    
	    assert(posts[0].title.equals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
	    
	    //Return chars are causing parsing issues. Checking for each 
	    assert(posts[0].body.contains("quia et suscipit"));
	    assert(posts[0].body.contains("suscipit recusandae consequuntur expedita et cum"));
	    assert(posts[0].body.contains("reprehenderit molestiae ut ut quas totam"));
	    assert(posts[0].body.contains("nostrum rerum est autem sunt rem eveniet architecto"));
	    
	}
	

	@Test
	public void testPosts_LastPost() throws Exception {
		
		String json = readUrl(BASE_URL + POSTS_BASE);
		
	    Gson gson = new Gson();  
	    
	    Posts[] posts = gson.fromJson(json, Posts[].class);
	    
	    if(debug) {
	    
		    System.out.println("userID :" + posts[99].userId );
		    System.out.println("ID :" + posts[99].id );
		    System.out.println("Title :" + posts[99].title );
		    System.out.println("Body :" + posts[99].body );
		    
	    }
	    
	    assert(posts[99].userId == 10);
	    
	    assert(posts[99].id == 100);
	    
	    assert(posts[99].title.equals("at nam consequatur ea labore ea harum"));
	    
	    //Return chars are causing parsing issues. Checking for each 
	    assert(posts[99].body.contains("cupiditate quo est a modi nesciunt soluta"));
	    assert(posts[99].body.contains("ipsa voluptas error itaque dicta in"));
	    assert(posts[99].body.contains("autem qui minus magnam et distinctio eum"));
	    assert(posts[99].body.contains("accusamus ratione error aut"));
	    		
	 
	    
	}
	
	
}
