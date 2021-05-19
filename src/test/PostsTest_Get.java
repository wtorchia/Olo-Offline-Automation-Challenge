package test;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import test.dto.Posts;

public class PostsTest_Get extends BaseTest {

	@Test
	public void test_Get_Posts_Count() throws Exception {
		
		String json = readUrl(BASE_URL + POSTS_BASE);
		
	    Gson gson = new Gson();  
	    
	    Posts[] postsArray = gson.fromJson(json, Posts[].class);

	    //100 results will always come back. Real API would have a variable number
	    checkIntValue(postsArray.length , 100);
		
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
	    
	    checkIntValue(postsArray[0].userId , 1);
	    
	    checkIntValue(postsArray[0].id , 1);
	    
	    checkTextPresent(postsArray[0].title, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    checkTextPresent(postsArray[0].body, "quia et suscipit");
	    checkTextPresent(postsArray[0].body, "suscipit recusandae consequuntur expedita et cum");
	    checkTextPresent(postsArray[0].body, "reprehenderit molestiae ut ut quas totam");
	    checkTextPresent(postsArray[0].body, "nostrum rerum est autem sunt rem eveniet architecto");
	    
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
	    
	    checkIntValue(postsArray[99].userId, 10);
	    
	    checkIntValue(postsArray[99].id, 100);
	    
	    checkTextPresent(postsArray[99].title, "at nam consequatur ea labore ea harum");
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    checkTextPresent(postsArray[99].body, "cupiditate quo est a modi nesciunt soluta");
	    checkTextPresent(postsArray[99].body, "ipsa voluptas error itaque dicta in");
	    checkTextPresent(postsArray[99].body, "autem qui minus magnam et distinctio eum");
	    checkTextPresent(postsArray[99].body, "accusamus ratione error aut");
	    		
	 
	    
	}
	
	
}
