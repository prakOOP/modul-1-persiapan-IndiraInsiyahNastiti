import java.util.ArrayList;
import java.util.Calendar;
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        // initialise instance variables
        super(id,foods,customer);
        
    }
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {
        // initialise instance variables
        super(id,foods,customer);
        this.deliveryFee=deliveryFee;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    public void setDeliveryFee(int DeliveryFee)
    {
        this.deliveryFee=deliveryFee;
    }
    public void setTotalPrice()
    {
        if(deliveryFee!=0)
        {
           this.totalPrice=totalPrice+this.deliveryFee;
        }
        else
        {
            this.totalPrice=totalPrice;
        }
    }
    public String toString()
    {
       
        
          
           return"=============INVOIVE================"+
           "ID:  "+getId()+
           "\nFood:: "+getFoods()+
           
           "\nCustomer:"+getCustomer().getName()+
           "\nTotal Price:"+getTotalPrice()+
           //"\nDelivery Fee:"+this.deliveryFee+"\nTotal Price:"+this.totalPrice + "\nStatus:"+getInvoiceStatus()+
           "\nStatus:"+getInvoiceStatus()+
           "\nPayment Type:" + getPaymentType()+
           "\n"+
           "\n==PROMO==\n"+
           //"\nCode:"+promo.getCode()+
           //"\nDiscount:"+promo.getDiscount()+
           //"\nMinimum Price: "+ promo.getMinPrice()+
           "\n"
           ;   
        }
       
       
    }
    /**public void printData()
    *{
    *    
   *     if(deliveryFee!=0)
    *    {
    *       System.out.println("ID:"+ getId());
    *       System.out.println("Food:"+ (getFood().getName()));
    *       System.out.println("Date:"+getDate());
    *       System.out.println("Customer:"+(getCustomer().getName()));
     *      System.out.println("Delivery Fee:"+this.deliveryFee);
     *      System.out.println("Total Price:"+this.totalPrice);
    *       System.out.println("Status:"+getInvoiceStatus());
    *       System.out.println("Payment Type:"+PAYMENT_TYPE);
           
           
     *   }
    *    else
     *   {
     *      System.out.println("ID:"+ getId());
     *      System.out.println("Food:"+ (getFood().getName()));
           System.out.println("Date:"+getDate());
           System.out.println("Customer:"+(getCustomer().getName()));
           System.out.println("Total Price:"+this.totalPrice);
           System.out.println("Status:"+getInvoiceStatus());
           System.out.println("Payment Type:"+PAYMENT_TYPE);
        }
            
    }
    **/
 

