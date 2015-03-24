package com.FCI.SWE.SocialNetwork;

import java.util.ArrayList;

import android.R.array;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class FriendRequestsActivity extends ListActivity  {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_friendrequest);
				
		Bundle extras = getIntent().getExtras();
		
		//String status = extras.getString("status");
		String unames = extras.getString("unames");
		String emails = extras.getString("emails");
		
		String[] names = unames.split("#");
		String[] mails = emails.split("#");
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names));

	}
	
	

}
