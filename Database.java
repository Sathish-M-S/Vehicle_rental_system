package VehicleRentalSystem;
import java.time.*;
import java.time.LocalDate;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Database

{
	static String name="",model="",regno="",status="AVAILABLE",type="",user="",pass="",query="",queryextend="";
	static int rpd=0,deposit=0,id;
	public static String db(String s,int n)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rental_management","root","29_March_2004");
		Statement stmt=con.createStatement();
		if(n==1)
		{
			stmt.executeUpdate(s);
			return "Successfully Updated";
		}
		else 
		{
			ResultSet result =stmt.executeQuery(s);
			String ret="";
			while(result.next())
			{
				ret="";
				if(n==2)
				{
					ret=result.getString(1);
					break;
				}
				else if(n==3)
				{
					ret+=result.getInt(1)+" | "+result.getString(2)+" | "+result.getString(3)+" | "+result.getString(4)+" | "+result.getString(5)+" | "+result.getString(6)+" | "+result.getString(7)+" | "+result.getInt(8)+" | "+result.getString(9)+" | "+result.getString(10);
				}
				else if(n==4)
				{
					ret+=result.getInt(1)+" | "+result.getString(2)+" | "+result.getString(3)+" | "+result.getString(4)+" | "+result.getString(5)+" | "+result.getString(6)+" | "+result.getInt(7)+" | "+result.getInt(8);
				}
				else if(n==5)
				{
					ret+=result.getInt(1)+" | "+result.getInt(2)+" | "+result.getString(3)+" | "+result.getInt(4)+" | "+result.getString(5)+" | "+result.getString(6)+" | "+result.getString(7)+" | "+result.getString(8)+" | "+result.getInt(9)+" | "+result.getInt(10);
				}
				else if(n==6)
				{
					ret+=result.getInt(1)+" | "+result.getString(2)+" | "+result.getString(3)+" | "+result.getString(4)+" | "+result.getInt(5)+" | "+result.getInt(6);
				}
				else if(n==7)
				{
					ret+=result.getString(1);
				}
				else if(n==8)
				{
					ret+=result.getString(1);
				}
				else if(n==9)
				{
					ret+=result.getString(1)+" | "+result.getString(2)+" | "+result.getString(3)+" | "+result.getString(4)+" | "+result.getString(5)+" | "+result.getString(6)+" | "+result.getString(7)+" | "+result.getString(8)+" | "+result.getString(9)+" | "+result.getString(10)+" | "+result.getString(11);
				}
				if(n!=8)
				System.out.println(ret);
			}
			return ret;
		}

		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("# ERROR # - "+e.getMessage());
			return null;
		}
	}
	//------------------------------------------------------
	
	public boolean checkLogin(String user,String password,int n)
	{
		if(n==1)
		query="SELECT A_PASSWORD FROM ADMIN WHERE A_USERNAME = '"+user+"'";
		else
		query="SELECT PASSWORD FROM CUSTOMER WHERE USERNAME = '"+user+"'";
		String result=db(query,2);
		if(password.equals(result))
			return true;
		else
			return false;
	}
	//-----------------------------------------------------
	
	//-----------------------------------------------------
    public static void disCust() 
    {
		
		db("SELECT * FROM CUSTOMER;",3);
	}
	public static void disVeh()
	{
		db("SELECT * FROM VEHICLE;",4);
	}
	public static void disRent()
	{
		db("SELECT * FROM rent_details;",9);
	}
	public static void addVeh()
	{
		System.out.println("Enter Vehicle name : ");
		name=Login.scan.next();
		System.out.println("Enter Vehicle Model : ");
		Login.scan.nextLine();
		model=Login.scan.nextLine();
		System.out.println("Enter Vehicle Register Number: ");
		regno=Login.scan.nextLine();
		System.out.println("Enter Vehicle Type : ");
		type=Login.scan.next();
		System.out.println("Enter Vehicle Rent per Day: ");
		rpd=Login.scan.nextInt();
		System.out.println("Enter Vehicle Deposit Ammount: ");
		deposit=Login.scan.nextInt();
		db("INSERT INTO VEHICLE (V_NAME,V_MODEL,V_REGNO,V_STATUS,V_TYPE,RENT_PER_DAY,V_DEPOSIT) VALUES ('"+name+"','"+model+"','"+regno+"','"+status+"','"+type+"',"+rpd+","+deposit+");", 1);
	}
	public static int dec(String str)
	{
		return Integer.parseInt(str);
	}
	public static void editVeh()
	{
		System.out.println();
		db("SELECT * FROM VEHICLE;",4);
		System.out.println();
		int select=1;
		while(select==1)
		{
			System.out.println("Enter V_ID to Edit");
			id=Login.scan.nextInt();
			System.out.println("Enter 1 to edit Vehicle name : ");
			System.out.println("Enter 2 for Vehicle Model : ");
			System.out.println("Enter 3 for Vehicle Register Number: ");
			System.out.println("Enter 4 for Vehicle status: ");
			System.out.println("Enter 5 for Vehicle Type : ");
			System.out.println("Enter 6 forVehicle Rent per Day: ");
			System.out.println("Enter 7 for Vehicle Deposit Ammount: ");
			System.out.println("Enter 0 for Exit: ");
			select=Login.scan.nextInt();
			if(select>=0&&select<=7)
			{
				query="UPDATE VEHICLE SET ";
				if(select==1)
				{
					System.out.println("Enter New Name:");
					query+="V_NAME = '"+Login.scan.next()+"' WHERE V_ID = "+id+" ;";
					db(query,1);
					
				}
				else if(select==2)
				{
					System.out.println("Enter New Model:");
					query+="V_MODEL = '"+Login.scan.next()+"' WHERE V_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==3)
				{
					System.out.println("Enter New Register Number:");
					query+="V_REGNO = '"+Login.scan.next()+"' WHERE V_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==4)
				{
					System.out.println("Enter New Status:");
					query+="V_STATUS = '"+Login.scan.next()+"' WHERE V_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==5)
				{
					System.out.println("Enter New Type:");
					query+="V_TYPE = '"+Login.scan.next()+"' WHERE V_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==6)
				{
					System.out.println("Enter New Rent Per Day:");
					query+="RENT_PER_DAY = '"+Login.scan.next()+"' WHERE V_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==7)
				{
					System.out.println("Enter New Vehicle Deposit:");
					query+="V_DEPOSIT = '"+Login.scan.next()+"' WHERE V_ID = "+id+" ;";
					db(query,1);
				}
				select=1;
			}	
			else if(select==0)
			{
				select=0;
			}
			else
			{
				System.out.println("Enter a Valid Number");
			}
		}
	}
	public static void editCust()
	{
		System.out.println();
		db("SELECT * FROM CUSTOMER;",3);
		System.out.println();
		int select=1;
		while(select==1)
		{
			System.out.println("Enter C_ID of the Customer to Edit");
			id=Login.scan.nextInt();
			System.out.println("Enter 1 to Edit Customer's Name : ");
			System.out.println("Enter 2 to Edit Customer's Mobile No : ");
			System.out.println("Enter 3 to Edit Customer's Address: ");
			System.out.println("Enter 4 to Edit Customer's Aadhar No: ");
			System.out.println("Enter 5 to Edit Customer's License No: ");
			System.out.println("Enter 6 to Edit Customer's Return Status: ");
			System.out.println("Enter 7 to Edit Customer's Deposit : ");
			System.out.println("Enter 8 to Edit Customer's Username : ");
			System.out.println("Enter 9 to Edit Customer's Password : ");
			System.out.println("Enter 0 for Exit: ");
			select=Login.scan.nextInt();
			if(select>0&&select<=9)
			{
				query="UPDATE CUSTOMER SET ";
				if(select==1)
				{
					System.out.println("Enter Customer's New Name:");
					query+="C_NAME = '"+Login.scan.next()+"' WHERE C_ID = "+id+" ;";
					db(query,1);
					
				}
				else if(select==2)
				{
					System.out.println("Enter Customer's New Mobile No:");
					query+="C_MOBILE = '"+Login.scan.next()+"' WHERE C_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==3)
				{
					System.out.println("Enter Customer's New Address:");
					query+="C_ADDRESS = '"+Login.scan.next()+"' WHERE C_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==4)
				{
					System.out.println("Enter Customer's New Aadhar No:");
					query+="AADHAR_NO = '"+Login.scan.next()+"' WHERE C_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==5)
				{
					System.out.println("Enter Customer's New License No:");
					query+="LICENSE_NO = '"+Login.scan.next()+"' WHERE C_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==6)
				{
					System.out.println("Enter Customer's Car Return Status: ");
					query+="C_STATUS = '"+Login.scan.next()+"' WHERE C_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==7)
				{
					System.out.println("Enter Customer's Security Deposit Value :");
					query+="S_DEPOSIT = '"+Login.scan.next()+"' WHERE C_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==8)
				{
					System.out.println("Enter Customer's New Username: ");
					query+="USERNAME = '"+Login.scan.next()+"' WHERE C_ID = "+id+" ;";
					db(query,1);
				}
				else if(select==9)
				{
					System.out.println("Enter Customer's New Password: ");
					query+="PASSWORD = '"+Login.scan.next()+"' WHERE C_ID = "+id+" ;";
					db(query,1);
				}
				select=1;
			}		
			else if(select==0)
			{				
				select=0;
			}
			else
			{
				System.out.println("Enter a Valid Number");
			}
		}
	}
	public void vehList()
	{
		db("SELECT V_ID,V_NAME,V_MODEL,V_TYPE,RENT_PER_DAY,V_DEPOSIT FROM VEHICLE WHERE V_STATUS='AVAILABLE';",6);
	}
	public int getId(String user1,String pass1)
	{
		String result=db("SELECT C_ID FROM CUSTOMER WHERE USERNAME = '"+user1+"' AND PASSWORD = '"+pass1+"';",8);
		if(!result.equals(""))
			return dec(result);
		else return 0;
	}
	public String getName(String user1,String pass1)
	{
		return db("SELECT C_NAME FROM CUSTOMER WHERE USERNAME = '"+user1+"' AND PASSWORD = '"+pass1+"';",7);
	}
	public boolean checkrent(int c_id)
	{
		String ret=db("select c_status from customer where c_id = "+c_id+";",8);
		if(!ret.equals("RENTED"))
		return true;
		else
		return false;
	}
	public void rent(int cid,String name,int vid)
	{
		LocalDate bdate=LocalDate.now();
		System.out.println("Enter Vehicle Getting Date in (yyyy-mm-dd) :");
		String fdate=Customer.scan.next();
		String f[]=fdate.split("-");
		LocalDate start=LocalDate.of(dec(f[0]),dec(f[1]),dec(f[2]));
		System.out.println("Enter Vehicle Returning Date in (yyyy-mm-dd) :");
		String rdate=Customer.scan.next();
		String e[]=rdate.split("-");
		LocalDate end=LocalDate.of(dec(e[0]),dec(e[1]),dec(e[2]));
		Period period=Period.between(start,end);
		int total=period.getDays();
		query=db("SELECT RENT_PER_DAY FROM VEHICLE WHERE V_ID ="+vid+";",8);
		total*=dec(query);
		query="INSERT INTO RENT_DETAILS (C_ID,C_NAME,V_ID,V_TYPE,R_STATUS,BOOK_DATE,FROM_DATE,END_DATE,FINE_AMMOUNT,TOTAL_RENT) VALUES ("+cid+",'"+name+"',"+vid+",'"+db("SELECT V_TYPE FROM VEHICLE WHERE V_ID ="+vid+";",2)+"',NOT RETURNED,'"+(bdate.toString())+"','"+fdate+"','"+rdate+"',0,"+total+");";
		db(query,1);
		db("UPDATE VEHICLE SET V_STATUS = 'RENTED' WHERE V_ID = "+vid+" ;",1);
		db("UPDATE CUSTOMER SET C_STATUS = 'RENTED' WHERE C_ID = "+cid+" ;",1);
	}
	public void cancelbooking(int c_id)
	{
		LocalDate bdate=LocalDate.now();
		String tdate=bdate.toString();
		String f[]=tdate.split("-");
		String fdate=db("SELECT FROM_DATE FROM RENT_DETAILS WHERE C_ID = "+c_id+";",8);
		String e[]=fdate.split("-");
		LocalDate start=LocalDate.of(dec(f[0]),dec(f[1]),dec(f[2]));
		LocalDate end=LocalDate.of(dec(e[0]),dec(e[1]),dec(e[2]));
		Period period=Period.between(start,end);
		int total=period.getDays();
		if(total==0)
			System.out.println("You Not Able to Cancel Booked Vehicle Now, Visit our dealer for More information");
		else
		{
			db("UPDATE VEHICLE SET V_STATUS = 'AVAILABLE' WHERE V_ID = "+dec(db("select v_id from rent_details where c_id="+c_id+";",8))+" ;",1);
			db("UPDATE CUSTOMER SET C_STATUS = '0' WHERE C_ID = "+c_id+" ;",1);
			db("UPDATE RENT_DETAILS SET R_STATUS = 'DROPED' WHERE C_ID = "+c_id+" ;",1);
			System.out.println("Successfully Canceled the Booking..");
		}
	}
	public void reg1(String name2, String mobile, int age, String address, String email, String user2, String pass2) 
	{
		db("INSERT INTO ADMIN (A_NAME,A_MOBILE,A_AGE,A_ADDRESS,A_EMAIL,A_USERNAME,A_PASSWORD) VALUES ('"+name2+"','"+mobile+"',"+age+",'"+address+"','"+email+"','"+user2+"','"+pass2+"') ;",1);	
	}
	public void reg2(String name2, String mobile, String address, String aadhar, String license, String user2, String pass2) 
	{
		db("INSERT INTO CUSTOMER (C_NAME,C_MOBILE,C_ADDRESS,AADHAR_NO,LICENSE_NO,USERNAME,PASSWORD) VALUES ('"+name2+"','"+mobile+"','"+address+"','"+aadhar+"','"+license+"','"+user2+"','"+pass2+"') ;",1);	
	}
}
