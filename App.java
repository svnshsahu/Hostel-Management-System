package com.knmodi.HostelManagementSystem;

//import java.sql.Connection;  
import java.util.Scanner;    

import com.knmodi.HostelManagementSystem.util.DataBaseUtil;
import com.knmodi.HostelManagementSystem.controller.StudentController;
import com.knmodi.HostelManagementSystem.controller.RoomController;
import com.knmodi.HostelManagementSystem.controller.FeesController;
import com.knmodi.HostelManagementSystem.controller.AttendanceController;
//import com.knmodi.college1.controller.CourseController;

public class App {
    public static void main(String[] args) {
        System.out.println("Hostel Management System Started...");


    	DataBaseUtil.createTables();
    	
    	Scanner scc = new Scanner (System.in);
    	
    	System.out.println("Choose one of the following role\n"
    					+ "1. Student \n"
    					+ "2. Warden");
    	int choice = scc.nextInt();
    	
    	switch(choice) {
    	case 1: 
    		Scanner x = new Scanner (System.in);
			int xyz  ;
    		do {
    		
    				System.out.println("Choose a module\n"
    						+ "1. Your Information\n"
    						+ "2. Your Room\n"
    						+ "3. Your Fees\n"
    						+ "4. Your Attendance\n"
    						+ "0. Exit " );
    			  				
    		
    				 xyz = x.nextInt();
    				switch(xyz) {
    				case 1:
    					new StudentController().showByStudId();
    				//access to just gain information about student
    				break;	
    				case 2:
    					new RoomController().showRo();
    				// access to just gain information about room
    				break;
    				case 3:
    					new FeesController().showFeesOne();
    				//access to fees info	
    				break;
    				case 4:
    					new AttendanceController().showAttendanceOne();
    				
    				
    				case 5 :
    					// insert visitors info
    				break;
    				case 6:
    					//get visitor of a student id
    				break;
    				
    				case 7:
    					//insert complaints
    				break;
    				case 8:
    					//get complaints of a student
    				break;	
    				case 0:
    					System.out.println("Exit System");
    				break;	
    				default:
    					System.out.println("Enter a valid choice");
    				
    				
    				}
    		}while(xyz!=0);	
    	break;
    	case 2 :
//    		new FacultyController().registerFacultyUI();
    		
    		Scanner y = new Scanner (System.in);
			int yz;
			
			do
			{
				System.out.println("Choose a module\n"
						+"-------------------   Room Methods  -------------------------\n"
						+ "1. Insert Room Information\n"
						+ "2. Read all room Information\n"
						+ "3. Read by room id\n"
						+ "----------------  Student Methods  --------------------------\n"
						+ "4. Insert Student Information (First insert room) \n"
						+ "5. Delete Student information \n"
						+ "6. Access all Student Information \n"
						+ "7. read by student id\n"
						+"------------------   Fees Methods  --------------------------\n"
						+ "8. Insert Fees Information \n"
						+ "9. Access all Fees Information\n"
						+ "10. About Student's Fees\n"
						+ "----------------- Attendance Methods ------------------------\n"
						+ "11. Insert Attendance Information\n"
						+ "12. Access All attendance information\n"
						+ "13. Access student's attendance\n"
						+ "----------------- Visitors Methods ---------------------------\n"
						+ "14. Get all visitors list\n"
						+ "15. Get specific students visitor\n"
						+ "----------------- Complaints Methods ------------------------\n"
						+ "16. Get all complaints\n"
						+ "17. Get specific stdudent's complaints\n"
						+"--------------------------------------------------------------\n"
						+ "0. Exit\n");
			  				
			
				yz = y.nextInt();
				switch(yz) {
				
				case 1:
					new RoomController().registerRoomUI();
				break;
				
				case 2:
					new RoomController().showRoom();
				break;
				
				case 3:
					new RoomController().showRo();
				break;	
				case 4:
		        	new StudentController().registerStudentUI();
	
		        break;
				case 5:
					new StudentController().deleteStudentUI();
		
				break;
				case 6:
					new StudentController().showStudent();

				break;
				case 7 :
					new StudentController().showByStudId();
				break;
				
				case 8:
					new FeesController().registerFeesUI();
				break;
				case 9:
					new FeesController().showFees();
				break;
				case 10:
					new FeesController().showFeesOne();
				break;
				
				case 11:
					new AttendanceController().registerAttendanceUI();
			 	break;
			 	
				case 12:
					new AttendanceController().showAttendance();
				break;
				case 13:
					new AttendanceController().showAttendanceOne();
				break;
				
				case 14:
					// visitor all information
				break;	
				case 15:
					// specific student's visitors
				break;
					
				case 16:
					// complaints all information
				break;	
				case 17:
					// specific student's complaints	
				break;
				
				case 0:
					System.out.println("System Closed");
				break;	
				default:
					System.out.println("Enter a valid choice");
				
				
				}
			}while(yz!=0);
			
    	break;
    	default:
    		System.out.println("Ronit ki mkc");
    	}
    	
    	
    	
}
    }
