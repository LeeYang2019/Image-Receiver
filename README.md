<Strong>Goals</Strong>

I learned the following from working on this project:

    Understand and implement a linked chain of nodes.
    Gain experience writing classes that implement Java interfaces.
    Gain experience working with Java references.
    Implement exceptions and undserstand the difference between checked and unchecked exception
  
<Strong>Description</Strong>

For this project, my partner and I created a program that simulates the transmission of an image over a computer network. We coded the receiver that gets information packets from a simulated network and reconstructs an image file. The sender and network simulator was already provided to us.

To transmit an image file, the image file is divided into numerous small data packets that are sent across the network. Packets might be corrupted, lost or duplicated, and may arrive at the receiver out of order. To address this, a sequence number is given to each packet. This simple approach can be used to determine if there are any missing or duplicate packets, and also to arrange the received packets in the correct order to properly reconstruct the file.

As the receiver, our job was to collect all these packets, remove duplicates, request any that are missing, replace any that are corrupted, and put them in order by sequence number so that the image can be opened without errors. For missing or corrupted packets, we needed to request retransmission. The packets are stored in a singly-linked list with each node storing one packet.
