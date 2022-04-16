package phase2;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assessment {
	public static final String DB_URL="jdbc:mysql://localhost:3306/db1";
	//DBURL-oracle-     jdbc:oracle:thin:@localhost:1521:xe
	public static final String USERNAME="root";
	public static final String PASSWORD="Ajith@1036";
	public static Connection con=null;
	
public static void main(String[] args) throws ClassNotFoundException, SQLException {	
	//register the vendor driver
	Class.forName("com.mysql.jdbc.Driver");

//establish the connection
	Connection con=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
	if(con!=null){
		System.out.println("CONNECTION IS ESTABLISHED");
	}
	else {
		System.out.println("check the details of the connection");
	}


//create a statement ->1.Statement    2.PreparedStatement
  Statement st= con.createStatement();
  
  Scanner s = new Scanner(System.in);
  while(true) {
  System.out.println("Select the operation: 1.insert  2.select  3.update  4.delete  5.exit");
   int operation = s.nextInt();
   switch (operation) {
   case 1:
	   String sql="insert into students values(7,'vignesh',25,'eee')";
	   int row = st.executeUpdate(sql);
	   if(row>0) {
	 	  System.out.println("Insertion is successfull");
	   }
	   else {
	 	  System.out.println("Not inserted");
	   }
	   
	  
	   break;
   case 2:
	   String sql1="select * from marks";
		ResultSet rs=st.executeQuery(sql1);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+ rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "+rs.getString(7));
		}
				
		
			break;
   case 3:
	   String sql2 = "update students set sage=28 where sid=1 ";
	     int num = st.executeUpdate(sql2);
          if(num>0){
			System.out.println("Successfully updated");
		}
          else {
          	System.out.println("Not updated");
          }		
		
		break;
   case 4:
	   String sql3="delete from students where sid=7";
	   int del =st.executeUpdate(sql3);
	   
	   if(del>0) {
	 	   System.out.println("successfully deleted");
	    }
	   else {
	 	  System.out.println("Failed");
	   }
	
	  break;
   case 5:
	  System.exit(0);
	default:
		System.out.println("select the correct option");
   }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}

}
}
