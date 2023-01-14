package jdbc_maven;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean exit =true;
		do {
			System.out.println("Enter to choose one option \n 1 for sign in \n 2 for log in \n 3 for delete \n 4 for exit");
			int choice=scanner.nextInt();
			User user=new User();
			UserCRUD crud=new UserCRUD();
			switch(choice) {
			case 1:{
				System.out.println("Enter the user id");
				int id=scanner.nextInt();
				System.out.println("Enter the user name");
				String username=scanner.next();
				System.out.println("Enter the password");
		     	String password=scanner.next();		
				System.out.println("Enter email id");
				String email=scanner.next();
				System.out.println("Enter the phone number");
				long phone =scanner.nextLong();				
				user.setId(id);
				user.setUserName(username);
				user.setPassword(password);
				user.setEmail(email);  
				user.setPhone(phone);
				user.setFbPassword("null");
				user.setInstaPassword("null");
				user.setTwitterPassword("null");
				user.setTelegramPassword("null");
				user.setWhatsAppPassword("null");
				try {
					crud.signIn(user);
				} catch (Exception e) {
					System.out.println("404 not found");
				}
			}break;
			case 2:{
				//User user=new User();
				System.out.println("Enter the id ");
				int id=scanner.nextInt();
				user.setId(id);
				System.out.println("Enter password");
				String password=scanner.next();
				user.setPassword(password);
				try {
					 boolean result=crud.logIn(user,password);
					 if(result==true) {
						 System.out.println("log in successfully");
						if(UserCRUD.i==1) {
							 System.out.println("Enter the Social media password");
							 System.out.println("===============================");
							 System.out.println("Enter face book password");
							 String fbpassword=scanner.next();
							 System.out.println("Enter instagram password");
							 String instapassword=scanner.next();
							 System.out.println("Enter the twitter password");
							 String twitterPassword=scanner.next();
							 System.out.println("Enter the telegram password");
							 String telegrampassword=scanner.next();
							 System.out.println("Enter the whats app password");
							 String whatspassword=scanner.next();
							 user.setFbPassword(fbpassword);
						     user.setInstaPassword(instapassword);
							 user.setTwitterPassword(twitterPassword);
							 user.setTelegramPassword(telegrampassword);
							 user.setWhatsAppPassword(whatspassword);

							 try {
								crud.saveSocailMedia(user);
								crud.getUserDetails(user);
							} catch (Exception e) {
								// TODO: handle exception
								System.out.println("user details not stored");
							}
						}
						if(UserCRUD.i==0)
						{
							boolean b=true;
				
							do {
							 System.out.println("Do you want update your password \n 1 for FaceBook password \n 2 for Instagram password \n 3 for Twitter password \n 4 for Telegram password \n 5 for WhatsAPP password \n 6 for Main Menu");
							 int choice1=scanner.nextInt();
							 switch(choice1) {
							 case 1:{
								 System.out.println("Enter id");
								 int id1=scanner.nextInt();
								 user.setId(id1);
								 System.out.println("Enter the new Face book password");
								 String fbpassword1=scanner.next();
								 user.setFbPassword(fbpassword1);
								 crud.updateFb(user);
							 }break;
							 case 2:{
								 System.out.println("Enter the id ");
								 int id1=scanner.nextInt();
								 user.setId(id1);
								 System.out.println("Enter the new instagram password");
								 String instapassword1=scanner.next();
								 user.setInstaPassword(instapassword1);
								 crud.updateInsta(user);
							 }break;
							 case 3:{
								 System.out.println("Enter the id ");
								 int id1=scanner.nextInt();
								 user.setId(id1);
								 System.out.println("Enter the new Twitter password");
								 String twitterpassword1=scanner.next();
								 user.setTwitterPassword(twitterpassword1);
								 crud.updateTwitter(user);
							 }break;
							 case 4:{
								 System.out.println("Enter the id ");
								 int id2=scanner.nextInt();
								 user.setId(id2);
								 System.out.println("Enter the new telegram password");
								 String telegrampassword1=scanner.next();
								 user.setTelegramPassword(telegrampassword1);
								 crud.updateTelegram(user);
							 }break;
							 case 5:{
								 System.out.println("Enter the id ");
								 int id2=scanner.nextInt();
								 user.setId(id2);
								 System.out.println("Enter the new whats app password");
								 String whatspassword1=scanner.next();
								 user.setWhatsAppPassword(whatspassword1);
								 crud.updateWhatsApp(user);
							 }break;
							 case 6:{
								 b=false;
							 }
							 default :{
								 System.out.println("Invalid option");
							 }
							 } 
							}while(b);
						 }
					 }
					 else {
						 System.out.println("invalid password");
					 }
				} catch (Exception e) {
					System.out.println("data is not there...!!!");
				}
				
			}break;
			case 3:{
				//User user=new User();
				System.out.println("Enter id");
				int id=scanner.nextInt();
				try {
					crud.deleteUser(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid id");
				}			
			}break;
			case 4:{
			    exit=false;
			}break;
			default :{
				System.out.println("invalid choice");
			}
			}	
		}while(exit);
		System.out.println("Thank You.........");
		

		
		

		

	}

}
