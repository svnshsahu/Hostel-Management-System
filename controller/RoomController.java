package com.knmodi.HostelManagementSystem.controller;

import java.util.Scanner;    
import com.knmodi.HostelManagementSystem.model.Room;   
import com.knmodi.HostelManagementSystem.service.RoomService;
import com.knmodi.HostelManagementSystem.service.impl.RoomServiceImpl;

public class RoomController{
	
	
		private RoomService RoomService;
		
		//constructor
		public RoomController() 
		{
			//to initialize service
			RoomService = new RoomServiceImpl();
		}
		//user interface for registration of new course
		public void registerRoomUI()
		{
			Scanner sc = new Scanner(System.in);
			//input of course id
			System.out.print("Enter room id: (e.g, 44567 )");
			int room_id = sc.nextInt();
			sc.nextLine(); // consume newline
			
			System.out.print("Enter room number : ");
			String room_no = sc.nextLine();
			
			System.out.print("Enter capacity (e.g, 44567 )");
			int capacity = sc.nextInt();
			sc.nextLine(); // consume newline
			
			System.out.print("Enter occupied: (e.g, 44567 )");
			int occupied = sc.nextInt();
			sc.nextLine(); // consume newline
			
			RoomService.registerRoom(new Room(room_id,room_no, capacity,occupied));

		}
		

		public void showRoom() {
			RoomService.showRoom();
		}
		public void showRo()
		{
			System.out.println("Enter room id to be accesssed");
			Scanner sc = new Scanner(System.in);
			int r_id = sc.nextInt();
			RoomService.showRoomId(r_id);
		}
	}

