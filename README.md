# console-chat-application

Introduction:
This is a console network-based chat application using Java and Java Socket API. This document
will provide the instructions of how to use the program and the program information and
features.



Program instructions:

1. Connect to the server socket connection:
  a. Open the command line terminal at the /src folder of the project.
  b. Enter the following command to compile the Server class: “javac ie/gmit/dip/ChatServer.java”.
  c. Run the program on the server connection by entering the following command: “java ie.gmit.dip.ChatServer”.
  d. The program menu should now run in the console and you will be asked to enter a name.
  e. The server user will then be asked to set a port number for connection and wait for the client connection (e.g. 3500).

2. Connect to the client socket connection:
  a. Open the command line terminal at the /src folder of the project.
  b. Enter the following command to compile the Server class: “javac ie/gmit/dip/ChatClient.java”.
  c. Run the program on the server connection by entering the following command: “java ie.gmit.dip.ChatClient”.
  d. The program menu should now run in the console and you will be asked to enter a name.
  e. The client user will then be asked for a port number to connect to the server, this should match the server socket port number (e.g. 3500).

3. If the port numbers match and are available, then either the server or client can now start
chatting by typing into the console and pressing enter.

4. The server or client can exit the chat by entering the command: “\q”.

5. If either user makes a hard-exit by using the command “ctrl + c”, then the other user will
be notified that the other user has left the chat and that the chat has ended.



Program information:

  ● The program uses the getName() method to allow the user to enter their name, this is used for the other user to see who they are chatting to. The name is stored as a private instance variable and accessed and sent to the other user using the PrintWriter out object. This name will be shown when the chat begins to notify each user and when every message is received, the name will be displayed beside the received message.
  
  ● The getPort() method allows the users to enter the port they would like to connect to, to begin the chat. The port number is set as a private instance variable. The server must set this number and the client must use the same port number in order to make a successful connection to the server.

  ● The users can exit the chat gracefully during the chat by entering the command “\q”. An if statement is used to allow this, and the server/client objects and PrintWriter out methods are then closed.

  ● Threads are used in both the server and client programs and kept open with an infinite loop to allow the users to send or receive messages at any time.

  ● If the client or the user connects initially but the connection is lost during the chat session, then the other user whose connection is still will be notified that the connection has dropped.

  ● If the client cannot reach the server then the client will be notified that they cannot connect. This may happen if the client enters a different port number then the server.


References:

  ● Socket (Java Platform SE 7 ). 2022. Socket (Java Platform SE 7 ). [ONLINE] Available at: https://docs.oracle.com/javase/7/docs/api/java/net/Socket.html. [Accessed 03 January 2022].
  ● GeeksforGeeks. 2022. A Group chat application in Java - GeeksforGeeks. [ONLINE] Available at: https://www.geeksforgeeks.org/a-group-chat-application-in-java/. [Accessed 04 January 2022].
  ● Jihen Barhoumi. 2022. Create a chat app with java sockets | by Jihen Barhoumi | Nerd For Tech | Medium. [ONLINE] Available at: https://medium.com/nerd-for-tech/create-a-chat-app-with-java-sockets-8449fdaa933. [Accessed 05 January 2022]
