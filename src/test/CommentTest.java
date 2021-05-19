package test;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import test.dto.Comments;
import test.dto.Posts;

public class CommentTest extends BaseTest {

	
	
	@Test
	public void test_Get_Comment() throws Exception {
		
		//https://jsonplaceholder.typicode.com/comments?postId={postId}
		
		String json = readUrl(BASE_URL + COMMENTS_BASE + "?"  + COMMENT_ID + 1);
		
	    Gson gson = new Gson();  
	    
	    Comments[] commentsArray = gson.fromJson(json, Comments[].class);
	    
	    
	    //validate comment count
	    assert(commentsArray.length == 5);
	 
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
	    assert(commentsArray[0].postId == 1);
	    	 
	    assert(commentsArray[0].id == 1);
	   
	    assert(commentsArray[0].name.equals("id labore ex et quam laborum"));
	    
	    assert(commentsArray[0].email.equals("Eliseo@gardner.biz"));
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    assert(commentsArray[0].body.contains("laudantium enim quasi est quidem magnam voluptate ipsam eos"));
	    assert(commentsArray[0].body.contains("tempora quo necessitatibus"));
	    assert(commentsArray[0].body.contains("dolor quam autem quasi"));
	    assert(commentsArray[0].body.contains("reiciendis et nam sapiente accusantium"));
	    
	  
	    //Comment 2
	    assert(commentsArray[1].postId == 1);
   	 
	    assert(commentsArray[1].id == 2);
	   
	    assert(commentsArray[1].name.equals("quo vero reiciendis velit similique earum"));
	    
	    assert(commentsArray[1].email.equals("Jayne_Kuhic@sydney.com"));
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    assert(commentsArray[1].body.contains("est natus enim nihil est dolore omnis voluptatem numquam"));
	    assert(commentsArray[1].body.contains("et omnis occaecati quod ullam at"));
	    assert(commentsArray[1].body.contains("voluptatem error expedita pariatur"));
	    assert(commentsArray[1].body.contains("nihil sint nostrum voluptatem reiciendis et"));
	    
	    
	    //Comment 3
	    assert(commentsArray[2].postId == 1);
   	 
	    assert(commentsArray[2].id == 3);
	   
	    assert(commentsArray[2].name.equals("odio adipisci rerum aut animi"));
	    
	    assert(commentsArray[2].email.equals("Nikita@garfield.biz"));
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    assert(commentsArray[2].body.contains("quia molestiae reprehenderit quasi aspernatur"));
	    assert(commentsArray[2].body.contains("aut expedita occaecati aliquam eveniet laudantium"));
	    assert(commentsArray[2].body.contains("omnis quibusdam delectus saepe quia accusamus maiores nam est"));
	    assert(commentsArray[2].body.contains("cum et ducimus et vero voluptates excepturi deleniti ratione"));
	    
	    
	    //Comment 4
	    assert(commentsArray[3].postId == 1);
   	 
	    assert(commentsArray[3].id == 4);
	   
	    assert(commentsArray[3].name.equals("alias odio sit"));
	    
	    assert(commentsArray[3].email.equals("Lew@alysha.tv"));
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    assert(commentsArray[3].body.contains("non et atque"));
	    assert(commentsArray[3].body.contains("occaecati deserunt quas accusantium unde odit nobis qui voluptatem"));
	    assert(commentsArray[3].body.contains("quia voluptas consequuntur itaque dolor"));
	    assert(commentsArray[3].body.contains("et qui rerum deleniti ut occaecati"));
	    
	    
	    //Comment 5
	    assert(commentsArray[4].postId == 1);
   	 
	    assert(commentsArray[4].id == 5);
	   
	    assert(commentsArray[4].name.equals("vero eaque aliquid doloribus et culpa"));
	    
	    assert(commentsArray[4].email.equals("Hayden@althea.biz"));
	    
	    //Return chars are causing parsing issues. Checking for each line in the whole string.
	    assert(commentsArray[4].body.contains("harum non quasi et ratione"));
	    assert(commentsArray[4].body.contains("tempore iure ex voluptates in ratione"));
	    assert(commentsArray[4].body.contains("harum architecto fugit inventore cupiditate"));
	    assert(commentsArray[4].body.contains("voluptates magni quo et"));
	    	    
	}
	
	
}
