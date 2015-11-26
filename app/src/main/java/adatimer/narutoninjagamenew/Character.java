package adatimer.narutoninjagamenew;

import java.util.ArrayList;

/** Container for Character's data.
 *CHARACTER_ID + " INT(11),\n" +
 "\t" + CHARACTER_SEX + " VARCHAR(1),\n" +
 "\t" + LAND_ID + " INT(11),\n" +
 "\t" + CATEGORY_ID + " INT(11),\n" +
 "\t" + CHARACTER_NAME + " VARCHAR(100),\n" +
 "\t" + CHARACTER_HP + " VARCHAR(20),\n" +
 "\t" + CHARACTER_CHAKRA + " VARCHAR(20), \n" +
 "\t" + CHARACTER_BASE_ABILITY + " VARCHAR(1000),\n" +
 "\t" + MODE_ID + " INT(11)\n" +
 * Created by Andrea De Agnoi on 15/11/2015.
 */
public class Character {
    private String id;
    private char sex;
    private Land land;
    private Category category;
    private String name;
    private String hp;
    private String chakra;
    private String baseAbility;
    private Mode mode;
    private ArrayList<Jutsu> jutsus = new ArrayList<Jutsu>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getChakra() {
        return chakra;
    }

    public void setChakra(String chakra) {
        this.chakra = chakra;
    }

    public String getBaseAbility() {
        return baseAbility;
    }

    public void setBaseAbility(String baseAbility) {
        this.baseAbility = baseAbility;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public ArrayList<Jutsu> getJutsus() {
        return jutsus;
    }

    public void setJutsus(ArrayList<Jutsu> jutsus) {
        this.jutsus = jutsus;
    }

    // Temporary constructor for test purpose
    public Character(String id, String name, String hp, String chakra, String baseAbility, Category category, Land land) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.chakra = chakra;
        this.baseAbility = baseAbility;
        this.category = category;
        this.land = land;
    }

    public Character(String id, String name) {
        this.id = id;
        this.name = name;
    }


}
