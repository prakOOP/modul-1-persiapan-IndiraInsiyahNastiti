package MarwahZulfannyAlief.jfood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class DatabaseConnectionPostgre berfungi untuk melakukan koneksi ke database di PostgreSQL melalui library java.sql
 *
 * @author (Marwah Zulfanny Alief)
 * @version (05/06/2020)
 */
public class DatabaseConnectionPostgre
{
    /**
     *  methods yang terdapat pada ClassDatabaseConnectionPostgre
     * untuk melakukan koneksi database
     * @return Connetion
     */
    public static Connection connection()
    {
        Connection c =null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jfood_marwahzulfannyalief",
                    "postgres","");
            System.out.println("Opened database successfully");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (SQLException e) {
            e.getMessage();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);
        }
        return c;
    }

}
