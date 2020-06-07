package MarwahZulfannyAlief.jfood;

import java.sql.*;

/**
 * Class DatabasePromoPostgre berfungi untuk melakukan koneksi ke database promo di PostgreSQL melalui library java.sql
 *
 * @author (Marwah Zulfanny Alief)
 * @version (06/06/2020)
 **/
public class DatabasePromoPostgre
{
    private static Connection conn = DatabaseConnectionPostgre.connection();
    private static Statement stmt = null;

    private static int lastId=0;

    public static int getLastPrompId()
    {
        try {
            stmt = conn.createStatement();
            ResultSet promo = stmt.executeQuery("SELECT id FROM jfood_promo ORDER BY id DESC LIMIT 1");
            if(promo.next()) {
                return promo.getInt("id");
            }
        } catch (Exception e) { }
        return 0;
    }

    public static Promo getPromoById(int id) throws PromoNotFoundException {
        try{
            stmt = conn.createStatement();
            ResultSet promo = stmt.executeQuery("SELECT * FROM jfood_promo WHERE id='" + id + "'");
            if(promo.next())
            {
                return new Promo(id,promo.getString("code"),promo.getInt("discount"),promo.getInt("minprice"),promo.getBoolean("active"));
            }else {
                return null;
            }

        } catch (SQLException e) { }
        throw new PromoNotFoundException(id);
    }

    public static Promo getPromoByCode(String code)
    {
        try{
            stmt = conn.createStatement();
            ResultSet promo = stmt.executeQuery("SELECT * FROM jfood_promo WHERE code='" + code + "'");
            if(promo.next())
            {
                return new Promo(promo.getInt("id"),promo.getString("code"),promo.getInt("discount"),promo.getInt("minprice"),promo.getBoolean("active"));
            }else {
                return null;
            }

        } catch (SQLException e) { }
        return null;
    }

    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {
        try {
            stmt = conn.createStatement();
            String sql = "SELECT id FROM jfood_promo WHERE code='"+ promo.getCode() +"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(!rs.next()) { //cek apakah promo sudah ada di table promo, jika belum insert promo
                sql = "INSERT INTO jfood_promo(code,discount,minprice,active) VALUES ('" + promo.getCode() + "','" + promo.getDiscount() + "','" + promo.getMinPrice() + "','" + promo.getActive() + "');";
                PreparedStatement prest;
                prest = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                prest.executeUpdate();
                ResultSet resultSet = prest.getGeneratedKeys();
                if(resultSet.next()) {
                    lastId = resultSet.getInt("id");
                }
            } else {
                lastId = rs.getInt("id");
                return false;
            }
        } catch (Exception e) { }
        return true;
    }

    public static boolean activatePromo(int id) throws SQLException
    {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM jfood_promo WHERE id='" + id + "'");
        Promo promo = new Promo(rs.getInt("id"),rs.getString("code"),rs.getInt("discount"),rs.getInt("minprice"),rs.getBoolean("active"));
        promo.setActive(true);
        return true;
    }

    public static boolean deactivatePromo(int id) throws SQLException
    {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM jfood_promo WHERE id='" + id + "'");
        Promo promo = new Promo(rs.getInt("id"),rs.getString("code"),rs.getInt("discount"),rs.getInt("minprice"),rs.getBoolean("active"));
        promo.setActive(false);
        return true;
    }

    public static boolean removePromo(int id) throws PromoNotFoundException {
        try {
            stmt = conn.createStatement();
            stmt.executeQuery("DELETE FROM jfood_promo WHERE id='" + id + "'");
            return true;
        } catch (Exception e) { }
        throw new PromoNotFoundException(id);
    }


}
