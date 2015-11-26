package adatimer.narutoninjagamenew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** This class will perform various operations on the database.
 *  Query for characters (id+name for previews and full data for viewing info)
 *  Save a character's data
 * Created by Andrea De Agnoi on 15/11/2015.
 */

public class DBManager {
    private SQLiteDatabase mDatabase;
    private DBOpenHelper mDbHelper;


    public DBManager(Context ctx) {
        mDbHelper = new DBOpenHelper(ctx);
        }
    public void open() throws SQLException {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    /**
     * Inserts a new character in the database, ONLY WITH NAME AND ID.
     * @param newCharacter the character to be inserted
     */
    public void insertCharacterTemp(Character newCharacter){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.CHARACTER_ID, newCharacter.getId());
        values.put(DBOpenHelper.CHARACTER_NAME, newCharacter.getName());
        values.put(DBOpenHelper.CATEGORY_ID, newCharacter.getCategory().getId());
        values.put(DBOpenHelper.LAND_ID, newCharacter.getLand().getId());
        values.put(DBOpenHelper.CHARACTER_HP, newCharacter.getHp());
        values.put(DBOpenHelper.CHARACTER_CHAKRA, newCharacter.getChakra());
        values.put(DBOpenHelper.CHARACTER_BASE_ABILITY, newCharacter.getBaseAbility());
        mDatabase.insert(DBOpenHelper.TABLE_CHARACTER, null, values);
        return ;
    }

    /**
     *
     * @return a list with all the characters name and id in the db.
     */
    public List<Character> getAllCharactersName() {
        List<Character> characters = new ArrayList<>();
        String[] columns = {DBOpenHelper.CHARACTER_ID, DBOpenHelper.CHARACTER_NAME};
        Cursor cursor = mDatabase.query(DBOpenHelper.TABLE_CHARACTER,
                columns, null, null, null, null,
                DBOpenHelper.CHARACTER_ID + " DESC");
        if (cursor.getCount() == 0) {
            cursor.close();
            return characters;
        }
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Character character = cursorToCharacter(cursor);
            characters.add(character);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return characters;
    }

    /**
     * Get a character infos by id from the db
     * @param characterId the id of the character
     * @return all the info about the character
     */
    public Character getCharacterById(String characterId){
        Character character;
        String[] columns = {DBOpenHelper.CHARACTER_ID, DBOpenHelper.CHARACTER_SEX, DBOpenHelper.LAND_ID,
                                DBOpenHelper.CATEGORY_ID, DBOpenHelper.CHARACTER_NAME, DBOpenHelper.CHARACTER_HP,
                                    DBOpenHelper.CHARACTER_CHAKRA, DBOpenHelper.CHARACTER_BASE_ABILITY};
        Cursor cursor = mDatabase.query(DBOpenHelper.TABLE_CHARACTER,
                columns, DBOpenHelper.CHARACTER_ID + " LIKE '" + characterId +"'", null, null, null,
                DBOpenHelper.CHARACTER_ID + " DESC");
        cursor.moveToFirst();
        character = cursorToCharacter(cursor);

        cursor.close();
        // add jutsu to character with another query

        return character;
    }

    private Character cursorToCharacter(Cursor cursor){
        Character character;
        if(cursor.getColumnCount() > 2) {
            character = new Character(cursor.getString(0),cursor.getString(4));

            character.setLand(MainActivity.LANDS.get(cursor.getInt(2)));
            character.setCategory(MainActivity.CATEGORIES.get(cursor.getInt(3)));
            character.setHp(cursor.getString(4));
            character.setChakra(cursor.getString(5));
            character.setBaseAbility(cursor.getString(6));

        }
        else {
            character = new Character(cursor.getString(0),cursor.getString(1));
        }
        return character;
    }

    private Land cursorToLand(Cursor cursor){
        Land land;
        land = new Land(cursor.getInt(0),cursor.getString(1));
        return land;
    }

    private Category cursorToCategory(Cursor cursor){
        Category category;
        category = new Category(cursor.getInt(0),cursor.getString(1));
        return category;
    }



    public HashMap<Integer,Land> getAllLands(){
        HashMap<Integer,Land> lands = new HashMap<>();
        String[] columns = {DBOpenHelper.LAND_ID, DBOpenHelper.LAND_DESC};
        Cursor cursor = mDatabase.query(DBOpenHelper.TABLE_LAND,
                columns, null, null, null, null,
                DBOpenHelper.LAND_ID + " DESC");
        if (cursor.getCount() == 0) {
            cursor.close();
            return lands;
        }
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Land land = cursorToLand(cursor);
            lands.put(land.getId(), land);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return lands;
    }

    public HashMap<Integer,Category> getAllCategories(){
        HashMap<Integer,Category> categories = new HashMap<>();
        String[] columns = {DBOpenHelper.CATEGORY_ID, DBOpenHelper.CATEGORY_DESC};
        Cursor cursor = mDatabase.query(DBOpenHelper.TABLE_CATEGORY,
                columns, null, null, null, null,
                DBOpenHelper.CATEGORY_ID + " DESC");
        if (cursor.getCount() == 0) {
            cursor.close();
            return categories;
        }
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Category category = cursorToCategory(cursor);
            categories.put(category.getId(), category);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return categories;
    }
}

