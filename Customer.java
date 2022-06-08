// Customer.java
// Represents a customer.
// D. Singletary
// 6/16/2016

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Customer implements Serializable {

    // constant date formatter
    public static final SimpleDateFormat DATEFORMATTER = new SimpleDateFormat("MM/dd/yyyy");
  
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private Date renewalDate;

      
    // default constructor  
    public Customer()
    {
        this.lastName = "";
        this.firstName = "";
        this.phoneNumber = "";
        this.renewalDate = new GregorianCalendar(1970, 1, 1).getTime();
    }
  
    // constructor which accepts args to set properties
    public Customer(String lastName, String firstName, String phoneNumber, Date renewalDate)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.renewalDate = renewalDate;
    }
  
    // accessors
    public String getLastName() { return this.lastName; }  
    public String getFirstName() { return this.firstName; }
    public String getPhoneNumber() { return this.phoneNumber; }
    public Date getRenewalDate() { return this.renewalDate; }

    // mutators
    public void setLastName(String lastName) { this.lastName = lastName; }  
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setRenewalDate(Date renewalDate) { this.renewalDate = renewalDate; }

    public String toString()
    {
        return "Customer [" + this.lastName + ", " + this.firstName +
               "] Phone = " + this.phoneNumber +
               ", Renewal Date = " + DATEFORMATTER.format(this.renewalDate);
    }
  
    public static void log(Object o) { System.out.println(o); }
}