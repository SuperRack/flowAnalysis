package cn.hist.flow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接相关配置
 */
public class ConnectionUtil {
	
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql:///flow";
	private static final String USER="root";
	private static final String PWD="123456";
	
	private static Connection con=null;
	
	static{
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USER,PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从数据库连接池中获取连接
	 */
	public static Connection getConnection(){
		return con;
	}
	
	/**
	 * 关闭
	 */
	public static void close(ResultSet rs,PreparedStatement ps,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs){
		close(rs,null,null);
	}
	public static void close(Connection con){
		close(null,null,con);
	}
	public static void close(PreparedStatement ps){
		close(null,ps,null);
	}
}
