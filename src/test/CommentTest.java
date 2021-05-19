package test;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import test.dto.Comments;
import test.dto.Posts;

public class CommentTest extends BaseTest {

	
	
	@Test
	public void test_Get_Comment_Success() throws Exception {
		
		
		String json = readUrl(BASE_URL + COMMENTS_BASE + "?"  + COMMENT_ID + 1);
		
	    Gson gson = new Gson();  
	    
	    Comments[] commentsArray = gson.fromJson(json, Comments[].class);
	    
	    
	    //validate comment count
	    checkIntValue(commentsArray.length, 5);
	 
	    //validate the comments
	    
	    if(debug) {
	    
	    	for(Comments comment : commentsArray) {
	    		
	    		System.out.println("----");
	    		
			    System.out.println("Post ID :" + comment.postId );
			    System.out.println("ID :" + comment.id );
			    System.out.println("Name :" + comment.name );
			    System.out.println("Email :" + comment.email );
			    System.out.println("Body :" + comment.body );
				
	    	}
	        
	    }
	   
		//Comment 1
	    checkIntValue(commentsArray[0].postId, 1);
	    	 
	    checkIntValue(commentsArray[0].id,  1);
	   
	    checkTextPresent(commentsArray[0].name, "id labore ex et quam laborum");
	    
	    checkTextPresent(commentsArray[0].email, "Eliseo@gardner.biz");
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    checkTextPresent(commentsArray[0].body, "laudantium enim quasi est quidem magnam voluptate ipsam eos");
	    checkTextPresent(commentsArray[0].body, "tempora quo necessitatibus");
	    checkTextPresent(commentsArray[0].body, "dolor quam autem quasi");
	    checkTextPresent(commentsArray[0].body, "reiciendis et nam sapiente accusantium");
	    
	  
	    //Comment 2
	    checkIntValue(commentsArray[1].postId, 1);
   	 
	    checkIntValue(commentsArray[1].id, 2);
	   
	    checkTextPresent(commentsArray[1].name, "quo vero reiciendis velit similique earum");
	    
	    checkTextPresent(commentsArray[1].email, "Jayne_Kuhic@sydney.com");
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    checkTextPresent(commentsArray[1].body, "est natus enim nihil est dolore omnis voluptatem numquam");
	    checkTextPresent(commentsArray[1].body, "et omnis occaecati quod ullam at");
	    checkTextPresent(commentsArray[1].body, "voluptatem error expedita pariatur");
	    checkTextPresent(commentsArray[1].body, "nihil sint nostrum voluptatem reiciendis et");
	    
	    
	    //Comment 3
	    checkIntValue(commentsArray[2].postId, 1);
   	 
	    checkIntValue(commentsArray[2].id, 3);
	   
	    checkTextPresent(commentsArray[2].name, "odio adipisci rerum aut animi");
	    
	    checkTextPresent(commentsArray[2].email, "Nikita@garfield.biz");
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    checkTextPresent(commentsArray[2].body, "quia molestiae reprehenderit quasi aspernatur");
	    checkTextPresent(commentsArray[2].body, "aut expedita occaecati aliquam eveniet laudantium");
	    checkTextPresent(commentsArray[2].body, "omnis quibusdam delectus saepe quia accusamus maiores nam est");
	    checkTextPresent(commentsArray[2].body, "cum et ducimus et vero voluptates excepturi deleniti ratione");
	    
	    
	    //Comment 4
	    checkIntValue(commentsArray[3].postId, 1);
   	 
	    checkIntValue(commentsArray[3].id, 4);
	   
	    checkTextPresent(commentsArray[3].name, "alias odio sit");
	    
	    checkTextPresent(commentsArray[3].email, "Lew@alysha.tv");
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    checkTextPresent(commentsArray[3].body, "non et atque");
	    checkTextPresent(commentsArray[3].body, "occaecati deserunt quas accusantium unde odit nobis qui voluptatem");
	    checkTextPresent(commentsArray[3].body, "quia voluptas consequuntur itaque dolor");
	    checkTextPresent(commentsArray[3].body, "et qui rerum deleniti ut occaecati");
	    
	    
	    //Comment 5
	    checkIntValue(commentsArray[4].postId, 1);
   	 
	    checkIntValue(commentsArray[4].id, 5);
	   
	    checkTextPresent(commentsArray[4].name, "vero eaque aliquid doloribus et culpa");
	    
	    checkTextPresent(commentsArray[4].email, "Hayden@althea.biz");
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    checkTextPresent(commentsArray[4].body, "harum non quasi et ratione");
	    checkTextPresent(commentsArray[4].body, "tempore iure ex voluptates in ratione");
	    checkTextPresent(commentsArray[4].body, "harum architecto fugit inventore cupiditate");
	    checkTextPresent(commentsArray[4].body, "voluptates magni quo et");
	    	    
	}
	
	
	@Test
	public void test_Get_Comment_Fail() throws Exception {

		//Test API only has 100 items. 
		String json = readUrl(BASE_URL + COMMENTS_BASE + "?"  + COMMENT_ID + 9999);
		
		Gson gson = new Gson();  
		    
	    Comments[] commentsArray = gson.fromJson(json, Comments[].class);
	    
	    //Should be empty
	    checkIntValue(commentsArray.length, 0);
		
	}
	
	
}
