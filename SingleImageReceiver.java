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

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This class simulates a receiver application for a single image by maintaining
 * an image buffer, which is a linked list of packets of the transmitted image
 * file. It collects packets from our InputDriver and reconstructs the image
 * file using a PacketLinkedList&lt;SimplePacket&gt; for the image buffer.
 * 
 * @author honghui
 */
public class SingleImageReceiver {
	private InputDriver input;
	private PacketLinkedList<SimplePacket> list;

	/**
	 * Constructs a Receiver to obtain the image file transmitted.
	 * 
	 * @param file
	 *            the filename you want to receive
	 * 
	 * @throws IOException
	 *             if fails to retrieve the file
	 */
	public SingleImageReceiver(String file) throws IOException 
	{
		input = new InputDriver(file);
		list = new PacketLinkedList<SimplePacket>();
	}

	/**
	 * Returns the PacketLinkedList buffer in the receiver
	 * 
	 * @return the PacketLinkedList object
	 */
	public PacketLinkedList<SimplePacket> getListBuffer() 
	{
		return list;
	}

	/**
	 * Asks for retransmitting the packet with a sequence number. The requested
	 * packet will arrive later by using {@link #askForNextPacket()}. Notice
	 * that ONLY missing packet will be retransmitted. Pass seq=0 if the missing
	 * packet is the "End of Streaming Notification" packet.
	 * 
	 * @param seq
	 *            the sequence number of the requested missing packet
	 * @return true if the requested packet is added in the receiving queue;
	 *         otherwise, false
	 */
	public boolean askForMissingPacket(int seq) {
		return input.resendMissingPacket(seq);
	}

	/**
	 * Returns true if the maintained list buffer has a valid image content.
	 * Notice that when it returns false.
	 * 
	 * @return true if the maintained list buffer has a valid image content;
	 *         otherwise, false
	 */
	public boolean validImageContent() {
		return input.validFile(list);
	}

	/**
	 * Returns the next packet.
	 * 
	 * @return the next SimplePacket object; returns null if no more packet to
	 *         receive
	 */
	public SimplePacket askForNextPacket() {
		return input.getNextPacket();
	}

	/**
	 * Outputs the formatted content in the PacketLinkedList buffer. See course
	 * webpage for the formatting detail.
	 * 
	 * @param list
	 *            the PacketLinkedList buffer
	 */
	public void displayList(PacketLinkedList<SimplePacket> list) {

		//local variables
		PacketLinkedListIterator<SimplePacket> itr = list.iterator();
		SimplePacket temp;

		String seq = "";
		int num = 0;

		//iterate through each item in the list and return the seq num, which
		//is concatenated
		while(itr.hasNext()) {
			temp = itr.next();
			num = temp.getSeq();

			seq += num + ", ";
		}
		
		System.out.println(seq);

	}

	/**
	 * Reconstructs the file by arranging the {@link PacketLinkedList} in
	 * correct order. It uses {@link #askForNextPacket()} to get packets until
	 * no more packet to receive. It eliminates the duplicate packets and asks
	 * for retransmitting when getting a packet with invalid checksum.
	 */
	public void reconstructFile() {

		//create a simple packet to store the packet passed in
		SimplePacket temp = askForNextPacket();
		
		//while there are still packets being passed in
		while (temp != null) {
			
			if (list.isEmpty()) //add to the list if it is empty
			{
				list.add(temp);
			}
			//compares the packet at position 0 against the packet passed in
			else if (list.get(0).getSeq() > temp.getSeq()) 			
			{	
				list.add(0, temp);
			}
			//compares the packet at position list.size-1 against the packet passed in
			else if (list.get(list.size()-1).getSeq() < temp.getSeq()) {
				list.add(list.size(), temp);
			}
			else {

				int i = 0;	
				
				//compares the packet at position i against the packet passed in
				while (list.get(i).getSeq() < temp.getSeq()) {
					i++;
				} 

				list.add(i, temp);
			}
			
			//ask for the next packet
			temp = askForNextPacket();
		}

		
		//local variable
		int previous = 0;

		if (list.size() > 0) {
			previous = list.get(0).getSeq(); //previous is the current number
		}

		//for each item in the list
		for (int i = 1; i < list.size(); i++) {
			
			//if a sequence number in the list matches previous, remove it
			if (list.get(i).getSeq() == previous) {
				list.remove(i).getSeq();  
				i--;
			} else {
				//previous is the current number
				previous = list.get(i).getSeq();
			}
		}
		
		//since we're using insert sort, end-of-transmission packet
		//will always be at position 0. 
		
		//packet at position 0
		int j = list.get(0).getSeq();
		
		int listSize = 0;
		
		//if less than 0, we know we have end-of-transmission packet
		if (j < 0)  {			
		
			listSize = Math.abs(j);
			list.remove(0); //remove it if it is in the list
		} else {
			//if not in the list, ask for it and add it to the list
			askForMissingPacket(0);
			SimplePacket endOfTransmissionPacket = askForNextPacket();
			listSize = Math.abs(endOfTransmissionPacket.getSeq());
		}

		
		//once we've obtained end-of-transmission packet, we can check to see
		//which other packets are missing
		
		//reference number to compare the items in our list against
		int k = 1;
		
		//for each packet on the list...
		for (int i = 0; i < list.size(); i++) {	
//			if (list.get(i) == null) //if null, ask for the next packet
//			{
//				askForMissingPacket(k);
//				SimplePacket missingPkt = askForNextPacket();
//				list.add(i, missingPkt);
//			}
			
			if (list.get(i).getSeq() != k) //if no match, request the missing packet
			{
				askForMissingPacket(k);
				SimplePacket missingPkt = askForNextPacket();
				list.add(i, missingPkt);
				k++;
			}
			else 
			{
				k++;//increment k to the next number if we have a packet with that seq
					//number
			} 
		}  
		//displayList(list);
	}
}


