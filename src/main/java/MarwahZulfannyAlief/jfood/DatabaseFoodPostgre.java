package MarwahZulfannyAlief.jfood;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class DatabaseFoodPostgre berfungi untuk melakukan koneksi ke database food di PostgreSQL melalui library java.sql
 *
 * @author (Marwah Zulfanny Alief)
 * @version (06/06/2020)
 **/
public class DatabaseFoodPostgre
{
    // membuat atribut dalam Class DatabaseFoodPostgre
    private static final Connection conn = DatabaseConnectionPostgre.connection();
    private static Statement stmt = null;
    private static int lastId=0;


    /**
     * method accesor dalam Class DatabaseFoodPostgre
     * @return lastId untuk mengembalikan nilai atribut
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method accesor dalam Class DatabaseFoodPostgre
     * @return 0 untuk mengembalikan nilai atribut
     */
    public static int getLastFoodId()
    {
        try {
            stmt = conn.createStatement();
            ResultSet foods = stmt.executeQuery("SELECT id FROM jfood_food ORDER BY id DESC LIMIT 1");
            if(foods.next()) {
                return foods.getInt("id");
            }
        } catch (Exception e) { }
        return 0;
    }

    /**
     * method accesor dalam Class DatabaseFoodPostgre
     * @return Food object untuk mengembalikan nilai atribut
     */
    public static Food getFoodById(int id) throws FoodNotFoundException
    {
        try {
            stmt = conn.createStatement();
            ResultSet foods = stmt.executeQuery("SELECT * FROM jfood_food WHERE id='" + id + "'");
            if(foods.next()) {
                int foodId = foods.getInt("id");
                int sellerId = foods.getInt("id_seller");
                int categoryId = foods.getInt("id_category");

                return new Food(foodId, foods.getString("name"), DatabaseSellerPostgre.getSellerById(sellerId), foods.getInt("price"), DatabaseFoodCategoryPostgre.getFoodCategoryById(categoryId));
            } else {
                return null;
            }

        } catch (Exception e) { }
        throw new FoodNotFoundException(id);
    }

    /**
     * method accesor dalam Class DatabaseFoodPostgre
     * @return Food object untuk mengembalikan nilai dalam array
     */
    public static ArrayList<Food> getFoodBySeller(int id) throws FoodNotFoundException
    {
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM jfood_food WHERE id_seller='" + id + "'");

            if(rs.next()) {
                ArrayList<Food> _food = new ArrayList<>();
                Food food = null;
                while (rs.next())
                {
                    int foodid = rs.getInt("id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int categoryId = rs.getInt("id_category");
                    food = new Food(foodid,name,DatabaseSellerPostgre.getSellerById(id),price,DatabaseFoodCategoryPostgre.getFoodCategoryById(categoryId));
                    _food.add(food);
                }
                return _food;
            } else {
                return null;
            }

        } catch (Exception e) { }
        throw new FoodNotFoundException(id);
    }


    /**
     * method boolean mutator dalam Class DatabaseFoodPostgre
     * @param food
     * @return true untuk menambahkan nilai dalam database postre
     */
    public static boolean addFood(Food food)
    {
        try {
            stmt = conn.createStatement();
            String sql = "SELECT id FROM jfood_food WHERE name='"+ food.getName() +"'";
            ResultSet foods = stmt.executeQuery(sql);
            if(!foods.next()) { //cek food sudah ada di table foods, jika belum insert food
                sql = "INSERT INTO jfood_food (name,id_seller,price,id_category) VALUES ('" + food.getName() + "','" + food.getSeller().getId() + "','" + food.getPrice() + "','" + food.getCategories().getId() + "');";
                PreparedStatement prest;
                prest = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                prest.executeUpdate();
                ResultSet rs = prest.getGeneratedKeys();
                if(rs.next()) {
                    lastId = rs.getInt("id");
                }
            } else {
                lastId = foods.getInt("id");
                return false;
            }
        } catch (Exception e) {

        }
        return true;
    }

    /**
     * method boolean mutator dalam Class DatabaseFoodPostgre
     * @param id
     * @return true untuk menghapus nilai dalam database postgre
     */
    public static boolean removeFood(int id) throws FoodNotFoundException{
        try {
            stmt = conn.createStatement();
            stmt.executeQuery("DELETE FROM jfood_food WHERE id ='" + id + "'");
            return true;
        } catch (Exception e) { }
        throw new FoodNotFoundException(id);

    }

    /**
     * method acessor dalam Class DatabaseFoodPostgre
     * @return _food untuk mengembalikkan nilai dalam array
     */
    public static ArrayList<Food> getFood() throws SQLException, SellerNotFoundException, FoodNotFoundException{

        stmt=conn.createStatement();

        String sql = "SELECT * FROM jfood_food;";
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Food> _food = new ArrayList<>();
        Food food = null;
        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int seller_id = rs.getInt("id_seller");
            int price = rs.getInt("price");
            int category_id = rs.getInt("id_category");
            food = new Food(id,name,DatabaseSellerPostgre.getSellerById(seller_id),price,DatabaseFoodCategoryPostgre.getFoodCategoryById(category_id));
            _food.add(food);
        }
        return _food;
    }
}
