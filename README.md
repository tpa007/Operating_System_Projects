# Operating_System_Projects
Operating System Projects related to RPC and Java RMI

#### 1. RemoteProceduralCall_OS

Remote Procedural Call (RPC) application that generates random numbers.
The random numbers are generated by the server and printed by the client.

Implemented for the coursework: http://cse.csusb.edu/tongyu/courses/cs660/labs/lab5.php

#### 2. Reader_Writer_Java_OS

Reader- Writer thread in Java. 20 reader threads and 3 writer threads.

Reading from and writing to a file named counter.txt (which has an integer counter).
 
A reader thread : reads the counter from counter.txt and prints out its thread name and the value of the counter.

A writer thread: increments the value of the counter in counter.txt, prints out its thread name and the new value of the counter.

Implemented for the coursework: http://cse.csusb.edu/tongyu/courses/cs660/hw/hw1.php

#### 3. Reader_Writer_Java_OS_2

Solution to Readers-Writers problem using writers priority in gaurded commands.

The variable 'writers' is the number of threads that are either writing or waiting to write. 

The variable 'active_writers' is the number of threads that are currently writing.

Implemented for the coursework: http://cse.csusb.edu/tongyu/courses/cs660/hw/hw1.php
