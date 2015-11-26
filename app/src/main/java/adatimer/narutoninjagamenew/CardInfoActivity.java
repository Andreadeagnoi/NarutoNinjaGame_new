package adatimer.narutoninjagamenew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardInfoActivity extends AppCompatActivity {
    static DBManager sDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_info);

        Intent intent = getIntent();
        sDb = new DBManager(getBaseContext());
        sDb.open();
        Character currentCharacter = sDb.getCharacterById( intent.getStringExtra("CharacterId"));

        TextView nameField = (TextView) findViewById(R.id.characterName);
        TextView categoryField = (TextView) findViewById(R.id.category);
        TextView landField = (TextView) findViewById(R.id.land);
        TextView healthPointsField = (TextView) findViewById(R.id.healthPoints);
        TextView chakraPointsField = (TextView) findViewById(R.id.chakraPoints);
        TextView baseAbilityField = (TextView) findViewById(R.id.baseAbility);
        TextView modeTypeField = (TextView) findViewById(R.id.modeType);
        TextView modeDescriptionField = (TextView) findViewById(R.id.modeDescription);
        ListView jutsuList = (ListView) findViewById(R.id.jutsuListView);
        ArrayList<Jutsu> jutsus = new ArrayList<Jutsu>();
        JutsuArrayAdapter jutsuAdapter = new JutsuArrayAdapter(this, jutsus);

        nameField.setText(currentCharacter.getName());
        categoryField.setText(currentCharacter.getCategory().getDescription());
        healthPointsField.setText(currentCharacter.getHp());
        chakraPointsField.setText(currentCharacter.getChakra());
        baseAbilityField.setText(currentCharacter.getBaseAbility());
        landField.setText(currentCharacter.getLand().getDescription());

    }

    public static class JutsuArrayAdapter extends ArrayAdapter<Jutsu> {
        private static Context sContext;
        private ArrayList<Jutsu> mValues;

        public JutsuArrayAdapter(Context context, ArrayList<Jutsu> values) {
            super(context, R.layout.row_layout_jutsu, values);
            this.sContext = context;
            this.mValues = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) sContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.row_layout_jutsu, parent, false);
            TextView jutsuNameField = (TextView) rowView.findViewById(R.id.jutsuName);
            TextView jutsuAttributesField = (TextView) rowView.findViewById(R.id.jutsuAttributes);
            TextView jutsuRequirementsField = (TextView) rowView.findViewById(R.id.jutsuRequirements);
            TextView jutsuEffectField = (TextView) rowView.findViewById(R.id.jutsuEffects);
            jutsuNameField.setText(mValues.get(position).getName());
            jutsuAttributesField.setText(mValues.get(position).getAttributes());
            jutsuRequirementsField.setText(mValues.get(position).getRequirements());
            jutsuEffectField.setText(mValues.get(position).getEffect());

            return rowView;
        }
    }
}



