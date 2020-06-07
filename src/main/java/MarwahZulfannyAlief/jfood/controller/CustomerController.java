package MarwahZulfannyAlief.jfood.controller;
import MarwahZulfannyAlief.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * Class Customer Controller berfungi untuk melakukan CRUD database customer di PostgreSQL melalui Springboot web REST API
 *
 * @author (Marwah Zulfanny Alief)
 * @version (07/06/2020)
 */



@RequestMapping("/customer")
@RestController
public class CustomerController {

    /**
     *  methods yang terdapat pada Class Customer Controller
     * Untuk melakukan pemberian nilai dan pengambilan nilai value
     */


    @RequestMapping("")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    /**
     * untuk mengambil seluruh customer pada DatabaseCustomer
     * @return Array List Customer
     */
    public ArrayList<Customer> getAllCustomer()
    {
        return DatabaseCustomer.getCustomerDatabase();
    }

    /**
     * untuk mengambil customer sesuai dengan email pada DatabaseCustomerPostgre
     * @return Customer
     */
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public Customer getCustomerIdByEmail(@PathVariable String email){
        Customer customer = null;
        int customerId;
        try {
            customer = DatabaseCustomerPostgre.getCustomerIdbyEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    /**
     * untuk mengambil customer sesuai dengan id pada DatabaseCustomerPostgre
     * @return Customer
     */
    @RequestMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Customer customer = null;
        try {
            customer = DatabaseCustomerPostgre.getCustomerById(id);
        } catch (CustomerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return customer;
    }

    /**
     * untuk memasukkan data customer sesuai dengan name, email, password pada DatabaseCustomerPostgre
     * @params name, email,password
     * @return Customer
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestParam(value="name") String name,
                                     @RequestParam(value="email") String email,
                                     @RequestParam(value="password") String password)
    {
        Customer customer = new Customer(DatabaseCustomer.getLastId()+1, name, email, password);
        try {
            //DatabaseCustomer.addCustomer(customer);
            DatabaseCustomerPostgre.insertCustomer(customer);
        } catch (EmailAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return customer;
    }

    /**
     * untuk melakukan penyocokan data customer saat login sesuai dengan email dan password pada DatabaseCustomerPostgre
     * @params email,password
     * @return Customer
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password)
    {
        Customer customer = DatabaseCustomerPostgre.getCustomerLogin(email, password);
        return customer;
    }
}

