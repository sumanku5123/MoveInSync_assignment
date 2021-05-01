package com.example.move_in_sync;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class data_entry extends AppCompatActivity {
    Student_Database mydb;
    EditText name,marks,class_name;
    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        mydb = new Student_Database(this);
        name = (EditText) findViewById(R.id.Student_Name);
        marks =(EditText) findViewById(R.id.Marks);
        class_name = (EditText) findViewById(R.id.Class);
        button=(Button) findViewById(R.id.button);
        add_Data();
    }
    public void add_Data()
    {
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean inserted = mydb.insert_Data(name.getText().toString(),
                                marks.getText().toString(),
                                class_name.getText().toString() );
                        if(inserted )
                            Toast.makeText(data_entry.this,"Data Inserted" ,Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(data_entry.this,"Data Inserted" ,Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}