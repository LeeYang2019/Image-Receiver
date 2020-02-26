///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (CacheImageApp.java)
// File:             (PacketLinkedList.java)
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
// Persons:          N/A
//
// Online sources:   N/A
//                   
//////////////////////////// 80 columns wide //////////////////////////////////

import java.awt.List;

/**
 * A Single-linked linkedlist with a "dumb" header node (no data in the node),
 * but without a tail node. It implements ListADT&lt;E&gt; and returns
 * PacketLinkedListIterator when requiring a iterator.
 * 
 * @author honghui
 */
public class PacketLinkedList<E> implements ListADT<E> {

	private Listnode<E> head;  // pointer to the head of the listnode
	private PacketLinkedListIterator<E> itr; //iterator
	private int numItem; //num of nodes

	/**
	 * Constructs a empty PacketLinkedList
	 * 
	 */
	public PacketLinkedList() 
	{	
		this.head = new Listnode<E>(null); // create a new Listnode
		this.itr = new PacketLinkedListIterator<E>(head);  // create iterator for the PacketLinkList
		this.numItem = 0; //keeps track of the number of nodes added
	}

	/**
	 * Adds item to the end of the List.
	 * 
	 * @param item
	 */
	@Override
	public void add(E item) 
	{
		if(item == null){
			throw new NullPointerException();
		}
		
		//new listnode curr to reference head, curr begins at position -1 at
		//header node
		Listnode<E> curr = head;
		
		//while the position at pos 0 is not null, increment curr
		while (curr.getNext() != null) 
		{
			curr = curr.getNext();
		}

		//set a new listnode 
		curr.setNext(new Listnode<E>(item));

		numItem++;
	}

	/**
	 * Adds item at position pos in the List, moving the items originally in 
	 * positions pos through size() - 1 one place to the right to make room.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(int pos, E item) {
		
		if (pos < 0 || pos > numItem) {
			throw new IndexOutOfBoundsException();
		}
		
		
		if (pos == numItem) {
			add(item);
			return;
		}

		//local variables
		Listnode<E> curr = head; //a reference to head
		Listnode<E> tmp = new Listnode(item); // new listnode

		int counter = 0;
		
		while (counter <= pos - 1) {
			curr = curr.getNext();
			counter++;
		}
		
		tmp.setNext(curr.getNext());
		curr.setNext(tmp);
		numItem++;
	}

	/**
	 * Returns true iff item is in the List 
	 * 
	 * (i.e., there is an item x in the List such that x.equals(item))
	 * 
	 */
	@Override
	public boolean contains(E item) {
		//new listnode curr to reference head, curr starts at pos 0 after the 
		//header node
		Listnode<E> curr = head.getNext();

		while (curr != null) {
			if (curr.getData().equals(item)) {
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}

	/**
	 * Returns the item at position pos in the List.
	 * 
	 */
	@Override
	public E get(int pos) {
		Listnode<E> curr = head.getNext();
		
		int position = 0;
		
		//while pos is equal to or less than pos -1 and curr is not null
		while (position <= pos - 1 && curr != null) {
			//curr and pos are incremented
			curr = curr.getNext();
			position++;
		}

		//the data of curr is returned
		return curr.getData();
	}

	/**
	 * Returns true iff the List is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		// if the next node is null
		return head.getNext() == null;
	}

	/**
	 * Removes and returns the item at position pos in the List, moving the 
	 * items originally in positions pos+1 through size() - 1 one place to the 
	 * left to fill in the gap.
	 * 
	 */
	@Override
	public E remove(int pos) {
		//local variables
		Listnode<E> curr = head; //reference to head
		Listnode<E> temp = null; //temp listnode that stores item being removed
 
		while (curr.getNext() != null) {
			//if an item at pos x is the same as the item at curr.getNext()
			
			if (get(pos).equals(curr.getNext().getData())) {
				//stores item being removed
				temp = curr.getNext();
				
				//removes item
				curr.setNext(curr.getNext().getNext());
				
				numItem--;
				break;
			} else {
				//increment curr
				curr = curr.getNext();
			}
		}
		
		//return item being removed
		return temp.getData();
	}

	/**
	 * Returns the number of items in the List.
	 * 
	 */
	@Override
	public int size() {
		//return the num of nodes 
		return numItem;
	}

	@Override
	public PacketLinkedListIterator<E> iterator() {	
		//return a new iterator
		return new PacketLinkedListIterator<E>(head);
	}

}
