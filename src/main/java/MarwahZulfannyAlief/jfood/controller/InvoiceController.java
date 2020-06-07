package MarwahZulfannyAlief.jfood.controller;
import MarwahZulfannyAlief.jfood.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Class Invoice Controller berfungi untuk melakukan CRUD database invoice
 *
 * @author (Marwah Zulfanny Alief)
 * @version (06/06/2020)
 */

@RequestMapping("/invoice")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController


public class InvoiceController {

    /**
     *  methods yang terdapat pada Class Invoice Controller
     * Untuk melakukan pemberian nilai dan pengambilan nilai value
     */

    /**
     * untuk mengambil seluruh invoice pada DatabaseInvoice
     * @return Array List Invoice
     */

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        ArrayList<Invoice> list = new ArrayList<>();
        list = DatabaseInvoice.getInvoiceDatabase();
        return list;
    }


    /**
     * untuk mengambil invoice sesuai dengan id pada DatabaseInvoice
     * @return Invoice
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * untuk mengambil seluruh invoice sesuai dengan id customer pada DatabaseInvoice
     * @return Array List Invoice
     */
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomerId(@PathVariable int customerId) {
        ArrayList<Invoice> list = new ArrayList<>();
        list = DatabaseInvoice.getInvoiceByCustomer(customerId);
        return list;
    }

    /**
     * untuk melakukan set variable InvoiceStatus dari invoice sesuai dengan id invoice pada DatabaseInvoice
     * @params invoiceStatus
     * @return Invoice
     */
    @RequestMapping(value = "/invoiceStatus/{id}",method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id, @RequestParam (value = "invoiceStatus") InvoiceStatus status){

        try {
            Invoice invoice = DatabaseInvoice.getInvoiceById(id);
            invoice.setTotalPrice();
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
            DatabaseInvoice.changeInvoiceStatus(id, status);
            try {
                return DatabaseInvoice.getInvoiceById(id);
            } catch (InvoiceNotFoundException ex) {
                ex.getMessage();
                return null;
            }

    }


    /**
     * untuk menghapus invoice sesuai dengan id invoice pada DatabaseInvoice
     * @return Boolean
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id){
        try {
            DatabaseInvoice.removeInvoice(id);
            return true;
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return false;
        }

    }

    /**
     * untuk memasukkan data cash invoice sesuai dengan array list food id, id customer, dan delivery fee pada DatabaseInvoice
     * @params foodIdList, customerId, deliveryFee
     * @return Invoice
     */
    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foodIdList")ArrayList<Integer> foodIdList,
                          @RequestParam(value = "customerId")int customerId,
                          @RequestParam(value = "deliveryFee", required = false, defaultValue = "0")int deliveryFee){

            ArrayList<Food> foods = new ArrayList<>();
            for (int foodId : foodIdList) {
                try {
                    foods.add(DatabaseFoodPostgre.getFoodById(foodId));
                } catch (FoodNotFoundException e) {
                    e.getMessage();
                    return null;
                }
            }

        try {
            Invoice cashInvoice = new CashInvoice(DatabaseInvoice.getLastId() + 1,foods, DatabaseCustomerPostgre.getCustomerById(customerId),deliveryFee);
            DatabaseInvoice.addInvoice(cashInvoice);
            cashInvoice.getDate();
            cashInvoice.setTotalPrice();
            return cashInvoice;
        } catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }

    }

    /**
     * untuk memasukkan data cashless invoice sesuai dengan array list food id, id customer, dan promo code pada DatabaseInvoice
     * @params foodIdList, customerId, promoCode
     * @return Invoice
     */
    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "foodIdList")ArrayList<Integer> foodIdList,
                                  @RequestParam(value = "customerId")int customerId,
                                  @RequestParam(value = "promoCode",required = false)String promoCode){


        ArrayList<Food> foods = new ArrayList<>();
        for (int foodId : foodIdList) {
            try {
                foods.add(DatabaseFoodPostgre.getFoodById(foodId));
            } catch (FoodNotFoundException e) {
                e.getMessage();
                return null;
            }
        }
        try {
            Invoice cashlessInvoice = null;
            if (promoCode.isEmpty()){
                cashlessInvoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1,foods, DatabaseCustomerPostgre.getCustomerById(customerId));
            }
            else {
                cashlessInvoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1,foods, DatabaseCustomerPostgre.getCustomerById(customerId),DatabasePromoPostgre.getPromoByCode(promoCode));
            }
            DatabaseInvoice.addInvoice(cashlessInvoice);
            cashlessInvoice.getDate();
            cashlessInvoice.setTotalPrice();
            return cashlessInvoice;
        } catch (CustomerNotFoundException |OngoingInvoiceAlreadyExistsException  e) {
            e.getMessage();
            return null;
        }


    }
}
