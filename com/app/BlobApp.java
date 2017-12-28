import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
package com.app;

import java.sql.Statement;

public class BlobApp {

	public static void main(String[] args) throws Exception  
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		File f=new File("C:\\Users\\preesneh\\Pictures\\Capture1.PNG");
		FileInputStream fin=new FileInputStream(f);
			String sql="insert into blob values(?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, 22);
		pst.setBinaryStream(2, fin, f.length());
		pst.executeUpdate();
		System.out.println("\n\t==ID and Image Inserted Succeessfully==");
		
		String sql1="select * from blob";
		Statement st=con.createStatement();
		ResultSet	rs=st.executeQuery(sql1);
		System.out.println("\n\n\t ID \t Image");
		System.out.println("\t================================================== ");
		while(rs.next())
		{
			System.out.print("\n\t"+rs.getInt(1)+"\t"+rs.getBlob(2));
		}
		System.out.println("\n\t=================================================== ");
	
		
		pst.close();
		con.close();
		
		System.out.print("\n\n------------END OF PROGRAMME------By Pratik-------\n");
		
		

	}

}
