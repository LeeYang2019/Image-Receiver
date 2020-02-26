///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (CacheImageApp.java)
// File:             (CacheImageApp.java)
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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is the main class that simulates an image viewer application with a
 * cache. For each image, it checks whether the image is in the cache. If not,
 * it created a SingleImageReceiver object to build the image and then store it
 * in the cache. After getting the PacketLinkedList of the cache, we can simply
 * send it to the ImageDriver to open it.
 * 
 * @author honghui
 */
public class CacheImageApp {

	// Used to open an image from a SimplePacketList.
	// Keep it as field for performance to avoid having to
	// reconstruct the driver for each image.
	private ImageDriver img;

	// Used to store a list of PacketLists for completed images.
	// This means that we do not have to rebuild the PacketLinkedList for
	// images that we have already processed.
	private PacketLinkedList<CacheImage<SimplePacket>> cachePacketLinkedList;

	/**
	 * Constructs a CacheImageApp to build and return completed image linked
	 * lists for image files that have been transmitted. You need to initialize
	 * private members of this class.
	 */
	public CacheImageApp() {
		img = new ImageDriver();
		cachePacketLinkedList = new PacketLinkedList<CacheImage<SimplePacket>>();
	}

	/**
	 * Returns the CacheImage LinkedList, so that it may be tested independently
	 * of the rest of the program.
	 * 
	 * @return the CachePacket LinkedList
	 */
	public PacketLinkedList<CacheImage<SimplePacket>> getCachePacketLinkedList() {
		return cachePacketLinkedList;
	}

	/**
	 * Receive a image file. If the image is in the cache, it simply gets its
	 * packetLinkedList from the cache.
	 * 
	 * Otherwise, it creates a SingleImageReceiver object to receive the image
	 * and then stores it in the cache.
	 * 
	 * @param filename
	 *            the filename you want to receive
	 * @throws IOException
	 *             if the constructor of SingleImageReceiver fails and throw
	 *             IOException
	 * @throws InvalidImageException
	 *             if the image is not in the cache and the reconstructed list
	 *             is null
	 * 
	 * @return the packet list for the specific image file.
	 */
	public PacketLinkedList<SimplePacket> retrieveImage(String filename)
			throws IOException, InvalidImageException {

		//create a SingleImageReceiver using the filename, reconstruct the file, 
		//and create a cache image
		SingleImageReceiver singl;
		CacheImage<SimplePacket> image;

		//if the cacheLinkedList is not empty...
		if (!cachePacketLinkedList.isEmpty()) {
			
			for (int i = 0; i < cachePacketLinkedList.size(); i++) {
				
				//loop through each packet in the list to find filename and return it
				if (cachePacketLinkedList.get(i).getImageName().equals(filename)) {
					return cachePacketLinkedList.get(i).getPacketLinkedList();
				}
			}
		} else  {
			//construct a new singleImageReceiver
			//reconstruct the image and add it to the cache
			singl = new SingleImageReceiver(filename); 
			singl.reconstructFile(); 
			image = new CacheImage<SimplePacket>(filename, singl.getListBuffer());
			cachePacketLinkedList.add(image);
			return image.getPacketLinkedList();
		}

		//construct a new singleImageReceiver and add it to the cacheLinkedList
		singl = new SingleImageReceiver(filename);
		singl.reconstructFile();
		image = new CacheImage<SimplePacket>(filename, singl.getListBuffer());
		cachePacketLinkedList.add(image);
		return image.getPacketLinkedList(); 

	}

	/**
	 * Opens the image file by sending the packet list for the image to the
	 * ImageDriver.
	 * 
	 * @param packetLinkedList
	 *            packet list for the image
	 */
	public void openImage(PacketLinkedList<SimplePacket> packetLinkedList) {
		try {
			img.openImage(packetLinkedList);
		} catch (Exception e) {
			System.out.println("Unable to open image packet list");
			e.printStackTrace();
		}
	}

	/**
	 * Initiates a CacheImageApp to build and open images.
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		CacheImageApp app = new CacheImageApp();
		Scanner sc = new Scanner(System.in);
		String filename = "";
		while (!filename.equals("0")) {
			System.out.print("Enter 0 to quit or image filename: ");
			filename = sc.nextLine().trim();
			if (filename.equals("0")) {
				System.out.println("Program End.");
			} else if (filename.isEmpty()) {
				System.out.println("The input is empty. Please input a vaild vaule.");
			} else {
				try {
					System.out.println("Retrieve Image = " + filename);
					PacketLinkedList<SimplePacket> packetList = app
							.retrieveImage(filename);
					app.openImage(packetList);
				} catch (FileNotFoundException e) {
					System.out.println("Sorry, " + filename
							+ " can not be retrieved.");
				} catch (Exception e) {
					System.out.println("Sorry, something unexpected happened.");
						e.printStackTrace();  // uncomment during debugging only
				}
			}
		}
		sc.close();
	}
}
