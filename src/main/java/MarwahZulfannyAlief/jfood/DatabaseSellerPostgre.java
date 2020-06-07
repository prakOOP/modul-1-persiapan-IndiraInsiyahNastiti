package MarwahZulfannyAlief.jfood;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class DatabaseSellerPostgre berfungi untuk melakukan koneksi ke database seller di PostgreSQL melalui library java.sql
 *
 * @author (Marwah Zulfanny Alief)
 * @version (06/06/2020)
 **/
public class DatabaseSellerPostgre
{
    // membuat atribut dalam Class DatabaseSellerPostgre
    private static Connection conn = DatabaseConnectionPostgre.connection();
    private static Statement stmt = null;
    private static int lastId=0;

    /**
     * method accesor dalam Class DatabaseSellerPostgre
     * @return lastId untuk mengembalikan nilai atribut
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method accesor dalam Class DatabaseSellerPostgre
     * @return 0 untuk mengembalikan nilai atribut
     */
    public static int getLastSellerId()
    {
        try {
            stmt = conn.createStatement();
            ResultSet seller = stmt.executeQuery("SELECT id FROM jfood_seller ORDER BY id DESC LIMIT 1");
            if(seller.next()) {
                return seller.getInt("id");
            }
            else {
                return 0;
            }
        } catch (Exception e) { }
        return 0;
    }

    /**
     * method accesor dalam Class DatabaseSellerPostgre
     * @return Seller object untuk mengembalikan nilai atribut
     */
    public static Seller getSellerById(int id) throws SellerNotFoundException
    {
        try {
            stmt = conn.createStatement();
            ResultSet seller = stmt.executeQuery("SELECT * FROM jfood_seller WHERE id='" + id + "'");
            if(seller.next()) {
//              int id, String name, email, phonenumber, Location location
                int Id = seller.getInt("id");
                String name = seller.getString("name");
                String email = seller.getString("email");
                String phonenumber = seller.getString("phone_number");
                int location_id = seller.getInt("id_location");
                return new Seller(Id, name, email, phonenumber, DatabaseLocationPostgre.getLocationById(location_id));
            } else {
                return null;
            }

        } catch (Exception e) { }
        throw new SellerNotFoundException(id);
    }

    /**
     * method boolean mutator dalam Class DatabaseSellerPostgre
     * @param seller
     * @return true untuk menambahkan nilai dalam database postgre
     */
    public static boolean addSeller(Seller seller)
    {
        try {
            stmt = conn.createStatement();
            String sql = "SELECT id FROM jfood_seller WHERE email='"+ seller.getEmail() +"'";
            ResultSet sellers = stmt.executeQuery(sql);
            if(!sellers.next()) { //cek food sudah ada di table sellers, jika belum insert food
                sql = "INSERT INTO jfood_seller(name,email,phone_number,id_location) VALUES ('" + seller.getName() + "','" + seller.getEmail() + "','" + seller.getPhoneNumber() + "','" + seller.getLocation().getId() + "');";
                PreparedStatement prest;
                prest = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                prest.executeUpdate();
                ResultSet rs = prest.getGeneratedKeys();
                if(rs.next()) {
                    lastId = rs.getInt("id");
                }
            } else {
                lastId = sellers.getInt("id");
                return false;
            }
        } catch (Exception e) { }
        return true;
    }

    /**
     * method boolean mutator dalam Class DatabaseSellerPostgre
     * @param id
     * @return true untuk menghapus nilai dalam database postgre
     */
    public static boolean removeSeller(int id) throws SellerNotFoundException {
        try {
            stmt = conn.createStatement();
            stmt.executeQuery("DELETE FROM jfood_seller WHERE id='" + id + "'");
            return true;
        } catch (Exception e) { }
        throw new SellerNotFoundException(id);
    }

    /**
     * method acessor dalam Class DatabaseSellerPostgre
     * @return _seller untuk mengembalikkan nilai dalam array
     */
    public static ArrayList<Seller> getSeller() throws SQLException
    {
        conn = DatabaseConnectionPostgre.connection();
        stmt=conn.createStatement();

        String sql = "SELECT * FROM jfood_seller;";
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Seller> _seller = new ArrayList<>();
        Seller seller = null;
        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String phonenumber = rs.getString("phone_number");
            int location_id = rs.getInt("id_location");
            seller = new Seller(id,name,email,phonenumber,DatabaseLocationPostgre.getLocationById(location_id));
            _seller.add(seller);
        }
        return _seller;
    }
}
