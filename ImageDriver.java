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
import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

/**
 * Using ImageIO to display the image by creating an ImageIcon, placing that
 * icon an a JLabel, and placing that label on a JFrame.
 * 
 * @author honghui
 */
public class ImageDriver {


	/**
	 * Opens the image file by merging the content in the list.
	 * 
	 * @param list
	 *            the list with correct order of packets
	 * @throws IllegalArgumentException
	 *             when list is null
	 */
	public void openImage(PacketLinkedList<SimplePacket> list) {
		if (list == null) {
			throw new IllegalArgumentException(
					"Unable to open image because the linkedlist buffer is null.");
		}
		System.out.println("Loading image from buffer...");
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		PacketLinkedListIterator<SimplePacket> iter = list.iterator();
		while (iter.hasNext()) {
			SimplePacket pkt = iter.next();
			try {
				outStream.write(pkt.getData());
			} catch (IOException e) {
				System.out
						.println("Unable to open the image for unknown reason.");
			}
		}
		byte[] data = outStream.toByteArray();
		final ByteArrayInputStream inStream = new ByteArrayInputStream(data);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame editorFrame = new JFrame("Secret");
				editorFrame
						.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

				Dimension screenSize = Toolkit.getDefaultToolkit()
						.getScreenSize();
				double width = screenSize.getWidth();
				double height = screenSize.getHeight();
				BufferedImage image = null;
				try {
					image = ImageIO.read(inStream);
					Image img = image.getScaledInstance((int) width,
							(int) height, Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(img);
					JLabel jLabel = new JLabel();

					jLabel.setIcon(imageIcon);
					JScrollPane scrPane = new JScrollPane(jLabel);
					editorFrame.getContentPane().add(scrPane,
							BorderLayout.CENTER);

					editorFrame.pack();
					editorFrame.setLocationRelativeTo(null);
					editorFrame.setVisible(true);
				} catch (IOException e) {
					System.out
							.println("Unable to open the image from the stream buffer.");
				} catch (NullPointerException e) {
					System.out
							.println("Unable to open the image because of broken buffer.");
				}
			}
		});
	}
}
