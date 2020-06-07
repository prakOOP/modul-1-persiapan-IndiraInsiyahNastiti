package MarwahZulfannyAlief.jfood;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class DatabaseLocationPostgre berfungi untuk melakukan koneksi ke database location di PostgreSQL melalui library java.sql
 *
 * @author (Marwah Zulfanny Alief)
 * @version (06/06/2020)
 **/
public class DatabaseLocationPostgre {
    // membuat atribut dalam Class DatabaseLocationPostgre
    private static Connection conn = DatabaseConnectionPostgre.connection();
    private static Statement stmt = null;
    private static int lastId=0;

    /**
     * method accesor dalam Class DatabaseLocationPostgre
     * @return lastId untuk mengembalikan nilai atribut
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method accesor dalam Class Database Lcation di PostgreSQL
     * @return 0 untuk mengembalikan nilai atribut
     */
    public static int getLastLocationId()
    {
        try {
            stmt = conn.createStatement();
            ResultSet location = stmt.executeQuery("SELECT id FROM jfood_location ORDER BY id DESC LIMIT 1");
            if(location.next()) {
                return location.getInt("id");
            }
            else {
                return 0;
            }
        } catch (Exception e) { }
        return 0;
    }

    /**
     * method accesor dalam Class DatabaseLocationPostgre
     * @return Location object untuk mengembalikan nilai atribut
     */
    public static Location getLocationById(int id)
    {
        try {
            stmt = conn.createStatement();
            ResultSet location = stmt.executeQuery("SELECT * FROM jfood_location WHERE id='" + id + "'");
            if(location.next()) {
                return new Location(location.getInt("id"), location.getString("city"), location.getString("province"), location.getString("description"));
            } else {
                return null;
            }

        } catch (Exception e) { }
        return null;
    }

    /**
     *method boolean mutator dalam Class Database Location di PostgreSQL
     * @param location
     * @return true untuk menambahkan nilai dalam database postgre
    **/
   public static boolean addLocation(Location location)
    {
        try {
            stmt = conn.createStatement();
                String sql = "INSERT INTO jfood_location (city,province,description) VALUES ('" + location.getCity() + "','" + location.getProvince() + "','" + location.getDescription() + "');";
                PreparedStatement prest;
                prest = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                prest.executeUpdate();
                ResultSet rs = prest.getGeneratedKeys();
                if(rs.next()) {
                    lastId = rs.getInt("id");
                }

        } catch (Exception e) { }
        return true;
      }

    /**
     * method boolean mutator dalam Class Database Location di PostgreSQL
     * @param id
     * @return true untuk menghapus nilai dalam database postgre
     */
   public static boolean removeLocation(int id) {
        try {
            stmt = conn.createStatement();
            stmt.executeQuery("DELETE FROM jfood_location WHERE id='" + id + "'");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * method acessor dalam Class Database Location di PostgreSQL
     * @return _location untuk mengembalikkan nilai atribut
     */
    public static ArrayList<Location> getLocation() throws SQLException
    {
        stmt=conn.createStatement();

        String sql = "SELECT * FROM jfood_location;";
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Location> _location = new ArrayList<>();
        Location location = null;
        while (rs.next())
        {
            // int id, String name, Seller seller, int price, FoodCategory category
            int id = rs.getInt("id");
            String city = rs.getString("city");
            String province = rs.getString("province");
            String description = rs.getString("description");

            location = new Location(id,city,province,description);
            _location.add(location);
        }
        return _location;
    }
}
