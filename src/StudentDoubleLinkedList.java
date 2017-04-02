 /* 
  * File name: StudentDoubleLinkedList.java
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
 * Holds a double linked list for student objects as well as the methods to manipulate it.
 * 
 * @author Christopher Runyan
 */
public class StudentDoubleLinkedList{
	private Node head;
	private Node tail;
	private int size;
	
	/**
	 * Returns the number of elements (nodes) of student objects in the double linked list
	 * 
	 * @return the number of student objects in the double linked list
	 */
	public int returnSize(){
		return size;
	}
	
	/**
	 * Accepts a student object as a parameter and adds the student object to the beginning of the double linked
	 * list
	 * 
	 * @param student student object being accepted to add to the beginning of the double linked list
	 */
	public void addFirst(Student student){
		if(head!=null){
			head.prev=new Node(student, null, head);
			head=head.prev;
		}
		else{
			head=new Node(student, null, head);
		}
		size++;
	}
	
	/**
	 * Accepts a student object as a parameter and adds the student object to the end of the double linked list
	 * 
	 * @param student student object being accepted to add to the end of the double linked list
	 */
	public void addLast(Student student){
		Node curr=head;
		
		if(head!=null){
			if(head.next!=null){
				while(curr.next!=null){
					curr=curr.next;
				}
				curr.next=new Node(student, curr, null);
				tail=curr.next;
			}
			else{
				head.next=new Node(student, head, null);
				tail=head.next;
			}
			size++;
		}
		else{
			addFirst(student);
		}
	}
	
	/**
	 * Accepts a student object as a parameter and places the student object in the double linked list based on
	 * alphabetical order by last name and then first name
	 * 
	 * @param student the student object being accepted to add into the double linked list
	 */
	public void addInOrder(Student student){
		Node curr=head;

		if(head==null){
			addFirst(student);
		}
		else if(head.next==null){
			if(student.compareTo(curr.student)>0){
				addLast(student);
			}
			else{
				addFirst(student);
			}
		}
		else{
			while(student.compareTo(curr.student)>0&&curr.next!=null){
				curr=curr.next;
			}
			if(curr.next==null){
				if(student.compareTo(curr.student)>0){
					addLast(student);
				}
				else{
					Node marker=curr;
					curr=head;
					while(curr.next!=marker){
						curr=curr.next;
					}
					curr.next=new Node(student, curr, marker);
					size++;
				}
				
			}
			else if(student.compareTo(curr.student)<0){
				if(curr==head){
					addFirst(student);
				}
				else{
					Node marker=curr;
					curr=head;
					while(curr.next!=marker){
						curr=curr.next;
					}
					curr.next=new Node(student, curr, marker);
					size++;
				}
			}
		}
	}
	
	/**
	 * Accepts a student ID and returns the student object corresponding to it
	 * 
	 * @param studentID the student ID being accepted of the student object to be returned
	 * @return the student object corresponding to an accepted student ID
	 * @throws EmptyLinkedListException throw if the linked list is empty
	 * @throws StudentNotFoundException throw if the linked list does not contain the student that the student ID
	 * corresponds with
	 */
	public Student returnStudent(int studentID) throws EmptyLinkedListException, StudentNotFoundException{
		Node curr=head;
		Student student=null;
		
		if(head!=null){
			while(curr.student.getStudentID()!=studentID&&curr!=null){
				curr=curr.next;
			}
			if(curr==null){
				throw new StudentNotFoundException();
			}
			else{
				student=curr.student;
			}
		}
		else{
			throw new EmptyLinkedListException();
		}
		
		return student;
	}
	
	/**
	 * Accepts information for a class to add as well as a student ID and adds the class to the student in the double
	 * linked list that corresponds with the student ID
	 * 
	 * @param studentID the student ID of the student having the class added
	 * @param courseID the unique identifier for the course
	 * @param courseName the name of the course
	 */
	public void addClassToStudent(int studentID, int courseID, String courseName){
		try {
			returnStudent(studentID).addClass(courseID, courseName);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (EmptyLinkedListException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Prints the double linked list from the beginning
	 * 
	 * @throws EmptyLinkedListException throw if the list is empty
	 */
	public void printFromBeginning()throws EmptyLinkedListException{
		Node curr=head;
		
		if(head!=null){
			while(curr!=null){
				System.out.println(curr.student.toString());
				curr=curr.next;
			}
		}
		else{
			throw new EmptyLinkedListException();
		}
	}
	
	/**
	 * Prints the double linked list from the end
	 * 
	 * @throws EmptyLinkedListException throw if the list is empty
	 */
	public void printFromEnd()throws EmptyLinkedListException{
		Node curr=tail;
		
		if(head!=null){
			while(curr!=null){
				System.out.println(curr.student.toString());
				curr=curr.prev;
			}
		}
		else{
			throw new EmptyLinkedListException();
		}
	}
	
	/**
	 * Prints the double linked list from the beginning with courses
	 * 
	 * @throws EmptyLinkedListException throw if the list is empty
	 */
	public void printFromBeginningWithCourses() throws EmptyLinkedListException{
		Node curr=head;
		
		if(head!=null){
			while(curr!=null){
				System.out.println(curr.student.toString());
				if(curr.student.getNumOfClasses()!=0){
					curr.student.printCourseList();
				}
				System.out.print("\n");
				curr=curr.next;
			}
		}
		else{
			throw new EmptyLinkedListException();
		}
	}
	
	/**
	 * Prints the double linked list from the end with courses
	 * 
	 * @throws EmptyLinkedListException throw if the list is empty
	 */
	public void printFromEndWithCourses() throws EmptyLinkedListException{
		Node curr=tail;
		
		if(head!=null){
			while(curr!=null){
				System.out.println(curr.student.toString());
				if(curr.student.getNumOfClasses()!=0){
					curr.student.printCourseList();
				}
				System.out.print("\n");
				curr=curr.prev;
			}
		}
		else{
			throw new EmptyLinkedListException();
		}
	}
	
	//overrides the default toString method to a formatted output
	@Override
	public String toString(){
		Node curr=head;
		String output="";
		
		while(curr!=null){
			output+=curr.student.toString()+"\n";
		}
		
		return output;
	}
	
	/**
	 * Inner class node for the student double linked list
	 * 
	 * @author Christopher Runyan
	 */
	private class Node{
		private Student student;
		private Node prev;
		private Node next;
		
		public Node(Student student){
			this.student=student;
			prev=null;
			next=null;
		}
		
		public Node(Student student, Node prev, Node next){
			this.student=student;
			this.prev=prev;
			this.next=next;
		}
	}
}
