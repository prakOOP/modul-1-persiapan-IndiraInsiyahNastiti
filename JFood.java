
/**
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JFood
{


    /**
     * Merupakan method utama yang akan dieksekusi
     * berisi deklarasi pembuatan Objek/Instance serta pemanggilan fungsi/method printData()
     * untuk menampilkan hasil eksekusi program ke interface user.
     */
    public static void main(String[] args)
    {
        // put your code here
        Location location1 = new Location("Bogor","Jawa Barat","hujan"); //membuat objek location1 dari class Location
        Seller seller1 =new Seller(1,"nadhila","nadhila@gmail.com","0897283627",location1); //membuat objek seller1 dari class Seller
        Food food1 = new Food(1,"Pisang",seller1,10000,"buah"); //membuat objek food1 dari class Food
        Customer customer1 = new Customer(1,"fanny","fanny@gmail.com","12345","27/02/2020"); //membuat objek customer1 dari class Customer
        Invoice invoice1 = new Invoice(1,1,"27/02/2020",customer1,10000); //membuat objek invoice1 dari class Invoice
        System.out.println(invoice1.getId());
        location1.printData();
        seller1.printData();
        customer1.printData();
        
        
    }
}
