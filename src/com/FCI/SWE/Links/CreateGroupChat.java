package com.FCI.SWE.Links;

import org.json.JSONObject;

import android.content.Intent;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Models.UserEntity;
import com.FCI.SWE.SocialNetwork.HomeActivity;

public class CreateGroupChat implements ControllerOptions
{

	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/createChatGroup";
		all[1] = "Esource=" + params[0] + "&GrName=" + params[1];

		return all;
	}

	@Override
	public void connReturn(String result) {


		  Intent homeIntent = new
		  Intent(Application.getAppContext(), HomeActivity.class);
		  
		  homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		  
		  Application.getAppContext().startActivity(homeIntent);
	}

}
