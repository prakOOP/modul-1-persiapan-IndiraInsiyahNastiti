import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import java.text.*;
/**
 * Write a description of class Invoice here.
 *
 * @author (Marwah Zulfanny Alief)
 * @version (27/02/2020)
 */
public abstract class Invoice
{
    // instance variables 
    private int id;
    private Food food;
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;
    /**
     * Constructor untuk objects dari class Invoice
     * @param id, idFood, date, customer,totalPrice
     */
    public Invoice(int id,Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
        // initialise instance variables
      this.id=id;
      this.food=food;
      this.customer=customer;
      this.invoiceStatus=invoiceStatus;
      date = setDate(Calendar.getInstance());
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
     * untuk mengambil nilai dari variable idFood
     * @return idFood
     */
    public Food getFood()
    {
        return food;
    }
    public Calendar getDate()
    {
        return date;
    }
    public int getTotalPrice()
    {
        return totalPrice;
    }
    public Customer getCustomer()
    {
        return customer;
    }
    public abstract PaymentType getPaymentType();
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setFoods(Food food)
    {
        this.food=food;
    }
    public Calendar setDate(Calendar date)
    {
        return date;
    }
    public Calendar setDate(int year, int month, int dayOfMonth)
    {
         date=new GregorianCalendar(year, month, dayOfMonth);
         return date;
        }
    public abstract void setTotalPrice();
    public void setCustomer(Customer customer)
    {
        this.customer=customer;
    }
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.invoiceStatus=invoiceStatus;
    }
    public abstract String toString();
}