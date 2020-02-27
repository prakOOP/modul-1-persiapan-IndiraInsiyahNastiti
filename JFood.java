
/**
 * Write a description of class JFood here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JFood
{


    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
        // put your code here
        Location location1 = new Location("Bogor","Jawa Barat","hujan");
        Seller seller1 =new Seller(1,"nadhila","nadhila@gmail.com","0897283627",location1);
        Food food1 = new Food(1,"Pisang",seller1,10000,"buah");
        Customer customer1 = new Customer(1,"fanny","fanny@gmail.com","12345","27/02/2020");
        Invoice invoice1 = new Invoice(1,1,"27/02/2020",customer1,10000);
        System.out.println(invoice1.getId());
        location1.printData();
        seller1.printData();
        customer1.printData();
        
        
    }
}
