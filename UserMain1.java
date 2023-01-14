package jdbc_maven_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMain1 {

	public static void main(String[] args) throws ClassNotFoundException, Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","root");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into user values(?,?,?,?,?)");
	    User user1=new User();
	    user1.setUserId(1021);
	    user1.setUserName("eswar chandra");
	    user1.setPassword("12345");
	    user1.setEmail("a@asdf");
	    user1.setPhone(12345);
	    User user2=new User();
	    user2.setUserId(2021);
	    user2.setUserName("david");
	    user2.setPassword("98745");
	    user2.setEmail("a@asdf");
	    user2.setPhone(56785);
	    User user3=new User();
	    user3.setUserId(3021);
	    user3.setUserName("narayannananna");
	    user3.setPassword("ghtrhg");
	    user3.setEmail("df@dfddg");
	    user3.setPhone(456785);
	    List <User> list=new ArrayList<User>();
	    list.add(user1);
	    list.add(user2);
	    list.add(user3);
	    for(User u:list) {
	    	preparedStatement.setInt(1, u.getUserId());
	    	preparedStatement.setString(2, u.getUserName());
	    	preparedStatement.setString(3,u.getPassword());
	    	preparedStatement.setString(4, u.getEmail());
	    	preparedStatement.setLong(5, u.getPhone());
	    	preparedStatement.addBatch();
	    	System.out.println(u.getUserName()+" added");
	    }
	    preparedStatement.executeBatch();
	    System.out.println("saved in db");
	    connection.close();
	    
	    

	}

}
