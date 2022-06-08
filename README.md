# cop2805cMod5Practice
COP2805C Module 5 Practice Exercise Solution

Adapt the Customer class from the Module 2 graded programming assignment to send the array of customers over the network to a server registered on port 8000 instead of writing them to a file. Your server should read the array and display the contents.

You will be able to use much of the code from the solution, but will need to change file references to network stream references. You will need a server class (e.g. "CustomerServer") and a client class (e.g. "CustomerClient"). The client will instantiate the same array of Customers as in the homework assignment. Run the server object from the command line, and the client object from jGrasp. Your Customer class can be shared between both the server and client objects.

Client output:  
  
----jGRASP exec:  
java CustomerClientConnected to the server at address localhost on port 8000  
wrote array to server.  
  
Server output:  
  
C:\temp>java CustomerServer  
Server registered on port 8000  
Read 4 customers!  
Customer [Smith, John] Phone = 904-555-1212, Renewal Date = 07/01/2016  
Customer [Brown, Sally] Phone = 904-555-5555, Renewal Date = 09/30/2016  
Customer [Park, Tyrell] Phone = 904-555-7777, Renewal Date = 10/31/2016  
Customer [McDowell, Sully] Phone = 904-555-9999, Renewal Date = 12/31/2016  
