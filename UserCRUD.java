package jdbc_maven;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class UserCRUD {
	static int i=0;
	public Connection getConnection() throws Exception {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		FileInputStream fileInputStream=new FileInputStream("userdbconfig.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		Connection connection =DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
		return connection;
	}
	public void signIn(User user) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into user1 values(?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getUserName());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setLong(5, user.getPhone());
		preparedStatement.setString(6, user.getFbPassword());
		preparedStatement.setString(7, user.getInstaPassword());
		preparedStatement.setString(8, user.getTwitterPassword());
		preparedStatement.setString(9, user.getTelegramPassword());
		preparedStatement.setString(10, user.getWhatsAppPassword());
		preparedStatement.execute();
		connection.close();
		System.out.println("successfully added");

		}
	public boolean logIn(User user,String password) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from user1 where id=?");
		preparedStatement.setInt(1, user.getId());
		ResultSet resultset=preparedStatement.executeQuery();
		while(resultset.next())
		{
			if(password.equals(resultset.getString(3)))
			{
				if(resultset.getString(7).equals("null")) 
					i=1;
				else
					i=0; 
				return true;
			}
		}
		return false;
		
	}
	public void saveSocailMedia(User user) throws Exception {
		
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update user1 set fbpassword=?,instapassword=?,twitterpassword=?,telegrampassword=?,whatspassword=? where id=? ");
		preparedStatement.setString(1, user.getFbPassword());
		preparedStatement.setString(2, user.getInstaPassword());
		preparedStatement.setString(3, user.getTwitterPassword());
		preparedStatement.setString(4, user.getTelegramPassword());
		preparedStatement.setString(5,user.getWhatsAppPassword());
		preparedStatement.setInt(6, user.getId());
	    preparedStatement.execute();	
	    
		System.out.println("addeeddd");
         connection.close();	
	}
	public void updateFb(User user) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update user1 set fbpassword=? where id=?");
		preparedStatement.setString(1, user.getFbPassword());
		preparedStatement.setInt(2, user.getId());
		preparedStatement.execute();
		connection.close();
		System.out.println("successfully updated your password");
				
	}
	public void updateInsta(User user) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update user1 set instapassword=? where id=?");
		preparedStatement.setString(1, user.getInstaPassword());
		preparedStatement.setInt(2,user.getId());
		preparedStatement.execute();
		connection.close();
		System.out.println("successfully updated your password");
	}
	public void updateTwitter(User user) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update user1 set twitterpassword=? where id=?");
		preparedStatement.setString(1, user.getTwitterPassword());
		preparedStatement.setInt(2, user.getId());
		preparedStatement.execute();
		connection.close();
		System.out.println("successfully updated your password");
		
	}
	public void updateTelegram(User user) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update user1 set telegrampassword=? where id=?");
		preparedStatement.setString(1, user.getTelegramPassword());
		preparedStatement.setInt(2, user.getId());
		preparedStatement.execute();
		connection.close();
		System.out.println("successfully updated your password");
	}
	public void updateWhatsApp(User user) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update user1 set whatspassword=? where id=?");
		preparedStatement.setString(1, user.getWhatsAppPassword());
		preparedStatement.setInt(2, user.getId()); 
		preparedStatement.execute();
		connection.close();
		System.out.println("successfully updated your password");
	}
	public void getUserDetails(User user) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from user1 where id=?");
		preparedStatement.setInt(1, user.getId());
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println("User id :"+resultSet.getInt(1));
			System.out.println("User Name :"+resultSet.getString(2));
			System.out.println("User password :"+resultSet.getString(3));
			System.out.println("User Email :"+resultSet.getString(4));
			System.out.println("User Phone :"+resultSet.getLong(5));
			System.out.println("Social media passwords");
			System.out.println("=======================  ");
			System.out.println("Face book :"+resultSet.getString(6));
			System.out.println("Instgram :"+resultSet.getString(7));
			System.out.println("Twitter :"+resultSet.getString(8));
			System.out.println("Telegram  :"+resultSet.getString(9));
			System.out.println("whats App :"+resultSet.getString(10));
		}
		connection.close();
		
	}
	public void deleteUser(int id) throws Exception {
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from user1 where id=?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		connection.close();
		System.out.println("successfully deleted");
		
	}

}
