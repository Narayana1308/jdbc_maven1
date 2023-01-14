package jdbc_maven_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb","root","root");
		return connection;
	}
	public void savePerson(Person person) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into person values(?,?,?)");
		preparedStatement.setInt(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setLong(3, person.getPhone());
        preparedStatement.executeUpdate();
        connection.close();
        System.out.println("successfully added");
	}
	public void updatePerson(Person person) throws Exception {
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update person set name=? where id=?");
	    preparedStatement.setInt(2, person.getId());
	    preparedStatement.setString(1,person.getName());
	    preparedStatement.execute();
	    connection.close();
	    System.out.println("successfully updated");
	}
	public void deletePerson(Person person) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from person where id=?");
		preparedStatement.setInt(1,person.getId());
		preparedStatement.execute();
		connection.close();
		System.out.println("successfully deleted");
	}
	public void getPersonDetails() throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from person");

		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println("====================");
		}
	}

}
