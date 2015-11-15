package adatimer.narutoninjagamenew;

/** Container for Mode's data
 * Created by Andrea De Agnoi on 15/11/2015.
 */
public class Mode {
    private int id;
    private String type;
    private String desc;

    public Mode(int id, String type, String desc) {
        this.id = id;
        this.type = type;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
