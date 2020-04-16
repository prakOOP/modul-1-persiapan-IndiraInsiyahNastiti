package MarwahZulfannyAlief.jfood.controller;


import MarwahZulfannyAlief.jfood.*;
import jdk.jfr.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/food")
@RestController


public class FoodController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood(){
        ArrayList<Food> list = new ArrayList<>();
        list = DatabaseFood.getFoodDatabase();
        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id) {
        Food food = null;
        try {
            food = DatabaseFood.getFoodById(id);
        } catch (FoodNotFoundException e) {
            e.getMessage();
            return null;
        }
        return food;
    }

    @RequestMapping(value = "/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        ArrayList<Food> list = new ArrayList<>();
            list = DatabaseFood.getFoodBySeller(sellerId);
        return list;
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) {
        ArrayList<Food> list = new ArrayList<>();
        list = DatabaseFood.getFoodByCategory(category);
        return list;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value = "name")String name,
                        @RequestParam(value = "price")int price,
                        @RequestParam(value = "category")FoodCategory category,
                        @RequestParam(value = "sellerId") int sellerId){

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1,name, DatabaseSeller.getSellerById(sellerId),price,category));
            return getFoodById(DatabaseFood.getLastId());
        } catch (SellerNotFoundException e) {
            e.getMessage();
        }
        return null;

    }



}

