package interfaces;

import java.lang.*;
import entity.*;

public interface IUserRepo
{
	User getUser(String userId, String password);
	void insertUser(User u);
	void updateUser(User u);
	void ChangePasswordInDB(User user);
	void deleteUser(String userId);
}