
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
        // CS MODUL 2
        System.out.println("CS MODUL 2");
        Location location1 = new Location("Bogor","Jawa Barat","hujan"); //membuat objek location1 dari class Location
        Seller seller1 =new Seller(1,"nadhila","nadhila@gmail.com","0897283627",location1); //membuat objek seller1 dari class Seller
        Food food1 = new Food(1,"Pisang",seller1,10000,FoodCategory.Beverages); //membuat objek food1 dari class Food
        Customer customer1 = new Customer(1,"fanny","fanny@gmail.com","12345","27/02/2020"); //membuat objek customer1 dari class Customer
        Invoice invoice1 = new Invoice(1,1,"27/02/2020",customer1,10000); //membuat objek invoice1 dari class Invoice
        System.out.println(invoice1.getId());
        location1.printData();
        seller1.printData();
        customer1.printData();
        //POST TEST MODUL 2
        System.out.println("POST TEST MODUL 2");
        Location location2 = new Location("Bekasi","Jawa Barat","macet");
        Seller seller2 = new Seller(2, "Marwah Zulfanny","marwah.zulfanny@ui.ac.id","087885310908",location2);
        Food food2 = new Food(2,"mangga", seller2, 5000,FoodCategory.Beverages);
        Customer customer2 = new Customer(2,"fakhira","fakhira.nadhila@yahoo.com","qwetyuip","28/02/2020");
        Invoice invoice2 =new Invoice(2,2,"28/02/2020",customer2,5000);
        System.out.println(seller2.getName());
        seller2.setName("Alwi");
        System.out.println(seller2.getName());
        food2.printData();
        //CS MODUL 3
        System.out.println("CS MODUL 3");
        Location location3 = new Location("Padang","Sumatera Barat","Makanan");
        Seller seller3 = new Seller(3, "Marwah Zulfanny","marwahzulfanny@gmail","0826762715445",location3);
        Food food3 = new Food(3,"americano", seller3, 50000,FoodCategory.Coffee);
        food3.printData();
        
        
        
        
        
        
        
        
    }
}
