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
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        // initialise instance variables
        super(id,foods,customer);
        
    }
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        // initialise instance variables
        super(id,foods,customer);
        this.promo=promo;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param    a sample parameter for a method
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
    public void setTotalPrice(){
        if (promo!=null && promo.getActive()==true && (totalPrice)>promo.getMinPrice()){
            this.totalPrice=totalPrice-promo.getDiscount();
        }
        else{
            this.totalPrice=totalPrice;
        }

    }
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        Date date = new Date();
        String foods = "";
        String months[] = {"","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        if(promo!=null && promo.getActive()==true && totalPrice>promo.getMinPrice()){
            return "Id:  "+getId()+
                    "\nFood: "+ foods +
                    "\nDate: "+ sdf.format(getDate().getTime())+
                    "\nCustomer: "+getCustomer().getName()+
                    "\nPromo: "+ promo.getCode()+
                    "\nTotal Price: " + this.totalPrice +
                    "\nStatus: " + getInvoiceStatus() +
                    "\nPayment Type: " + PAYMENT_TYPE;
        }
        else{
            return "Id:  "+getId()+
                    "\nFood: "+ foods +
                    "\nDate: "+ sdf.format(getDate().getTime())+
                    "\nCustomer: "+getCustomer().getName()+
                    "\nTotal Price: " + this.totalPrice +
                    "\nStatus: " + getInvoiceStatus() +
                    "\nPayment Type: " + PAYMENT_TYPE;
        }
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
    
    
    
