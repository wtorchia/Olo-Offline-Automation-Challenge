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
	    
	    post.userId = 1;
	    
	    post.body = "TEST BODY";
	    
	    post.title = "TEST TITTLE";
	    
	    PostResponse response = gson.fromJson(postJSONToURL(url, gson.toJson(post)), PostResponse.class);
	    
	    checkIntValue(response.id, 101);
		
	}
	
	
	
	
	
}
