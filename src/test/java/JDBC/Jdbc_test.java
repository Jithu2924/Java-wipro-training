package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_test {
	public static void main(String[] args) {
		
		String url="jdbc:mysql://LocalHost/4thaug2025";
		String user="root";
		String password="Mysqljithu@2002";
		try (
			Connection con=DriverManager.getConnection(url,user,password);)
		{
		System.out.println("DB connected");	
//		String insertsql="insert into students(id,name,age) values(?,?,?)";
//		try(PreparedStatement psmt=con.prepareStatement(insertsql)){
//			psmt.setInt(1,102);
//			psmt.setString(2, "Ganga");
//			psmt.setInt(3, 24);
//			int exc=psmt.executeUpdate();
//			System.out.println("inserted"+exc);
//		}
		
//		String updatesql="update students set name=? where id=? ";
//		try(PreparedStatement psmt=con.prepareStatement(updatesql)){
//			psmt.setString(1, "Gangu");
//			psmt.setInt(2,102);
//			int exc=psmt.executeUpdate();
//			System.out.println("inserted"+exc);
//		}
		
		
//		String deletesql="delete from students where id=? ";
//		try(PreparedStatement psmt=con.prepareStatement(deletesql)){
//			psmt.setInt(1,101);
//			int exc=psmt.executeUpdate();
//			System.out.println("inserted"+exc);
//		}
//		
		String readsql="select * from students";
		try (Statement stmt=con.createStatement();){
			ResultSet rs=stmt.executeQuery(readsql);
			while(rs.next()) {
				System.out.println("id :"+rs.getInt(1));
				System.out.println("name :"+rs.getString(2));
				System.out.println("age :"+rs.getInt(3));
			}
		}
		
		
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
}
