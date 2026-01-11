package com.knmodi.HostelManagementSystem.dao.impl;

import java.util.ArrayList; 

import com.knmodi.HostelManagementSystem.dao.StudentDAO;    
import com.knmodi.HostelManagementSystem.model.Student;
import java.sql.*;


import com.knmodi.HostelManagementSystem.util.*;
//import com.knmodi.college1.model.Course;
//import com.knmodi.college1.util.DataBaseUtil;
/*---------------------------------------------------
 * ------- Structure Of the Course ---------
 * table : course
 * --------------------------------------
 * fields - data type - 
 * courseid - varchar(30) - primary key
 * coursename - varchar(300) - not null 				Student studentData = new Student();
 * description - varchar(1000) - not null
 * duration - int - not null
 * min_enrollment - int - not null 
 * max_enrollment - int  - not null
 * */
public class StudentDAOImpl implements StudentDAO
{

	@Override
	public int save(Student studentdata) 
	{
		int insertedRows = 0;
		try(Connection con =DataBaseUtil.establishConnection())
		{
	
			String sql =
					"INSERT INTO student (student_id, student_name, gender, contact, address, room_id, admission_date, status, hostel_id) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";

					PreparedStatement ps = con.prepareStatement(sql);

					ps.setInt(1, studentdata.getStudentId());
					ps.setString(2, studentdata.getStudentname());
					ps.setString(3, studentdata.getGender());
					ps.setString(4, studentdata.getContact());
					ps.setString(5, studentdata.getAddress());
					ps.setInt(6, studentdata.getRoomid());
					ps.setString(7, studentdata.getAdmissiondate());
					ps.setString(8, studentdata.getStatus());
					ps.setInt(9, studentdata.getHostelid());

			//to execute the query
			insertedRows = ps.executeUpdate();
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		// TODO Auto-generated method stub
		return insertedRows;
	}
	
	public void delete (int stud_id)
	{
		try(Connection con =DataBaseUtil.establishConnection())
		{
			//to create reference of preparedStatement interface
			PreparedStatement stmt1 = con.prepareStatement("delete from complaints where student_id = ?");
			//setting query parameters
			stmt1.setInt(1, stud_id);
			stmt1.executeUpdate();
			
			PreparedStatement stmt2 = con.prepareStatement("delete from visitors where student_id = ?");
			//setting query parameters
			stmt2.setInt(1, stud_id);
			stmt2.executeUpdate();
			
			PreparedStatement stmt3 = con.prepareStatement("delete from attendance where student_id = ?");
			//setting query parameters
			stmt3.setInt(1, stud_id);
			stmt3.executeUpdate();

			PreparedStatement stmt4 = con.prepareStatement("delete from fees where student_id = ?");
			//setting query parameters
			stmt4.setInt(1, stud_id);
			stmt4.executeUpdate();
			
			PreparedStatement stmt6 = con.prepareStatement("delete from student where student_id = ?");
			//setting query parameters
			stmt6.setInt(1, stud_id);
			stmt6.executeUpdate();
			
			
			int roomId = -1;

			// 1. Get room_id from student table
			PreparedStatement ps1 = con.prepareStatement(
			    "SELECT room_id FROM student WHERE student_id = ?"
			);
			ps1.setInt(1, stud_id);

			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
			    roomId = rs.getInt(1);
			}

			// 2. Delete that room using room_id
			if (roomId != -1) {
			    PreparedStatement ps2 = con.prepareStatement(
			        "DELETE FROM room WHERE room_id = ?"
			    );
			    ps2.setInt(1, roomId);
			    ps2.executeUpdate();
			}

			

		
			
			
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
	}
	
	public ArrayList<Student> findAll() {
		//defining an arraylist
		ArrayList<Student> StudentList = new ArrayList<>();
		try(Connection con = DataBaseUtil.establishConnection())
		{
			//create statement
			Statement stmt = con.createStatement();
			//query to select data from table
			String sqlQuery = "Select student_id,"
					+"student_name,gender,"
					+"contact,address,room_id,admission_date,status ,"
					+"hostel_id from student";
			//to execute the select query
			ResultSet result = stmt.executeQuery(sqlQuery);
			//Creating object of Course
			Student student;
			//fetching data
			while(result.next())
			{
				student = new Student();
				//setting course data
				student.setStudentId(result.getInt(1));
				student.setStudentname(result.getString(2));
				student.setGender(result.getString(3));
				student.setContact(result.getString(4));
				student.setAddress(result.getString(5));
				student.setRoomid(result.getInt(6));
				student.setAdmissiondate(result.getString(7));
				student.setStatus(result.getString(8));
				student.setHostelid(result.getInt(9));
				
				//inserting course into arraylist
				StudentList.add(student);
			}				
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		
		return StudentList;
	}
	
	public ArrayList<Student> findOne(  int stu_id )
	{
		//defining an arraylist
		ArrayList<Student> StudentList = new ArrayList<>();
		try(Connection con = DataBaseUtil.establishConnection())
		{
			//create statement
//			Statement stmt = con.createStatement();
			//query to select data from table
			String sqlQuery = "Select student_id,"
					+"student_name,gender,"
					+"contact,address,room_id,admission_date,status ,"
					+"hostel_id from student where student_id = ?";
			
	        PreparedStatement pstmt = con.prepareStatement(sqlQuery);
	        pstmt.setInt(1, stu_id);
			//to execute the select query
			ResultSet result = pstmt.executeQuery();
			//Creating object of Course
			Student student;
			//fetching data
			while(result.next())
			{
				student = new Student();
				//setting course data
				student.setStudentId(result.getInt(1));
				student.setStudentname(result.getString(2));
				student.setGender(result.getString(3));
				student.setContact(result.getString(4));
				student.setAddress(result.getString(5));
				student.setRoomid(result.getInt(6));
				student.setAdmissiondate(result.getString(7));
				student.setStatus(result.getString(8));
				student.setHostelid(result.getInt(9));
				
				//inserting course into arraylist
				StudentList.add(student);
			}				
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		
		return StudentList;
	}



	
}
