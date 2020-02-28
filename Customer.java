
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
    private String joinDate;

    /**
     * Constructor untuk objects dari class Customer
     * @param id, name, email, password, joinDate
     */
    public Customer(int id, String name, String email, String password, String joinDate)
    {
        // initialise instance variables
       this.id=id;
       this.name=name;
       this.email=email;
       this.password=password;
       this.joinDate=joinDate;
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
     public String getJoinDate()
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
        this.email=email;
    }
    /**
     * untuk memberikan nilai pada variable password
     * @params password
     */
    public void setPassword(String password)
    {
        this.password=password;
    }
    /**
     * untuk memberikan nilai pada variable joinDate
     * @params joinDate
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate=joinDate;
    }
    /**
     * untuk menampilkan isi nilai variable name
     * @params name
     */
    public void printData()
    {
        
        System.out.println(name);
    }
    
    
    
    
}
