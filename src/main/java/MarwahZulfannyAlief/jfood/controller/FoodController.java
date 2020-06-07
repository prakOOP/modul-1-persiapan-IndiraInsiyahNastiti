package MarwahZulfannyAlief.jfood.controller;

import MarwahZulfannyAlief.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Class Food Controller berfungi untuk melakukan CRUD database food di PostgreSQL melalui Springboot web REST API
 *
 * @author (Marwah Zulfanny Alief)
 * @version (06/06/2020)
 */

@RequestMapping("/food")
@RestController
public class FoodController {

    /**
     *  methods yang terdapat pada Class Food Controller
     * Untuk melakukan pemberian nilai dan pengambilan nilai value
     */

    /**
     * untuk mengambil seluruh food pada DatabaseFoodPostgre
     * @return Array List Food
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood() throws SQLException, SellerNotFoundException, FoodNotFoundException {
        return DatabaseFoodPostgre.getFood();
    }

    /**
     * untuk mengambil food sesuai dengan id pada DatabaseFoodPostgre
     * @return Food
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id) throws FoodNotFoundException
    {
        Food food = DatabaseFoodPostgre.getFoodById(id);

        return food;
    }

    /**
     * untuk mengambil seluruh food sesuai dengan seller pada DatabaseFoodPostgre
     * @return Array List Food
     */
    @RequestMapping(value = "/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) throws FoodNotFoundException
    {
        ArrayList<Food> food = DatabaseFoodPostgre.getFoodBySeller(sellerId);
        return food;
    }

    /**
     * untuk memasukkan data food sesuai dengan name, price, food category,dan id Seller pada DatabaseFoodPostgre
     * @params name, price, category, sellerId
     * @return Food
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                         @RequestParam(value="price") int price,
                         @RequestParam(value="category") String category,
                         @RequestParam(value="sellerId") int sellerId) throws SellerNotFoundException {
        Food food = null;
        food = new Food(DatabaseFoodPostgre.getLastId() + 1, name, DatabaseSellerPostgre.getSellerById(sellerId), price, DatabaseFoodCategoryPostgre.getFoodCategoryByName(category));
        DatabaseFoodPostgre.addFood(food);
        return food;
    }

    /**
     * untuk memasukkan data food category sesuai dengan name pada DatabaseFoodCategoryPostgre
     * @params name
     * @return FoodCategories
     */
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public FoodCategories addCategories(@RequestParam(value="name") String name) {
        FoodCategories foodCategories = null;
        foodCategories = new FoodCategories(DatabaseFoodCategoryPostgre.getLastId() + 1, name);
        DatabaseFoodCategoryPostgre.addFoodcategory(foodCategories);
        return foodCategories;
    }


}
