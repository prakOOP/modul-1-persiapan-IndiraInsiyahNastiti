import java.util.ArrayList;

/**
 * Write a description of class DatabasePromo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabasePromo
{
    // instance variables - replace the example below with your own
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList();
    private static int lastId;

    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }
    public static int getLastId()
    {
        return lastId;
    }
    public static Promo getPromoById(int id) throws PromoNotFoundException {
        for(Promo promo : PROMO_DATABASE){
            if (promo.getId() == id){
                return promo;
            }
        }
        throw new PromoNotFoundException(id);
    }
    public  static Promo getPromoByCode(String code)
    {
        for(Promo promo : PROMO_DATABASE){
            if (promo.getCode().equals(code)){
                return promo;
            }
        }
        return null;
    }
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException {
        for (Promo _promo : PROMO_DATABASE) {
            if (_promo.getCode().equals(promo.getCode())){
                throw new PromoCodeAlreadyExistsException(promo);
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }
    public static boolean activatePromo(int id)
    {
        for(Promo promo : PROMO_DATABASE){
            if (promo.getId() == id){
                promo.setActive(true);
                return true;
            }
        }
        return false;
    }
    public static boolean deactivatePromo(int id)
    {
        for(Promo promo : PROMO_DATABASE){
            if (promo.getId() == id){
                promo.setActive(false);
                return true;
            }
        }
        return false;
    }
    public static boolean removePromo(int id) throws PromoNotFoundException {
        for (Promo promo : PROMO_DATABASE){
            if (promo.getId() == id){
                PROMO_DATABASE.remove(promo);
                return true;
            }
        }
        throw new PromoNotFoundException(id);
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   /** public static boolean addPromo(Promo promo)
    {
        // put your code here
        return true;
    }
    public static boolean removePromo(Promo promo)
    {
        // put your code here
        return true;
    }
    public static Promo getPromo()
    {
        // put your code here
        return null;
    }
    public static String[] getListPromo()
    {
        // put your code here
        return listPromo;
    }**/
}
