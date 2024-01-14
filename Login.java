package VehicleRentalSystem;
import java.util.Scanner;
public class Login 
{
	Admin    ad=new Admin();
	Customer cs=new Customer(); 
	static Scanner scan=new Scanner(System.in);
	static int pass=0;
	public int user()
	{
		while(pass==0)
		{
			pass=cs.checkPass();
		}
		//------
		return 1;
	}
	public int admin()
	{
		while(pass==0)
		{
			pass=ad.checkKey();
		}
		return 1;
	}
}
