package zama.learning.hr.rest.dao;

import java.util.List;

import zama.learning.hr.rest.domain.User;

/**
 * 
 * @author Zama
 *
 */
public interface UserDao {
	public List<User> getAllUsers();
	public User getUser(Integer id);
	public boolean isUserExist(User user);
	public boolean createUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public boolean deleteAllUsers();
}
