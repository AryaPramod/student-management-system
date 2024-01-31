package com.sms.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Studentmanagementsystem {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Scanner s1=new Scanner(System.in);
		while(true) {
			intro();
			System.out.println("============================");
			System.out.println("Choose the operation");
			int o=s1.nextInt();
			switch (o) {
			case 1: 
				System.out.println("**************************");
				System.out.println("*     INSERT RECORD      *");
				System.out.println("**************************");
				insert();
				break;
			case 2:
				System.out.println("**************************");
				System.out.println("*      EDIT RECORD       *");
				System.out.println("**************************");
				edit();
				break;
			case 3:
				System.out.println("**************************");
				System.out.println("*     VIEW RECORD        *");
				System.out.println("**************************");
				view();
				break;
			case 4:
				System.out.println("**************************");
				System.out.println("*     DELETE RECORD      *");
				System.out.println("**************************");
				delete();
				break;
			case 5:
				System.out.println("**************************");
				System.out.println("*      EXIT RECORD       *");
				System.out.println("**************************");
				System.exit(0);
				break;
			default:
				System.out.println("invalid number");
				break;
			}
	}
	}
	public static void delete() throws SQLException {
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url, "root","root@1234");
		
		String q="DELETE FROM student_info WHERE (id =?);";
		PreparedStatement ps=con.prepareStatement(q);
		Scanner s=new Scanner(System.in);
		System.out.println("select ID to delete:");
		int id=s.nextInt();
		
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Rcord deleted successfully");
		
	}
	public static void edit() throws SQLException
	{
		String url3="jdbc:mysql://localhost:3306/sms_db";
		Connection con3=DriverManager.getConnection(url3, "root","root@1234");
	    String query="UPDATE student_info SET name = ?, std = ?, fname =?,mobile=? WHERE(id=?);";
		PreparedStatement ps =con3.prepareStatement(query);
		Scanner s=new Scanner(System.in);
		System.out.println("select the id to Edit:");
		int i=s.nextInt();
		System.out.println("Enter name");
		s.nextLine();
		String n=s.nextLine();
		System.out.println("Enter std");
		String c =s.nextLine();
		System.out.println("Enter  fname");
		String fn=s.nextLine();
		System.out.println("Enter mobile");
		String mob=s.nextLine();
		ps.setString(1, n);
		ps.setString(2, c);
		ps.setString(3,fn);
		ps.setString(4, mob);
		ps.setInt(5,i);
		ps.executeUpdate();
		System.out.println("Data updated sucessfully....");

			}
	public static void view() throws SQLException {
		String url1="jdbc:mysql://localhost:3306/sms_db";
		Connection con1=DriverManager.getConnection(url1, "root","root@1234");
Statement st=con1.createStatement();
		
		System.out.println("ID|NAme|std|father|mobile");
		ResultSet rs=st.executeQuery("select *from student_info");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getString(5));
			
		}
		
	}

	public static void insert() throws SQLException {
		Scanner s=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url, "root","root@1234");
		System.out.println("Enter ur name");
		String n=s.nextLine();
		System.out.println("Enter ur class");
		String c =s.nextLine();
		System.out.println("Enter ur father name");
		String f=s.nextLine();
		System.out.println("Enter ur mobile number");
		String m=s.nextLine();
		String query="insert into student_info(name,std,fname,mobile)"+"value(?,?,?,?)";
	
		PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,n);
		ps.setString(2,c);
		ps.setString(3,f);
		ps.setString(4,m);
		ps.executeUpdate();
		System.out.println("data inserted successfully");
		
	}
	
	public static void intro()
	{
		System.out.println("************************************");
		System.out.println("*        STUDENTS MODULE           *");
		System.out.println("************************************");
		System.out.println("\n 1. insert");
		System.out.println("2.edit");
		System.out.println("3.view");
		System.out.println("4.Delete");
		
	}

}
