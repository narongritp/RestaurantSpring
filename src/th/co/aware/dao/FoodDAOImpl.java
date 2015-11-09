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

import th.co.aware.bean.FoodBean;
import th.co.aware.config.MYLOG;

public class FoodDAOImpl implements FoodDAO{
	
	private static final String ENTITY_NAME = "food";
	private static final String FIELD_FOODID = "food_id";
	private static final String FIELD_NAME = "name";
	private static final String FIELD_TYPE = "type";
	private static final String FIELD_PRICE = "price";
	private static final String FIELD_DETAIL = "detail";
	private static final String FIELD_PICTURE = "picture";
	private static final String FIELD_UPDATETIME = "update_time" ;
	
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public int addFood(FoodBean food) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO "+ENTITY_NAME+"("+
						FIELD_NAME+","+
						FIELD_TYPE+","+
						FIELD_PRICE+","+
						FIELD_DETAIL+","+
						FIELD_PICTURE+","+
						FIELD_UPDATETIME+") VALUES(?,?,?,?,?,now())";
		return jdbc.execute(SQL, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws DataAccessException {
				try{
					ps.setString(1, food.getName());
					ps.setString(2, food.getType());
					ps.setInt(3, food.getPrice());
					ps.setString(4, food.getDetail());
					ps.setString(5, food.getPicture());
					return ps.executeUpdate();
				}catch(SQLException ex){
					MYLOG.printError(ex.getMessage());
					return -1;
				}
			}
		});
	}

	@Override
	public int updateFood(FoodBean food) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "UPDATE "+ENTITY_NAME+" SET "+
						FIELD_NAME+"=?,"+
						FIELD_TYPE+"=?,"+
						FIELD_PRICE+"=?,"+
						FIELD_DETAIL+"=?,"+
						FIELD_PICTURE+"=?,"+
						FIELD_UPDATETIME+"=now() WHERE "+FIELD_FOODID+"="+food.getFoodId();
		return jdbc.execute(SQL, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws DataAccessException {
				try{
					ps.setString(1, food.getName());
					ps.setString(2, food.getType());
					ps.setInt(3, food.getPrice());
					ps.setString(4, food.getDetail());
					ps.setString(5, food.getPicture());
					return ps.executeUpdate();
				}catch(SQLException ex){
					MYLOG.printError(ex.getMessage());
					return -1;
				}
			}
		});
	}

	@Override
	public int deleteFood(int foodId) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "DELETE FROM "+ENTITY_NAME+" WHERE "+FIELD_FOODID+"="+foodId;
		return jdbc.execute(SQL, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws DataAccessException {
				try{
					return ps.executeUpdate();
				}catch(SQLException ex){
					MYLOG.printError(ex.getMessage());
					return -1;
				}
			}
		});
	}

	@Override
	public FoodBean getFoodById(int foodId) {
		String SQL = "SELECT * FROM "+ENTITY_NAME+" WHERE "+FIELD_FOODID+"="+foodId;
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		List<FoodBean> list = jdbc.query(SQL, new RowMapper<FoodBean>(){
			@Override
			public FoodBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodBean fb = new FoodBean();
				fb.setFoodId(rs.getInt(FIELD_FOODID));
				fb.setName(rs.getString(FIELD_NAME));
				fb.setType(rs.getString(FIELD_TYPE));
				fb.setPrice(rs.getInt(FIELD_PRICE));
				fb.setDetail(rs.getString(FIELD_DETAIL));
				fb.setPicture(rs.getString(FIELD_PICTURE));
				fb.setUpdateTime(rs.getDate(FIELD_UPDATETIME));
				return fb;
			}
		});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<FoodBean> getFoodByType(String type) {
		String SQL = "SELECT * FROM "+ENTITY_NAME+" WHERE "+FIELD_TYPE+" LIKE '"+type+"'";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		return jdbc.query(SQL, new RowMapper<FoodBean>(){
			@Override
			public FoodBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodBean fb = new FoodBean();
				fb.setFoodId(rs.getInt(FIELD_FOODID));
				fb.setName(rs.getString(FIELD_NAME));
				fb.setType(rs.getString(FIELD_TYPE));
				fb.setPrice(rs.getInt(FIELD_PRICE));
				fb.setDetail(rs.getString(FIELD_DETAIL));
				fb.setPicture(rs.getString(FIELD_PICTURE));
				fb.setUpdateTime(rs.getDate(FIELD_UPDATETIME));
				return fb;
			}
		});
	}

	@Override
	public List<FoodBean> getAllFood() {
		String SQL = "SELECT * FROM "+ENTITY_NAME;
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		return jdbc.query(SQL, new RowMapper<FoodBean>(){
			@Override
			public FoodBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodBean fb = new FoodBean();
				fb.setFoodId(rs.getInt(FIELD_FOODID));
				fb.setName(rs.getString(FIELD_NAME));
				fb.setType(rs.getString(FIELD_TYPE));
				fb.setPrice(rs.getInt(FIELD_PRICE));
				fb.setDetail(rs.getString(FIELD_DETAIL));
				fb.setPicture(rs.getString(FIELD_PICTURE));
				fb.setUpdateTime(rs.getDate(FIELD_UPDATETIME));
				return fb;
			}
		});
	}

}
