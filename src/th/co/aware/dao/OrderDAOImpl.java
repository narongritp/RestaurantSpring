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

import th.co.aware.bean.OrderBean;
import th.co.aware.config.MYLOG;

public class OrderDAOImpl implements OrderDAO{
	
	private static final String ENTITY_NAME = "`order`";
	private static final String FIELD_ORDERID = "order_id";
	private static final String FIELD_USERIDORDERING = "user_id_ordering";
	private static final String FIELD_USERIDCOMMIT = "user_id_commit";
	private static final String FIELD_DETAIL = "detail";
	private static final String FIELD_STATUS = "status";
	private static final String FIELD_ORDERDATE = "order_date";
	private static final String FIELD_COMMITDATE = "commit_date";
	
	@Autowired
	DataSource dataSource;

	@Override
	public OrderBean addOrder(OrderBean order) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO "+ENTITY_NAME+"("+
						FIELD_ORDERID+","+
						FIELD_USERIDORDERING+","+
						FIELD_DETAIL+","+
						FIELD_STATUS+","+
						FIELD_ORDERDATE+") VALUES(?,?,?,?,now())";
		int status = jdbc.execute(SQL, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws DataAccessException {
				try{
					ps.setString(1, order.getOrderId());
					ps.setInt(2, order.getUserIdOrdering());
					ps.setString(3, order.getDetail());
					ps.setString(4, order.getStatus());
					return ps.executeUpdate();
				}catch(SQLException ex){
					MYLOG.printError(ex.getMessage());
					return -1;
				}
			}
		});
		if(status==1){
			
			return order;
		}else{
			return null;
		}
	}

	@Override
	public int updateOrder(OrderBean order) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "UPDATE "+ENTITY_NAME+" SET "+
				FIELD_USERIDCOMMIT+"=?,"+
				FIELD_DETAIL+"=?,"+
				FIELD_STATUS+"=?,"+
				FIELD_COMMITDATE+"=now() "+
				"WHERE "+FIELD_ORDERID+"="+order.getOrderId();
		return jdbc.execute(SQL, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws DataAccessException {
				try{
					ps.setInt(1, order.getUserIdCommit());
					ps.setString(2, order.getDetail());
					ps.setString(3, order.getStatus());
					return ps.executeUpdate();
				}catch(SQLException ex){
					MYLOG.printError(ex.getMessage());
					return -1;
				}
			}
		});
	}

	@Override
	public int cancelOrder(int orderId) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "DELETE FROM "+ENTITY_NAME+" WHERE "+FIELD_ORDERID+"="+orderId;
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
	public OrderBean getOrderById(String orderId) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM "+ENTITY_NAME+" WHERE "+FIELD_ORDERID+" LIKE '"+orderId+"'";
		List<OrderBean> orders =  jdbc.query(SQL, new RowMapper<OrderBean>() {
			@Override
			public OrderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderBean order = new OrderBean();
				order.setOrderId(rs.getString(FIELD_ORDERID));
				order.setUserIdOrdering(rs.getInt(FIELD_ORDERID));
				order.setUserIdCommit(rs.getInt(FIELD_USERIDCOMMIT));
				order.setDetail(rs.getString(FIELD_DETAIL));
				order.setStatus(rs.getString(FIELD_STATUS));
				order.setOrderDate(rs.getDate(FIELD_ORDERDATE));
				order.setCommitDate(rs.getDate(FIELD_COMMITDATE));
				return order;
			}
		});
		
		if(orders!=null&orders.size()>0){
			return orders.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<OrderBean> getAllOrder() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM "+ENTITY_NAME+" ORDER BY "+FIELD_ORDERDATE+" DESC";
		return jdbc.query(SQL, new RowMapper<OrderBean>() {
			@Override
			public OrderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderBean order = new OrderBean();
				order.setOrderId(rs.getString(FIELD_ORDERID));
				order.setUserIdOrdering(rs.getInt(FIELD_USERIDORDERING));
				order.setUserIdCommit(rs.getInt(FIELD_USERIDCOMMIT));
				order.setDetail(rs.getString(FIELD_DETAIL));
				order.setStatus(rs.getString(FIELD_STATUS));
				order.setOrderDate(rs.getDate(FIELD_ORDERDATE));
				order.setCommitDate(rs.getDate(FIELD_COMMITDATE));
				return order;
			}
		});
	}

	@Override
	public List<OrderBean> getAllOrderW() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM "+ENTITY_NAME+" WHERE status LIKE 'W' ORDER BY "+FIELD_ORDERDATE+" DESC";
		return jdbc.query(SQL, new RowMapper<OrderBean>() {
			@Override
			public OrderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderBean order = new OrderBean();
				order.setOrderId(rs.getString(FIELD_ORDERID));
				order.setUserIdOrdering(rs.getInt(FIELD_USERIDORDERING));
				order.setUserIdCommit(rs.getInt(FIELD_USERIDCOMMIT));
				order.setDetail(rs.getString(FIELD_DETAIL));
				order.setStatus(rs.getString(FIELD_STATUS));
				order.setOrderDate(rs.getDate(FIELD_ORDERDATE));
				order.setCommitDate(rs.getDate(FIELD_COMMITDATE));
				return order;
			}
		});
	}

}
