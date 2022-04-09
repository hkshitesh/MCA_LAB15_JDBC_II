import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedSTMT {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf8","root","hkshitesh");  			 
				
			int id;			
			System.out.println("Enter ID");
			id=sc.nextInt();
			String s = "select * from emp2 where id=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);						
			ResultSet rs=pstmt.executeQuery();  
			while(rs.next())  
			System.out.println(rs.getInt(1)+" "+rs.getString(2));		 
			con.close();  			
		} 
		catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} 
	}

}
