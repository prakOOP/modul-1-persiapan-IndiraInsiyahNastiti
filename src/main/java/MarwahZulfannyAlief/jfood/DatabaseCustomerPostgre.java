package MarwahZulfannyAlief.jfood;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Class DatabaseCustomerPostgre berfungi untuk melakukan koneksi ke database customer di PostgreSQL melalui library java.sql
 *
 * @author (Marwah Zulfanny Alief)
 * @version (06/06/2020)
 */

public class DatabaseCustomerPostgre {

    // instance variables conn, stmt, lastId
    private static Connection conn = DatabaseConnectionPostgre.connection();
    private static Statement stmt = null;

    private static int lastId=0;

    /**
     *  methods yang terdapat pada Class DatabaseCustomerPostgre
     * Untuk melakukan pemberian nilai dan pengambilan nilai value
     * pada databse Customer di PostgreSQL
     */

    /**
     * untuk mengambil nilai dari variable lastId
     * @return lastId
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * untuk mengambil nilai id terakhir pada database customer di PostgreSQL
     * @return integer customers.getInt("id");
     */
    public static int getLastCustomerId()
    {
        try {
            stmt = conn.createStatement();
            ResultSet customers = stmt.executeQuery("SELECT id FROM jfood_customer ORDER BY id DESC LIMIT 1");
            if(customers.next()) {
                return customers.getInt("id");
            }
        } catch (Exception e) { }
        return 0;
    }

    /**
     * untuk mengambil customer sesuai dengan email pada Database Customer di PostgreSQL
     * @return Customer
     */
    public static Customer getCustomerIdbyEmail(String email)
    {
        try {
            stmt = conn.createStatement();
            ResultSet customers = stmt.executeQuery("SELECT * FROM jfood_customer WHERE email='" + email + "'");
            if(customers.next()) {
                int year = Integer.parseInt(customers.getString("joindate").substring(0,3));
                int month = Integer.parseInt(customers.getString("joindate").substring(5,6));
                int dayOfMonth = Integer.parseInt(customers.getString("joindate").substring(8,9));
                Calendar joinDate = new GregorianCalendar(year, month, dayOfMonth);
                return new Customer(customers.getInt("id"), customers.getString("name"), customers.getString("email"), customers.getString("password"), joinDate);
            }else {
                return null;
            }
        } catch (Exception e) { }
     return null;
    }

    /**
     * untuk mengambil customer sesuai dengan id pada Database Customer di PostgreSQL
     * @return Customer
     */
    public static Customer getCustomerById(int id) throws CustomerNotFoundException
    {
        try {
            stmt = conn.createStatement();
            ResultSet customers = stmt.executeQuery("SELECT * FROM jfood_customer WHERE id='" + id + "'");
            if(customers.next()) {
                int year = Integer.parseInt(customers.getString("joindate").substring(0,3));
                int month = Integer.parseInt(customers.getString("joindate").substring(5,6));
                int dayOfMonth = Integer.parseInt(customers.getString("joindate").substring(8,9));
                Calendar joinDate = new GregorianCalendar(year, month, dayOfMonth);
                return new Customer(id, customers.getString("name"), customers.getString("email"), customers.getString("password"), joinDate);
            } else {
                return null;
            }

        } catch (Exception e) { }
        throw new CustomerNotFoundException(id);
    }

    /**
     * untuk memasukkan data customer sesuai dengan name, email, password, dan joindate pada Database Customer di PostgreSQL
     * @params Customer
     * @return Customer
     */
    public static boolean insertCustomer(Customer customer) throws EmailAlreadyExistsException
    {
        try {
            stmt = conn.createStatement();
            String sql = "SELECT id FROM jfood_customer  WHERE email='"+ customer.getEmail() +"'";
            ResultSet customers = stmt.executeQuery(sql);
            if(!customers.next()) { //cek apakah email sudah ada di table customers, jika belum insert customer
                sql = "INSERT INTO jfood_customer (name,email,password,joindate) VALUES ('" + customer.getName() + "','" + customer.getEmail() + "','" + customer.getPassword() + "',CURRENT_TIMESTAMP);";
                PreparedStatement prest;
                prest = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                prest.executeUpdate();
                ResultSet rs = prest.getGeneratedKeys();
                if(rs.next()) {
                    lastId = rs.getInt("id");
                }
            } else {
                lastId = customers.getInt("id");
                return false;
            }
        } catch (Exception e) { }
        return true;
    }

    /**
     * untuk menghapus customer sesuai dengan id invoice pada Database Customer di PostgreSQL
     * @return Boolean
     */
    public static boolean removeCustomer(int id) throws CustomerNotFoundException {
        try {
            stmt = conn.createStatement();
            stmt.executeQuery("DELETE FROM jfood_customer WHERE id='" + id + "'");
            return true;
        } catch (Exception e) { }
        throw new CustomerNotFoundException(id);
    }

    /**
     * untuk melakukan penyocokan data customer saat login sesuai dengan email dan password pada Database Customer di PostgreSQL
     * @params email,password
     * @return Customer
     */
    public static Customer getCustomerLogin(String email, String password)
    {
        try {
            stmt = conn.createStatement();
            ResultSet customers = stmt.executeQuery("SELECT * FROM jfood_customer WHERE email = '" + email + "'");
            if(customers.next()) {
                if(customers.getString("password").contentEquals(password)){
                    int year = Integer.parseInt(customers.getString("joindate").substring(0,3));
                    int month = Integer.parseInt(customers.getString("joindate").substring(5,6));
                    int dayOfMonth = Integer.parseInt(customers.getString("joindate").substring(8,9));
                    Calendar joinDate = new GregorianCalendar(year, month, dayOfMonth);
                    return new Customer(customers.getInt("id"), customers.getString("name"), customers.getString("email"), customers.getString("password"), joinDate);
                }
            }
        } catch (Exception e) { }
        return null;
    }
}
