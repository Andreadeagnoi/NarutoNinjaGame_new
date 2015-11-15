package adatimer.narutoninjagamenew;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Utilizzato per creare il database all'installazione dell'app o aggiornarlo
 * quando l'app viene modificata.
 *
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String TABLE_CHARACTER = "PERSONAGGIO";
    public static final String TABLE_CATEGORY = "CATEGORIA";
    public static final String TABLE_LAND = "VILLAGGIO";
    public static final String TABLE_MODE = "MODALITA";
    public static final String TABLE_JUTSU = "TECNICA";
    public static final String TABLE_CHARACTER_JUTSU = "PERSONAGGIO_TECNICA";
    public static final String TABLE_PARTY = "PARTY";
    public static final String CHARACTER_ID = "ID_personaggio";
    public static final String CHARACTER_SEX = "sesso";
    public static final String LAND_ID = "ID_vil";
    public static final String CATEGORY_ID = "ID_cat";
    public static final String CHARACTER_NAME = "nome";
    public static final String CHARACTER_HP = "punti_vita";
    public static final String CHARACTER_CHAKRA = "chakra";
    public static final String CHARACTER_BASE_ABILITY = "abilita_base";
    public static final String MODE_ID = "ID_mod";
    public static final String CATEGORY_DESC = "descrizione";
    public static final String LAND_DESC = "descrizione_vil";
    public static final String MODE_TYPE = "tipologia";
    public static final String MODE_DESC = "descrizione_mod";
    public static final String JUTSU_ID = "ID_tecnica";
    public static final String JUTSU_ATTRIBUTES = "attributi";
    public static final String JUTSU_NAME = "nome_tecnica";
    public static final String JUTSU_REQ = "requisiti";
    public static final String JUTSU_EFFECTS = "effetti";
    public static final String CHARACTER_JUTSU_ID = "ID_personaggio_tecnica";
    public static final String PARTY_ID = "ID_party";
    public static final String PARTY_MAIN = "main";
    public static final String PARTY_CURRENT = "corrente";
    private static final String DATABASE_NAME = "NarutoNinjaGame_new.db";
    private static final int DATABASE_VERSION = 1;
    // Create table necessari
    private static final String DATABASE_CREATE_PERSONAGGIO =
            "CREATE TABLE " + TABLE_CHARACTER + " (\n" +
            "\t\n" +
                    "\t" + CHARACTER_ID + " VARCHAR(11),\n" +
                    "\t" + CHARACTER_SEX + " VARCHAR(1),\n" +
                    "\t" + LAND_ID + " INT(11),\n" +
                    "\t" + CATEGORY_ID + " INT(11),\n" +
                    "\t" + CHARACTER_NAME + " VARCHAR(100),\n" +
                    "\t" + CHARACTER_HP + " VARCHAR(20),\n" +
                    "\t" + CHARACTER_CHAKRA + " VARCHAR(20), \n" +
                    "\t" + CHARACTER_BASE_ABILITY + " VARCHAR(1000),\n" +
                    "\t" + MODE_ID + " INT(11)\n" +
            "\t\t\n" +
            ");";
    private static final String DATABASE_CREATE_CATEGORIA =
            "CREATE TABLE " + TABLE_CATEGORY + " (\n" +
            "\t\n" +
                    "\t" + CATEGORY_ID + " INT(11),\n" +
                    "\t" + CATEGORY_DESC + " VARCHAR(100)\n" +
            "\t\t\n" +
            ");";
    private static final String DATABASE_CREATE_VILLAGGIO =
            "CREATE TABLE " + TABLE_LAND + "(\n" +
            "\t\n" +
                    "\t" + LAND_ID + " INTEGER,\n" +
                    "\t" + LAND_DESC + " TEXT\n" +
            "\t\t\n" +
            ");";
    // La tipologia conterrà M e A per modalità ed abilità innata
    private static final String DATABASE_CREATE_MODALITA =
            "CREATE TABLE " + TABLE_MODE + "(\n" +
                    "\n" +
                    "\t" + MODE_ID + " INTEGER,\n" +
                    "\t" + MODE_TYPE + " TEXT,\n" +
                    "\t" + MODE_DESC + " TEXT\n" +
                    "\t\n" +
                    ");";
    private static final String DATABASE_CREATE_TECNICA =
            "CREATE TABLE " + TABLE_JUTSU + "(\n" +
                    "\n" +
                    "\t" + JUTSU_ID + " INTEGER,\n" +
                    "\t" + JUTSU_ATTRIBUTES + " TEXT,\n" +
                    "\t " + JUTSU_NAME + " TEXT,\n" +
                    "\t" + JUTSU_REQ + " TEXT,\n" +
                    "\t" + JUTSU_EFFECTS + " TEXT\n" +
                    "\t\n);";
    private static final String DATABASE_CREATE_PERSONAGGIO_TECNICA =
            "CREATE TABLE " + TABLE_CHARACTER_JUTSU + "(\n" +
                    "\n" +
                    "\t" + CHARACTER_JUTSU_ID + " INTEGER,\n" +
                    "\t" + CHARACTER_ID + " INTEGER,\n" +
                    "\t" + JUTSU_ID + " INTEGER\n" +
                    "\t\n" +
                    ");";

    private static final String DATABASE_CREATE_PARTY =
            "CREATE TABLE " + TABLE_PARTY + "(\n" +
                    "\n" +
                    "\t" + PARTY_ID + " INTEGER,\n" +
                    "\t" + PARTY_MAIN + " INTEGER,\n" +
                    "\t" + CHARACTER_ID + " INTEGER,\n" +
                    "\t" + JUTSU_ID + " INTEGER,\n" +
                    "\t" + PARTY_CURRENT + " INTEGER\n" +
                    "\t\n" +
                    ");\n";

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Chiamato da android quando si fa per la prima volta l'accesso al db e
     * questi non esiste.
     */
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_PERSONAGGIO);
        database.execSQL(DATABASE_CREATE_CATEGORIA);
        database.execSQL(DATABASE_CREATE_VILLAGGIO);
        database.execSQL(DATABASE_CREATE_MODALITA);
        database.execSQL(DATABASE_CREATE_TECNICA);
        database.execSQL(DATABASE_CREATE_PERSONAGGIO_TECNICA);
        database.execSQL(DATABASE_CREATE_PARTY);
    }

    /**
     * Chiamato da android quando il db viene aggiornato, cioè quando
     * si installa l'app aggiornata e sono successe modifiche alla struttura del
     * db.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBOpenHelper.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        //TODO: Implementare una volta che modifichiamo il database dopo aver rellato l'app
        onCreate(db);
    }

}