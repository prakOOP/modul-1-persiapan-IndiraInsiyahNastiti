
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
        //Invoice invoice1 = new Invoice(1,1,"27/02/2020",customer1,50000,InvoiceStatus.Finished); //membuat objek invoice1 dari class Invoice
        //System.out.println(invoice1.getId());
        location1.printData();
        seller1.printData();
        customer1.printData();
        //POST TEST MODUL 2
        System.out.println("POST TEST MODUL 2");
        Location location2 = new Location("Bekasi","Jawa Barat","macet");
        Seller seller2 = new Seller(2, "Marwah Zulfanny","marwah.zulfanny@ui.ac.id","087885310908",location2);
        Food food2 = new Food(2,"mangga", seller2, 5000,FoodCategory.Beverages);
        Customer customer2 = new Customer(2,"fakhira","fakhira.nadhila@yahoo.com","qwetyuip","28/02/2020");
        //Invoice invoice2 =new Invoice(2,2,"28/02/2020",customer2,5000,InvoiceStatus.Finished);
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
        //POST TEST MODUL 3
        System.out.println("POST TEST MODUL 3");
        Food food4 = new Food(4,"Nasi Goreng", seller3, 50000,FoodCategory.Rice);
        Customer customer3 = new Customer(3,"milo","milo@yahoo.com","dgudsjhs","06/03/2020");
        //Invoice invoice3 =new Invoice(3,food4.getID(),"06/03/2020",customer3,food4.getPrice(),InvoiceStatus.Finished);
        //invoice3.printData();
        //CS MODUL 4
        Promo promo1 = new Promo(1, "LinkAja01", 1000, 50000, true);
        
        Customer customer4 = new Customer(4,"duto","duto@yahoo.com","dugutogo","12/03/2020");
        Food food5 = new Food(5,"Nasi Bakar", seller3, 55000,FoodCategory.Rice);
        CashlessInvoice cashlessinvoice1 = new CashlessInvoice(1, food5, "12/03/2020", customer4, InvoiceStatus.Ongoing, promo1);
        
        Customer customer5 = new Customer(5,"alfian","alfian@yahoo.com","agalfian","12/03/2020");
        Food food6 = new Food(6,"Nasi Liwet", seller3, 40000,FoodCategory.Rice);
        CashlessInvoice cashlessinvoice2 = new CashlessInvoice(2, food6, "12/03/2020", customer5, InvoiceStatus.Ongoing, promo1);
        
        Customer customer6 = new Customer(6,"hanif","hanif@yahoo.com","haganigif","12/03/2020");
        Food food7 = new Food(7,"Nasi Timbel", seller3, 50000,FoodCategory.Rice);
        CashlessInvoice cashlessinvoice3 = new CashlessInvoice(3, food7, "12/03/2020", customer6, InvoiceStatus.Ongoing);
        
        cashlessinvoice1.setTotalPrice();
        cashlessinvoice2.setTotalPrice();
        cashlessinvoice3.setTotalPrice();
        
        System.out.println("CS MODUL 4");
        System.out.println("Invoice 1");
        cashlessinvoice1.printData();
        System.out.println("Invoice 2");
        cashlessinvoice2.printData();
        System.out.println("Invoice 3");
        cashlessinvoice3.printData();
        
        
        
        
        
        
    }
}
