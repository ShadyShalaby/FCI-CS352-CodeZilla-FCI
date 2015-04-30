package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.CreateGroupChat;
import com.FCI.SWE.Links.RecFriendReqs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends Activity {

	Button FriendRequestActivity;
	Button addFriend;
	Button signOut;
	Button createChatGp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		Bundle extras = getIntent().getExtras();

		FriendRequestActivity = (Button) findViewById(R.id.sendRequestActivity);

		// String status = extras.getString("status");
		String name = "";

		if (extras.containsKey("name")) {
			name = extras.getString("name");
			// Toast.makeText(this, "Welcome "+ name,
			// Toast.LENGTH_SHORT).show();
		}

		Toast.makeText(this, "Welcome " + name, Toast.LENGTH_SHORT).show();
		FriendRequestActivity.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent FriendReqIntent = new Intent(getApplicationContext(),
						SendRequestActivity.class);
				startActivity(FriendReqIntent);
			}
		});

		addFriend = (Button) findViewById(R.id.addFriendButton);

		addFriend.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				UserController controller = Application.getUserController();
				RecFriendReqs frReqs = new RecFriendReqs();
				controller.execute(frReqs, controller.getCurrentActiveUser()
						.getEmail());
			}
		});

		signOut = (Button) findViewById(R.id.signOutActivity);

		signOut.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				UserController controller = Application.getUserController();
				controller.signOut();

				Intent Main = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(Main);

			}
		});

		createChatGp = (Button) findViewById(R.id.createChatGpButton);

		createChatGp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				UserController controller = Application.getUserController();
				CreateGroupChat grChat = new CreateGroupChat();
				controller.execute(grChat, controller.getCurrentActiveUser().getEmail(),  "shokryy");
			}
		});
	}
}
