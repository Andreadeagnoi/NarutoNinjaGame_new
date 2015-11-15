package adatimer.narutoninjagamenew;

/** Container for Land's Data
 * Created by Andrea De Agnoi on 15/11/2015.
 */
public class Land {
    private int id;
    private String description;

    public Land(String description, int id) {
        this.description = description;
        this.id = id;
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
