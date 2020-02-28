
/**
 * Write a description of class Location here.
 *
 * @author (Marwah Zulfanny Alief)
 * @version (27/02/2020)
 */
public class Location
{
    // instance variables - replace the example below with your own
    private String province;
    private String description;
    private String city;

     /**
     * Constructor untuk objects dari class Location
     * @param city,province,description
     */
    public Location(String city, String province, String description)
    {
        // initialise instance variables
        this.city=city;
        this.province=province;
        this.description=description;
    }

    /**
     *  methods yang terdapat pada Class Customer
     * Untuk melakukan pemberian nilai dan pengambilan nilai value
     * Pemberian nilai dengan setVariable()
     * Pengambilan nilai dengan getVariable()
     */
    
    /**
     * untuk mengambil nilai dari variable province
     * @return province
     */
    public String getProvince()
    {
        // put your code here
        return  province;
    }
     public String getCity()
    {
        // put your code here
        return city;
    }
     public String getDescription()
    {
        // put your code here
        return description;
    }
     public void setProvince(String province)
    {
        // put your code here
        this.province=province;
    }
     public void setCity(String city)
    {
        // put your code here
        this.city=city;
    }
     public void setDescription(String description)
    {
        // put your code here
        this.description=description;
    }
    public void printData()
    {
       System.out.println(province);
    }
}
