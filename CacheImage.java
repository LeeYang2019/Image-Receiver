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
 * The CacheImage structure which includes an image name and it corresponding
 * PacketLinkedList.
 *
 * @author honghui
 */

public class CacheImage<E> {
	private String imageName;
	private PacketLinkedList<E> list;

	/**
	 * Constructs a CacheImage with an image name and it corresponding
	 * PacketLinkedList.
	 * 
	 * @param imageName
	 *            the image name
	 * @param list
	 *            it corresponding PacketLinkedList
	 */
	public CacheImage(String imageName, PacketLinkedList<E> list) {
		this.imageName = imageName;
		this.list = list;
	}

	/**
	 * Returns the image name of the CacheImage
	 * 
	 * @return the image name of the CacheImage
	 */
	public String getImageName() {
		return imageName;
	}

	
	/**
	 * Returns the PacketLinkedList of the CacheImage
	 * 
	 * @return the PacketLinkedList of the CacheImage
	 */
	public PacketLinkedList<E> getPacketLinkedList() {
		return list;
	}
}
