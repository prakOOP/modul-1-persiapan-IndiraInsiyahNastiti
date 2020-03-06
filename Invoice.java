
/**
 * Write a description of class Invoice here.
 *
 * @author (Marwah Zulfanny Alief)
 * @version (27/02/2020)
 */
public class Invoice
{
    // instance variables 
    private int id;
    private int idFood;
    private String date;
    private int totalPrice;
    private Customer customer;
    private PaymentType paymentType;
    private InvoiceStatus status;
    /**
     * Constructor untuk objects dari class Invoice
     * @param id, idFood, date, customer,totalPrice
     */
    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice, InvoiceStatus status)
    {
        // initialise instance variables
      this.id=id;
      this.idFood=idFood;
      this.date=date;
      this.customer=customer;
      this.totalPrice=totalPrice;
      this.status=status;
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
    public int getIdFood()
    {
        return idFood;
    }
    public String getDate()
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
    public PaymentType getPaymentType()
    {
        return paymentType;
    }
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setIdFoods(int idFood)
    {
        this.idFood=idFood;
    }
    public void setDate(String date)
    {
        this.date=date;
    }
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice=totalPrice;
    }
    public void setCustomer(Customer customer)
    {
        this.customer=customer;
    }
    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType=paymentType;
    }
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status=status;
    }
    public void printData()
    {
        System.out.println("================INVOICE===============");
        System.out.println("ID:" + this.id);
        System.out.println("Food ID:" + this.idFood);
        System.out.println("Date:" + this.date);
        System.out.println("Customer:" + customer.getName());
        System.out.println("Total Price:" + this.totalPrice);
        System.out.println("STatus:" + this.status);
    }
}
