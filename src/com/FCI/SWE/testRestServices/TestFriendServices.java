package testRestServices;

import junit.framework.Assert;

import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.AcceptFriend;
import com.FCI.SWE.Links.SendFriendReq;

public class TestFriendServices {
  
	  String status;
	  
	  public void setStatus(String s)
	  {
	    status=s;
	  }
	  
	  
	     @DataProvider(name = "addFriendService")
	       public static Object[][] testAddFriendServiceTestCases(){
	         return new Object[][] { 
	           {"ok","sheref_shokry@yahoo.com", "shrio@yahoo.com"},
	           {"failed", "AmrDiab@yahoo.com", "sheref_shokry@yahoo.com"},
	      };
	       }
	         
	  @Test(dataProvider = "addFriendService")
	  public void testLoginService(String expected , String Esource , String Edestination)throws JSONException {
		  
		 UserController controller = Application.getUserController();
			AcceptFriend acc = new AcceptFriend();
			controller.execute(acc, Esource ,Edestination);
	    
	      Assert.assertEquals(expected, status);
	  
	  }
	  
	  /************************************************************************/
	  
	      @DataProvider(name = "SendRequestService")
	  
	        public static Object[][] testSendRequestServiceTestCases(){
	         return new Object[][] { 
	           {"ok","sheref_shokry@yahoo.com", "shrio@yahoo.com"},
	           {"failed", "AmrDiab@yahoo.com", "sheref_shokry@yahoo.com"} };
	       }
	       
	  @Test(dataProvider = "sendRequestService")
	  public void testSendRequestService(String expected, String Esource, String Edestination)throws JSONException {
		  
		 UserController controller = Application.getUserController();
			SendFriendReq obj = new SendFriendReq();
			controller.execute(  obj ,Esource ,Edestination);
	      Assert.assertEquals(expected, status);
	  
	  }
	  
	  
	}

