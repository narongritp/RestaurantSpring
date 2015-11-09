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

import th.co.aware.bean.OrderListBean;
import th.co.aware.config.MYLOG;

public class OrderListDAOImpl implements OrderListDAO{

	private static final String ENTITY_NAME = "order_list";
	private static final String FIELD_ORDERID = "order_id";
	private static final String FIELD_FOODID = "food_id";
	private static final String FIELD_PRICE = "price";
	private static final String FIELD_AMOUNT = "amount";
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public List<OrderListBean> getAllItem() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM "+ENTITY_NAME;
		return jdbc.query(SQL, new RowMapper<OrderListBean>() {
			@Override
			public OrderListBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderListBean orderList = new OrderListBean();
				orderList.setOrderId(rs.getInt(FIELD_ORDERID));
				orderList.setFoodId(rs.getInt(FIELD_FOODID));
				orderList.setPrice(rs.getInt(FIELD_PRICE));
				orderList.setAmount(rs.getInt(FIELD_AMOUNT));
				return orderList;
			}
		});
	}
	
	@Override
	public OrderListBean getItem(OrderListBean olb) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM "+ENTITY_NAME+" WHERE "+FIELD_ORDERID+"="+olb.getOrderId();
		return jdbc.query(SQL, new RowMapper<OrderListBean>() {
			@Override
			public OrderListBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderListBean orderList = new OrderListBean();
				orderList.setOrderId(rs.getInt(FIELD_ORDERID));
				orderList.setFoodId(rs.getInt(FIELD_FOODID));
				orderList.setPrice(rs.getInt(FIELD_PRICE));
				orderList.setAmount(rs.getInt(FIELD_AMOUNT));
				return orderList;
			}
		}).get(0);
	}

	@Override
	public int addItem(OrderListBean olb) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO "+ENTITY_NAME+"("+
						FIELD_ORDERID+","+
						FIELD_FOODID+","+
						FIELD_PRICE+","+
						FIELD_AMOUNT+") VALUES(?,?,?,?)";
		
		return jdbc.execute(SQL, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws DataAccessException {
				try{
					ps.setInt(1, olb.getOrderId());
					ps.setInt(2, olb.getFoodId());
					ps.setInt(3, olb.getPrice());
					ps.setInt(4, olb.getAmount());
					return ps.executeUpdate();
				}catch(SQLException ex){
					MYLOG.printError(ex.getMessage());
					return -1;
				}
			}
		});
	}

	@Override
	public int updateItem(OrderListBean olb) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "UPDATE "+ENTITY_NAME+" SET "+
						FIELD_PRICE+"=?,"+
						FIELD_AMOUNT+"=? "+
						"WHERE "+FIELD_FOODID+"="+olb.getFoodId()+" AND "+
						FIELD_ORDERID+"="+olb.getOrderId();
		
		return jdbc.execute(SQL, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws DataAccessException {
				try{
					ps.setInt(1, olb.getPrice());
					ps.setInt(2, olb.getAmount());
					return ps.executeUpdate();
				}catch(SQLException ex){
					MYLOG.printError(ex.getMessage());
					return -1;
				}
			}
		});
	}

	@Override
	public int deleteItem(OrderListBean olb) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "DELETE FROM "+ENTITY_NAME+" WHERE "+FIELD_ORDERID+"="+olb.getOrderId()+
				" AND "+FIELD_FOODID+"="+olb.getFoodId();
		
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

	

}
