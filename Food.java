
/**
 * Write a description of class Food here.
 *
 * @author (Marwah Zulfanny Alief)
 * @version (27/02/2020)
 */
public class Food
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private Seller seller;
    private int price;
    private String category;
   

    /**
     * Constructor untuk objects dari class Food
     * @param id, name, seller, price, category
     */
    public Food(int id, String name, Seller seller, int price, String category)
    {
        // initialise instance variables
        this.id=id;
        this.name=name;
        this.seller=seller;
        this.price=price;
        this.category=category;
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
    public int getID()
    {
        // put your code here
        return id;
    }
    
    public String getName()
    {
        // put your code here
        return name;
    }
    
    public Seller getSeller()
    {
        return seller;
    }
     
    public int getPrice()
    {
        return price;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public void setId (int id)
    {
        this.id=id;
    }
    
     public void setName (String name)
    {
        this.name=name;
    }
    
    public void setSeller(Seller seller)
    {
        this.seller=seller;
    }
    
     public void setPrice (int price)
    {
        this.price=price;
    }
     public void setCategory (String category)
    {
        this.category=category;
    }
    
    public void printData()
    {
        System.out.println(name);
    }
}
