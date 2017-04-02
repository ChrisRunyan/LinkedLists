 /* 
  * File name: CourseSingleLinkedList.java
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
 * Manages a single linked list for course objects
 * 
 * @author Christopher Runyan
 */
public class CourseSingleLinkedList{
	private Node head;
	private int size;
	
	/**
	 * Returns the size of the single linked list
	 * 
	 * @return the size of the single linked list
	 */
	public int returnSize(){
		return size;
	}
	
	/**
	 * Accepts a course object and adds it to the beginning of the single linked list
	 * 
	 * @param course the course object to add to the beginning of the single list
	 */
	public void addFirst(Course course){
		if(head!=null){
			head=new Node(course, head);
		}
		else{
			head=new Node(course, null);
		}
		size++;
	}
	
	/**
	 * Accepts a course object and adds it to the end of the single linked list
	 * 
	 * @param course the course object to add to the end of the single list
	 */
	public void addLast(Course course) {
		Node curr=head;
		
		if(head!=null){
			while(curr.next!=null){
				curr=curr.next;
			}
			curr.next=new Node(course, null);
			size++;
		}
		else{
			addFirst(course);
		}
	}
	
	/**
	 * Prints the contents of the lsit 
	 * 
	 * @throws EmptyLinkedListException throw if the list is empty
	 */
	public void printList() throws EmptyLinkedListException{
		Node curr=head;
		
		if(head!=null){
			while(curr!=null){
				System.out.printf("%5d", curr.course.getCourseID());
				System.out.println(" "+curr.course.getCourseName());
				curr=curr.next;
			}
		}
		else{
			throw new EmptyLinkedListException();
		}
	}
	
	//Overrides the default toString method to a formatted output
	@Override
	public String toString(){
		Node curr=head;
		String output="";
		
		while(curr!=null){
			output+= curr.course.getCourseID()+" "+curr.course.getCourseName()+"\n";
			curr=curr.next;
		}
		
		return output;
	}
	
	/**
	 * Node for a single linked list with a course object for date
	 * 
	 * @author Christopher Runyan 
	 */
	private class Node{
		private Course course;
		private Node next;
		
		public Node(Course course){
			this.course=course;
			next=null;
		}
		
		public Node(Course course, Node next){
			this.course=course;
			this.next=next;
		}
	}
}
