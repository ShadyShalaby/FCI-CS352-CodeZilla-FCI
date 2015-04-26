package com.FCI.SWE.Controllers;

public class AddMemberObserver extends GroupObserver {

  private UserController userController;
	@Override
	public void update(String Username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachObserver(GroupChat groupChat) {

		this.groupChat = groupChat;
		groupChat.setObserver(this);
		
	}

}
