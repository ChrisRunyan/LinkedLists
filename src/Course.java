 /* 
  * File name: Course.java
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
 * Holds information pertaining to a course, such as course ID and course name. Creates method to modify and return
 * information pertaining to a course.
 * 
 * @author Christopher Runyan
 */
public class Course{
	private int courseID;
	private String courseName;

	/**
	 * Default constructor
	 */
	public Course(){
		courseID=0;
		courseName=null;
	}
	
	/**
	 * Constructor with parameters for course id and course name
	 * 
	 * @param courseID the unique identifier for the course
	 * @param courseName the name of the course
	 */
	public Course(int courseID, String courseName){
		this.courseID=courseID;
		this.courseName=courseName;
	}
	
	/**
	 * Returns the course ID
	 * 
	 * @return the value of the instance variable courseID
	 */
	public int getCourseID(){
		return courseID;
	}
	
	/**
	 * Returns the course name
	 * 
	 * @return the value of the instance variable courseName
	 */
	public String getCourseName(){
		return courseName;
	}
	
	/**
	 * Setter for the course id
	 * 
	 * @param courseID the unique identifier for the course
	 */
	public void setCourseID(int courseID){
		this.courseID=courseID;
	}
	
	/**
	 * Setter for the course name
	 * 
	 * @param courseName the name of the course
	 */
	public void setCourseName(String courseName){
		this.courseName=courseName;
	}

	/**
	 * Accepts a course object as a parameter to see if it is the same as the course object of the instance
	 * 
	 * @param course the course object being accepted as a parameter
	 * @return true or false depending on if the course objects are the same or not
	 */
	public boolean equals(Course course){
		boolean equals=false;
		
		if(courseID==course.getCourseID()&&courseName.equals(course.getCourseName())){
			equals=true;
		}
		
		return equals;
	}
	
	//Overrides the default toString method to a formatted output
	@Override
	public String toString(){
		return courseID+" "+courseName;
	}
}
