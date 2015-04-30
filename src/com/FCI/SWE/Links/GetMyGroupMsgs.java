package com.FCI.SWE.Links;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.FriendRequestsActivity;

public class GetMyGroupMsgs implements ControllerOptions
{
	
	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/GetMyGroupMsgs";
		all[1] = "Esource=" + params[0];

		return all;
	}

	@Override
	public void connReturn(String result) throws JSONException {
		
		JSONObject object = new JSONObject(result);
		Iterator<String> iter = object.keys();
		String ID = "", gpName = "";
		while (iter.hasNext()) {
			String key = iter.next();
			try {
				ID += key + "#";
				gpName += object.get(key) + "#";
			} catch (JSONException e) {
				// Something went wrong!
			}

		}

		Intent frReqIntent = new Intent(
				Application.getAppContext(),
				FriendRequestsActivity.class);
		frReqIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		// frReqIntent.putExtra("unames", unames);
		// frReqIntent.putExtra("emails", emails);

		Application.getAppContext().startActivity(frReqIntent);
		
	}

}
