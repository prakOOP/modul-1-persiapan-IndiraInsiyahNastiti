package MarwahZulfannyAlief.jfood.controller;

import MarwahZulfannyAlief.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class Promo Controller berfungi untuk melakukan CRUD database Promo di PostgreSQL melalui Springboot web REST API
 *
 * @author (Marwah Zulfanny Alief)
 * @version (06/06/2020)
 */


@RequestMapping("/promo")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController

public class PromoController {

    /**
     *  methods yang terdapat pada Class Promo Controller
     * Untuk melakukan pemberian nilai dan pengambilan nilai value
     */

    /**
     * untuk mengambil seluruh Promo pada DatabasePromoPostgre
     * @return Array List Promo
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo(){
        ArrayList<Promo> list = new ArrayList<>();
        list = DatabasePromo.getPromoDatabase();
        return list;
    }

    /**
     * untuk mengambil promo sesuai dengan code pada DatabasePromoPostgre
     * @return Promo
     */
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code) {
        Promo promo = null;
        promo = DatabasePromoPostgre.getPromoByCode(code);

        return promo;

    }

    /**
     * untuk memasukkan data promo sesuai dengan code, discount, minimal price, dan active pada DatabasePromoPostgre
     * @params code, discount, minPrice,active
     * @return Promo
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value = "code")String code,
                            @RequestParam(value = "discount")int discount,
                            @RequestParam(value = "minPrice")int minPrice,
                            @RequestParam(value = "active")Boolean active){
        Promo promo = new Promo(DatabasePromo.getLastId() + 1,code, discount,minPrice, active);
        try {
            DatabasePromoPostgre.addPromo(promo);
            DatabasePromoPostgre.getPromoByCode(promo.getCode());
            return promo;
        }
        catch (PromoCodeAlreadyExistsException e){
            e.getMessage();
        }
        return null;
    }
}
