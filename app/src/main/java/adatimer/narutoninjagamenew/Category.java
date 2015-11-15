package adatimer.narutoninjagamenew;

/** Container for Category's data
 * Created by Andrea De Agnoi on 15/11/2015.
 */
public class Category {
    private String id;
    private String description;

    public Category(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
