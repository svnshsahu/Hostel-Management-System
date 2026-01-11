package com.knmodi.HostelManagementSystem.controller;

import java.util.Scanner;      
import com.knmodi.HostelManagementSystem.model.Fees;

import com.knmodi.HostelManagementSystem.service.FeesService;

import com.knmodi.HostelManagementSystem.service.impl.FeesServiceImpl;


public class FeesController{
	
	
	private FeesService FeesService;
	
	//constructor
	public FeesController() 
	{
		//to initialize service
		FeesService = new FeesServiceImpl();
	}
	//user interface for registration of new course
	public void registerFeesUI()
	{
		Scanner sc = new Scanner(System.in);
		//input of course id
		System.out.print("Enter fees id: (e.g, 44567 )");
		int fees_id = sc.nextInt();
		sc.nextLine(); // consume newline
		
		System.out.print("Enter student id : ");
		int student_id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter amount paid");
		int amount_paid = sc.nextInt();
		sc.nextLine(); // consume newline
		
		System.out.print("Enter amount left:");
		int amount_left = sc.nextInt();
		sc.nextLine(); // consume newline
		
		System.out.println("Enter  Status: (e.g., Successful/Failed )");
		String status = sc.nextLine();
		
		System.out.println("Enter date paid");
		String date_paid=sc.nextLine();
		
		System.out.println("Enter receipt no.");
		String receipt = sc.nextLine();
		
		FeesService.registerFees(new Fees(fees_id,student_id,amount_paid,amount_left,status,date_paid,receipt));

	}
	public void showFees()
	{
		FeesService.showFees();
	}
	
	public void showFeesOne()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student id to get info");
		int temp = sc.nextInt();
		FeesService.showFeesOne(temp);
	}
	
	
}
