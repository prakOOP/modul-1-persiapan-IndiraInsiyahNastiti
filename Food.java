
/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
     * Constructor for objects of class Food
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
        
    }
}
