package VehicleRentalSystem;
import java.util.*;
class Customer 
{
	static Database db=new Database();
	static Scanner scan=new Scanner(System.in);
	private static int id;
	//private static int deposit;
	private static String name="";
	private String mobile="",address="",aadhar="",license="";
	private String user="",pass="";
	
	public int checkPass()
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
					if(db.checkLogin(user,pass,2))
					{
						menu(user,pass);
						loop=1;
						select=0;
					}
					else
					{
						System.out.println("Enter Correct Username And Password");
					}
				}
			}
			//--------------------
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
				System.out.println("Enter your Address :");
				address=scan.nextLine();
				System.out.println("Enter your Aadhar No :");
				aadhar=scan.nextLine();
				System.out.println("Enter your License No :");
				license=scan.nextLine();
				System.out.println("Enter your Username :");
				user=scan.next();
				System.out.println("Enter your Password :");
				pass=scan.next();
				db.reg2(name,mobile,address,aadhar,license,user,pass);
				select=0;
			}
			//--------------------
			else if(select==0)
			{
				select=100;
			}
			//-------------------
			else 
			{
				System.out.println("Enter A Valid Number");
				select=0;
			}
			//-------------------
		}
		return 1;
	}
	public static void menu(String user1,String pass1)
	{
		Customer.id=db.getId(user1, pass1);
		Customer.name=db.getName(user1,pass1);
		int select=0;
		while(select==0)
		{
			System.out.println();
			System.out.println("        Welcome To Renting Page      ");
			System.out.println("=====================================");
			System.out.println("1)Enter 1 to Book a Vehicle for Rent:");
			System.out.println("2)Enter 2 to Cancel a Vehicle Rented:");
			System.out.println("3)Enter 0 to Exit the Dashboard :");
			System.out.println("=====================================");
			select=scan.nextInt();
			if(select==1)
			{
				System.out.println("V_ID|NAME|MODEL|V_TYPE|RENT/DAY|V_DEPOSIT");
				System.out.println("=========================================");
				db.vehList();
				System.out.println("=========================================");
				System.out.println("");
				System.out.println("Enter Vehicle Id For Booking Vehicle: ");
				int v_id=scan.nextInt();
				if(db.checkrent(id))
				db.rent(id,name,v_id);
				else
				System.out.println("Already Booked you can book only 1 car At a time");
			}
			else if(select==2)
			{
				db.cancelbooking(id);
			}
			else if(select==0)
			{
				select=10;
			}
			else
			{
				System.out.println("Enter a Valid Number:");
				select=0;
			}
		}
		Customer.id=0;
		Customer.name="";
		System.out.println();
		
	}
}
