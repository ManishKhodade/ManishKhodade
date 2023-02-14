package Alumni_Dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspWriter;

import Alumni_BO.Alumni_Bo;
import Alumni_BO.Dil_Alumni_Bo;



public class Alumni_Dao 
{

	
	public static Connection getConnection()
	{
		Connection con=null;
		try {
		
		String url="jdbc:mysql://localhost:3306/alumnimanagement";
		String uname="root";
		String pass="manish@825";
		
		 Class.forName("com.mysql.cj.jdbc.Driver"); 
		 con=DriverManager.getConnection(url,uname,pass);
		
		 
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
		
		return con;
		
	}

	  public static int signup(Alumni_Bo ab)
	  {
		  int status=0;
		  try
		  {
			  Connection con=Alumni_Dao.getConnection();
			  
				String sql="insert into signup(name,email,number,password) values (?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setString(1, ab.getName());
				ps.setString(2, ab.getEmail());
				ps.setString(3, ab.getNumber());
				ps.setString(4, ab.getPassword());
			  
				
				status=ps.executeUpdate();
				
		  }
		  catch (Exception e) {
			
			  System.out.println(e);
		}
		  
		  
		return status;  
	  }
	  
	  
	  
	  public static boolean adminlogin(String email , String pass) {
			
			boolean status=false;
			
			try {
				
				 Connection con=Alumni_Dao.getConnection();
	             String sql="select * from signup where email = ? and password = ? ";
	             
	             PreparedStatement ps=con.prepareStatement(sql);
	             
	             
	             ps.setString(1, email);
	             ps.setString(2, pass);
	             
	             
	             ResultSet rs= ps.executeQuery();
	             
	             status =rs.next();
				
			} catch (Exception e)
			{
				
	            System.out.println(e);
	                   
			}
			
			return status;
			
			
		}
	  
	  
	  public static int addAlumni(Dil_Alumni_Bo ob) {
			
			int status=0;
			
			try {
				
				Connection con=Alumni_Dao.getConnection();
				
				String q="insert into alumni_data(Reg_No,Name,Email,Mob,Aadhar,Stream,Course,Join_year,Passout_year,Profession,Gender) values (?,?,?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement ps= con.prepareStatement(q);
				
				
				ps.setString(1, ob.getReg_no());
				ps.setString(2, ob.getName());
				ps.setString(3, ob.getEmail());
				ps.setString(4, ob.getMob());
				ps.setString(5, ob.getAadhar());
				ps.setString(6, ob.getStream());
				ps.setString(7, ob.getCourse());
				ps.setString(8, ob.getJoin_year());
				ps.setString(9, ob.getPassout_year());
				ps.setString(10, ob.getProfession());
				ps.setString(11, ob.getGender());
				
				
				status=ps.executeUpdate();
				
			
				
			} catch (Exception  e) {

	              System.out.println(e);
	              
			}
			
			return status;
		}
		
	  
	  public static List getAllAlumni()
	  {
		  List <Dil_Alumni_Bo>list=new ArrayList<Dil_Alumni_Bo>();
		 
		  try {
			
			  Connection con=Alumni_Dao.getConnection();
			  
			  String query="select * from alumni_data";
		  
			  PreparedStatement ps=con.prepareStatement(query);
			  
			  ResultSet rs=ps.executeQuery();
			  
			  while(rs.next())
			  {
				 Dil_Alumni_Bo ob=new Dil_Alumni_Bo();
				 
				 ob.setID(rs.getInt(1));
				 ob.setReg_no(rs.getString(2));
				 ob.setName(rs.getString(3));
				 ob.setEmail(rs.getString(4));
				 ob.setMob(rs.getString(5));
				 ob.setAadhar(rs.getString(6));
				 ob.setStream(rs.getString(7));
				 ob.setCourse(rs.getString(8));
				 ob.setJoin_year(rs.getString(9));
				 ob.setPassout_year(rs.getString(10));
				 ob.setProfession(rs.getString(11));
				 ob.setGender(rs.getString(12));
				 
				 
				 list.add(ob);
			  }
		  
		  
		  
		  } catch (Exception e) 
		  {
			System.out.println(e);
		}
		  
		  
		  
		return list;
		  
	  }
	  
	  public static List getAllEmployee() 
		{
			List <Dil_Alumni_Bo> list=new ArrayList<Dil_Alumni_Bo>();
			
			try {
				
				Connection con=Alumni_Dao.getConnection();
				
				String query="select * from alumni_data";
				
				PreparedStatement ps=con.prepareStatement(query);
				
				ResultSet rs= ps.executeQuery();
				
				while(rs.next())
				{
					
					Dil_Alumni_Bo eb=new Dil_Alumni_Bo();
					
					eb.setID(rs.getInt(1));
					eb.setReg_no(rs.getString(2));
					eb.setName(rs.getString(3));
					eb.setEmail(rs.getString(4));
					eb.setMob(rs.getString(5));
					eb.setAadhar(rs.getString(6));
					eb.setStream(rs.getString(7));
					eb.setCourse(rs.getString(8));
					eb.setJoin_year(rs.getString(9));
					eb.setPassout_year(rs.getString(10));
					eb.setProfession(rs.getString(11));
					eb.setGender(rs.getString(12));
					
					list.add(eb);
				}
			} catch (Exception e) {
				 System.out.println(e);
			}
		
			return list;
		}
	  
	  public static Dil_Alumni_Bo getEmployeeById(int eid)
		{
		  Dil_Alumni_Bo eb= new Dil_Alumni_Bo();
			
			try
			{
				Connection con=Alumni_Dao.getConnection();
				
				String sql="select * from alumni_data where id=?";
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setInt(1, eid);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					eb.setID(rs.getInt(1));
					eb.setReg_no(rs.getString(2));
					eb.setName(rs.getString(3));
					eb.setEmail(rs.getString(4));
					eb.setMob(rs.getString(5));
					eb.setAadhar(rs.getString(6));
					eb.setStream(rs.getString(7));
					eb.setCourse(rs.getString(8));
					eb.setJoin_year(rs.getString(9));
					eb.setPassout_year(rs.getString(10));
					eb.setProfession(rs.getString(11));
					eb.setGender(rs.getString(12));
					
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return eb;
			
		}
	  
	  public static int update(Dil_Alumni_Bo ab)
		{
			int status=0;
			
				Connection con=Alumni_Dao.getConnection();
				
				String sql="update alumni_data set Reg_No=?,Name=?,Email=?,Mob=?,Aadhar=?,Stream=?,Course=?,Join_year=?,Passout_year=?,Profession=?, Gender =? where id=?";
				try
				{
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setString(1, ab.getReg_no());
				ps.setString(2, ab.getName());
				ps.setString(3, ab.getEmail());
				ps.setString(4, ab.getMob());
				ps.setString(5, ab.getAadhar());
				ps.setString(6, ab.getStream());
				ps.setString(7, ab.getCourse());
				ps.setString(8, ab.getJoin_year());
				ps.setString(9, ab.getPassout_year());
				ps.setString(10, ab.getProfession());
				ps.setString(11, ab.getGender());
				ps.setInt(12, ab.getID());
				
				status=ps.executeUpdate();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			return status;
		}
		
		
		public static int delete(int id)
		{
			int status=0;
			
			 try {
					
				  Connection con=Alumni_Dao.getConnection();
				  String query="Delete from alumni_data where id=?";
				  PreparedStatement ps=con.prepareStatement(query);
				  ps.setInt(1, id);
				  status=ps.executeUpdate();
				  
			} catch (Exception e) {
			
				   System.out.println(e);
			}
			
			return status;
		}

	  
	  
		
		
	  
	  
	
	
	
}
