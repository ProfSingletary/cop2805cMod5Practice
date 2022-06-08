// CustomerServer.java
// Reads a customer array from a client
// D. Singletary
// 4/26/2016

import java.net.Socket;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.EOFException;

public class CustomerServer
{
    public static void main(String[] args)
    {
        final int PORT = 8000;
        try (ServerSocket serverSocket = new ServerSocket(PORT))
        {
            // Create a server socket
            System.out.println("Server registered on port " + PORT);
            // Listen for a new connection request
            Socket socket = serverSocket.accept();

            // Create an input stream from the socket
            try (ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream()))
            {
                // read the customers from the client as an arry and display them
                Customer newArray[] = (Customer[])(inputFromClient.readObject());
                log("Read " + newArray.length + " customers!");
                for (Customer c : newArray)
                    log(c);    
            } catch (EOFException ex) {
                log("Client connection closed");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                Throwable[] s = e.getSuppressed();
                if (s.length > 0)
                    for (Throwable sx : s)
                        log("Suppressed: " + sx);
            }
        }
        catch(IOException ex) {
            log("socket exception!");
            ex.printStackTrace();
        }
    }
  
    public static void log(Object o) { System.out.println(o); }
}