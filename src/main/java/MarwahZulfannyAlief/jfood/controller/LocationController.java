package MarwahZulfannyAlief.jfood.controller;
import MarwahZulfannyAlief.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class Location Controller berfungi untuk melakukan CRUD database location di PostgreSQL melalui Springboot web REST API
 *
 * @author (Marwah Zulfanny Alief)
 * @version (06/06/2020)
 */

@RequestMapping("/location")
@RestController
public class LocationController {

    /**
     *  methods yang terdapat pada Class Location Controller
     * Untuk melakukan pemberian nilai dan pengambilan nilai value
     */

    /**
     * untuk mengambil seluruh location pada DatabaseLocationPostgre
     * @return Array List Location
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Location> getAllLocation() throws SQLException {
        return DatabaseLocationPostgre.getLocation();
    }

    /**
     * untuk mengambil location sesuai dengan id pada DatabaseLocationPostgre
     * @return Location
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Location getLocationById(@PathVariable int id) {
        return DatabaseLocationPostgre.getLocationById(id);
    }

    /**
     * untuk menghapus location sesuai dengan id location pada DatabaseLocationPostgre
     * @return Boolean
     */
        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public boolean removeLocation(@PathVariable int id)
        {
            try
            {
                return DatabaseLocationPostgre.removeLocation(id);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                return true;
            }
        }

    /**
     * untuk memasukkan data location sesuai dengan city, province, dan description pada DatabaseLocationPostgre
     * @params city, province, description
     * @return Location
     */
        @RequestMapping(value = "", method = RequestMethod.POST)
        public Location addLocation(@RequestParam(value="city") String city,
                              @RequestParam(value="province") String province,
                              @RequestParam(value="description") String description)
        {
            Location location = null;
            try {
                location = new Location(DatabaseLocationPostgre.getLastId() + 1, city, province, description);
                DatabaseLocationPostgre.addLocation(location);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return location;
        }
}
