package testRestServices;

import junit.framework.Assert;

import org.json.JSONException;
import org.junit.Test;
import org.testng.annotations.DataProvider;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.LogIn;
import com.FCI.SWE.Links.SignUp;


public class TestUserServices {
	String status;

	public void setStatus(String s) {
		status = s;
	}

	     @DataProvider(name = "LoginService")
	       public static Object[][] testLoginServiceTestCases(){
	         return new Object[][] { 
	           {"ok","sheref_shokry@yahoo.com", "12345"},
	           {"failed", "AmrDiab@yahoo.com", "12345"},
	           {"failed", "", "12345"},
	           {"failed", "sheref@yahoo.com", ""} };
	   
	       }

	public void testLoginService(String exepected, String Esource,
			String password) throws JSONException {

		UserController controller = Application.getUserController();
		LogIn logIn = new LogIn();
		controller.execute(logIn, Esource, password);

		Assert.assertEquals(exepected, status);

	}

	/************************************************************************/

	@DataProvider(name = "SignUpService")
	       public static Object[][] testRegistrationServiceTestCases(){
	         return new Object[][] { 
	           {"ok", "sheref", "AmrDiab@yahoo.com", "12345"},
	           {"failed", "sheref", "sheref_shokry@yahoo.com", "12345"},
	           {"failed", "", "AmrDiab@yahoo.com", "12345"},
	           {"failed", "sheref", "", "12345"},
	           {"failed", "sheref", "sheref@yahoo.com", ""}
	         };
	       }

	public void testLoginService(String expected, String uName, String email,
			String password) throws JSONException {

		UserController controller = Application.getUserController();
		SignUp signUp = new SignUp();
		controller.execute(signUp, uName, email, password);
		Assert.assertEquals(expected, status);

	}

}
