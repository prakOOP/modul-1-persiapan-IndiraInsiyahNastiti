package MarwahZulfannyAlief.jfood;
/**
 * Write a description of class Seller here.
 *
 * @author (Marwah Zulfanny Alief)
 * @version (27/02/2020)
 */
public class Seller
{
    // instance variables 
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;
    
    /**
     * Constructor untuk objects dari class Seller
     * @param id, name, email, phoneNumber, Location
     */
    public Seller(int id, String name, String email, String phoneNumber, Location location)
    {
        // initialise instance variables
        this.id=id;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.location=location;
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
     * untuk mengambil nilai dari variable phoneNumber
     * @return phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
     /**
     * untuk mengambil nilai dari variable location
     * @return location
     */
    public Location getLocation()
    {
        return location;
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
        this.email=email;
    }
      /**
     * untuk memberikan nilai pada variable phoneNumber
     * @params phoneNumber
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber=phoneNumber;
    }
      /**
     * untuk memberikan nilai pada variable location
     * @params location
     */
    public void setLocation(Location location)
    {
        this.location=location;
    }
    /**
     * untuk menampilkan isi nilai variable name
     * @params name
     */
    public String toString()
    {
        
        return "Id = " + this.id + "Nama = " + this.name  + "Phone Number =" + this.phoneNumber + "Location =" + this.location;
       
    }
    
    /**public void printData()
    *{
    *    System.out.println(name);
    *}
    */
}
