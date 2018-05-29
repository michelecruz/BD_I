import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://35.225.192.75:1433";
		String user = "SA";
		String passwd = "<YourNewStrong!Passw0rd>";
		String connectionUrl = url + ";database=" + ";user=" + user+ ";password="+ passwd;
		Connection conn = DriverManager.getConnection(connectionUrl);
		
		String query = "select name from sys.Databases";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			String name = rs.getString("name");
			System.out.println(name);
		}
		rs.close();
		ps.close();
		conn.close();

	}

}
