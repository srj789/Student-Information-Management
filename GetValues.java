package projectRAT;

import java.sql.ResultSet;
import java.util.Vector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.EscapeTokenizer;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class GetValues
{
	public static Vector<Vector<String>> records;
	public static Vector<String> header;
	public static Vector<String> getcourse()
	{
		Vector<String> v=new Vector<>();
	try
	{
		String query="select * from course order by name";
		PreparedStatement ps=(PreparedStatement) DBInfo.con.prepareStatement(query);
		ResultSet res=ps.executeQuery();
		while(res.next())
		{
			String course=res.getString(2);
			v.add(course);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	System.out.println(v);
	return v;
	}
	public static Vector<String> getBranch()
	{
		Vector<String> v=new Vector<>();
	try
	{
		String query="select * from branch order by name";
		PreparedStatement ps=(PreparedStatement) DBInfo.con.prepareStatement(query);
		ResultSet res=ps.executeQuery();
		while(res.next())
		{
			String branch=res.getString(2);
			v.add(branch);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	System.out.println(v);
	return v;
	}
	public static void getStudents()
	{
		records=new Vector<>();
		header=new Vector<>();
		String query="select * from student_registration";
		Connection con=(Connection) DBInfo.con;
		try
		{
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=(ResultSetMetaData) res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)

			{
				header.add(rsmd.getColumnName(i));
			}
			while(res.next())
				{
				Vector<String> v=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					v.add(res.getString(i));
				}
				records.add(v);
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void getNotices()
	{
		records=new Vector<>();
		header=new Vector<>();
		String query="select * from notice";
		Connection con=(Connection) DBInfo.con;
		try
		{
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=(ResultSetMetaData) res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)

			{
				header.add(rsmd.getColumnName(i));
			}
			while(res.next())
				{
				Vector<String> v=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					v.add(res.getString(i));
				}
				records.add(v);
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
