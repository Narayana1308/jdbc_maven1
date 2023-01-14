package jdbc_maven_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		return connection;
	}
	public void saveStudent(Student student) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("Insert into student values(?,?,?,?)");
		preparedStatement.setInt(1, student.getIdstudent());
		preparedStatement.setString(2, student.getSname());
		preparedStatement.setInt(3, student.getSmarks());
		preparedStatement.setString(4, student.getAddress());
		preparedStatement.execute();
		connection.close();
		System.out.println("successfully added");
	}
	public void updateStudent(Student student) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update student set sname=? where idstudent=?");
		preparedStatement.setInt(2, student.getIdstudent());
		preparedStatement.setString(2, student.getSname());
		preparedStatement.execute();
		connection.close();
		System.out.println("successfully updated");
		
	}
	public void deleteStudent(Student student) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from student where idtudent=?=");
		preparedStatement.setInt(1, student.getIdstudent());
		preparedStatement.execute();
		connection.close();
		System.out.println("deleted");
	}
	public void getStudentDetails() throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from student");
		ResultSet  resultset= preparedStatement.executeQuery();
		while(resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getInt(3));
			System.out.println(resultset.getString(4));
			
		}
	}

}
