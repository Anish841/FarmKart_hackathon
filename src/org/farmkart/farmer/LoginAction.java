package org.farmkart.farmer;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	private String password;
	private SessionMap<String, Object> session;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=(SessionMap)session;
	}
	
	public String execute() throws NamingException, SQLException
	{
//		System.out.println(":::::::::::::::::"+session);
//		User user = (User) session.get("user");
//		if (user != null)
//		{
//			if(user.getUserType().equalsIgnoreCase("F"))
//				return "farmer";
//			else
//				return "buyer";
//		}
//		
//			//User newUser = new User(userID, password);
//			User usr=UserDAOImpl.isValidUser(userID);
//			session.put("user", usr);
//			session.put("login", true);
//			if(usr.getUserType().equalsIgnoreCase("F"))
//				return "farmer";
//			else
//				return "buyer";
//			
		return "success";
	}
//	
//	public String logout(){  
//	    if(session!=null && session.get("login")!=null){
//	    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//	    	Date dateobj = new Date();
//	    	LoginDAO ld=new LoginDAOimpl();
//	    	User u=(User)session.get("user");
//	    	ld.updateLogoutTime(u.getUserId(), df.format(dateobj).toString());
//	    	session.put("login", null);
//	    	session.remove("user");
//	        session.invalidate();  
//	        addActionMessage("Your Account has been successfully logged out");
//	    }  
//	    return "success";  
//	}  
}
