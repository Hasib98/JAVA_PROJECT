package repository;

import java.lang.*;

import entity.*;
import interfaces.*;

public class UserRepo implements IUserRepo
{
	DatabaseConnection dbc;
	
	public UserRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	//Override
	public User getUser(String userId, String pass)
	{
		User user = null;
		String query = "SELECT userId, password, status FROM login WHERE userId='"+userId+"' AND password='"+pass+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				user = new User();
				user.setUserId(dbc.result.getString("userId"));
				user.setPassword(dbc.result.getString("password"));
				user.setStatus(dbc.result.getInt("status"));
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return user;
	}
	//Override
	public void insertUser(User u)
	{
		String query = "INSERT INTO login VALUES ('"+u.getUserId()+"','"+u.getPassword()+"',"+u.getStatus()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	//Override
	public void updateUser(User u){}
	
	//Overrride
	public void ChangePasswordInDB(User user)
	{
		
		
		
		String query = "UPDATE login SET password='"+user.getPassword()+"' WHERE userId='"+user.getUserId()+"';";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	//Override
	public void deleteUser(String userId)
	{
		String query = "DELETE from login  WHERE userId='"+userId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}