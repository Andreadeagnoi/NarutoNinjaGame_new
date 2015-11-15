package adatimer.narutoninjagamenew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
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
        mDatabase.insert(DBOpenHelper.TABLE_CHARACTER, null, values);
        return ;
    }

    /**
     *
     * @return a list with all the characters name and id in the db.
     */
    public List<Character> getAllCharactersName() {
        List<Character> characters = new ArrayList<Character>();
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

    private Character cursorToCharacter(Cursor cursor){
        Character character = new Character(cursor.getString(0),cursor.getString(1));
        return character;
    }

}

