package VehicleRentalSystem;
import java.util.*;

public class Admin 
{
	private String key = "MS123";
	static String name="",mobile="",model="",regno="",status="AVAILABLE",type="",user="",pass="",query="";
	static int rpd=0,deposit=0,id;
	static Database db=new Database();
	static Scanner scan=new Scanner(System.in);
	//----------------------------------------------------------------
	public int checkKey()
	{
		System.out.println("Enter Pass Key :");
		String k=Login.scan.next();
		if(k.equals(key))
		{
			int select=0;
			while(select==0)
			{
				System.out.println("Enter 1 for Login, 2 for Register, 0 for Exit");
				select=scan.nextInt();
				if(select==1)
				{
					int loop=0;
					while(loop==0)
					{
						System.out.println("Enter Username: ");
						user=scan.next();
						System.out.println("Enter Password: ");
						pass=scan.next();
						if(db.checkLogin(user,pass,1))
						{
							menu();
							loop=1;
						}
						else
						{
							System.out.println("Enter Correct Username And Password");
						}
					}
				}
				else if(select==2)
				{
					System.out.println();
					System.out.println("         Resistration Page       ");
					System.out.println("==================================");
					System.out.println("Enter your Name : ");
					scan.nextLine();
					name=scan.nextLine();
					System.out.println("Enter your Mobile No : ");
					mobile=scan.nextLine();
					System.out.println("Enter your Age :");
					int age=scan.nextInt();
					System.out.println("Enter your Address :");
					scan.nextLine();
					String address=scan.nextLine();
					System.out.println("Enter your email id :");
					String email=scan.next();
					System.out.println("Enter your Username :");
					user=scan.next();
					System.out.println("Enter your Password :");
					pass=scan.next();
					db.reg1(name,mobile,age,address,email,user,pass);
				}
				else 
				{
					System.out.println("Enter A Valid Number");
					select=0;
				}
			}
			return 1;
		}
		else
		{
			System.out.println("Enter A Valid Key :");
			return 0;
		}
	}
	//----------------------------------------------------------
	public static void menu() 
	{
		System.out.println();
		System.out.println("       Welcome To Admin Page      ");
		System.out.println("==================================");
		System.out.println("Enter 1 to Display Customer detail");
		System.out.println("Enter 2 to Display vehicle List");
		System.out.println("Enter 3 to Display Rented  List");
		System.out.println("Enter 4 to Add New Vehicle Detail");
		System.out.println("Enter 5 to Edit Vehicle Detail");
		System.out.println("Enter 6 to Customer return vehicle");
		System.out.println("Enter 0 to Exit The Dashboard");
		int loop=0;
		
		while(loop==0)
		{
			int select = scan.nextInt();
			
			if(select==1)
				Database.disCust();
			else if(select==2)
				Database.disVeh();
			else if(select==3)
				Database.disRent();
			else if(select==4)
				Database.addVeh();
			else if(select==5)
				Database.editVeh();
			else if(select==6)
				Database.editCust();
			else if(select==0)
				loop=1;
		}
	}
}
