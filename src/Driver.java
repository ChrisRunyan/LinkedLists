 /* 
  * File name: Driver.java
  * 
  * Programmer: Christopher Runyan
  * ULID: caruny1
  * 
  * Date: 3/24/2016
  * 
  * Class: IT 179
  * Lecture Section: 03
  * Lecture Instructor: Cathy Holbrook
  */
package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver method that reads names and classes from a text file and calls the appropriate methods to place the
 * names/classes in its corresponding linked list and displays the results to the user.
 * 
 * @author Christopher Runyan
 */
public class Driver{
	public static void main(String[] args){
		Scanner reader=null;
		StudentDoubleLinkedList studentList=new StudentDoubleLinkedList();
		Student student=null;
		int transactionCode;
		int studentID;
		int courseID;
		String firstName;
		String lastName;
		String courseName;
		
		try{
			reader=new Scanner(new File("Schedules.txt"));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}
		
		while(reader.hasNext()){
			transactionCode=reader.nextInt();
			studentID=reader.nextInt();
			
			if(transactionCode==1){
				firstName=reader.next();
				lastName=reader.next();
				student=new Student(studentID, firstName, lastName);
				studentList.addInOrder(student);
			}
			else{
				courseID=reader.nextInt();
				courseName=reader.next();
				
				try{
					student=studentList.returnStudent(studentID);
				} 
				catch(StudentNotFoundException e){
					e.printStackTrace();
					System.exit(1);
				}
				catch(EmptyLinkedListException e){
					e.printStackTrace();
					System.exit(1);
				}
				student.addClass(courseID, courseName);
			}
		}
		reader.close();
		System.out.println("Student List");
		try{
			studentList.printFromBeginning();
		}
		catch(EmptyLinkedListException e){
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("\n\nStudent List with Courses");
		try{
			studentList.printFromBeginningWithCourses();
		}
		catch(EmptyLinkedListException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
