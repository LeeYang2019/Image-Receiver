///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (CacheImageApp.java)
// File:             (SingleImageReceiver.java)
// Semester:         (Introduction to Data Structures) Fall 2016
//
// Author:           (Nhialee Yang nyang5@wisc.edu)
// CS Login:         (nhialee)
// Lecturer's Name:  (Alexander Brooks)
// Lab Section:      (N/A)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     (Yia Xiong)
// Email:            (yxiong58@wisc.edu)
// CS Login:         (yia)
// Lecturer's Name:  (Alexander Brooks)
// Lab Section:      (N/A)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * The internal node structure of {@link PacketLinkedList}.
 *
 * @param <E>
 *            the generic type of the data content stored in the list
 * 
 * @author honghui
 */
public class Listnode<E> {
	private E data; // data to be stored
	private Listnode<E> next; // connnection to next node

	/**
	 * Constructs a new list nodes with no links to neighboring nodes.
	 * 
	 * @param data
	 *            the data to be stored in this node
	 */
	Listnode(E data) {
		this(data, null);
	}

	/**
	 * Constructs a new list node with links to neighboring nodes.
	 * 
	 * @param data
	 *            the data to be stored in this node
	 * @param next
	 *            the node after this one
	 */
	Listnode(E data, Listnode<E> next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * Returns the current data.
	 * 
	 * @return the current data
	 */
	E getData() {
		return data;
	}

	/**
	 * Returns the current next node.
	 * 
	 * @return the current next node
	 */
	Listnode<E> getNext() {
		return next;
	}

	/**
	 * Sets the data to the given new value.
	 * 
	 * @param data
	 *            the new data
	 */
	void setData(E data) {
		this.data = data;
	}

	/**
	 * Sets the next node to the given new value.
	 * 
	 * @param next
	 *            the new next node
	 */
	void setNext(Listnode<E> next) {
		this.next = next;
	}
}
