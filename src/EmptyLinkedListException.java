 /* 
  * File name: EmptyLinkedListException.java
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
 * Exception for an empty linked list
 * 
 * @author Christopher Runyan
 */
@SuppressWarnings("serial")
public class EmptyLinkedListException extends Throwable{
	public EmptyLinkedListException(){
		super("Linked list is empty.");
	}
	public EmptyLinkedListException(String message){
		super(message);
	}
}
