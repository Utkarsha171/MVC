package com.LTI;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.LTI.Results;
import com.LTI.User;

public class UserDAO {
DatabaseConnector db = new DatabaseConnector();
	public User authenticateUser(User uinput)
	{
	    User uoutput=null;
		String email=uinput.getEmail();
		String emailD="";
		String password= uinput.getPassword();
		String passwordD="";
	
	try{
		String query="Select email,password from zuser where email='"+email+"'";
		ResultSet rs=db.getResultSet(query);
		
		if(rs.next())
		{
			emailD= rs.getString("email");
			
			passwordD= rs.getString("password");
			
		}
		
		if(email.equals(emailD)&& password.equals(passwordD)){
			uoutput=getUserByEmail(email);
			
		}
		else{
			uoutput=null;
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	finally{
		db.closeConnection();
		}
	
	return uoutput;
}
	
	
	public String addUser(User u)
	{
		String result="";
		try
		{
			String query="Insert into zuser values(?,?,?,?)";
			PreparedStatement pstmt= db.getPreparedStatement(query);
			pstmt.setInt(1, u.getId());
			pstmt.setString(2, u.getName());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getPassword());
			 int i= pstmt.executeUpdate();
			 if(i==1)
			 {
				 result= Results.SUCCESS;
			 }
			 else{
				 result= Results.FAILURE;
			 }
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			result= Results.PROBLEMS;
		}
		finally{
			db.closeConnection();
		}
		return result;
	}
	
	public String updateUser(User u)
	{
		String result="";
		
		try
		{
			String query="update zuser set name=?,email=?,password=? where id=?";;
			PreparedStatement pstmt=db.getPreparedStatement(query);
			pstmt.setInt(4,u.getId());
			pstmt.setString(1, u.getName());
			pstmt.setString(2,u.getEmail());
			pstmt.setString(3, u.getPassword());
			
			int i=pstmt.executeUpdate();
			
			if(i==1)
			{
				result=Results.SUCCESS;
			}
			else
			{
				result=Results.FAILURE;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=Results.PROBLEMS;
		}
		finally
		{
			db.closeConnection();
		}
		
		return result;
	}
	
	public String deleteUser(User u)
	{
		String result="";
		
		try
		{
			String query="delete from zuser where id=?";;
			PreparedStatement pstmt=db.getPreparedStatement(query);
			pstmt.setInt(1,u.getId());
			
			int i=pstmt.executeUpdate();
			
			if(i==1)
			{
				result=Results.SUCCESS;
			}
			else
			{
				result=Results.FAILURE;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=Results.PROBLEMS;
		}
		finally
		{
			db.closeConnection();
		}
		
		return result;
	}
	
	public User getUserByEmail(String email)
	{
		User uinput=null;
		
		try
		{
		    String query="select *from zuser where email='"+email+"'";
		    ResultSet rs=db.getResultSet(query);
		    if(rs.next())
		    {
		    	uinput=new User();
		    	uinput.setId(rs.getInt("id"));
		    	uinput.setName(rs.getString("name"));
		    	uinput.setEmail(rs.getString("email"));
		    	uinput.setPassword(rs.getString("password"));
		    	
		    	
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			db.closeConnection();
		}
		
		return uinput;
		
		
	}
	
	public User getUserById(int id)
	{
		User uinput=null;
		
		try
		{
		    String query="select *from zuser where email='"+id+"'";
		    ResultSet rs=db.getResultSet(query);
		    if(rs.next())
		    {
		    	uinput=new User();
		    	uinput.setId(rs.getInt("id"));
		    	uinput.setName(rs.getString("name"));
		    	uinput.setEmail(rs.getString("email"));
		    	uinput.setPassword(rs.getString("password"));
		    	
		    	
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			db.closeConnection();
		}
		
		return uinput;
		
		
	}
	
	public ArrayList<User> getAllUsers()
	{
		ArrayList<User> list=new ArrayList<>();
		
		
		try
		{
			String query="Select * from zuser";
			ResultSet rs=db.getResultSet(query);
			while(rs.next())
			{
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				
				list.add(u);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}
		finally
		{
			db.closeConnection();
		}
		
		return  list;
	}

	
	
}

