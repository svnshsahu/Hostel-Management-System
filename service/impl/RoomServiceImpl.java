package com.knmodi.HostelManagementSystem.service.impl;

import com.knmodi.HostelManagementSystem.dao.RoomDAO;        
import com.knmodi.HostelManagementSystem.dao.impl.RoomDAOImpl;
import com.knmodi.HostelManagementSystem.model.Room;
//import com.knmodi.HostelManagementSystem.model.Student;
import com.knmodi.HostelManagementSystem.service.RoomService;
import java.util.ArrayList;

//import java.util.*;

public class RoomServiceImpl implements RoomService
{
	private RoomDAO RoomDAO;
	
	//constructor 

	public RoomServiceImpl() {
		//to initialize DAO reference
		RoomDAO = new RoomDAOImpl();
	}
	
	
	public void registerRoom(Room room)
	{
		if(room== null) //verifying course object null
		{
			System.out.println("Room data is empty");
		}

		else
		{
			//calling save method()of dao to insert the course data into the table
			int rows = RoomDAO.save(room);
			if(rows > 0) // number of rows greater than 0 indicates successful insert operation
			{
				System.out.println("room Successfully Registered");
			}
			else
			{
				System.out.println("Unable to register the room");
			}
		}
		
	}
	
	public void deleteRoom (int room_id)
	{
		RoomDAO.delete(room_id);
		System.out.println("Information deleted");
	}
	
	public void showRoom()
	{
		ArrayList<Room> RoomList = RoomDAO.findAll();
		if(RoomList.size() > 0)
		{
			System.out.println(RoomList);
		}
		else
		{
			System.out.println("No student data found");
		}
	}
	
	public void showRoomId(int r_id)
	{
		ArrayList<Room> RoomList = RoomDAO.findOne(r_id);
		if(RoomList.size() > 0)
		{
			System.out.println(RoomList);
		}
		else
		{
			System.out.println("No student data found");
		}
	}



	
	
	
}