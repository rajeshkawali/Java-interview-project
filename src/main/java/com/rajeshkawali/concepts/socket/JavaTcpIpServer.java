package com.rajeshkawali.concepts.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author Rajesh_Kawali
 *
 */
public class JavaTcpIpServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// Start a server
		ServerSocket server = new ServerSocket(1234);
		System.out.println("Server started, listening on port 1234");
		while (true) {
			// Wait for a client to connect
			Socket client = server.accept();
			System.out.println("Client connected from " + client.getInetAddress().getHostAddress());
			// Get input and output streams for communication
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			// Read data from the client
			byte[] buffer = new byte[1024];
			int bytesRead = in.read(buffer);
			// Send the data back to the client
			out.write(buffer, 0, bytesRead);
			// Close the connection
			client.close();
		}
	}
}
/*
The TCP/IP (Transmission Control Protocol/Internet Protocol) is a suite of 
communication protocols used to interconnect network devices on the internet. 
It is the foundation of data communication on the internet, and the standard 
protocol for transmitting data over the internet.

Here are some key features of the TCP/IP protocol:-->

Transmission Control Protocol (TCP): A reliable, stream-oriented protocol used to 
transmit data between applications. It ensures that data is transmitted reliably 
and in order by breaking it down into smaller segments, called packets, 
and transmitting them to the recipient.

Internet Protocol (IP): A connectionless, unreliable protocol used to transmit 
data between networks. It is responsible for routing packets from the source to 
the destination and ensuring that they are transmitted reliably.

IP addresses: A unique identifier for each device on a network.

Domain Name System (DNS): A hierarchical naming system used to translate domain names into IP addresses.

Simple Mail Transfer Protocol (SMTP): A protocol used to send and receive email messages.

File Transfer Protocol (FTP): A protocol used to transfer files between computers.

The TCP/IP protocol is a robust and flexible protocol that provides the backbone 
for data communication on the internet. It is used in almost every aspect of data communication, 
including email, web browsing, file transfers, and more.
*/

/*
Here is a list of methods available in the java.net.ServerSocket class:-->

accept() - listens for a connection to be made to this socket and accepts it.
bind(SocketAddress endpoint) - binds the server socket to a specific address (IP address and port number).
close() - closes the server socket.
getInetAddress() - returns the address to which the socket is bound.
getLocalPort() - returns the local port number to which this socket is bound.
setSoTimeout(int timeout) - enables/disables SO_TIMEOUT with the specified timeout, in milliseconds.
toString() - returns a string representation of the server socket.
--------------------------------------------------------------------------------------------------------
Here is a list of methods available in the java.net.Socket class:-->

bind(SocketAddress bindpoint) - binds the socket to a local address.
close() - closes the socket.
connect(SocketAddress endpoint) - connects the socket to a remote address.
getInetAddress() - returns the address to which the socket is connected.
getLocalAddress() - returns the address of the local endpoint.
getLocalPort() - returns the local port to which this socket is bound.
getPort() - returns the remote port to which this socket is connected.
isBound() - tells whether or not the socket is bound.
isConnected() - tells whether or not the socket is connected.
isClosed() - tells whether or not the socket is closed.
setSoTimeout(int timeout) - enables/disables SO_TIMEOUT with the specified timeout, in milliseconds.
toString() - returns a string representation of the socket.
*/