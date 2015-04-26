package com.FCI.SWE.Controllers;

public abstract class GroupObserver {
	
	protected GroupChat groupChat;
	
	public abstract void update(String Username);
	
	public abstract void attachObserver(GroupChat groupChat);
	

}
