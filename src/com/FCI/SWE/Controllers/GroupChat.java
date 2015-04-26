package com.FCI.SWE.Controllers;

import java.util.ArrayList;

public class GroupChat {
	
  private ArrayList<String> users;
  private GroupObserver observer;
  
  public ArrayList<String> getUsers()
  {
	  return users;
  }
  
  public void setUsers(ArrayList<String>users)
  {
	  this.users = users;
	  notifyAllUsers();
  }
  
  
  
 public GroupObserver getObserver() {
	return observer;
}

public void setObserver(GroupObserver observer) {
	this.observer = observer;
}

public void  notifyAllUsers ()
 {
	 for(String userName : users)
		 observer.update(userName);
	         
 }
  
  

}
