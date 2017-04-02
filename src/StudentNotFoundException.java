 /* 
  * File name: StudentNotFoundException.java
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

/**
 * Exception for a student not being found
 * 
 * @author Christopher Runyan
 */
@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception {
	public StudentNotFoundException(){
		super("Linked list is empty.");
	}
	public StudentNotFoundException(String message){
		super(message);
	}
}
