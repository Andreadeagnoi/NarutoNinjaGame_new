package adatimer.narutoninjagamenew;

/** Container for Land's Data
 * Created by Andrea De Agnoi on 15/11/2015.
 */
public class Land {
    private int id;
    private String description;

    public Land(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
