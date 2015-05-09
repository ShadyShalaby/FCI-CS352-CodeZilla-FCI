package com.FCI.SWE.Links;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.GetSingleMsgsActivity;

public class SendGroupMsg implements ControllerOptions {

	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/SendGroupMessage";
		all[1] = "Esource=" + params[0] + "&ID=" + params[1] + "&Message="
				+ params[2];

		return all;
	}

	@Override
	public void connReturn(String result) throws JSONException {

		JSONArray object = new JSONArray(result);
		
		
		ArrayList<String> emails = new ArrayList<String>();

		for (int i = 1; i < object.length(); i++)
			emails.add(object.get(i).toString());

		Intent frReqIntent = new Intent(Application.getAppContext(),
				GetSingleMsgsActivity.class);
		frReqIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		frReqIntent.putExtra("emails", emails);

		Application.getAppContext().startActivity(frReqIntent);

	}

}
