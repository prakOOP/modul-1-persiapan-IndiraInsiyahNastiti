import java.util.ArrayList;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseCustomer
{
    // instance variables - replace the example below with your own
    private static final ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList();
    private static int lastId;

    public static ArrayList<Customer> getCustomerDatabase()
    {
        // put your code here
        return CUSTOMER_DATABASE;
    }
    public static int getLastId()
    {
        // put your code here
        return lastId;
    }
    public static Customer getCustomerById(int id)
    {
        for(Customer customer : CUSTOMER_DATABASE){
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }
    public static boolean removeCustomer(int id)
    {
        for (Customer customer : CUSTOMER_DATABASE){
            if (customer.getId() == id){
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        return false;
    }
    public static boolean addCustomer(Customer customer)
    {
        for ( Customer _customer : CUSTOMER_DATABASE) {
            if (_customer.getEmail().equals(customer.getEmail())){
                return false;
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   /** public static boolean addCustomer(Customer customer)
    {
        // put your code here
        return true;
    }
    public static boolean removeCustomer(Customer customer)
    {
        // put your code here
        return true;
    }
    public static Customer getCustomer()
    {
        // put your code here
        return null;
    }
    public static String[] getListCustomer()
    {
        // put your code here
        return listCustomer;
    }**/
}
