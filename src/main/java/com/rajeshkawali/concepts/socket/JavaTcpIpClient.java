package com.rajeshkawali.concepts.socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
/**
 * @author Rajesh_Kawali
 *
 */
public class JavaTcpIpClient {
    public static void main(String[] args) throws IOException {
        // Connect to the server
        Socket server = new Socket(InetAddress.getByName("localhost"), 1234);
        System.out.println("Connected to server");
        // Get input and output streams for communication
        InputStream in = server.getInputStream();
        OutputStream out = server.getOutputStream();
        // Send some data to the server
        String message = "Hello from the client!";
        out.write(message.getBytes());
        // Read the response from the server
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        // Print the response
        System.out.println("Server response: " + new String(buffer, 0, bytesRead));
        // Close the connection
        server.close();
    }
}
/*
In this example, the server listens on port 1234 and waits for a 
client to connect using the TCP/IP protocol. When a client connects, 
it reads data from the client, sends the data back to the client, 
and then closes the connection. The client connects to the server 
using the TCP/IP protocol, sends some data, reads the response 
from the server, and then closes the connection. This example 
demonstrates the basic communication between two 
Java applications using the TCP/IP protocol.
*/