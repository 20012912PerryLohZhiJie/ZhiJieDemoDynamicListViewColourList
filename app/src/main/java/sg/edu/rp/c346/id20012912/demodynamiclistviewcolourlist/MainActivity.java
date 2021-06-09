package sg.edu.rp.c346.id20012912.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    EditText etElement, etIndexElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextPosition);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);

        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove =findViewById(R.id.DeleteColour);
        btnUpdate = findViewById(R.id.UpdateColour);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String newColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, newColour);
                aaColour.notifyDataSetChanged();
                etElement.setText(" ");


            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
                etElement.setText(" ");
                etIndexElement.setText(null);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String updatecolour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos, updatecolour);
                aaColour.notifyDataSetChanged();
                etElement.setText(" ");
                etIndexElement.setText(" ");
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(MainActivity.this, " " + alColours.get(position), Toast.LENGTH_LONG).show();
                String colour = lvColour.getSelectedItem().toString();
                etIndexElement.setText(" " + position);

            }
        });

    }
}