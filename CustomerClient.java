// CustomerClient.java
// Writes an array to a server on port 8000.
 
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.net.Socket;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class CustomerClient
{
    public static void main (String [] args)
    {
        final int PORT = 8000;
        final String HOST = "localhost";
      
        final int NUMCUSTOMERS = 4;
     
        // create an array of customers
        Customer custArray[] = new Customer[NUMCUSTOMERS];
      
        // declare 4 customers
        try {
            custArray[0] = new Customer("Smith", "John", "904-555-1212", Customer.DATEFORMATTER.parse("7/1/2016"));
            custArray[1] = new Customer("Brown", "Sally", "904-555-5555", Customer.DATEFORMATTER.parse("9/30/2016"));
            custArray[2] = new Customer("Park", "Tyrell", "904-555-7777", Customer.DATEFORMATTER.parse("10/31/2016"));
            custArray[3] = new Customer("McDowell", "Sully", "904-555-9999", Customer.DATEFORMATTER.parse("12/31/2016"));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
  
        try (Socket socket = new Socket(HOST, PORT))
        {
            // Connect to server and send customers
            log("Connected to the server at address " + HOST + " on port " + PORT);

            // Initialize output stream to server
            try (ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream()))
            {      
                toServer.writeObject(custArray);
                log("wrote array to server.");
            }
            catch (IOException ex)  // catch output stream exceptions
            {
                log("Output stream exception!");
                ex.printStackTrace();
            }
        }
        catch (IOException ex) // catch socket exceptions
        {
            log("Socket exception!");
            ex.printStackTrace();
        }
    }
   
    public static void log(Object o) { System.out.println(o); }
}