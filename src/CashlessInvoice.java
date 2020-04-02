import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import java.text.*;

/**
 * Write a description of class CashlessInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
        // initialise instance variables
        super(id,food,customer,invoiceStatus);
        
    }
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        // initialise instance variables
        super(id,food,customer,invoiceStatus);
        this.promo=promo;
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
    public Promo getPromo()
    {
        return promo;
    }
    public void setPromo(Promo promo)
    {
        this.promo=promo;
    }
    public void setTotalPrice()
    {
        if(promo!=null && promo.getActive()==true && (getFood().getPrice()) > promo.getMinPrice())
        {
           this.totalPrice=(getFood().getPrice())-promo.getDiscount();
        }
        else
        {
            this.totalPrice=(getFood().getPrice());
        }
    }
    public String toString()
    {
           
            SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
            Date date = new Date();
            
           return"=============INVOIVE================"+
           "ID:  "+getId()+
           "\nFood:: "+getFood().getName()+
           "\nDate:"+format.format(getDate().getTime())+
           "\nCustomer:"+getCustomer().getName()+
           "\nTotal Price:"+getTotalPrice()+
           //"\nDelivery Fee:"+this.deliveryFee+"\nTotal Price:"+this.totalPrice + "\nStatus:"+getInvoiceStatus()+
           "\nStatus:"+getInvoiceStatus()+
           "\nPayment Type:" + getPaymentType();
           //"\n==PROMO==\n"+
           //"\nCode:"+promo.getCode()+
           //"\nDiscount:"+promo.getDiscount()+
           //"\nMinimum Price: "+ promo.getMinPrice()+
           //"\n"
           
        
       
       
    }
    /**public void printData()
    {
        
        if(promo!=null && promo.getActive()==true && (getFood().getPrice()) >= promo.getMinPrice())
        {
           System.out.println("ID:"+ getId());
           System.out.println("Food:"+ (getFood().getName()));
           System.out.println("Date:"+getDate());
           System.out.println("Date:"+getDate());
           System.out.println("Customer:"+(getCustomer().getName()));
           System.out.println("Promo:"+promo.getCode());
           System.out.println("Total Price:"+this.totalPrice);
           System.out.println("Status:"+getInvoiceStatus());
           System.out.println("Payment Type:"+PAYMENT_TYPE);
           
           
        }
        else
        {
           System.out.println("ID:"+ getId());
           System.out.println("Food:"+ (getFood().getName()));
           System.out.println("Date:"+getDate());
           System.out.println("Date:"+getDate());
           System.out.println("Customer:"+(getCustomer().getName()));
           System.out.println("Total Price:"+this.totalPrice);
           System.out.println("Status:"+getInvoiceStatus());
           System.out.println("Payment Type:"+PAYMENT_TYPE);
        }
            
    **/}
    
    
    
