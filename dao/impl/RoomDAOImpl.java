package com.knmodi.HostelManagementSystem.dao.impl;

//import java.util.ArrayList; 

import com.knmodi.HostelManagementSystem.dao.RoomDAO;    
import com.knmodi.HostelManagementSystem.model.Room;
//import com.knmodi.HostelManagementSystem.model.Student;

import java.sql.*;
import java.util.ArrayList;

import com.knmodi.HostelManagementSystem.util.*;

public class RoomDAOImpl implements RoomDAO
{

	@Override
	public int save(Room roomdata) 
	{
		int insertedRows = 0;
		try(Connection con =DataBaseUtil.establishConnection())
		{
	
			String sql =
					"INSERT INTO room (room_id, room_no, capacity, occupied) "
					+ "VALUES (?,?,?,?)";

					PreparedStatement ps = con.prepareStatement(sql);

					ps.setInt(1, roomdata.getRoom_id());
					ps.setString(2, roomdata.getRoom_no());
					ps.setInt(3, roomdata.getCapacity());
					ps.setInt(4, roomdata.getOccupied());
		

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
	
	public void delete (int room_id)
	{
		try(Connection con =DataBaseUtil.establishConnection())
		{
			//to create reference of preparedStatement interface
			PreparedStatement stmt = con.prepareStatement("delete from room where room_id = ?");
			//setting query parameters
			stmt.setInt(1, room_id);

		
			
			stmt.executeUpdate();
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
	}
	
	
	
	public ArrayList<Room> findAll() {
		//defining an arraylist
		ArrayList<Room> RoomList = new ArrayList<>();
		try(Connection con = DataBaseUtil.establishConnection())
		{
			//create statement
			Statement stmt = con.createStatement();
			//query to select data from table
			String sqlQuery = "Select room_id,"
					+"room_no,capacity,"
					+"occupied from room";
			//to execute the select query
			ResultSet result = stmt.executeQuery(sqlQuery);
			//Creating object of Course
			Room room;
			//fetching data
			while(result.next())
			{
				room = new Room();
				//setting course data
				room.setRoom_id(result.getInt(1));
				room.setRoom_no(result.getString(2));
	
				room.setCapacity(result.getInt(3));

				room.setOccupied(result.getInt(4));
				
				//inserting course into arraylist
				RoomList.add(room);
			}				
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		
		return RoomList;
	}
	
	public ArrayList<Room> findOne(int room_id){
		//defining an arraylist
		ArrayList<Room> RoomList = new ArrayList<>();
		try(Connection con = DataBaseUtil.establishConnection())
		{

			String sqlQuery = "Select room_id,"
					+"room_no,capacity,"
					+"occupied from room where room_id= ?";
			
			   PreparedStatement pstmt = con.prepareStatement(sqlQuery);
		        pstmt.setInt(1, room_id);

			ResultSet result1 = pstmt.executeQuery();
			//Creating object of Course
			Room room;
			//fetching data
			while(result1.next())
			{
				room = new Room();
				//setting course data
				room.setRoom_id(result1.getInt(1));
				room.setRoom_no(result1.getString(2));
	
				room.setCapacity(result1.getInt(3));

				room.setOccupied(result1.getInt(4));
				
				//inserting course into arraylist
				RoomList.add(room);
			}				
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		
		return RoomList;
	}




	
}
