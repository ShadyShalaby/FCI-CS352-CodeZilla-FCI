package observerDP;

import com.FCI.SWE.Controllers.GroupChat;
import com.FCI.SWE.Controllers.UserController;

public class MessageObserver extends GroupObserver {

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
