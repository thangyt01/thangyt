package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConnectSQL {
	static Connection conn = null;
	public ConnectSQL() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection Connect() throws SQLException {
		var sever = "DESKTOP-9KTV682\\SQLEXPRESS";
        var user = "sa";
        var password = "0123456";
        var db = "CSDL";
        var port = 1433;
        SQLServerDataSource source= new SQLServerDataSource();
        source.setUser(user);
        source.setPassword(password);
        source.setDatabaseName(db);
        source.setServerName(sever);
        source.setPortNumber(port);
			
        try {
        	System.out.println("Đang kết nối!");
			conn = source.getConnection();
	        System.out.println("Ket noi thanh cong toi Database: " + conn.getCatalog());
	        return conn;
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
//	public static Connection Connect() throws SQLException {
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			System.out.println("Khởi tạo");
//			String s = "jdbc:sqlserver://DESKTOP-9KTV682\\\\SQLEXPRESS:1433;databaseName=Benh_Nhan;integratedSecurity=true;";
//			conn = DriverManager.getConnection(s, "sa", "0123456");
//			System.out.println("Khởi tạo");
//			return conn;
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
	
	public static ObservableList<BenhNhan> getBenhNhan() throws SQLException{
		ObservableList<BenhNhan> list = FXCollections.observableArrayList();
		Connection conn = Connect();
        PreparedStatement ps = conn.prepareStatement("select * from BenhNhan");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
//        	System.out.println(rs.getString("HoTen"));
//        	System.out.println(rs.getInt("NamSinh"));
//        	System.out.println(rs.getString("GioiTinh"));
//        	System.out.println(rs.getInt("SDT"));
//        	System.out.println(rs.getString("DiaChi"));
        	list.add(new BenhNhan(
        			rs.getString("HoTen"),
                    rs.getInt("NamSinh"),
                    rs.getString("GioiTinh"), 
                    rs.getInt("MaBHYT"), 
                    rs.getString("SDT"), 
                    rs.getString("DiaChi")                    
        			));
        }
//        System.out.print(list);
		return list;
	}
}
