package VehicleRentalSystem;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) 
	{
		try (Scanner scan = new Scanner(System.in))
		{
			Login log = new Login();
			System.out.println("Welcome to Rental Management System");
			System.out.println("-----------------------------------");
			//Login Loop
			int select1=0;
			while(select1==0)
			{
				System.out.println("Enter 1 For User, 2 For Admin, 3 For Exit");
				select1=scan.nextInt();
				if(select1==1)
					select1=log.user();
				else if(select1==2)
					select1=log.admin();
				else if(select1==0)
					select1=1;
				else
				System.out.println("Enter a Valid Number");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
}
