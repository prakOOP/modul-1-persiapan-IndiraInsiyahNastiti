package MarwahZulfannyAlief.jfood.controller;

import MarwahZulfannyAlief.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class Seller Controller berfungi untuk melakukan CRUD database Seller di PostgreSQL melalui Springboot web REST API
 *
 * @author (Marwah Zulfanny Alief)
 * @version (06/06/2020)
 */

@RequestMapping("/seller")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController

public class SellerController {

    /**
     *  methods yang terdapat pada Class Seller Controller
     * Untuk melakukan pemberian nilai dan pengambilan nilai value
     */

    /**
     * untuk mengambil seluruh seller pada DatabaseSellerPostgre
     * @return Array List Seller
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Seller> getAllSeller() {
        ArrayList<Seller> list = new ArrayList<>();
        list = DatabaseSeller.getSellerDatabase();
        return list;
    }

    /**
     * untuk mengambil Seller sesuai dengan id pada DatabaseSellerPostgre
     * @return Seller
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id) {
        Seller seller = null;
        try {
            seller = DatabaseSellerPostgre.getSellerById(id);
        } catch (SellerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return seller;

    }

    /**
     * untuk memasukkan data seller dan location sesuai dengan name, email, phone number, province, description, dan city pada DatabaseSellerPostgre dan DatabaseLocationPostgre
     * @params name, email, phone number, province, description,city
     * @return Seller
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value = "name") String name,
                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "phoneNumber") String phoneNumber,
                            @RequestParam(value = "province") String province,
                            @RequestParam(value = "description") String description,
                            @RequestParam(value = "city") String city) {
        Location location = new Location(DatabaseLocationPostgre.getLastLocationId()+1,city, province, description);
        DatabaseLocationPostgre.addLocation(location);
        Seller seller = new Seller(DatabaseSellerPostgre.getLastId() + 1, name, email, phoneNumber,new Location(DatabaseLocationPostgre.getLastLocationId(),city, province, description));
        DatabaseSellerPostgre.addSeller(seller);
        return seller;
    }

    /**
     * untuk menghapus seller sesuai dengan id invoice pada DatabaseSellerPostgre
     * @return Boolean
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeSeller(@PathVariable int id)
    {
        try
        {
            return DatabaseSellerPostgre.removeSeller(id);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
