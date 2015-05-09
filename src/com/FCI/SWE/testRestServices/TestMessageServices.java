package testRestServices;

import org.json.JSONException;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.CreateGroupChat;
import com.FCI.SWE.Links.SendGroupMsg;
import com.FCI.SWE.Links.SendSingleMsg;

public class TestMessageServices {
  
	  String status;
	  
	  public void setStatus(String s)
	  {
	    status=s;
	  }
	  
	  //NotificationService obj = new NotificationService();
	    
	     @DataProvider(name = "CreateChatGroupService")
	       public static Object[][] testCreateChatGroupServiceTestCases(){
	         return new Object[][] { 
	           {"ok","sheref_shokry@yahoo.com", "ACM"},
	           {"failed", "AmrDiab@yahoo.com", ""},
	      };
	       }
	         
	  @Test(dataProvider = "CreateChatGroupService")
	  public void testLoginService(String expected , String Esource , String groupName)throws JSONException {
		  
		 UserController controller = Application.getUserController();
			CreateGroupChat obj = new CreateGroupChat();
			controller.execute(obj, Esource ,groupName);
	    
	      Assert.assertEquals(expected, status);
	  
	  }
	  
	  /************************************************************************/
	  
	             
	       @DataProvider(name = "SendSingleMsgSetvice")
	       public static Object[][] sendSingleMsgServiceTestCases(){
	         return new Object[][] { 
	           {"ok", "sheref_shokry@yahoo.com","shrio@yahoo.com","Hello"},
	           {"failed", "sheref_shokry@yahoo.com","shrio@yahoo.com",""},
	           {"failed", "sheref_shokry@yahoo.com","shankoty@yahoo.com","Hello"}
	         };
	       }
		   @Test(dataProvider = "sendSingleMsg")
		   public void testSendSingleMessage(String expected, String src, String dest, String msg) throws JSONException {
	         
		   UserController controller = Application.getUserController();
			SendSingleMsg obj = new SendSingleMsg();
			controller.execute(obj, src ,dest  , msg);
	         
		       Assert.assertEquals(expected, status);
		   }

		 /***********************************************//*************************************************************************************************************/
		  
	      @DataProvider(name = "SendGroupMsgService")
	       public static Object[][] sendGroupMsgServiceTestCases(){
	         return new Object[][] { 
	           {"ok", "sheref_shokry@yahoo.com","1","Hello"},
	           {"failed", "sheref_shokry@yahoo.com","1",""},
	         };
	       }

		   @Test(dataProvider = "SendGroupMsgService")
		   public void testSendGroupMessage(String expected, String src, String ID, String msg)throws JSONException {
		   
		   UserController controller = Application.getUserController();
			SendGroupMsg obj = new SendGroupMsg();
			controller.execute(obj, src ,ID  , msg);
	         
		       Assert.assertEquals(expected, status);

	       }
	  
}
