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
 * The Packet structure which includes a sequence number, a checksum
 * (true/false), and the delivered data.
 *
 * @author honghui
 */
public class SimplePacket {
	private int seq;
	private byte[] data;

	/**
	 * Constructs a SimplePacket with sequence number, checksum validation, and
	 * the data.
	 * 
	 * @param seq
	 *            the sequence number starting from 1
	 * @param buf
	 *            the delivered data in the packet
	 */
	public SimplePacket(int seq, byte[] buf) {
		this.seq = seq;
		data = buf;
	}

	/**
	 * Returns the sequence number of the packet
	 * 
	 * @return the sequence number of the packet
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 * Returns the bytes delivered by the packet
	 * 
	 * @return the bytes delivered by the packet
	 */
	public byte[] getData() {
		return data;
	}
}
