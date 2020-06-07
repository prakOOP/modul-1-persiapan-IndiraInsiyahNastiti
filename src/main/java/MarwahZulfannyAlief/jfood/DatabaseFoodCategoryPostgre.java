package MarwahZulfannyAlief.jfood;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseFoodCategoryPostgre
{
    private static Connection conn = DatabaseConnectionPostgre.connection();
    private static Statement stmt = null;

    private static int lastId=0;


    /**
     * method accesor dalam Class DatabaseFoodCategoryPostgre
     * @return lastId untuk mengembalikan nilai atribut
     */
    public static int getLastId()
    {
        return lastId;
    }

//    /**
//     * method accesor dalam Class DatabaseFoodCategoryPostgre
//     * @return 0 untuk mengembalikan nilai atribut
//     */
//    public static int getLastFoodCategoryId()
//    {
//        try {
//            stmt = conn.createStatement();
//            ResultSet cat = stmt.executeQuery("SELECT id FROM jfood_foodcategory ORDER BY id DESC LIMIT 1");
//            if(cat.next()) {
//                return cat.getInt("id");
//            }
//        } catch (Exception e) { }
//        return 0;
//    }

    public static FoodCategories getFoodCategoryByName(String nameCategory) {
        try {
            stmt = conn.createStatement();
            ResultSet foodCategory = stmt.executeQuery("SELECT * FROM jfood_foodcategory WHERE name='" + nameCategory + "'");
            if(foodCategory.next()) {
                int id_category = foodCategory.getInt("id");
                String name = foodCategory.getString("name");
                return new FoodCategories(id_category, name);
            } else {
                return null;
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    /**
     * method accesor dalam Class DatabaseFoodCategoryPostgre
     * @return FoodCategory object untuk mengembalikan nilai atribut
     */
    public static FoodCategories getFoodCategoryById(int id) {
        try {
            stmt = conn.createStatement();
            ResultSet foodCategory = stmt.executeQuery("SELECT * FROM jfood_foodcategory WHERE id='" + id + "'");
            if(foodCategory.next()) {
                int id_category = foodCategory.getInt("id");
                String name = foodCategory.getString("name");
                return new FoodCategories(id_category, name);
            } else {
                return null;
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

//    /**
//     * method boolean mutator dalam Class DatabaseFoodCategoryPostgre
//     * @param foodCategory
//     * @return true untuk menambahkan nilai dalam database postgre
//     */
    public static boolean addFoodcategory(FoodCategories categories)
    {
        try {
            stmt = conn.createStatement();
            String sql = "SELECT id FROM jfood_foodcategory  WHERE name='"+ categories.getCategory() +"'";
            ResultSet category = stmt.executeQuery(sql);
            if(!category.next()) {
                sql = "INSERT INTO jfood_foodcategory (name) VALUES ('" + categories.getCategory() + "');";
                PreparedStatement prest;
                prest = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                prest.executeUpdate();
                ResultSet rs = prest.getGeneratedKeys();
                if(rs.next()) {
                    lastId = rs.getInt("id");
                }
            } else {
                lastId = category.getInt("id");
                return false;
            }
        } catch (Exception e) { }
        return true;
    }

//    /**
//     * method boolean mutator dalam Class DatabaseFoodCategoryPostgre
//     * @param id
//     * @return true untuk menghapus nilai dalam database postgre
//     */
//    public static boolean removeFoodcategory(int id) {
//        try {
//            stmt = conn.createStatement();
//            stmt.executeQuery("DELETE FROM jfood_foodcategory WHERE id='" + id + "'");
//            return true;
//        } catch (Exception e) { }
//        return false;
//    }

    /**
     * method acessor dalam Class DatabaseFoodCategoryPostgre
     * @return _foodcat untuk mengembalikkan nilai atribut
     */
 /**   public static ArrayList<FoodCategory> getFoodcategory() throws SQLException
    {
        stmt=conn.createStatement();

        String sql = "SELECT * FROM jfood_foodcategory;";
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<FoodCategory> _foodCategory = new ArrayList<>();
        FoodCategories foodCategories = null;
        while (rs.next())
        {
            // int id, String name, Seller seller, int price, FoodCategory category
            int id = rs.getInt("id");
            String category = rs.getString("category");

            foodCategory = new FoodCategories(id,category);
            _foodCategory.add(foodCategory);
        }
        return _foodCategory;
    }**/


}
