package adatimer.narutoninjagamenew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Scopo di questa app è di essere di supporto al gioco da tavolo Naruto Ninja Game new!
 * Si compone di diversi elementi:
 *  - card database: database contenente informazioni sulle carte del gioco.
 *  - party organizer: utility di supporto al giocatore dove memorizzare le carte della propria squadra.
 *  - enemy setup: utility di supporto al giocatore che impersona i nemici nelle battaglie.
 *
 *  FEATURES FUTURE:
 *  - QR code reader: lettore di QR code proprietari del gioco.
 *  - Map: funzione di navigazione su mappa, con generazione di percorsi minimi considerando i vari tile.
 *  - Manual: manuale di gioco digitale in formato html.
 *  - Live Battle Arena: possibilità di giocare le battaglie in modo automatizzato, senza dadi, carta o penna.
 *
 *  La main activity corrisponde al card database.
 */
public class MainActivity extends AppCompatActivity {
    static DBManager sDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sDb = new DBManager(getBaseContext());
        sDb.open();
        ArrayList<Character> characters = (ArrayList<Character>) sDb.getAllCharactersName();
        if(characters.size() == 0){
            sDb.insertCharacterTemp(new Character("PG-001", "NARUTO"));
            sDb.insertCharacterTemp(new Character("PG-002","SASUKE"));
            sDb.insertCharacterTemp(new Character("PG-003","SAKURA"));
            characters = (ArrayList<Character>) sDb.getAllCharactersName();
        }
        CharacterArrayAdapter adapter = new CharacterArrayAdapter(this, characters);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(adapter);
        final Activity thisActivity = this;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(thisActivity);
                integrator.initiateScan();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            Toast.makeText(getApplicationContext(), scanResult.getContents(),
                    Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class CharacterArrayAdapter extends ArrayAdapter<Character> {
        private static Context sContext;
        private ArrayList<Character> mValues;

        public CharacterArrayAdapter(Context context, ArrayList<Character> values) {
            super(context, R.layout.row_layout, values);
            this.sContext = context;
            this.mValues = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) sContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.row_layout, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.label);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            textView.setText(mValues.get(position).getName());

            return rowView;
        }
    }
}
