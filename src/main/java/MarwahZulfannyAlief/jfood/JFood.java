package MarwahZulfannyAlief.jfood;
import javax.xml.crypto.Data;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.zip.DeflaterOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */

@SpringBootApplication
public class JFood {


    /**
     * Merupakan method utama yang akan dieksekusi
     * berisi deklarasi pembuatan Objek/Instance serta pemanggilan fungsi/method printData()
     * untuk menampilkan hasil eksekusi program ke interface user.
     */
    public static void main(String[] args) {
        Location location1 = new Location("Bogor", "Jawa Barat", "hujan"); //membuat objek location1 dari class Location
        Location location2 = new Location("Padang", "Sumatera Barat", "rendang"); //membuat objek location2 dari class Location
        Location location3 = new Location("Jakarta", "DKI Jakarta", "macet"); //membuat objek location3 dari class Location

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "manda", "manda@gmail.com", "087383846837", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "milo", "milo@gmail.com", "087383846876", location2));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "duto", "duto@gmail.com", "087383846893", location3));

        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "nasi ijo", DatabaseSeller.getSellerById(1), 50000, FoodCategory.Rice));
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "nasi merah", DatabaseSeller.getSellerById(2), 50000, FoodCategory.Rice));
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "kopi item", DatabaseSeller.getSellerById(3), 50000, FoodCategory.Coffee));
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "kopi susu", DatabaseSeller.getSellerById(1), 50000, FoodCategory.Coffee));
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        SpringApplication.run(JFood.class, args);
        // CS MODUL 2
        //System.out.println("CS MODUL 2");
        /**Seller seller1 = new Seller(1, "nadhila", "nadhila@gmail.com", "0897283627", location1); //membuat objek seller1 dari class Seller
        Food food1 = new Food(1, "Pisang", seller1, 10000, FoodCategory.Beverages); //membuat objek food1 dari class Food
        //Customer customer1 = new Customer(1,"fanny","fanny@gmail.com","12345","27/02/2020"); //membuat objek customer1 dari class Customer
        //Invoice invoice1 = new Invoice(1,1,"27/02/2020",customer1,50000,InvoiceStatus.Finished); //membuat objek invoice1 dari class Invoice
        //System.out.println(invoice1.getId());
        //location1.printData();
        //seller1.printData();
        //customer1.printData();
        //POST TEST MODUL 2
        //System.out.println("POST TEST MODUL 2");
        // Location location2 = new Location("Bekasi","Jawa Barat","macet");
        Seller seller2 = new Seller(2, "Marwah Zulfanny", "marwah.zulfanny@ui.ac.id", "087885310908", location1);
        Food food2 = new Food(2, "mangga", seller2, 5000, FoodCategory.Beverages);
        //Customer customer2 = new Customer(2,"fakhira","fakhira.nadhila@yahoo.com","qwetyuip","28/02/2020");
        //Invoice invoice2 =new Invoice(2,2,"28/02/2020",customer2,5000,InvoiceStatus.Finished);
        //System.out.println(seller2.getName());
        seller2.setName("Alwi");
        //System.out.println(seller2.getName());
        //food2.printData();
        //CS MODUL 3
        //System.out.println("CS MODUL 3");
        Location location3 = new Location("Padang", "Sumatera Barat", "Makanan");
        Seller seller3 = new Seller(3, "Marwah Zulfanny", "marwahzulfanny@gmail", "0826762715445", location3);
        Food food3 = new Food(3, "americano", seller3, 50000, FoodCategory.Coffee);
        //food3.printData();
        //POST TEST MODUL 3
        //System.out.println("POST TEST MODUL 3");
        Food food4 = new Food(4, "Nasi Goreng", seller3, 50000, FoodCategory.Rice);
        //Customer customer3 = new Customer(3,"milo","milo@yahoo.com","dgudsjhs","06/03/2020");
        //Invoice invoice3 =new Invoice(3,food4.getID(),"06/03/2020",customer3,food4.getPrice(),InvoiceStatus.Finished);
        //invoice3.printData();
        //CS MODUL 4
        Promo promo1 = new Promo(1, "LinkAja01", 1000, 50000, true);

        //Customer customer4 = new Customer(4,"duto","duto@yahoo.com","dugutogo","12/03/2020");
        Food food5 = new Food(5, "Nasi Bakar", seller3, 55000, FoodCategory.Rice);
        //CashlessInvoice cashlessinvoice1 = new CashlessInvoice(1, food5, "12/03/2020", customer4, InvoiceStatus.Ongoing, promo1);

        //Customer customer5 = new Customer(5,"alfian","alfian@yahoo.com","agalfian","12/03/2020");
        Food food6 = new Food(6, "Nasi Liwet", seller3, 40000, FoodCategory.Rice);
        //CashlessInvoice cashlessinvoice2 = new CashlessInvoice(2, food6, "12/03/2020", customer5, InvoiceStatus.Ongoing, promo1);

        //Customer customer6 = new Customer(6,"hanif","hanif@yahoo.com","haganigif","12/03/2020");
        Food food7 = new Food(7, "Nasi Timbel", seller3, 50000, FoodCategory.Rice);
        //CashlessInvoice cashlessinvoice3 = new CashlessInvoice(3, food7, "12/03/2020", customer6, InvoiceStatus.Ongoing);

        //cashlessinvoice1.setTotalPrice();
        //cashlessinvoice2.setTotalPrice();
        //cashlessinvoice3.setTotalPrice();

        //System.out.println("CS MODUL 4");
        //System.out.println("Invoice 1");
        //cashlessinvoice1.printData();
        //System.out.println("Invoice 2");
        //cashlessinvoice2.printData();
        //System.out.println("Invoice 3");
        //cashlessinvoice3.printData();

        //POST TEST MODUL 4
        //Customer customer7 = new Customer(7,"indira","indira@yahoo.com","igindigiraga","13/03/2020");
        Food food8 = new Food(8, "Nasi Lemak", seller3, 60000, FoodCategory.Rice);


        //cashinvoice1.setTotalPrice();
        //cashinvoice2.setTotalPrice();

        //System.out.println("POST TEST MODUL 4");
        //System.out.println("Invoice 1");
        //cashinvoice1.printData();
        //System.out.println("Invoice 2");
        //cashinvoice2.printData();

        System.out.println("CS MODUL 5");
        Calendar tanggal = Calendar.getInstance();

        Customer customer1 = new Customer(1, "marwah", ".etd@ui.ac.id", "apalah", tanggal);
        Customer customer2 = new Customer(2, "fanny", "etd@ui.ac.id", "Apalah1", 2020, 3, 19);
        Customer customer3 = new Customer(3, "alief", "fanny.alief@gmail.com", "yayayA3");


        System.out.println(customer1.toString());
        System.out.println(customer2.toString());
        System.out.println(customer3.toString());

        customer1.setEmail("et.d@ui.ac.id");
        customer1.setPassword("apalaH1");

        System.out.println(customer1.toString());

        // System.out.println("POST TES MODUL 5");
        // CashlessInvoice cashlessinvoice1 = new CashlessInvoice(1, food8, customer1, InvoiceStatus.Finished);
        //CashInvoice cashinvoice2 = new CashInvoice(2, food8, customer2, InvoiceStatus.Finished,10000);
        //System.out.println(cashlessinvoice1.toString());
        //System.out.println(cashinvoice2.toString());

        System.out.println("CASE STUDY MODUL 6");
        /**DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "marw", "marw@gmail.com", "apalaH12"));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "marw", "marw@gmail.com", "apalaH13"));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "dhil", "dhil@gmail.com", "apalaH14"));
        System.out.println(DatabaseCustomer.getCustomerDatabase());
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "nasi ijo", DatabaseSeller.getSellerById(4), 50000, FoodCategory.Rice));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "nasi merah", DatabaseSeller.getSellerById(4), 50000, FoodCategory.Rice));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "kopi item", DatabaseSeller.getSellerById(4), 50000, FoodCategory.Coffee));
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Rice)) {
            System.out.println(food.getName());
        }
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Coffee)) {
            System.out.println(food.getName());
        }
        System.out.println("POST TEST MODUL 6");
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "DISKON", 5000, 50000, false));
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "DISKON", 6000, 60000, false));
        System.out.println("\nPromo");
        for (Promo promo : DatabasePromo.getPromoDatabase()) {
            System.out.println(promo);
            System.out.println("");
        }
        ArrayList<Food> fl = new ArrayList<Food>();
        fl.add(DatabaseFood.getFoodById(1));
        fl.add(DatabaseFood.getFoodById(2));

        ArrayList<Food> fl2 = new ArrayList<Food>();
        fl2.add(DatabaseFood.getFoodById(3));
        fl2.add(DatabaseFood.getFoodById(2));

        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, fl, DatabaseCustomer.getCustomerById(1), 10000));
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size() - 1).setTotalPrice();
        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, fl2, DatabaseCustomer.getCustomerById(1)));
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size() - 1).setTotalPrice();

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase()) {
            System.out.println(invoice);
            System.out.println();
        }
        DatabaseInvoice.changeInvoiceStatus(DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size() - 1).getId(), InvoiceStatus.Finished);

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, fl2, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoByCode("DISKON")));
        DatabasePromo.activatePromo(1);
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase()) {
            invoice.setTotalPrice();
            System.out.println(invoice);
            System.out.println();
        }**/
        /**System.out.println("CS MODUL 7");
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "marw", "marw@gmail.com", "apalaH12"));
        }catch (EmailAlreadyExistsException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "dhil", "dhil@gmail.com", "apalaH14"));
        }catch (EmailAlreadyExistsException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "nana", "nana@gmail.com", "apalaH15"));
        }catch (EmailAlreadyExistsException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "fan", "marw@gmail.com", "apalaH13"));
        }catch (EmailAlreadyExistsException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "HUTPROMO", 5000, 50000, true));
        }catch (PromoCodeAlreadyExistsException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "HUTPROMO", 6000, 60000, true));
        }catch (PromoCodeAlreadyExistsException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "nasi ijo", DatabaseSeller.getSellerById(4), 50000, FoodCategory.Rice));
        }catch (SellerNotFoundException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "nasi merah", DatabaseSeller.getSellerById(4), 50000, FoodCategory.Rice));
        }catch (SellerNotFoundException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabasePromo.getPromoById(5);
        }catch (PromoNotFoundException except){
            System.out.println(except.getMessage());
        }
        try{
            DatabaseCustomer.getCustomerById(5);
        }catch (CustomerNotFoundException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabaseFood.getFoodById(5);
        }catch (FoodNotFoundException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabaseSeller.getSellerById(5);
        }catch (SellerNotFoundException except){
            System.out.println(except.getMessage());
        }
        for (Customer customer : DatabaseCustomer.getCustomerDatabase()) {
            System.out.println(customer);
            System.out.println();
        }
        for (Promo promo : DatabasePromo.getPromoDatabase()) {
            System.out.println(promo);
            System.out.println();
        }
        for (Food food : DatabaseFood.getFoodDatabase()) {
            System.out.println(food);
            System.out.println();
        }
        ArrayList<Food> fl = new ArrayList<Food>();
        try {
            fl.add(DatabaseFood.getFoodById(1));
        }catch (FoodNotFoundException except){
            System.out.println((except.getMessage()));
        }
        try {
            fl.add(DatabaseFood.getFoodById(2));
        }catch (FoodNotFoundException except){
            System.out.println((except.getMessage()));
        }
        try{
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,fl, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoByCode("DISKON")));
        }catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException except){
            System.out.println(except.getMessage());
        }
        try{
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,fl, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoByCode("DISKON")));
        }catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException except){
            System.out.println(except.getMessage());
        }
        try {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, fl, DatabaseCustomer.getCustomerById(3), DatabasePromo.getPromoByCode("DISKON")));
        }catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException except){
            System.out.println(except.getMessage());
        }

        /**for (Invoice invoice: DatabaseInvoice.getInvoiceDatabase()){
                new Thread(new PriceCalculator(invoice)).start();
            }**/
        /**System.out.println("POST TEST MODUL 7");
        try{
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId(),fl, DatabaseCustomer.getCustomerById(3), DatabasePromo.getPromoByCode("DISKON")));
        }catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException except) {
            System.out.println(except.getMessage());
        }
        try{
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,fl, DatabaseCustomer.getCustomerById(3), DatabasePromo.getPromoByCode("DISKON")));
        }catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException except) {
            System.out.println(except.getMessage());
        }
        try {
            DatabaseInvoice.getInvoiceById(10);
        }catch (InvoiceNotFoundException except){
            System.out.println((except.getMessage()));
        }**/
    }
}



