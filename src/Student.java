 /* 
  * File name: Student.java
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
 * Holds information pertaining to a single student, including student ID, the student's first and last names,
 * and a linked list of courses the student is taking. Creates methods to modify all of these attributes as well
 * as display them.
 * 
 * @author Christopher Runyan
 */
public class Student{
	private int studentID;
	private String firstName;
	private String lastName;
	private CourseSingleLinkedList courseList;
	
	/**
	 * Default constructor
	 */
	public Student(){
		studentID=0;
		firstName=null;
		lastName=null;
		courseList=new CourseSingleLinkedList();
	}
	
	/**
	 * Constructor with parameters for student ID, the student's first name, and the student's last name
	 * 
	 * @param studentID the unique identifier for each student 
	 * @param firstName the first name of the student
	 * @param lastName the last name of the student
	 */
	public Student(int studentID, String firstName, String lastName){
		this.studentID=studentID;
		this.firstName=firstName;
		this.lastName=lastName;
		this.courseList=new CourseSingleLinkedList();
	}
	
	/**
	 * Getter for the student ID
	 * 
	 * @return instance variable studentID (the unique identifier for each student)
	 */
	public int getStudentID(){
		return studentID;
	}
	
	/**
	 * Getter for the student's first name
	 * 
	 * @return instance variable firstName (the first name of the student)
	 */
	public String getFirstName(){
		return firstName;
	}
	
	/**
	 * Getter for the student's last name
	 * 
	 * @return instance variable lastName (the last name of the student)
	 */
	public String getLastName(){
		return lastName;
	}
	
	/**
	 * Getter for the student's course list
	 * 
	 * @return the toString output for the single linked list of courses (CourseSingleLinkedList)
	 */
	public String getCourseList(){
		return courseList.toString();
	}
	
	/**
	 * Setter for the student ID
	 * 
	 * @param studentID instance variable studentID (the unique identifier for each student)
	 */
	public void setStudentID(int studentID){
		this.studentID=studentID;
	}
	
	/**
	 * Setter for the student's first name
	 * 
	 * @param firstName the first name of the student
	 */
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	
	/**
	 * Setter for the student's last name
	 * 
	 * @param lastName the last name of the student
	 */
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	
	/**
	 * Setter for the student's course list
	 * 
	 * @param courseList a CourseSingleLinkedList of courses corresponding to the student
	 */
	public void setCourseList(CourseSingleLinkedList courseList){
		this.courseList=courseList;
	}
	
	/**
	 * Adds a class to the student's CourseSingleLinkedList of courses
	 * 
	 * @param courseID the unique identifier for the course
	 * @param courseName the name of the course
	 */
	public void addClass(int courseID, String courseName){
		courseList.addLast(new Course(courseID, courseName));
	}
	
	/**
	 * Returns the number of classes the student has (the size of the CourseSingleLinkedList of courses)
	 * 
	 * @return the size of the CourseSingleLinkedList of courses
	 */
	public int getNumOfClasses(){
		return courseList.returnSize();
	}
	
	/**
	 * Prints the list of courses the student has 
	 */
	public void printCourseList(){
		try{
			courseList.printList();
		} catch (EmptyLinkedListException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Accepts a student object as a parameter to see if it is the same as the student object of the instance
	 * 
	 * @param student the student object accepted as a parameter
	 * @return true or false depending on if the student objects are the same or not
	 */
	public boolean equals(Student student){
		boolean equals=false;
		
		if(studentID==student.getStudentID()&&firstName.equals(student.getFirstName())
				&&lastName.equals(student.getLastName())&&courseList.equals(student.getCourseList())){
			equals=true;
		}
		
		return equals;
	}
	
	/**
	 * Accepts a student object as a parameter and returns its numeric value based on its position in the
	 * alphabet compared to the student object of the instance
	 * 
	 * @param student the student object accepted as a parameter
	 * @return a numeric value based on the position of the accepted student object in the alphabet compared to 
	 * the student object of the instance
	 */
	public int compareTo(Student student){
		if(lastName.compareTo(student.getLastName())==0){
			if(firstName.compareTo(student.getFirstName())==0){
				return 0;
			}
			else{
				return firstName.compareTo(student.getFirstName());		
			}
		}
		else{
			return lastName.compareTo(student.getLastName());
		}
	}
	
	//Overrides the default toString method to a formatted output
	@Override
	public String toString(){
		return studentID+" "+firstName+" "+lastName;
	}
}
