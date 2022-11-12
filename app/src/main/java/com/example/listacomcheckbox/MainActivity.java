package com.example.listacomcheckbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listViewData;
    ArrayAdapter<String> adapter;
    String[] arrayPeliculas = {"Filme 1","Filme 2","Filme 3","Filme 4","Filme 5","Filme 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewData = findViewById(R.id.listView_data);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,arrayPeliculas);
        listViewData.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_done){
            String itemselected = "Selected items: \n";
            for (int i=0;i<listViewData.getCount();i++){
                if (listViewData.isItemChecked(i)){
                    itemselected += listViewData.getItemAtPosition(i)+ "\n";

                }
            }
            Toast.makeText(this,itemselected, Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}