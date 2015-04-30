package com.FCI.SWE.Links;

import android.content.Intent;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.HomeActivity;

public class AddMemberInGroupChat implements ControllerOptions
{
	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/AddMemberInChatGroup";
		all[1] = "mmEmail=" + params[0] + "&ChatID=" + params[1];

		return all;
	}

	@Override
	public void connReturn(String result) {
		
		Intent homeIntent = new Intent(Application.getAppContext(),
				HomeActivity.class);

		homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		Application.getAppContext().startActivity(homeIntent);
		
	}

}
