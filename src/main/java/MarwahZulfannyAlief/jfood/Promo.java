package MarwahZulfannyAlief.jfood;
/**
 * Write a description of class Promo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Promo
{
    // instance variables - replace the example below with your own
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;
    

    /**
     * Constructor for objects of class Promo
     */
    public Promo(int id, String code, int discount, int minPrice, boolean active)
    {
        // initialise instance variables
        this.id=id;
        this.code=code;
        this.discount=discount;
        this.minPrice=minPrice;
        this.active=active;
    }

    /**
     * untuk mengambil nilai dari variable id
     * @return id
     */
    public int getId()
    {
        // put your code here
        return id;
    }
    public String getCode()
    {
        // put your code here
        return code;
    }
    public int getDiscount()
    {
        // put your code here
        return discount;
    }
    public int getMinPrice()
    {
        // put your code here
        return minPrice;
    }
    public boolean getActive()
    {
        // put your code here
        return true;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setCode(String code)
    {
        this.code=code;
    }
    public void setDiscount(int discount)
    {
        this.discount=discount;
    }
    public void setMinPrice(int minPrice)
    {
        this.minPrice=minPrice;
    }
    public void setActive(boolean active)
    {
        this.active=active;
    }
    public String toString()
    {
        
        return "Id = " + this.id + "Code = " + this.code  + "Discount =" + this.discount + "MinPrice =" + this.minPrice + "Active Status =" + this.active;
       
    }
    /**public void printData()
    *{
    *    System.out.println("ID:" + this.id);
    *    System.out.println("Code:" + this.code);
    *    System.out.println("Discount:" + this.discount);
    *    System.out.println("Minimum Price:" + this.minPrice);
    *    System.out.println("Status:" + this.active);
    *}
    */
    
    
    
    
    
    
    
}
