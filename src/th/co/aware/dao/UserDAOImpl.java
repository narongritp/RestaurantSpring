package th.co.aware.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import th.co.aware.bean.UserBean;
import th.co.aware.config.MYLOG;

public class UserDAOImpl implements UserDAO {

	private static final String ENTITY_NAME = "user";
	private static final String FIELD_USERID = "user_id";
	private static final String FIELD_FNAME = "first_name";
	private static final String FIELD_LNAME = "last_name";
	private static final String FIELD_USERNAME = "username";
	private static final String FIELD_PASSWORD = "password";
	private static final String FIELD_TELEPHONE = "telephone";
	private static final String FIELD_TYPE = "type";
	private static final String FIELD_TIMESTAMP = "timestamp";

	@Autowired
	DataSource dataSource;

	@Override
	public int createUser(UserBean user) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO "+ENTITY_NAME+"("+
						FIELD_FNAME+","+
						FIELD_LNAME+","+
						FIELD_USERNAME+","+
						FIELD_PASSWORD+","+
						FIELD_TELEPHONE+","+
						FIELD_TYPE+","+
						FIELD_TIMESTAMP+") VALUES(?,?,?,?,?,?,now())";
		return jdbc.execute(SQL, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws DataAccessException {
				try{
					ps.setString(1, user.getFirstName());
					ps.setString(2, user.getLastName());
					ps.setString(3, user.getUsername());
					ps.setString(4, user.getPassword());
					ps.setString(5, user.getTelephone());
					ps.setString(6, user.getType());
					return ps.executeUpdate();
				}catch(SQLException ex){
					MYLOG.printError(ex.getMessage());
					return -1;
				}
			}
		});
	}

	@Override
	public int updateUser(UserBean user) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "UPDATE "+ENTITY_NAME+" SET "+
						FIELD_FNAME+"=?,"+
						FIELD_LNAME+"=?,"+
						FIELD_PASSWORD+"=?,"+
						FIELD_TELEPHONE+"=?,"+
						FIELD_TYPE+"=? WHERE "+FIELD_USERID+"="+user.getUserId();
		return jdbc.execute(SQL, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws DataAccessException {
				try{
					ps.setString(1, user.getFirstName());
					ps.setString(2, user.getLastName());
					ps.setString(3, user.getPassword());
					ps.setString(4, user.getTelephone());
					ps.setString(5, user.getType());
					return ps.executeUpdate();
				}catch(SQLException ex){
					MYLOG.printError(ex.getMessage());
					return -1;
				}
			}
		});
	}

	@Override
	public int teminateUser(int userId) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "UPDATE "+ENTITY_NAME+" SET "+
						FIELD_TYPE+"=? WHERE "+FIELD_USERID+"="+userId;
		return jdbc.execute(SQL, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws DataAccessException {
				try{
					ps.setString(1, "-1");
					return ps.executeUpdate();
				}catch(SQLException ex){
					MYLOG.printError(ex.getMessage());
					return -1;
				}
			}
		});
	}

	@Override
	public UserBean getUserById(String username) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM "+ENTITY_NAME+" WHERE "+FIELD_USERNAME+" LIKE '"+username+"'";
		return jdbc.query(SQL, new RowMapper<UserBean>() {
			@Override
			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt(FIELD_USERID));
				user.setFirstName(rs.getString(FIELD_FNAME));
				user.setLastName(rs.getString(FIELD_LNAME));
				user.setUsername(rs.getString(FIELD_USERNAME));
				user.setPassword(rs.getString(FIELD_PASSWORD));
				user.setTelephone(rs.getString(FIELD_TELEPHONE));
				user.setType(rs.getString(FIELD_TYPE));
				user.setTimestamp(rs.getDate(FIELD_TIMESTAMP));
				return user;
			}
		}).get(0);
	}

	@Override
	public List<UserBean> getAll() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM "+ENTITY_NAME+" WHERE "+FIELD_TYPE+" NOT LIKE '-1'";
		return jdbc.query(SQL, new RowMapper<UserBean>() {
			@Override
			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt(FIELD_USERID));
				user.setFirstName(rs.getString(FIELD_FNAME));
				user.setLastName(rs.getString(FIELD_LNAME));
				user.setUsername(rs.getString(FIELD_USERNAME));
				user.setPassword(rs.getString(FIELD_PASSWORD));
				user.setTelephone(rs.getString(FIELD_TELEPHONE));
				user.setType(rs.getString(FIELD_TYPE));
				user.setTimestamp(rs.getDate(FIELD_TIMESTAMP));
				return user;
			}
		});
	}

	@Override
	public UserBean validate(String username, String password) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM "+ENTITY_NAME+" WHERE "+FIELD_USERNAME+" LIKE '"+username+"' AND "+
				FIELD_PASSWORD+" LIKE '"+password+"'";
		List<UserBean> obj = jdbc.query(SQL, new RowMapper<UserBean>() {
			@Override
			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt(FIELD_USERID));
				user.setFirstName(rs.getString(FIELD_FNAME));
				user.setLastName(rs.getString(FIELD_LNAME));
				user.setUsername(rs.getString(FIELD_USERNAME));
				user.setPassword(rs.getString(FIELD_PASSWORD));
				user.setType(rs.getString(FIELD_TYPE));
				user.setTelephone(rs.getString(FIELD_TELEPHONE));
				user.setTimestamp(rs.getDate(FIELD_TIMESTAMP));
				return user;
			}
		});
		if(obj!=null&&obj.size()>0){
			return obj.get(0);
		}else{
			return null;
		}
		
	}

}
