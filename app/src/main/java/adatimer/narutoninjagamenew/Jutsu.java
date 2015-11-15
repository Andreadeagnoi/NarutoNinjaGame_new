package adatimer.narutoninjagamenew;

/** Container for jutsu's data
 * JUTSU_ID + " INTEGER,\n" +
 "\t" + JUTSU_ATTRIBUTES + " TEXT,\n" +
 "\t " + JUTSU_NAME + " TEXT,\n" +
 "\t" + JUTSU_REQ + " TEXT,\n" +
 "\t" + JUTSU_EFFECTS + " TEXT\n" +
 * Created by Andrea De Agnoi on 15/11/2015.
 */
public class Jutsu {
    private int id;
    private String attributes;
    private String name;
    private String requirements;
    private String effects;

    public Jutsu(int id, String attributes, String name, String requirements, String effects) {
        this.id = id;
        this.attributes = attributes;
        this.name = name;
        this.requirements = requirements;
        this.effects = effects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }
}
