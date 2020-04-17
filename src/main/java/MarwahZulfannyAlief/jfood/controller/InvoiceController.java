package MarwahZulfannyAlief.jfood.controller;
import MarwahZulfannyAlief.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController


public class InvoiceController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        ArrayList<Invoice> list = new ArrayList<>();
        list = DatabaseInvoice.getInvoiceDatabase();
        return list;
    }

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

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomerId(@PathVariable int customerId) {
        ArrayList<Invoice> list = new ArrayList<>();
        list = DatabaseInvoice.getInvoiceByCustomer(customerId);
        return list;
    }

    @RequestMapping(value = "/invoiceStatus/{id}",method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id, InvoiceStatus status){
        Invoice invoice = null;
        DatabaseInvoice.changeInvoiceStatus(id, status);
        try {
            return DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
        }
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id){
        try {
            DatabaseInvoice.removeInvoice(id);
            return true;
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
        }
        return false;
    }

   /** @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foodIdList")ArrayList<Integer> foodIdList,
                          @RequestParam(value = "customerId")int customerId,
                          @RequestParam(value = "deliveryFee")int deliveryFee){

        try {
            ArrayList<Food> foods = new ArrayList<>();
            for (int foodId : foodIdList.get()) {
                foods.add(DatabaseFood.getFoodById());
            }
            CashInvoice cashInvoice = new CashInvoice(DatabaseInvoice.getLastId() + 1,foodIdList,DatabaseCustomer.getCustomerById(customerId),deliveryFee);
        }catch (CustomerNotFoundException e){
            e.getMessage();
        }
        try {
            DatabasePromo.addPromo(promo);
            DatabasePromo.getPromoByCode(promo.getCode());
            return promo;
        }
        catch (PromoCodeAlreadyExistsException e){
            e.getMessage();
        }
        return null;
    }**/
}
