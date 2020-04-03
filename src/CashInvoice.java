import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;
import java.text.*;
import java.util.GregorianCalendar;
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashInvoice extends Invoice {
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer) {
        // initialise instance variables
        super(id, foods, customer);

    }

    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee) {
        // initialise instance variables
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return the sum of x and y
     */
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(int DeliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public void setTotalPrice() {
        if (deliveryFee != 0) {
            this.totalPrice = totalPrice + getDeliveryFee();
        } else {
            this.totalPrice = totalPrice;
        }
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        Date date = new Date();
        String foods = "";
        String months[] = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (Food foodlist : getFoods()) {
            foods = foods += foodlist.getName() + ", ";
        }
        foods = foods.substring(0, foods.length() - 2);
        return "Id:  " + getId() +
                "\nFood: " + foods +
                "\nDate: " + sdf.format(getDate().getTime()) +
                "\nCustomer: " + getCustomer().getName() +
                "\nDeliveryFee: " + getDeliveryFee() +
                "\nTotal Price: " + totalPrice +
                "\nStatus: " + getInvoiceStatus() +
                "\nPayment Type: " + PAYMENT_TYPE;

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
 

