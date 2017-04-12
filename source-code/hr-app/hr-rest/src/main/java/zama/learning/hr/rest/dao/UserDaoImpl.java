package zama.learning.hr.rest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import zama.learning.hr.rest.domain.User;

/**
 * 
 * @author Zama
 *
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	public User getUser(Integer id) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id",id));
		return (User) criteria.uniqueResult();
	}

	public boolean createUser(User user) {
		getSession().save(user);
		return true;
	}

	public boolean updateUser(User user) {
		getSession().update(user);
		return true;	
	}

	public boolean deleteUser(User user) {
		getSession().delete(user);
		return true;
	}

	public boolean isUserExist(User user) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		if(criteria.list().size()>0){
			return true;
		}else{
			return false;
		}
	}

	public boolean deleteAllUsers() {
		return false;
	}
}
