package MarwahZulfannyAlief.jfood.controller;

import MarwahZulfannyAlief.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/promo")
@RestController

public class PromoController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo(){
        ArrayList<Promo> list = new ArrayList<>();
        list = DatabasePromo.getPromoDatabase();
        return list;
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code) {
        Promo promo = null;
        promo = DatabasePromo.getPromoByCode(code);

        return promo;

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value = "code")String code,
                            @RequestParam(value = "discount")int discount,
                            @RequestParam(value = "minPrice")int minPrice,
                            @RequestParam(value = "active")Boolean active){
        Promo promo = new Promo(DatabasePromo.getLastId() + 1,code, discount,minPrice, active);
        try {
            DatabasePromo.addPromo(promo);
            DatabasePromo.getPromoByCode(promo.getCode());
            return promo;
        }
        catch (PromoCodeAlreadyExistsException e){
            e.getMessage();
        }
        return null;
    }
}
