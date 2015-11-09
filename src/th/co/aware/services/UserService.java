package th.co.aware.services;

import java.util.List;

import th.co.aware.bean.UserBean;

public interface UserService {
	public int createUser(UserBean user);
	public int updateUser(UserBean user);
	public int teminateUser(int userId);
	public UserBean getUserById(String username);
	public List<UserBean> getAll();
	public UserBean validate(String username,String password);
}
