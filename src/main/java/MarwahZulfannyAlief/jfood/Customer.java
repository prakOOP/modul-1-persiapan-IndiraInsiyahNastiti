package MarwahZulfannyAlief.jfood;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.*;
import java.util.*;
import java.text.*;

/**
 * Write a description of class Customer here.
 *
 * @author (Marwah Zulfanny Alief)
 * @version (27/02/2020)
 */

public class Customer
{
    // instance variables
    private int id;
    private String name;
    private String email;
    private String password;
    private Calendar joinDate = Calendar.getInstance();
    

    /**
     * Constructor untuk objects dari class Customer
     * @param id, name, email, password, joinDate
     */
    public Customer(int id, String name, String email, String password, Calendar joinDate)
    {
        // initialise instance variables
       this.id=id;
       this.name=name;
       setEmail(email);
       setPassword(password);
       this.joinDate=joinDate;
    }
    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        // initialise instance variables
       this.id=id;
       this.name=name;
       setEmail(email);
       setPassword(password);
       this.joinDate = new GregorianCalendar(year,month,dayOfMonth);
    }
    public Customer(int id, String name, String email, String password)
    {
        // initialise instance variables
       this.id=id;
       this.name=name;
       setEmail(email);
       setPassword(password);
    }

    /**
     *  methods yang terdapat pada Class Customer
     * Untuk melakukan pemberian nilai dan pengambilan nilai value
     * Pemberian nilai dengan setVariable()
     * Pengambilan nilai dengan getVariable()
     */
    
    /**
     * untuk mengambil nilai dari variable id
     * @return id
     */
    public int getId() 
    {
        // put your code here
        return id;
    }
     /**
     * untuk mengambil nilai dari variable name
     * @return name
     */
    public String getName()
    {
        return name;
    }
     /**
     * untuk mengambil nilai dari variable email
     * @return email
     */
     public String getEmail()
    {
        return email;
    }
     /**
     * untuk mengambil nilai dari variable password
     * @return password
     */
     public String getPassword()
    {
        return password;
    }
     /**
     * untuk mengambil nilai dari variable joinDate
     * @return joinDate
     */
     public Calendar getJoinDate()
    {
        return joinDate;
    }
     /**
     * untuk memberikan nilai pada variable id
     * @params id
     */
    public void setId(int id)
    {
        this.id=id;
    }
    /**
     * untuk memberikan nilai pada variable name
     * @params name
     */
    public void setName(String name)
    {
        this.name=name;
    }
    /**
     * untuk memberikan nilai pada variable email
     * @params email
     */
    public void setEmail(String email)
    {
      
        String pattern =  "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        if(m.matches())
        {
            this.email = email;
        }
        else
        {
            this.email ="";
        }
         
    }
    /**
     * untuk memberikan nilai pada variable password
     * @params password
     */
    public void setPassword(String password)
    {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        if(m.matches())
        {
            this.password = password;
        }
        else
        {
            this.password ="";
        }
    }
    /**
     * untuk memberikan nilai pada variable joinDate
     * @params joinDate
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate=joinDate;
    }
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate=new GregorianCalendar(year, month-1, dayOfMonth);
    }
    /**
     * untuk menampilkan isi nilai variable name
     * @params name
     */
   
        public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
       if(joinDate == null)
       {
           return"ID:  "+this.id+"\nName: "+this.name+"\nEmail: "+this.email+"\nPassword: "+this.password+"\n";
    
       }
       
       else
       {    
           return"ID:  "+this.id+"\nName: "+this.name+"\nEmail: "+this.email+"\nPassword: "+this.password+"\nDate: "+
           sdf.format(getJoinDate().getTime());
       }
    }
    
    
    
    
    
}
