import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStmt2 {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf8","root","hkshitesh");  			 
				
			int id;
			String name="";
			System.out.println("Enter ID");
			id=sc.nextInt();
			System.out.println("Enter Name");
			name=sc.next();
			String s="insert into emp2 value(?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			ResultSet rs=pstmt.executeQuery("select * from emp2");  
			while(rs.next())  
			{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));		
			}
			con.close();  			
		} 
		catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} 

	}

}
