# Image-Receiver

## Description

For this project, I created an image viewer application with cache (i.e. CacheImageApp).

To transmit an image file, it is divided into numerous small data packets that are sent across the network. The reality is that networks are complicated and not very reliable. Packets might be lost or duplicated (to make life easier, packets are not corrupted in this assignment), and if that wasn’t enough, they arrive at the receiver out of order! To address this, a sequence number is given to each packet. This simple approach can be used to determine if there are any missing or duplicate packets, and also to arrange the received packets in the correct order to properly reconstruct the file.

As the receiver, I collected all these packets, removed duplicates, requested any that are missing, and put them in order by sequence number so that the image can be opened without errors. For missing packets, I needed to request re-transmission. The packets are stored in a singly-linked list with a header node but without a tail node. The data item for each node is one packet. When I have done my job well, I will have reconstructed the entire file as a complete and properly sequenced chain of packets so that it can be opened by our image viewer for me to see the picture. The following figure illustrates this process.

But sometimes an image file may be very large or the network may be very slow. And I may wish to request the same image many times. As it is really time-consuming to receive and reconstruct an image in this way again and again, my program will address this issue by using a cache. In computing, a cache is hardware or software that stores data so future requests for that data can be served faster.

What I need to do is first check whether the image is already in the cache when I want to receive an image file. If the image’s linked list is already in the cache, I don’t need to receive and reconstruct it again. If the image chain is not in the cache of image linked lists, I will receive it, and store its name and linked list in the cache. The following is the structure of the cache.

## Goals

I learned the following from working on this project:

    Understand, implement, and use linked chains of nodes.
    Write classes that implement Java interfaces.
    Gain experience working with Java references.
    Implement exceptions and understand the difference between checked and unchecked exception.
  
