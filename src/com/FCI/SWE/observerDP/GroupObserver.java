package observerDP;

import com.FCI.SWE.Controllers.GroupChat;

public abstract class GroupObserver {
	
	protected GroupChat groupChat;
	
	public abstract void update(String Username);
	
	public abstract void attachObserver(GroupChat groupChat);
	

}
