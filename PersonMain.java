package jdbc_maven_eb9;

import java.util.Scanner;

public class PersonMain {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		System.out.println("Enter the name ");
		String name=scanner.next();
		System.out.println("Enter the phone number");
		long phone =scanner.nextLong();
		Person person=new Person();
		person.setId(id);
		person.setName(name);
		person.setPhone(phone);
		PersonCRUD crud=new PersonCRUD();
//		try {
//			crud.deletePerson(person);;
//		} catch (Exception e) {
//			System.out.println("404 not found");
//		}
//		try {
//			crud.savePerson(person);
//		} catch (Exception e) {
//			System.out.println("not found");
//		}
//		try {
//			crud.updatePerson(person);
//		} catch (Exception e) {
//			System.out.println("not found");
//		}
		try {
			crud.getPersonDetails();
		} catch (Exception e) {
			System.out.println("not found");
		}

	}

}
