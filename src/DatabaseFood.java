import java.util.ArrayList;

/**
 * Write a description of class DatabaseFood here.
 *
 * @author (Marwah Zulfanny Alief)
 * @version (27/02/2020)
 */
public class DatabaseFood {
    // instance variables - replace the example below with your own
    private static ArrayList <Food> FOOD_DATABASE = new ArrayList();
    private static int lastId;



    

    /**
     *  methods yang terdapat pada Class Customer
     * Untuk melakukan pemberian nilai dan pengambilan nilai value
     * Pemberian nilai dengan setVariable()
     * Pengambilan nilai dengan getVariable()
     */
    
    /**
     * untuk menambahkan objek food
     * @return true 
     */
    public static ArrayList<Food> getFoodDatabase()
    {
        // put your code here
        return FOOD_DATABASE;
    }
     /**
     * untuk menghapus objek food
     * @return true 
     */
    public static int getLastId()
    {
        // put your code here
        return lastId;
    }
    public static Food getFoodById(int id) throws FoodNotFoundException {
        // put your code here
        for(Food food : FOOD_DATABASE){
            if (food.getId() == id){
                return food;
            }
        }
        throw new FoodNotFoundException(id);
    }
    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        // put your code here
        ArrayList<Food> list = new ArrayList<>();
        for(Food food : FOOD_DATABASE){
            if (food.getSeller().getId() == sellerId){
                list.add(food);
            }
        }
        return list;
    }
    public static ArrayList<Food> getFoodByCategory(FoodCategory category)
    {
        // put your code here
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (Food food : FOOD_DATABASE){
            if (food.getCategory().equals(category)){
                foodList.add(food);
            }
        }
        return foodList;
    }
    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }
    public static boolean removeFood(int id) throws FoodNotFoundException {
        for (Food food : FOOD_DATABASE){
            if (food.getId() == id){
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
        throw new FoodNotFoundException(id);

    }
}
