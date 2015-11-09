package th.co.aware.services;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import th.co.aware.bean.UserBean;
import th.co.aware.dao.UserDAO;

public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public int createUser(UserBean user) {
		int tmp = (int)(Math.random()*100000%10000);
		String pass = new DecimalFormat("0000.##").format(tmp);
		user.setPassword(pass);
		return userDAO.createUser(user);
	}

	@Override
	public int updateUser(UserBean user) {
		return userDAO.updateUser(user);
	}

	@Override
	public int teminateUser(int userId) {
		return userDAO.teminateUser(userId);
	}

	@Override
	public UserBean getUserById(String username) {
		return userDAO.getUserById(username);
	}

	@Override
	public List<UserBean> getAll() {
		return userDAO.getAll();
	}

	@Override
	public UserBean validate(String username, String password) {
		return userDAO.validate(username, password);
	}

}
