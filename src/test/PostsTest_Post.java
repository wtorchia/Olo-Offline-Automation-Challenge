package test;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import test.dto.PostResponse;
import test.dto.Posts;

public class PostsTest_Post extends BaseTest {

	@Test
	public void test_Get_Posts_Count() throws Exception {
		
		String url = BASE_URL + POSTS_BASE;
		
	    Gson gson = new Gson();  
	    
	    Posts post = new Posts();
	    
	    int userId = 1;
	    
	    String body = "TEST BODY";
	    
	    String title = "TEST TITTLE";
	    
	    
	    post.userId = userId;
	    
	    post.body = body;
	    
	    post.title = title;
	    
	    PostResponse response = gson.fromJson(postJSONToURL(url, gson.toJson(post)), PostResponse.class);
	    
	    if(debug) {
	    
		    System.out.println("ID : " + response.id);
		    System.out.println("Title : " + response.title);
		    System.out.println("Body : " + response.body);
		    System.out.println("UserID : " + response.userId);
		    
	    }
	    
	    checkIntValue(response.id, 101);
	    
	    checkIntValue(response.userId, userId);
	    
	    checkTextPresent(response.title, title);
	    
	    checkTextPresent(response.body, body);
		
	}
	
	
	
	
	
}
