package com.example.move_in_sync;


import androidx.appcompat.app.AppCompatActivity;


import android.app.SearchManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.widget.CompoundButton;

import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.move_in_sync.adapter.adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements android.widget.CompoundButton.OnCheckedChangeListener  {
      Student_Database mydb;
      Button button , selected_item;
      ListView listView;
      ArrayList<student> arrayList;
      com.example.move_in_sync.adapter.adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new Student_Database(this);
        selected_item=(Button) findViewById(R.id.selected_Item);
        button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();


        loadData();
        addData();

    }



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
            selected_item.setVisibility(View.VISIBLE);
        int pos = listView.getPositionForView(buttonView);
        if(pos != ListView.INVALID_POSITION)
        {

            final student s = arrayList.get(pos);
            s.setSelected(isChecked);

            selected_item.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(),selected_data.class);

                            intent.putExtra("id",s.getId());
                            intent.putExtra("name",s.getName());
                            intent.putExtra("marks",s.getMarks());
                            intent.putExtra("student_class",s.getStudent_class());


                            startActivity(intent);


                        }
                    });
            Toast.makeText(this,"Clicked on:"+s.getName(),Toast.LENGTH_SHORT).show();
        }

        if(isChecked == false)
            selected_item.setVisibility(View.INVISIBLE);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchContact(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchContact(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }



    public void addData()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),data_entry.class);
                startActivity(i);
            }
        });
    }

    public void loadData()
    {
        arrayList = mydb.getData();
        adapter = new adapter(this,arrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private void searchContact(String keyword) {
        Student_Database databaseHelper = new Student_Database(getApplicationContext());
        List<student> contacts = databaseHelper.search(keyword);
        if (contacts != null) {
            listView.setAdapter(new adapter(getApplicationContext(), (ArrayList<student>) contacts));
        }
    }


}