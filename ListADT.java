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
 * A List is a general container storing a contiguous collection of items,
 * that is position-oriented using zero-based indexing and where duplicates
 * are allowed. ListADT extends the Iterable interface so that Lists can
 * be used with for-each loops.
 * 
 * @author honghui
 */
import java.lang.Iterable;

public interface ListADT<E> extends Iterable<E> {

	/**
	 * Adds item to the end of the List.
	 * 
	 * @param item
	 *            the item to add
	 * @throws IllegalArgumentException
	 *             if item is null
	 */
	void add(E item);

	/**
	 * Adds item at position pos in the List, moving the items originally in
	 * positions pos through size() - 1 one place to the right to make room.
	 * 
	 * @param pos
	 *            the position at which to add the item
	 * @param item
	 *            the item to add
	 * @throws IllegalArgumentException
	 *             if item is null
	 * @throws IndexOutOfBoundsException
	 *             if pos is less than 0 or greater than size(), please check
	 *             this exception before IllegalArgumentException.
	 */
	void add(int pos, E item);

	/**
	 * Returns true iff item is in the List (i.e., there is an item x in the
	 * List such that x.equals(item))
	 * 
	 * @param item
	 *            the item to check
	 * @return true if item is in the List, false otherwise
	 */
	boolean contains(E item);

	/**
	 * Returns the item at position pos in the List.
	 * 
	 * @param pos
	 *            the position of the item to return
	 * @return the item at position pos
	 * @throws IndexOutOfBoundsException
	 *             if pos is less than 0 or greater than or equal to size()
	 */
	E get(int pos);

	/**
	 * Returns true iff the List is empty.
	 * 
	 * @return true if the List is empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Removes and returns the item at position pos in the List, moving the
	 * items originally in positions pos+1 through size() - 1 one place to the
	 * left to fill in the gap.
	 * 
	 * @param pos
	 *            the position at which to remove the item
	 * @return the item at position pos
	 * @throws IndexOutOfBoundsException
	 *             if pos is less than 0 or greater than or equal to size()
	 */
	E remove(int pos);

	/**
	 * Returns the number of items in the List.
	 * 
	 * @return the number of items in the List
	 */
	int size();
}
